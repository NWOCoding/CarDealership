import java.util.Scanner;

public class UserInterface{
    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        init();
    }
    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.loadDealership();
    }

    public void display() {
        boolean quit = false;
        while (!quit){
            System.out.println("Welcome to" + dealership.getName() + "!");
            System.out.println("1. View inventory");
            System.out.println("2. Add vehicle to inventory");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayVehicles();
                    break;
                case 2:
                    addVehicle();
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice Please try again");

            }
        }
    }

               private void displayVehicles() {
                   System.out.println("Inventory: ");
                   for (Vehicle vehicle : dealership.getInventory()) {
                       System.out.println(vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + " -$" + vehicle.getPrice());

                   }
               }

               private void addVehicle() {
                   System.out.println("Enter VIN: ");
                   int vin = scanner.nextInt();
                   scanner.nextLine();

                   System.out.println("Enter year: ");
                   int year = scanner.nextInt();
                   scanner.nextLine();

                   System.out.println("Enter make: ");
                   String make = scanner.nextLine();

                   System.out.println("Enter model: ");
                   String model = scanner.nextLine();

                   System.out.println("Enter vehicle type: ");
                   String vehicleType = scanner.nextLine();

                   System.out.println("Enter color: ");
                   String color = scanner.nextLine();

                   System.out.println("Enter odometer: ");
                   int odometer = scanner.nextInt();
                   scanner.nextLine();

                   System.out.println("Enter price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                   Vehicle vehicle = new Vehicle(vin, year,make,model,vehicleType,color,odometer,price );
                   dealership.getInventory().add(vehicle);

                   DealershipFileManager dealershipFileManager = new DealershipFileManager();
                   dealershipFileManager.saveDealership(dealership);

                   System.out.println("Vehicle added to inventory");
               }
}