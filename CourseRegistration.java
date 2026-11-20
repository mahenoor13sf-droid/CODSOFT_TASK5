
import java.util.Scanner;

class CourseRegistration {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        String courses[] = {
            "Java Programming",
            "Python Programming",
            "Web Development",
            "Database Management"
        };

        String codes[] = {"C101", "C102", "C103", "C104"};

        int capacity[] = {3, 3, 3, 3};
        int registered[] = {0, 0, 0, 0};

        String studentCourses[] = new String[10];

        int count = 0;
        int choice;

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        do {
            System.out.println("\n===== COURSE REGISTRATION =====");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAVAILABLE COURSES");

                    for (int i = 0; i < courses.length; i++) {
                        System.out.println(codes[i] + " - " +
                        courses[i] + " | Available Slots: " +
                        (capacity[i] - registered[i]));
                    }
                    break;

                case 2:
                    System.out.print("Enter Course Code: ");
                    String code = sc.next();

                    boolean found = false;

                    for (int i = 0; i < courses.length; i++) {

                        if (codes[i].equalsIgnoreCase(code)) {
                            found = true;

                            if (registered[i] < capacity[i]) {
                                if (count < studentCourses.length) {
                                    studentCourses[count] = code;
                                    count++;
                                    registered[i]++;

                                    System.out.println("Registration Successful!");
                                }
                                else {
                                    System.out.println("Registration limit reached!");
                                }
                            }
                            else {
                                System.out.println("Course is Full!");
                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Course Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Course Code to Drop: ");
                    String drop = sc.next();

                    boolean removed = false;

                    for (int i = 0; i < count; i++) {

                        if (studentCourses[i].equalsIgnoreCase(drop)) {

                            for (int j = i; j < count - 1; j++) {
                                studentCourses[j] = studentCourses[j + 1];
                            }

                            count--;

                            for (int k = 0; k < courses.length; k++) {
                                if (codes[k].equalsIgnoreCase(drop)) {
                                    registered[k]--;
                                    break;
                                }
                            }

                            removed = true;
                            System.out.println("Course Dropped Successfully!");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Course Not Registered!");
                    }
                    break;

                case 4:
                    System.out.println("\nSTUDENT DETAILS");
                    System.out.println("Student ID: " + id);
                    System.out.println("Student Name: " + name);

                    System.out.println("Registered Courses:");

                    for (int i = 0; i < count; i++) {
                        System.out.println(studentCourses[i]);
                    }

                    if (count == 0) {
                        System.out.println("No Courses Registered.");
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
