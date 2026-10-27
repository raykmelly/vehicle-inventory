package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class VehicleInventoryApp {
    public static void main(String[] args) {
        // Create a scanner
        Scanner scanner = new Scanner(System.in);

        // Create an array (vehicles) that stores 5 vehicle objects
        List<Vehicle> vehicles = new ArrayList<>(6);

        // Preload the vehicles (array with 5 Vehicle objects)
        loadVehicles(vehicles);

        // Enter the menu loop
        boolean running = true;

        while (running) {
            System.out.println("\n-> Select a choice from the menu");
            int choice = promptChoice(scanner);

            switch (choice) {
                case 1:
                    // List all the vehicles
                    listAllVehicles(vehicles);
                    break;
                case 2:
                    // Search by make / model
                    searchForMakeModel(vehicles,scanner);
                    break;
                case 3:
                    // Search by price range
                    searchForPriceRange(vehicles,scanner);
                    break;
                case 4:
                    // Search by color
                    searchForColor(vehicles,scanner);
                    break;
                case 5:
                    // Add a vehicle
                    addVehicle(vehicles,scanner);
                    break;
                case 6:
                    // Exit the program
                    System.out.println("-> Exiting the program...");
                    running = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error, invalid choice, try again.");
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Method to add a vehicle
    public static void addVehicle(List<Vehicle> vehicles, Scanner scanner) {
        scanner.nextLine();
        System.out.println("-> What is the vehicle's vehicle ID? (ex. 101121)");
        long vehicleId = scanner.nextLong();
        scanner.nextLine();
        System.out.println("-> What is the vehicle's make / model?");
        String makeModel = scanner.nextLine();
        System.out.println("-> What is the vehicle's color");
        String color = scanner.nextLine();
        System.out.println("-> What is the vehicle's odometer reading?");
        int odometerReading = scanner.nextInt();
        System.out.println("-> What is the vehicle's price");
        double price = scanner.nextDouble();

        vehicles.add(new Vehicle(
                vehicleId,makeModel,
                color,odometerReading,price
        ));
    }

    // Method to search vehicles by color
    public static void searchForColor(List<Vehicle> vehicles, Scanner scanner) {
        scanner.nextLine();
        System.out.println("-> Enter your preferred car color");
        String color = scanner.nextLine();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                System.out.println("[FOUND]: " + vehicle.getMakeModel());
            }
        }
    }

    // Method to search for price on the cars
    public static void searchForPriceRange(List<Vehicle> vehicles, Scanner scanner) {
        scanner.nextLine();
        System.out.println("-> Enter your min price");
        double minPrice = scanner.nextDouble();
        System.out.println("-> Enter your max price");
        double maxPrice = scanner.nextDouble();

        List<Vehicle> vehiclesInPriceRange = new ArrayList<Vehicle>();

        for (Vehicle vehicle : vehicles) {
            double vehiclePrice = vehicle.getPrice();
            if ((vehiclePrice >= minPrice) & (vehiclePrice <= maxPrice)) {
                vehiclesInPriceRange.add(vehicle);
            }
        }
        // Display the found vehicles in price range
        for (Vehicle vehicle : vehiclesInPriceRange) {
            System.out.println("[FOUND]: " + vehicle.getMakeModel());
        }
    }

    // Method to search for a specific make/model
    public static void searchForMakeModel(List<Vehicle> vehicles,Scanner scanner) {
        scanner.nextLine();
        System.out.println("-> Enter a make/model to search");
        String search = scanner.nextLine();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMakeModel().equalsIgnoreCase(search)) {
                // Found the vehicle, display its information
                System.out.println("- [FOUND]: " + vehicle.getMakeModel());
            }
        }
    }

    // Method to display all the vehicles
    public static void listAllVehicles(List<Vehicle> vehicles) {
        System.out.println("-> These are the current vehicles (" + vehicles.size() + ")");
        for (Vehicle vehicle : vehicles) {
            System.out.println("- " + vehicle.getMakeModel());
        }
    }
    public static int promptChoice(Scanner scanner){
        System.out.println("1.) List all vehicles");
        System.out.println("2.) Search by make/model");
        System.out.println("3.) Search by price range");
        System.out.println("4.) Search by color");
        System.out.println("5.) Add a vehicle");
        System.out.println("6.) Quit");

        return scanner.nextInt();
    }

    // Method to preload the vehicles
    public static void loadVehicles(List<Vehicle> vehicles) {
        // Preload the array with vehicles.
        vehicles.add(new Vehicle(
                101121,"Ford Explorer",
                "Red",45000,13500
        ));
        vehicles.add(new Vehicle(
                101122,"Toyota Camry",
                "Blue",60000,11000
        ));
        vehicles.add(new Vehicle(
                101123,"Chevrolet Malibu",
                "Black",50000,9700
        ));
        vehicles.add(new Vehicle(
                101124,"Honda Civic",
                "White",70000,7500
        ));
        vehicles.add(new Vehicle(
                101125,"Subaru Outback",
                "Green",55000,14500
        ));
        vehicles.add(new Vehicle(
                101126,"Jeep Wrangler",
                "Yellow",30000,16000
        ));
    }
}