public class SalesRep extends StaffMember {
    private double allowance;

    // Parameterized constructor
    public SalesRep(String firstName, String lastName, String deptNumber, double hoursWorked, double allowance) {
        super(firstName, lastName, deptNumber, hoursWorked);
        this.allowance = allowance;
    }

    // Getter and Setter for allowance
    private double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    // Override calculateSalary method
    @Override
    public double calculateSalary() {
        return (getHoursWorked() * 1500) + allowance;
    }

    // Override display method to include allowance
    @Override
    public void display() {
        super.display();
        System.out.println("Allowance: " + allowance);
    }
}