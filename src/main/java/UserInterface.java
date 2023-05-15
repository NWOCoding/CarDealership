import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to " + dealership.getName() + "!");
            System.out.println("Please select an option:");
            System.out.println("1. Search for vehicles by year range");
            System.out.println("2. Search for vehicles by color");
            System.out.println("3. Search for vehicles by mileage range");
            System.out.println("4. Search for vehicles by type");
            System.out.println("5. Add a vehicle to the inventory");
            System.out.println("6. Remove a vehicle from the inventory");
            System.out.println("7. Save inventory to file");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter minimum year:");
                    int minYear = scanner.nextInt();
                    System.out.println("Enter maximum year:");
                    int maxYear = scanner.nextInt();
                    List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(minYear, maxYear);
                    System.out.println("Vehicles found:");
                    for (Vehicle vehicle : vehiclesByYear) {
                        System.out.println(vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel());
                    }
                    break;
                case 2:
                    System.out.println("Enter color:");
                    String color = scanner.nextLine();
                    List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
                    System.out.println("Vehicles found:");
                    for (Vehicle vehicle : vehiclesByColor) {
                        System.out.println(vehicle.getColor() + " " + vehicle.getMake() + " " + vehicle.getModel());
                    }
                    break;
                case 3:
                    System.out.println("Enter minimum mileage:");
                    int minMileage = scanner.nextInt();
                    System.out.println("Enter maximum mileage:");
                    int maxMileage = scanner.nextInt();
                    List<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(minMileage, maxMileage);
                    System.out.println("Vehicles found:");
                    for (Vehicle vehicle : vehiclesByMileage) {
                        System.out.println(vehicle.getOdometer() + " miles " + vehicle.getMake() + " " + vehicle.getModel());
                    }
                    break;
                case 4:
                    System.out.println("Enter vehicle type:");
                    String vehicleType = scanner.nextLine();
                    List<Vehicle> vehiclesByType = dealership.getVehiclesByType(vehicleType);
                    System.out.println("Vehicles found:");
                    for (Vehicle vehicle : vehiclesByType) {
                        System.out.println(vehicle.getVehicleType() + " " + vehicle.getMake() + " " + vehicle.getModel());
                    }
                    break;
                case 5:
                    System.out.println("Enter VIN:");
                    int vin = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter make:");
                    String make = scanner.nextLine();
                    System.out.println("Enter model:");
                    String model = scanner.nextLine();
                    System.out.println("Enter vehicle type:");
                    String type = scanner.nextLine();
                    System.out.println("Enter color:");
                    String vehicleColor = scanner.nextLine();
                    System.out.println("Enter odometer reading:");
                    int odometer = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Vehicle newVehicle = new Vehicle(vin, year, make, model, type, vehicleColor, odometer, price);
                    dealership.addVehicle(newVehicle);
                    System.out.println("Vehicle added to inventory.");
                    break;
                case 6:
                    System.out.println("Enter VIN of vehicle to remove:");
                    int vinToRemove = scanner.nextInt();
                    scanner.nextLine();
                    List<Vehicle> inventory = dealership.getInventory();
                    boolean vehicleRemoved = false;
                    for (Vehicle vehicle : inventory) {
                        if (vehicle.getVin() == vinToRemove) {
                            dealership.removeVehicle(vehicle);
                            System.out.println("Vehicle removed from inventory.");
                            vehicleRemoved = true;
                            break;
                        }
                    }
                    if (!vehicleRemoved) {
                        System.out.println("Vehicle with VIN " + vinToRemove + " not found in inventory.");
                    }
                    break;
                case 7:
                    dealership.saveInventory();
                    System.out.println("Inventory saved to file.");
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
