import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean authenticationSuccessful = false;

        while (!authenticationSuccessful) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (UserAuthentication.authenticateUser(username, password)) {
                System.out.println("Authentication successful.");
                authenticationSuccessful = true;
            } else {
                System.out.println("Authentication failed. Please try again.");
            }
        }

        AttendanceSystem<Student> physicsAttendance = new PhysicsAttendance();
        AttendanceSystem<Student> mathAttendance = new MathAttendance();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n*** COURSE SELECTION ***");
            System.out.println("1. Physics");
            System.out.println("2. Math");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int courseChoice = scanner.nextInt();
            scanner.nextLine();

            switch (courseChoice) {
                case 1:
                    performAttendanceOperations(scanner, physicsAttendance);
                    break;
                case 2:
                    performAttendanceOperations(scanner, mathAttendance);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        scanner.close();
    }

    private static void performAttendanceOperations(Scanner scanner, AttendanceSystem studentAttendance) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n*** Attendance Menu ***");
            System.out.println("1. Add Student");
            System.out.println("2. Add Attendance");
            System.out.println("3. Remove Student");
            System.out.println("4. Show All Student");
            System.out.println("5. Update Attendance");
            System.out.println("6. Check Attendance");
            System.out.println("7. Show Attendance Percentage");
            System.out.println("8. List All Attendance");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(scanner, studentAttendance);
                    break;
                case 2:
                    addAttendance(scanner, studentAttendance);
                    break;
                case 3:
                    removeStudent(scanner, studentAttendance);
                    break;
                case 4:
                    showAllStudents(scanner, studentAttendance);
                    break;
                case 5:
                    updateAttendance(scanner, studentAttendance);
                    break;

                case 6:
                    checkAttendance(scanner, studentAttendance);
                    break;
                case 7:
                    showAttendancePercentage(scanner, studentAttendance);
                    break;
                case 8:
                    studentAttendance.listAllAttendance();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
    private static void addStudent(Scanner scanner, AttendanceSystem<Student> studentAttendance) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);

        studentAttendance.addAttendance(student, 0);
        System.out.println(studentName + " added successfully.");
    }

    private static void addAttendance(Scanner scanner, AttendanceSystem<Student> studentAttendance) {
        List<Student> studentList = studentAttendance.getStudentList();

        if (studentList.isEmpty()) {
            System.out.println("No students in the attendance records.");
        } else {
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Students in the attendance records:");
                for (int i = 0; i < studentList.size(); i++) {
                    System.out.println((i + 1) + ". " + studentList.get(i));
                }

                System.out.print("Enter the number of the student to add attendance: ");
                int selectedStudentIndex = scanner.nextInt();
                scanner.nextLine();

                if (selectedStudentIndex > 0 && selectedStudentIndex <= studentList.size()) {
                    Student selectedStudent = studentList.get(selectedStudentIndex - 1);

                    int numberOfClasses;
                    do {
                        System.out.print("Enter number of classes attended by " + selectedStudent + " (maximum 14): ");
                        numberOfClasses = scanner.nextInt();
                        scanner.nextLine();

                        if (numberOfClasses <= 0 || numberOfClasses > 14) {
                            System.out.println("Invalid input. Please enter a number between 1 and 14.");
                        } else {
                            validInput = true;
                        }
                    } while (!validInput);

                    studentAttendance.addAttendance(selectedStudent, numberOfClasses);
                    System.out.println(selectedStudent + "'s attendance added successfully.");
                } else {
                    System.out.println("Invalid student selection. Please try again.");
                }
            }
        }
    }

    private static void removeStudent(Scanner scanner, AttendanceSystem<Student> studentAttendance) {
        List<Student> studentList = studentAttendance.getStudentList();

        if (studentList.isEmpty()) {
            System.out.println("No students in the attendance records.");
        } else {
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Students in the attendance records:");
                for (int i = 0; i < studentList.size(); i++) {
                    System.out.println((i + 1) + ". " + studentList.get(i));
                }

                System.out.print("Enter the number of the student to remove: ");
                int selectedStudentIndex = scanner.nextInt();
                scanner.nextLine();

                if (selectedStudentIndex > 0 && selectedStudentIndex <= studentList.size()) {
                    Student selectedStudent = studentList.get(selectedStudentIndex - 1);
                    studentAttendance.removeStudent(selectedStudent);
                    validInput = true;
                } else {
                    System.out.println("Invalid student selection. Please try again.");
                }
            }
        }
    }
    private static void showAllStudents(Scanner scanner, AttendanceSystem<Student> studentAttendance) {
        List<Student> allStudents = studentAttendance.getStudentList();

        if (allStudents.isEmpty()) {
            System.out.println("\nNo students in the attendance records.");
        } else {
            System.out.println("\nAll Students:");
            for (int i = 0; i < allStudents.size(); i++) {
                System.out.println((i + 1) + ". " + allStudents.get(i));
            }
        }
    }



    private static void updateAttendance(Scanner scanner, AttendanceSystem<Student> studentAttendance) {
        List<Student> studentList = studentAttendance.getStudentList();

        if (studentList.isEmpty()) {
            System.out.println("No students in the attendance records.");
        } else {
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Students in the attendance records:");
                for (int i = 0; i < studentList.size(); i++) {
                    System.out.println((i + 1) + ". " + studentList.get(i));
                }

                System.out.print("Enter the number of the student to update attendance: ");
                int selectedStudentIndex = scanner.nextInt();
                scanner.nextLine();

                if (selectedStudentIndex > 0 && selectedStudentIndex <= studentList.size()) {
                    Student selectedStudent = studentList.get(selectedStudentIndex - 1);

                    int updatedNumberOfClasses;
                    do {
                        System.out.print("Enter the updated number of classes attended by " + selectedStudent + " (maximum 14): ");
                        updatedNumberOfClasses = scanner.nextInt();
                        scanner.nextLine();

                        if (updatedNumberOfClasses <= 0 || updatedNumberOfClasses > 14) {
                            System.out.println("Invalid input. Please enter a number between 1 and 14.");
                        } else {
                            validInput = true;
                        }
                    } while (!validInput);

                    studentAttendance.updateAttendance(selectedStudent, updatedNumberOfClasses);
                    System.out.println(selectedStudent + "'s attendance updated successfully.");
                } else {
                    System.out.println("Invalid student selection. Please try again.");
                }
            }
        }
    }
    private static void checkAttendance(Scanner scanner, AttendanceSystem<Student> studentAttendance) {
        List<Student> studentList = studentAttendance.getStudentList();

        if (studentList.isEmpty()) {
            System.out.println("No students in the attendance records.");
        } else {
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Students in the attendance records:");
                for (int i = 0; i < studentList.size(); i++) {
                    System.out.println((i + 1) + ". " + studentList.get(i));
                }

                System.out.print("Enter the number of the student to check attendance: ");
                int selectedStudentIndex = scanner.nextInt();
                scanner.nextLine();

                if (selectedStudentIndex > 0 && selectedStudentIndex <= studentList.size()) {
                    Student selectedStudent = studentList.get(selectedStudentIndex - 1);
                    studentAttendance.checkAttendance(selectedStudent);
                    validInput = true;
                } else {
                    System.out.println("Invalid student selection. Please try again.");
                }
            }
        }
    }

    private static void showAttendancePercentage(Scanner scanner, AttendanceSystem<Student> studentAttendance) {
        List<Student> studentList = studentAttendance.getStudentList();
        int totalClasses = 14;

        if (studentList.isEmpty()) {
            System.out.println("No students in the attendance records.");
        } else {
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Students in the attendance records:");
                for (int i = 0; i < studentList.size(); i++) {
                    System.out.println((i + 1) + ". " + studentList.get(i));
                }
                System.out.print("Enter the number of the student to show attendance percentage: ");
                int selectedStudentIndex = scanner.nextInt();
                scanner.nextLine();
                if (selectedStudentIndex > 0 && selectedStudentIndex <= studentList.size()) {
                    Student selectedStudent = studentList.get(selectedStudentIndex - 1);
                    double attendancePercentage = studentAttendance.calculateAttendancePercentage(selectedStudent, totalClasses);
                    System.out.println(selectedStudent + "'s attendance percentage: " + attendancePercentage + "%");
                    validInput = true;
                } else {
                    System.out.println("Invalid student selection. Please try again.");
                }
            }
        }
    }
}
