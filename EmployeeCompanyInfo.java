class EmployeeCompanyInfo {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeCompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeCompanyInfo("Divya", 65000);
        new EmployeeCompanyInfo("Arjun", 0);
        new EmployeeCompanyInfo("Priya", 55000);

        EmployeeCompanyInfo.printCompanyInfo();
    }
}
