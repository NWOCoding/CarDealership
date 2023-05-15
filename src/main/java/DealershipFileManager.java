import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealershipFileManager {
    private String inventory;

    public DealershipFileManager(String filename) {
        this.inventory = filename;
    }

    public Dealership loadDealership() {
        Dealership dealership = new Dealership();

        try {
            FileReader fileReader = new FileReader(inventory);
            CSVReader csvReader = new CSVReader(fileReader);

            csvReader.skip(1);

            String[] data;
            while ((data = csvReader.readNext()) != null) {
                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String type = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fileWriter = new FileWriter(inventory);
            CSVWriter csvWriter = new CSVWriter(fileWriter)
        }
    }
}