import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DealershipFileManager {
    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fileWriter = new FileWriter("dealership.csv");
            CSVWriter csvWriter = new CSVWriter(fileWriter);


            String[] header = {"VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"};
            csvWriter.writeNext(header);

             for(Vehicle vehicle : dealership.getInventory()) {
                 String[] data = {String.valueOf(vehicle.getVin()), String.valueOf(vehicle.getYear()), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), String.valueOf(vehicle.getOdometer()), String.valueOf(vehicle.getPrice())};
                 csvWriter.writeNext(data);
             }


            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}