import java.util.Scanner;

// Superclass: Staff (Does not contain a main method)
class Staff {
    protected String staffNo;
    protected String staffName;
    protected int staffAge;

    public Staff(String staffNo, String staffName, int staffAge) {
        this.staffNo = staffNo;
        this.staffName = staffName;
        this.staffAge = staffAge;
    }

    public void display() {
        System.out.println("\nStaff Number: " + staffNo);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Staff Age: " + staffAge);
    }
}

// Subclass 1: FulltimeStaff
class FulltimeStaff extends Staff {
    private double basicSalary;
    private double statutoryDeductions;

    public FulltimeStaff(String staffNo, String staffName, int staffAge, double basicSalary, double statutoryDeductions) {
        super(staffNo, staffName, staffAge);
        this.basicSalary = basicSalary;
        this.statutoryDeductions = statutoryDeductions;
    }

    public double calculateNetSalary() {
        return basicSalary - statutoryDeductions;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("Monthly Net Pay: USD %.2f\n", calculateNetSalary());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Capture Full-Time Staff Details ---");
        
        System.out.print("Enter Staff Number: ");
        String no = sc.nextLine();
        System.out.print("Enter Staff Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Monthly Basic Salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter Statutory Deductions: ");
        double deductions = sc.nextDouble();

        FulltimeStaff ft = new FulltimeStaff(no, name, age, salary, deductions);
        System.out.println("\n--- Full-Time Staff Payroll Profile ---");
        ft.display();
        sc.close();
    }
}

// Subclass 2: ParttimeStaff
class ParttimeStaff extends Staff {
    private int hoursWorked;
    // Rule constraint: Rate per hour must be a property of the class, not a local variable
    private final double hourlyRate = 10.0; 

    public ParttimeStaff(String staffNo, String staffName, int staffAge, int hoursWorked) {
        super(staffNo, staffName, staffAge);
        this.hoursWorked = hoursWorked;
    }

    public double calculateNetSalary() {
        double grossPay = hoursWorked * hourlyRate;
        double tax = 0.30 * grossPay; // 30% tax deduction
        return grossPay - tax;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("Monthly Net Pay (After 30%% Tax): USD %.2f\n", calculateNetSalary());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Capture Part-Time Staff Details ---");
        
        System.out.print("Enter Staff Number: ");
        String no = sc.nextLine();
        System.out.print("Enter Staff Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Hours Worked: ");
        int hours = sc.nextInt();

        ParttimeStaff pt = new ParttimeStaff(no, name, age, hours);
        System.out.println("\n--- Part-Time Staff Payroll Profile ---");
        pt.display();
        sc.close();
    }
}
