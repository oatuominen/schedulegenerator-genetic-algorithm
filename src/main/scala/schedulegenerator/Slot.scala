
package schedulegenerator

class Slot(val course: Course, val assignedClass: Class_, var time: Time ):

    override def toString(): String = 
        course.toString()
