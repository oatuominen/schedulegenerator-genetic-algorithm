# schedulegenerator-genetic-algorithm
## Introduction
This project presents a schedule generator implemented in Scala, utilizing a genetic algorithm. It is specifically designed to create schedules for educational institutions.

## Features
- **Rapid Schedule Generation**: Capable of generating schedules for 12 classes (each with unique subject requirements) and 20 teachers in under two minutes, typically within 3000 generations.
- **Adaptable Subject Criteria**: The algorithm offers the flexibility for users to modify class-specific subject requirements in the code.
- **Manual Teacher Availability Estimation**: The algorithm relies on externally provided estimates of teacher availability, as it does not automatically determine the number of teachers capable of handling different classes.
- **Fitness Function**: Utilizes a fitness function to evaluate and optimize the schedule quality. This function evaluates schedule instances by considering overlaps and calculating a fitness value for each individual instance.



## Main Requirements for a Passable Schedule
1. **No Overlapping**: Ensures there are no conflicts in class or teacher schedules.
2. **Subject Quota Fulfillment**: Each class receives the required number of classes per subject.
3. **Course Requirements**: Each class has a course for a subject with a single teacher.
3. **Subject Distribution**: Classes are scheduled for only one instance of a particular subject per day.

## Advanced Customization
- **Expandable Requirements**: The algorithm supports additional scheduling requirements. Adding more intricate criteria can lead to a higher number of generations required for achieving the optimal solution.
    * For instance, implementing criteria like minimizing gaps in the schedule can be managed through adjustments in the `fitness` function. 
    * Preferences can be integrated into the `fitness` function to consider class-specific and teacher-specific preferences.

    
## Potential Improvements and Future Work
- **User Interface**: Development of a user-friendly interface for easier manipulation of input parameters and visualization of schedules.
- **Algorithm Optimization**: Continuous refinement of the genetic algorithm for faster convergence and handling of more complex scheduling scenarios.
- **Data Import/Export**: Integration of functionality for importing data from external sources and exporting generated schedules.
- **Handling Early Convergence**: Occasionally, the algorithm might experience early convergence, potentially leading to extended scheduling times. This is a recognized limitation and variour strategies can be examined to resolve this issue.


### For example, a schedule for a single class might look like this:
![Schedule image](https://github.com/olivtuo/schedulegenerator-genetic-algorithm/blob/main/Schedule_image.png)
