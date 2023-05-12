import com.opencsv.CSVWriter;
import java.io.FileWriter;

public class DealershipFileManager {
    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fileWriter = new FileWriter("dealership.csv");
            CSVWriter csvWriter = new CSVWriter(fileWriter);
        }
    }

}
