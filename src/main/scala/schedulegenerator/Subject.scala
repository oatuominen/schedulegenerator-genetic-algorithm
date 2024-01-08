

package schedulegenerator


sealed trait Subject:
    override def toString(): String

/*object AllSubjects:
    def get: Seq[Subject] = Seq(Math, Physics, Chemistry, Biology, Geography,
    History, SocialStudies, HealthScience, 
    Finnish, English, Swedish, 
    Music, Art, Handicraft, HomeEconomics, Gym, StudyGuidance)*/


case object Math extends Subject:
    override def toString() = "Math"
case object Physics extends Subject:
    override def toString() = "Physics"
case object Chemistry extends Subject:
    override def toString() = "Chemistry"
case object Biology extends Subject:
    override def toString() = "Biology"
case object Geography extends Subject:
    override def toString() = "Geography"


case object History extends Subject:
    override def toString() = "History"
case object SocialStudies extends Subject:
    override def toString() = "SocialStudies"
case object HealthScience extends Subject:
    override def toString() = "HealtScience"


case object Finnish extends Subject:
    override def toString() = "Finnish"
case object Swedish extends Subject:
    override def toString() = "Swedish"
case object English extends Subject:
    override def toString() = "English"


case object Music extends Subject:
    override def toString() = "Music"
case object Art extends Subject:
    override def toString() = "Art"
case object Handicraft extends Subject:
    override def toString() = "Handicraft"
case object HomeEconomics extends Subject:
    override def toString() = "HomeEconomics"
case object Gym extends Subject:
    override def toString() = "Gym"
case object StudyGuidance extends Subject:
    override def toString() = "StudyGuidance"




