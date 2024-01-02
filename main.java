import java.util.*;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

    public abstract double calculateSalary();

    public String getName(){
        return name;
    }

    public int getid(){
        return id;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee{
    public double MonthlySalary;

    public FullTimeEmployee(String name,int id,double MonthlySalary){
        super(name,id);
        this.MonthlySalary=MonthlySalary;
    }

    @Override
    public double calculateSalary(){
        return MonthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    public int hrsWrkd;
    public double hrRate;

    public PartTimeEmployee(String name,int id,int hrsWrkd,double hrRate){
        super(name,id);
        this.hrsWrkd=hrsWrkd;
        this.hrRate=hrRate;
    }

    @Override
    public double calculateSalary(){
        return hrRate*hrsWrkd;
    }
}

class PayRollSystem{
    private List<Employee> employeeList;

    public PayRollSystem(){
        employeeList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee EmployeeToBeRemoved=null;
        for(Employee employee: employeeList){
            if(employee.getid()==id){
                EmployeeToBeRemoved=employee;
                break;
            }
        }
        if(EmployeeToBeRemoved!=null){
            employeeList.remove(EmployeeToBeRemoved);
        }
    }

    public void displayEmployees(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}

class Main{
    public static void main(String[] args){
        PayRollSystem payrollSystem = new PayRollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("John Doe", 101, 5000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Jane Smith", 102, 30, 15.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    }
}
