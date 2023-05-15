import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public Dealership(String name, String address, String phone, String csvFilePath) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                inventory.add(vehicle);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void saveInventory() {
        String csvFilePath = "inventory.csv";
        try (FileWriter writer = new FileWriter(csvFilePath)) {
            for (Vehicle vehicle : inventory) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }
}
