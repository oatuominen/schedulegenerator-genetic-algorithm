
package schedulegenerator

import scala.util.Random

class GeneticAlgorithm(var populationSize: Int):

    private def evolve(population: Population): Population = 
      val newGeneration = crossOverPopulation(population)
      mutatePopulation(newGeneration)
      newGeneration
    end evolve


    private def crossOverPopulation(population: Population): Population = 
      val crossOverPop = new Population(populationSize)
      for i <- 0 until populationSize do 
        val schedule1 = parentSelection(population)
        var schedule2 = parentSelection(population, Some(schedule1)) 
        val childSchedule = crossOver(schedule1, schedule2) 
        crossOverPop.updateSchedule(i, childSchedule)
      crossOverPop
    end crossOverPopulation 

     
    private def parentSelection(population: Population, otherParent:Option[Schedule]=None): Schedule =
      val tournamentSize = 4
      val candidates = otherParent match
                        case Some(parent) => 
                          Random.shuffle(population.getSchedulesExcept(parent)).take(tournamentSize)
                        case None =>  
                          Random.shuffle(population.getSchedules).take(tournamentSize)
      candidates.sortBy(- _.fitness).head
    end parentSelection


    private def mutatePopulation(population: Population): Unit = 
      for sched <- population.getSchedules do
        mutateSched(sched)
    end mutatePopulation



    private def crossOver(s1: Schedule, s2: Schedule): Schedule = 
      val crossOverRate = 0.6
      val child = new Schedule()

      for i <- 0 until child.size do 
        val rand: Double = Random.nextDouble() 
        if rand > crossOverRate then
          val newSlot = crossOver_(s1, i)
          child.update(i, newSlot)
        else
          val newSlot = crossOver_(s2, i)
          child.update(i, newSlot) 

      def crossOver_(s: Schedule, i: Int): Slot = 
            val course = 
                if i >= 1 
                  && child(i-1).course.subject == s(i).course.subject 
                  && child(i-1).assignedClass.id == s(i).assignedClass.id then
                    child(i-1).course 
                else s(i).course.copy               
            new Slot(course, s(i).assignedClass.copy, s(i).time.copy)

      child
    end crossOver


    private def mutateSched(schedule: Schedule): Unit = 
      var rateOfMutation = 0.001
      for i <- 0 until schedule.size do
        val rand: Double = Random.nextDouble()
        if rand < rateOfMutation then 
          schedule.mutateSlot(i)
    end mutateSched

    
    
    def completeEvolution(limit: Int): Unit = 
      var generation = 0
      var population = Population(populationSize)  

      while population(0).fitness != 1.0 && generation < limit do
        if generation != 0 && generation % 1500 == 0 then populationSize += 2 
        population = evolve(population)
        generation += 1
        population.sortByFitness()
        if generation % 100 == 0  then
          println(statusUpdate(population.getSchedules, generation)) 

      val winner = population.getSchedules.head
      announceWinner(winner, generation)
    end completeEvolution
      
      
    def statusUpdate(schedules: Array[Schedule], gen: Int): String = 
      "Gen-" + gen + " top fitness: " + schedules.head.fitness


    def announceWinner(winner: Schedule, generation: Int): Unit =
      val winnerFitness = winner.fitness
      if winnerFitness == 1 then
        println("Winner fitness: " + winner.fitness)
        println(s"I took ${generation} generations to reach the winner.")
      else
        println("Failed to acieve optimal solution in " + generation + " generations.")
      println((winner.visualString()._1))







