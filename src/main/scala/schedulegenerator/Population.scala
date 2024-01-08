
package schedulegenerator


class Population(size: Int):
    
    private var schedules = Array.fill(size)(new Schedule())
  
    schedules.foreach(_.initialize())
    this.sortByFitness()

    def apply(i: Int): Schedule = schedules(i)

    def  sortByFitness(): Unit = 
        schedules.sortBy(- _.fitness)

    def getSchedules = schedules

    def getSchedulesExcept(schedule: Schedule) = 
        schedules.filterNot(_ == schedule)

    def updateSchedule(i: Int, s: Schedule) = 
        schedules(i) = s




