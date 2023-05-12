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

            }
        }
    }
}