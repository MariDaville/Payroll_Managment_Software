import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Payroll {
    public static void main(String[] args) {
        //Object Instantiation and Display
        StaffMember staffMember = new StaffMember("Lloyd", "Bonner", "D001", 40) {
            @Override
            public double calculateSalary() {
                return 0; // Not used for this object
            }
        };
        staffMember.display();

        //List of Sales Representatives
        ArrayList<SalesRep> salesReps = new ArrayList<>();
        salesReps.add(new SalesRep("Alice", "Smith", "D002", 35, 500));
        salesReps.add(new SalesRep("Bob", "Johnson", "D003", 40, 600));
        salesReps.add(new SalesRep("Charlie", "Brown", "D004", 30, 400));
        salesReps.add(new SalesRep("David", "Wilson", "D005", 45, 700));
        salesReps.add(new SalesRep("Eve", "Davis", "D006", 50, 800));

        //Iterates thru the ArrayList and invoke the Displaying method for each Sales Representatives
        for (SalesRep salesRep : salesReps) {
            salesRep.display();
        }

        //Demonstrating Polymorphism
        StaffMember manager = new Manager("Frank", "Miller", "D007", 40, 1000);
        manager.display();

        //Displaying Salaries
        Manager managerObj = new Manager("Grace", "Lee", "D008", 40, 1200);
        SalesRep salesRepObj = new SalesRep("Henry", "Garcia", "D009", 35, 500);

        //System.out.println("Manager Salary: " + managerObj.calculateSalary());
        System.out.println("Manager Salary: \n" + managerObj.getFirstName() + " " + managerObj.getLastName() + " " + managerObj.getDeptNumber() + " " + managerObj.getHoursWorked() + " " + "$"+ managerObj.calculateSalary());
        //System.out.println("SalesRep Salary: " + salesRepObj.calculateSalary());

        // Generatin Paystub wit names and depNumber
        try (FileWriter writer = new FileWriter("paystubs.txt")) {
            writer.write("Manager Salary: \n" + managerObj.getDeptNumber() + " " + managerObj.getFirstName() + " " + managerObj.getLastName() + " " + "$"+ managerObj.calculateSalary() + "\n\n");
            writer.write("SalesRep Salary: " +/*+ salesRepObj.calculateSalary() +*/ "\n");
            for (SalesRep salesRep : salesReps) {
                writer.write(salesRep.getDeptNumber() + " " + salesRep.getFirstName() + " " + salesRep.getLastName() + " Salary: " + "$" + salesRep.calculateSalary() + "\n");
            }
            System.out.println("Paystubs generated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while generating paystubs: " + e.getMessage());
        }
    }
}
