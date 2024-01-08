package schedulegenerator

import schedulegenerator.GeneticAlgorithm

object Main:
    def main(args: Array[String]): Unit =
        val popSize = 10
        val genLimit = 10000
        val algorithm = new GeneticAlgorithm(popSize)
        val winner = algorithm.completeEvolution(genLimit)

        

