import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FoodDeliverySystem {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Restaurant> restaurants = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Food Quick!");

        // Capture customer details
        System.out.println("Enter customer details:");
        int orderNumber = captureIntInput("Order number: ");
        String customerName = captureStringInput("Customer name: ");
        String contactNumber = captureStringInput("Contact number: ");
        String address = captureStringInput("Address: ");
        String location = captureStringInput("Location (city): ");
        String email = captureStringInput("Email address: ");

        Customer customer = new Customer(orderNumber, customerName, contactNumber, address, location, email);
        customers.add(customer);

        // Capture restaurant details
        System.out.println("\nEnter restaurant details:");
        String restaurantName = captureStringInput("Restaurant name: ");
        String restaurantLocation = captureStringInput("Restaurant location: ");
        String restaurantContactNumber = captureStringInput("Restaurant contact number: ");

        Restaurant restaurant = new Restaurant(restaurantName, restaurantLocation, restaurantContactNumber);
        restaurants.add(restaurant);

        // Read drivers.txt file and find the driver in the correct area with the smallest load
        String driverName = findDriver(location);

        // Generate invoice
        generateInvoice(customer, restaurant, driverName);

        System.out.println("\nInvoice generated successfully!");
    }

    private static int captureIntInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

    private static String captureStringInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }

    private static String findDriver(String location) {
        try {
            File file = new File("drivers.txt");
            Scanner scanner = new Scanner(file);

            String driverName = "";
            int minLoad = Integer.MAX_VALUE;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");

                if (parts.length == 3) {
                    String name = parts[0];
                    String driverLocation = parts[1];
                    int load = Integer.parseInt(parts[2]);

                    if (driverLocation.equalsIgnoreCase(location) && load < minLoad) {
                        driverName = name;
                        minLoad = load;
                    }
                }
            }

            scanner.close();

            if (!driverName.isEmpty()) {
                return driverName;
            } else {
                return "Sorry! Our drivers are too far away from you to be able to deliver to your location.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    private static void generateInvoice(Customer customer, Restaurant restaurant, String driverName) {
        try {
            FileWriter writer = new FileWriter("invoice.txt");

            writer.write("Order number: " + customer.getOrderNumber() + "\n");
            writer.write("Customer: " + customer.getCustomerName() + "\n");
            writer.write("Email: " + customer.getEmail() + "\n");
            writer.write("Phone number: " + customer.getContactNumber() + "\n");
            writer.write("Location: " + customer.getLocation() + "\n\n");

            writer.write("You have ordered the following from " + restaurant.getName() +
                    " in " + restaurant.getLocation() + ":\n");

            // Assuming you have a list of meals and their prices
            List<String> meals = new ArrayList<>();
            meals.add("Pepperoni pizza (R78.00)");
            meals.add("Hawaiian pizza (R82.00)");

            for (String meal : meals) {
                writer.write("- 1 x " + meal + "\n");
            }

            // Assuming you have special instructions provided by the customer
            String specialInstructions = "Extra tomato base on the Pepperoni pizza";
            
             if (!specialInstructions.isEmpty()) {
                writer.write("Special instructions: " + specialInstructions+ "\n");
             }
            
             double totalAmount = 78.00 * 1 + 82.00 * 2;
             writer.write("\nTotal: R" + totalAmount);

             if (!driverName.startsWith("Sorry")) {
                writer.write("\n\n" + driverName+ " is nearest to the restaurant and so he will be delivering your order to you at:\n");
                writer.write(customer.getAddress()+ "\n");
                writer.write(customer.getLocation());
             }

             // Assuming you have contact number of the restaurant
             String restaurantContactNumber = restaurant.getContactNumber();
             writer.write("\n\nIf you need to contact the restaurant, their number is " + restaurantContactNumber+ ".");

             writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
