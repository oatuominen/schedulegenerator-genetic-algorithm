# schedulegenerator-genetic-algorithm

This project is a schedule generator implemented in Scala, using a genetic algorithm. It is specifically designed to create schedules for educational institutions.

## Main Requirements for a Passable Schedule
1. **No Overlapping**: Ensures there are no conflicts in class or teacher schedules.
2. **Subject Quota Fulfillment**: Each class receives the required number of classes per subject.
3. **Course Requirements**: Each class has a course for a subject with a single teacher.
3. **Subject Distribution**: Classes are scheduled for only one instance of a particular subject per day.

## Advanced Customization
- **Expandable Requirements**: The algorithm supports additional scheduling requirements. Adding more intricate criteria can lead to a higher number of generations required for achieving the optimal solution.
    * For instance, implementing criteria like minimizing gaps in the schedule can be managed through adjustments in the `fitness` function. 
    * Preferences can be integrated into the `fitness` function to consider class-specific and teacher-specific preferences.
