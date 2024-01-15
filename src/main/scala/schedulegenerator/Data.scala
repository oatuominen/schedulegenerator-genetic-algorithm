

package schedulegenerator
import schedulegenerator.*
import schedulegenerator.Course
import schedulegenerator.Time


// Example data
object Data:
    val teachers = Array[Teacher](Teacher("T01", "Teacher01", Set(Math, Chemistry)),
                                  Teacher("T02", "Teacher02", Set(Math, Chemistry)),
                                  Teacher("T03", "Teacher03", Set(Math, Physics)),
                                  Teacher("T04", "Teacher04", Set(Math, Physics)),
                                  Teacher("T05", "Teacher05", Set(Math)),
                                  Teacher("T06", "Teacher06", Set(Biology, Geography)),
                                  Teacher("T07", "Teacher07", Set(Biology, Geography)),
                                  Teacher("T08", "Teacher08", Set(History, SocialStudies)),
                                  Teacher("T09", "Teacher09", Set(History, SocialStudies)),
                                  Teacher("T10", "Teacher10", Set(HealthScience, Gym)),
                                  Teacher("T11", "Teacher11", Set(HealthScience, Gym)),
                                  Teacher("T12", "Teacher12", Set(Finnish)),
                                  Teacher("T13", "Teacher13", Set(Finnish)),
                                  Teacher("T14", "Teacher14", Set(Finnish, Swedish)),
                                  Teacher("T15", "Teacher15", Set(Swedish, English)),
                                  Teacher("T16", "Teacher16", Set(English)),
                                  Teacher("T17", "Teacher17", Set(Music)),
                                  Teacher("T18", "Teacher18", Set(Art)),
                                  Teacher("T19", "Teacher19", Set(Handicraft)),
                                  Teacher("T20", "Teacher20", Set(HomeEconomics))
                                  )

    val classes = Array(Class_("7A"), Class_("7B"), Class_("7C"),
                        Class_("8A"), Class_("8B"), Class_("8C"),
                        Class_("9A"), Class_("9B"), Class_("9C"))


    val times = Array(
        Time("Monday", 0), Time("Monday", 1), Time("Monday", 2), Time("Monday", 3), Time("Monday", 4), Time("Monday", 5), Time("Monday", 6),
        Time("Tuesday", 0), Time("Tuesday", 1), Time("Tuesday", 2), Time("Tuesday", 3), Time("Tuesday", 4), Time("Tuesday", 5), Time("Tuesday", 6),
        Time("Wednesday", 0), Time("Wednesday", 1), Time("Wednesday", 2), Time("Wednesday", 3), Time("Wednesday", 4), Time("Wednesday", 5), Time("Wednesday", 6),
        Time("Thursday", 0), Time("Thursday", 1), Time("Thursday", 2), Time("Thursday", 3), Time("Thursday", 4), Time("Thursday", 5), Time("Thursday", 6),
        Time("Friday", 0), Time("Friday", 1), Time("Friday", 2), Time("Friday", 3), Time("Friday", 4), Time("Friday", 5), Time("Friday", 6)

    )

