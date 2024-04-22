import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
    

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    public void setSalaryRate(double salaryRate) {
        this.salaryRate = salaryRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", code='" + code + '\'' +
                ", salaryRate=" + salaryRate +
                '}';
    }
}

class EmployeeManager {
    private List<Employee> employeeList;

    public EmployeeManager() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}

public class EmployeeManagementApp {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        initializeEmployees(employeeManager);

        System.out.println("Danh sach thanh vien:");
        displayEmployees(employeeManager);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Them mot thanh vien moi:");
        System.out.print("Nhap ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line sau khi đọc số nguyên
        boolean isIdDuplicate = false;
        for (Employee employee : employeeManager.getEmployeeList()) {
           if (employee.getId() == id) {
              isIdDuplicate = true;
              break;
           }
        }
        
        if (isIdDuplicate) {
           System.out.println("Loi: ID da ton tai trong danh sach.");
           return; // Kết thúc chức năng thêm nhân viên
        }

        System.out.print("Nhap ten: ");
        String name = scanner.nextLine();
        
        boolean isNameDuplicate = false;
        for (Employee employee : employeeManager.getEmployeeList()) {
            if (employee.getName().equals(name)) {
             isNameDuplicate = true;
             break;
   }
}

        if (isNameDuplicate) {
            System.out.println("Loi: Ten da ton tai trong danh sach.");
            return; 
        }

        System.out.print("Nhap tuoi: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhap phong ban: ");
        String department = scanner.nextLine();

        System.out.print("Nhap ma thanh vien: ");
        String code = scanner.nextLine();
        boolean isCodeDuplicate = false;
        for (Employee employee : employeeManager.getEmployeeList()) {
            if (employee.getName().equals(code)) {
             isCodeDuplicate = true;
             break;
   }
}

        if (isCodeDuplicate) {
            System.out.println("Loi: Ma da ton tai trong danh sach.");
            return; 
        }

        System.out.print("Nhap muc luong: ");
        double salaryRate = scanner.nextDouble();

        Employee newEmployee = new Employee(id, name, age, department, code, salaryRate);
        employeeManager.addEmployee(newEmployee);

        System.out.println("Danh sach nhan vien sau khi them:");
        displayEmployees(employeeManager);

        System.out.println("Xoa mot nhan vien:");
        System.out.print("Nhap id cua nhan vien can xoa: ");
        int employeeIdToRemove = scanner.nextInt();

        Employee employeeToRemove = findEmployeeById(employeeManager, employeeIdToRemove);
        if (employeeToRemove != null) {
            employeeManager.removeEmployee(employeeToRemove);
            System.out.println("Da xoa nhan vien co ID " + employeeIdToRemove);
        } else {
            System.out.println("Khong tim thay nhan vien co ID " + employeeIdToRemove);
        }

        System.out.println("Danh sach nhan vien sau khi xoa:");
        displayEmployees(employeeManager);
    }

    private static void initializeEmployees(EmployeeManager employeeManager) {
        employeeManager.addEmployee(new Employee(1, "Nguyen Van A", 30, "IT", "24562", 5000));
        employeeManager.addEmployee(new Employee(2, "Nguyen Thi B", 35, "HR","98421", 4500));
        employeeManager.addEmployee(new Employee(3, "Tran Van C", 28, "Sales", "65120", 4800));
        employeeManager.addEmployee(new Employee(4, "Lai Van D", 32, "Marketing", "32456", 4200));
        employeeManager.addEmployee(new Employee(5, "Pham Van E", 29, "Finance", "41235", 5100));
        employeeManager.addEmployee(new Employee(6, "Le Van F", 31, "IT", "65984", 4900));
        employeeManager.addEmployee(new Employee(7, "Pham Bang O", 34, "HR", "24569", 4600));
        employeeManager.addEmployee(new Employee(8, "Vo Van C", 27, "Sales", "48956", 4700));
        employeeManager.addEmployee(new Employee(9, "Pham Minh D", 33, "Marketing", "45123", 4300));
        employeeManager.addEmployee(new Employee(10, "Pham Ngoc F", 30, "Finance", "78954", 5200));
    }

    private static void displayEmployees(EmployeeManager employeeManager) {
        List<Employee> employeeList = employeeManager.getEmployeeList();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    private static Employee findEmployeeById(EmployeeManager employeeManager, int id) {
        List<Employee> employeeList = employeeManager.getEmployeeList();
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
