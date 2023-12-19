import java.util.*;

public class PhysicsAttendance implements AttendanceSystem<Student> {
    private Map<Student, Integer> attendanceMap = new HashMap<>();

    @Override
    public void addAttendance(Student student, int numberOfClasses) {
        if (attendanceMap.containsKey(student)) {
            int currentAttendance = attendanceMap.get(student);
            attendanceMap.put(student, currentAttendance + numberOfClasses);
        } else {
            attendanceMap.put(student, numberOfClasses);
        }
    }

    @Override
    public void removeStudent(Student student) {
        if (attendanceMap.containsKey(student)) {
            attendanceMap.remove(student);
            System.out.println(student + " removed successfully.");
        } else {
            System.out.println(student + " is not in the attendance records.");
        }
    }

    @Override
    public void showAllStudents(Student student) {
        List<Student> physicsStudents = getStudentList();
        System.out.println("Physics Students:");
        for (int i = 0; i < physicsStudents.size(); i++) {
            System.out.println((i + 1) + ". " + physicsStudents.get(i));
        }
    }

    @Override
    public void updateAttendance(Student student, int updatedNumberOfClasses) {
        if (attendanceMap.containsKey(student)) {
            attendanceMap.put(student, updatedNumberOfClasses);
            System.out.println(student + "'s attendance updated successfully.");
        } else {
            System.out.println(student + " is not in the attendance records.");
        }
    }

    @Override
    public void checkAttendance(Student student) {
        if (attendanceMap.containsKey(student)) {
            int classesAttended = attendanceMap.get(student);
            System.out.println(student + " attended " + classesAttended + " classes.");
        } else {
            System.out.println(student + " has no attendance record.");
        }
    }

    @Override
    public double calculateAttendancePercentage(Student student, int totalClasses) {
        if (attendanceMap.containsKey(student)) {
            int classesAttended = attendanceMap.get(student);
            return ((double) classesAttended / totalClasses) * 100;
        } else {
            return 0;
        }
    }
    public void listAllAttendance() {
        List<Student> sortedList = getStudentList();
        sortedList.sort(Comparator.comparingInt(student -> -attendanceMap.getOrDefault(student, 0)));


        System.out.println("\n*** All Attendance ***");
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println((i + 1) + ". " + sortedList.get(i) + ": " + attendanceMap.getOrDefault(sortedList.get(i), 0) + " classes attended");
        }
    }

    @Override
    public List<Student> getStudentList() {
        return new ArrayList<>(attendanceMap.keySet());
    }
}
