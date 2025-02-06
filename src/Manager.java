public class Manager extends StaffMember {
    private double bonus;

    // Parameterized constructor
    public Manager(String firstName, String lastName, String deptNumber, double hoursWorked, double bonus) {
        super(firstName, lastName, deptNumber, hoursWorked);
        this.bonus = bonus;
    }

    // Getter and Setter for bonus
    private double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // Override calculateSalary method
    @Override
    public double calculateSalary() {
        return (getHoursWorked() * 2500) + bonus;
    }

    // Override display method to include bonus
    @Override
    public void display() {
        super.display();
        System.out.println("Bonus: " + bonus);
    }
}