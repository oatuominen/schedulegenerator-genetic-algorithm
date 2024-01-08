
package schedulegenerator

import scala.util.Random
import scala.collection.mutable.Buffer
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import schedulegenerator.Data.teachers


class Schedule():

    val data = Data

    data.classes.foreach(c => c.initializeSubjects()) 

    val size = data.classes.map(_.getSize).sum

    val slots = Array.fill[Slot](size)(null)     

    def apply(i: Int): Slot = slots(i)

    def update(index: Int, slot: Slot) = 
        slots(index) = slot

    def potentialTeachers(subject: Subject): Array[Teacher] = 
        data.teachers.filter(_.getSubjects.contains(subject))
        
    def initialize(): Unit =
        var index = 0
        for class_ <- data.classes do
            for (subject, count) <- class_.subjectMap do
                val potentials = potentialTeachers(subject)
                val teacher = Random.shuffle(potentials).head
                for i <- index until count + index do                                     
                    val course = if i == index then {                                    
                                    val courseCode = subject.toString() + class_.toString()
                                    new Course(courseCode, subject, teacher)
                                    } else slots(i-1).course                           
                    val time = Random.shuffle(data.times).head
                    val slot = new Slot(course, class_, time)
                    slots(i) = slot                                        
                index += count
        

    def mutateSlot(i: Int): Unit = 
        val changePossibility = 0.2
        val course = slots(i).course
        val class_ = slots(i).assignedClass
        val newTime = Random.shuffle(data.times).head
        val newSlot = new Slot(course, class_, newTime)
        val potentials = potentialTeachers(course.subject)    
        if changePossibility > Random.nextDouble() then 
            val newTeacher =  Random.shuffle(potentials).head
            course.setTeacher(newTeacher)
        slots(i) = newSlot 


    // calculates the fitness of an individual (i.e. the schedule)
    def fitness: Double = 
        val classGroups = slots.groupBy(_.assignedClass.id)
        val teacherGroups = slots.groupBy(_.course.teacher.id)
        var nofConflicts = 0

        for (id, group) <- classGroups do
            var count = 1
            for s1 <- group do
                for s2 <- group.drop(count) do                      
                    if s1.time.isEqualTo(s2.time) then
                        nofConflicts += 1
                    if s1.course.subject == s2.course.subject then
                        if s1.time.day == s2.time.day then 
                            nofConflicts += 1
                count += 1
        
        for (id, group) <- teacherGroups do
            var count = 1
            for s1 <- group do
                for s2 <- group.drop(count) do
                    if s1.time.isEqualTo(s2.time) then 
                        nofConflicts += 1
                count += 1
        
        1.0 * 1 / (nofConflicts + 1)


    def structuralConflicts(classSlots: Array[Slot]): Int =
        var conflicts = 0
        val orderByTime = classSlots.groupBy(_.time.day).view.mapValues(_.sortBy(_.time.timeIndex).map(_.time))
        for (id, day) <- orderByTime do
          if day.length < 4 then conflicts += 1
          val timeArr = day.map(_.timeIndex)
          if !timeArr.zip(timeArr.tail).forall((t1, t2) => t2 - t1 == 1) then 
            conflicts += 1
        conflicts



    def visualString(): (String, String) =
        val dayOrder = Array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
        val fullRow = (0 until dayOrder.length)
        val classGroups = slots.groupBy(_.assignedClass.id).toArray.sortBy(_._1.toCharArray.head.toString).map(_._2)
        val teacherGroups = slots.groupBy(_.course.teacher.id).map(_._2)
        var result = ""
        val dayStrings = dayOrder.map(day => f"$day%20s").mkString(" | ")
        val schedHeader = s"""
______________________________________________________________________________________________________________________________________
|                 | ${dayStrings} |
|                 | ${(0 until dayOrder.length).map(x => s"${" " * 20}").mkString(" | ")} |"""
        

        def body(data: Array[Array[String]]): String =
            var string = for (elem, i) <- data.zipWithIndex yield 
                val formattedElem = elem.map(item => f"$item%20s").mkString(" | ")
                s"|  ${toTimeString(i)}  | ${formattedElem} |"
            "\n" + string.mkString("\n") + "\n" + "|______________________________________________________________________________________________________________________________________"
        
        def toSchedVal(s: Slot): String =
            s.course.subject.toString() + "," + s.course.teacher.id.toString()
        
        def make_schedules(groups: Iterable[Array[Slot]], teacher: Boolean=false) =
            for (owner, i) <- groups.zipWithIndex do
                val rowGroups = owner.groupBy(_.time.timeIndex).map(_._2).toArray.sortBy(a => a.head.time.timeIndex)
                val ordered = rowGroups.map(_.sortBy(_.time.timeIndex)).toArray
                var index = -1
                val paddedArr = ordered.map(a => {
                    index = -1
                    a.zipAll(fullRow, null, null).map({ (s, j) =>
                        index += 1
                        if a.exists(s => dayOrder.indexOf(s.time.day) == index) then 
                            val slot = a.find(s => dayOrder.indexOf(s.time.day) == index).get
                            toSchedVal(slot)
                        else ""
                        })
                    })
                
                val schedString = schedHeader + body(paddedArr)
                val id = if teacher then owner.head.course.teacher.toString() else owner.head.assignedClass.toString()
                result += "\n" + "\n" + id + ": " + schedString
            result
        return (make_schedules(classGroups), make_schedules(teacherGroups, teacher=true))


    def toTimeString(i: Int): String = 
        i match
            case 0 => " 8:00 -  9:00"
            case 1 => " 9:00 - 10:00"
            case 2 => "10:00 - 11:00"
            case 3 => "11:00 - 13:00"
            case 4 => "13:00 - 14:00"
            case 5 => "14:00 - 15:00"
            case 6 => "15:00 - 16:00"
            
        





        






