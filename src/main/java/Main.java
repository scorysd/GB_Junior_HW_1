import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        System.out.println(Numbers.findMax(Numbers.generateNumbers()));
        System.out.println(Numbers.sumOfNumbers(Numbers.generateNumbers()));
        System.out.println(Numbers.findNumbers(Numbers.generateNumbers()));

        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Roman", 30, 123234.4, "IT"));
        employees.add(new Employee("Timofei", 23, 123234.4, "Marketing"));
        employees.add(new Employee("Orlan", 16, 76545.54, "IT"));
        employees.add(new Employee("MAhmud", 54, 3434.34, "Marketing"));
        employees.add(new Employee("Petya", 34, 37867.7, "Marketing"));
        employees.add(new Employee("Vasya", 57, 11239534.86, "DIRECTOR"));
        employees.add(new Employee("Afonasii", 23, 34534.34, "Marketing"));
        employees.add(new Employee("Anfisa", 22, 89237.89, "Buhgalteria"));
        employees.add(new Employee("Julia", 18, 67845.3434, "Buhgalteria"));
        employees.add(new Employee("Ahmed", 31, 34879.87, "Buhgalteria"));
        employees.add(new Employee("Rayan Gosling", 35, 784578.45, "IT"));
        employees.add(new Employee("Maria", 43, 1984.56, "Buhgalteria"));
        employees.add(new Employee("Jared", 27, 1232.4, "IT"));


        System.out.println(Employee.employeesOnDepartment(employees, "IT"));
        System.out.println();
        System.out.println(Employee.employeesOnDepartment(employees, "DIRECTOR"));
        System.out.println();
        System.out.println(Employee.employeesOnDepartment(employees, "Buhgalteria"));


        Employee.updateSalary(employees);

//        System.out.println(Employee.departmentEmployees(employees));

        System.out.println(Employee.salaryInDept(employees));








          }
}
