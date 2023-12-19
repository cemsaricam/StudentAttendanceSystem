import java.util.List;

public interface AttendanceSystem<T> {
    void addAttendance(T student, int numberOfClasses);
    void removeStudent(T student);
    void showAllStudents(T student);
    void updateAttendance(T student, int updatedNumberOfClasses);
    void checkAttendance(T student);
    double calculateAttendancePercentage(Student student, int totalClasses);
    void listAllAttendance();
    List<T> getStudentList();

    }

