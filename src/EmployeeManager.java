import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;
import java.util.SequencedCollection;

public class EmployeeManager {

    static Scanner scanner = new Scanner(System.in);
    static Path path = Paths.get("src/employee_records.csv");

    static void menu() {
        System.out.println("""
                =====| Menu |=====
                1. Add
                2. List all
                3. Search by id
                0. Exit
                """);
    }

    public static void main(String[] args) {

        int op;
        while (true) {
            menu();
            System.out.print("Enter an option: ");
            op = Integer.parseInt(scanner.nextLine());

            if (op == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (op) {
                case 1 -> addEmployee();
                case 2 -> listAllEmployees();
                case 3 -> searchEmployeeId();
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private static void searchEmployeeId() {

        System.out.print("Enter an id: ");
        Integer id = Integer.parseInt(scanner.nextLine());

        try (BufferedReader reader = new BufferedReader(
                new FileReader(path.toFile())
        )) {
            String value;
            while ((value = reader.readLine()) != null) {
                Employee employee = Employee.fromCSV(value);
                if (employee.getId().equals(id)) {
                    System.out.println(employee);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void listAllEmployees() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(path.toFile())
        )) {

            String value;
            while ((value = reader.readLine()) != null) {
                Employee employee = Employee.fromCSV(value);
                System.out.println(employee);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void addEmployee() {
        System.out.print("Enter ID: ");
        Integer id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Salary: ");
        Double salary = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        Employee employee = new Employee(id, name, salary, department);
        String value = employee.toCSV();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(path.toFile(), true)
        )) {

            writer.write(value);
            writer.newLine();
            System.out.println("Employee added");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
