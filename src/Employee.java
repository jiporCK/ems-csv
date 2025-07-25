
public class Employee {

    private Integer id;

    private String name;

    private Double salary;

    private String department;

    public Employee() { }

    public Employee(Integer id, String name, Double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    // id,name,salary,department
    public String toCSV() {
        return id + "," + name + "," + salary + "," +department;
    }

    public static Employee fromCSV(String value) {
        String[] parts = value.split(",");
        return new Employee(
                Integer.valueOf(parts[0]),
                parts[1],
                Double.valueOf(parts[2]),
                parts[3]
        );
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

}
