

package schedulegenerator

import scala.collection.mutable.HashMap


class Class_(val id: String):
    
    val subjectMap: HashMap[Subject, Int] = HashMap()

    private var size = 0

    val classLevel = id.toCharArray().head

    def initializeSubjects() = 
            size = 0
            if classLevel == '7' then 
                val subjectCounts = Map[Subject, Int](
                    Finnish -> 3,
                    English -> 2,
                    Swedish -> 2,
                    Math -> 3,
                    Biology -> 1,
                    Geography -> 1,
                    Physics -> 1,
                    Chemistry -> 1,
                    HealthScience -> 1,
                    History -> 2,
                    Music -> 2,
                    Art -> 2,
                    Handicraft -> 2,
                    Gym -> 2,
                    HomeEconomics -> 3
                )
                this.addToMap(subjectCounts)


            else if classLevel == '8' then
                val subjectCounts = Map[Subject, Int](
                    Finnish -> 4,
                    English -> 2,
                    Swedish -> 2,
                    Math -> 4,
                    Biology -> 2,
                    Geography -> 1,
                    Physics -> 2,
                    Chemistry -> 2,
                    HealthScience -> 2,
                    History -> 2,
                    Gym -> 3
                )
                this.addToMap(subjectCounts)

            else if classLevel == '9' then
                val subjectCounts = Map[Subject, Int](
                    Finnish -> 3,
                    English -> 3,
                    Swedish -> 2,
                    Math -> 4,
                    Biology -> 2,
                    Geography -> 2,
                    Physics -> 2,
                    HealthScience -> 2,
                    SocialStudies -> 3,
                    Gym -> 2
                )
                this.addToMap(subjectCounts)
                    

    def addToMap(countSubjects: Map[Subject, Int]) = 
        for (subject, count) <- countSubjects do
            subjectMap += (subject -> count)
            size += count

    def copy: Class_ = new Class_(this.id)

    def getSize = size

    override def toString(): String = id



