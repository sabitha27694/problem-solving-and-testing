import java.util.List;
import java.util.ArrayList;

class Result {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();
        for (int grade : grades) {
            if (grade >= 38) {
                int nextMultipleOfFive = ((grade / 5) + 1) * 5;
                if (nextMultipleOfFive - grade < 3) {
                    grade = nextMultipleOfFive;
                }
            }
            roundedGrades.add(grade);
        }
        return roundedGrades;
    }
}