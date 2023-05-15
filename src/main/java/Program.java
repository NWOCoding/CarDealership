public class Program {
    public static void main(String[] args) {
        Dealership dealership = new Dealership("My Dealership", "123 Main St", "555-1234", "inventory.csv");
        UserInterface ui = new UserInterface(dealership);
        ui.display();
    }
}
