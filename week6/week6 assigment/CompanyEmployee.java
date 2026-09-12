public class CompanyEmployee {

    // Instance fields
    String empName;
    double salary;

    // Static fields
    static String companyName =
        "Bright Horizon Technologies";

    static int employeeCount = 0;

    // Constructor
    CompanyEmployee(String empName, double salary) {

        this.empName = empName;
        this.salary = salary;

        // Increase count whenever an object is created
        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {

        System.out.println(companyName);
        System.out.println(
            "Employees on record: " + employeeCount
        );
    }

    public static void main(String[] args) {

        // Create three employees
        CompanyEmployee employee1 =
            new CompanyEmployee("Divya", 65000);

        CompanyEmployee employee2 =
            new CompanyEmployee("Arjun", 45000);

        CompanyEmployee employee3 =
            new CompanyEmployee("Priya", 55000);

        // Call static method using CLASS NAME
        CompanyEmployee.printCompanyInfo();
    }
}