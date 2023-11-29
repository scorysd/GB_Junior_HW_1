import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    String name;
    int age;
    double salary;
    String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Работник{" +
                "Имя='" + name + '\'' +
                ", Возраст=" + age +
                ", зарплпта=" + salary +
                ", отдел='" + department + '\'' +
                '}';
    }

    /**
     * Метод создающий новую коллекцию из имеющейся, в которой содержаться исключительно работники
     * указанного отдела (департамента)
     * @param list на вход принимает коллекцию работников
     * @param department указывается интересующи нас отдел
     * @return коллекцию работников указанного отдела
     */
    public static List<Employee> employeesOnDepartment(ArrayList<Employee> list, String department) {
        List<Employee> collect = list.stream().filter(it -> it.getDepartment().equals(department))
                .collect(Collectors.toList());
        return collect;
    }

    /**
     * Метод повышения зарплаты на 20% сотрудникам, у которых она < 10000
     * @param list на вход принимает коллекцию работников
     */
    public static void updateSalary(ArrayList<Employee> list) {

        list.stream().filter(it -> it.getSalary() < 10000.0)
                .forEach(it -> it.setSalary(it.getSalary() * 1.20));
    }

    /**
     * Метод, создающий и возвращающий коллекцию, содержащую в себе название отдела и работников,
     * входящих в указанных отдел
     * @param list на вход принимает коллекцию работников
     * @return хэш-мап, где ключ-название отдела, значение-список работников отдела
     */
    public static Map<String, List<Employee>> departmentEmployees(ArrayList<Employee> list) {
        Map<String, List<Employee>> deptemploy = new HashMap<>();
        list.stream().forEach((k) -> {
            deptemploy.put(k.department, employeesOnDepartment(list, k.department));
        });
        return deptemploy;
    }

    /**
     * Метод нахождения средней зарплаты в отделе
     * @param list на вход принимает коллекцию работников
     * @return хэш-мап, где ключ-название отдела, значение-средняя зарплата отдела
     *
     * TODO: работает коряво. Что-то считает, но не то. Видимо я где-то запутался  с этими стримами)
     */

    public static Map<String, Double> salaryInDept(ArrayList<Employee> list) {
        Map<String, Double> salarydept = new HashMap<>();
        list.stream().forEach((k) -> {
            salarydept.put(k.department, employeesOnDepartment(list, k.department).stream().flatMapToDouble(it -> OptionalDouble.of(k.salary).stream().average().stream()).sum());
        });
        return salarydept;
    }
}


