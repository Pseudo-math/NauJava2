import java.util.ArrayList;

public class Employee {
    private String fullName;
    private Integer age;
    private String department;
    private Integer salary;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    private static ArrayList<Employee> prefilledList() {
        var list = new ArrayList<Employee>(5);

        var Vasiliy = new Employee();
        Vasiliy.setFullName("Василий Спрингович Джавов");
        Vasiliy.setAge(27);
        Vasiliy.setDepartment("Отдел разработки");
        Vasiliy.setSalary(500_000);
        list.add(Vasiliy);

        var Silvestr = new Employee();
        Silvestr.setFullName("Силвестр Андреевич Кабанов");
        Silvestr.setAge(40);
        Silvestr.setDepartment("Совет директоров");
        Silvestr.setSalary(50_000_000);
        list.add(Silvestr);

        var Anna = new Employee();
        Anna.setFullName("Анна Тестировна Багова");
        Anna.setAge(30);
        Anna.setDepartment("Отдел тестирования");
        Anna.setSalary(350_000);
        list.add(Anna);

        var Ivan = new Employee();
        Ivan.setFullName("Иван Датаевич Аналитиков");
        Ivan.setAge(35);
        Ivan.setDepartment("Отдел аналитики");
        Ivan.setSalary(400_000);
        list.add(Ivan);

        var Ekaterina = new Employee();
        Ekaterina.setFullName("Екатерина Менеджеровна HRова");
        Ekaterina.setAge(32);
        Ekaterina.setDepartment("Отдел кадров");
        Ekaterina.setSalary(300_000);
        list.add(Ekaterina);

        return list;
    }

    private static void print(Employee employer) {
        System.out.println("Работник: " + employer.getFullName() +
                ", Возраст: " + employer.getAge() +
                ", Департамент: " + employer.getDepartment() +
                ", Зарплата: " + employer.getSalary()
        );
    }
    public static void sortAscendSalary() {
        var list = prefilledList();
        list.stream().sorted((a,b) -> Integer.compare(a.getSalary(), b.getSalary())).forEach(Employee::print);
    }
}
