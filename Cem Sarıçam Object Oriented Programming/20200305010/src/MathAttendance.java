import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MathAttendance extends PhysicsAttendance {

    public MathAttendance() {
        super();
    }

    @Override
    public void addAttendance(Student student, int numberOfClasses) {
        super.addAttendance(student, numberOfClasses);
    }

    @Override
    public void removeStudent(Student student) {
        super.removeStudent(student);
    }

    @Override
    public void showAllStudents(Student student) {
        super.showAllStudents(student);
    }

    @Override
    public void updateAttendance(Student student, int updatedNumberOfClasses) {
        super.updateAttendance(student, updatedNumberOfClasses);
    }

    @Override
    public void checkAttendance(Student student) {
        super.checkAttendance(student);
    }

    @Override
    public double calculateAttendancePercentage(Student student, int totalClasses) {
        return super.calculateAttendancePercentage(student, totalClasses);
    }




    public List<Student> getMathStudents() {
        List<Student> mathStudents = new ArrayList<>(getStudentList());
        return mathStudents;
    }
}
