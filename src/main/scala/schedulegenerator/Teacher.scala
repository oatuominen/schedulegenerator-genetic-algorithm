
package schedulegenerator


class Teacher(val id: String, val name: String, val subjects: Set[Subject]):
    
    def getSubjects = subjects

    def copy: Teacher = new Teacher(this.id, this.name, this.subjects)

    override def toString(): String = name
