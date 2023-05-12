import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
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

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(this);
    }

    public void editvehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        for (Vehicle vehicle : inventory) {
          if(vehicle.getVin() == vin) {
              vehicle.setYear(year);
              vehicle.setMake(make);
              vehicle.setModel(model);
              vehicle.setVehicleType(vehicleType);
              vehicle.setColor(color);
              vehicle.setOdometer(odometer);
              vehicle.setPrice(price);
          }
        }
    }
}