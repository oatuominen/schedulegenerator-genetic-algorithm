
package schedulegenerator




class Time(val day: String, val timeIndex: Int):

    private val dayOrder = Array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

    def copy: Time = new Time(this.day, this.timeIndex)



    def isEqualTo(other: Time): Boolean = 
      this.day == other.day && this.timeIndex == other.timeIndex
  

    override def toString(): String = day + " " + timeIndex.toString()
