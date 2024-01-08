
package schedulegenerator

import schedulegenerator.{Subject, Teacher}


class Course(code: String, val subject: Subject, var teacher: Teacher):
    
    def setTeacher(t: Teacher) = teacher = t

    def copy: Course = new Course(this.code, this.subject, this.teacher.copy)

    def id: String = code

    override def toString(): String = code
