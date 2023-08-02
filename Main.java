/** ESCOBAR, PRINCESS_SANTIAGO, MONICA - S16A 
 * 
 * The Main class represents the main entry point of the program for the Vending Machine.
 * It allows users to create vending machines, test them, and perform maintenance operations.
 */

import java.util.Scanner;

public class Main {

    private Scanner scanner;

    /**
     * Constructs a new Main instance and initializes the scanner to read user input.
     */
    public Main() {
        scanner = new Scanner(System.in);
    }

     /**
     * Displays the main menu and reads the user's choice.
     *
     * @return The selected option from the main menu.
     */
    public int mainMenu() {
        System.out.println("\n==============================================");
        System.out.println("       █░░░█ █▀▀ █░░ █▀▀ █▀▀█ █▀▄▀█ █▀▀");
        System.out.println("       █▄█▄█ █▀▀ █░░ █░░ █░░█ █░▀░█ █▀▀");
        System.out.println("       ░▀░▀░ ▀▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░░▀ ▀▀▀");
        System.out.println("         to sandWHICH? Vending MOCHIne");
        System.out.println("==============================================\n");
        System.out.println("[1] Create a Vending Machine");
        System.out.println("[2] Test a Vending Machine");
        System.out.println("[3] Exit");
        System.out.print("Enter selection: ");
        return readInteger(1, 3);
    }

    /**
     * Displays the menu to select the type of vending machine to create and reads the user's choice.
     *
     * @return The selected option to create a vending machine.
     */
    public int selectVMType() {
        System.out.println("\nWhich vending machine would you like to create?");
        System.out.println("[1] Regular Vending Machine");
        System.out.println("[2] Special Vending Machine");
        System.out.println("[3] Return to Main Menu");
        System.out.print("Enter your choice: ");
        return readInteger(1, 3);
    }

    /**
     * Displays the test menu for the vending machine and reads the user's choice.
     *
     * @return The selected option from the test menu.
     */
    public int displayTestMenu() {
        System.out.println("\n[Regular] Select an option:");
        System.out.println("[1] Test Vending Machine Features");
        System.out.println("[2] Perform Vending Machine Maintenance");
        System.out.println("[3] Exit");
        System.out.print("Enter your choice: ");
        return readInteger(1, 3);
    }

    /**
     * Displays the maintenance menu for the vending machine and reads the user's choice.
     *
     * @return The selected option from the maintenance menu.
     */
    public int displayMaintMenu() {
        System.out.println("\n[Regular] Select an option:");
        System.out.println("[1] Restock Items");
        System.out.println("[2] Change Item Price");
        System.out.println("[3] Collect Money");
        System.out.println("[4] Replenish Denomination");
        System.out.println("[5] Print Transaction History");
        System.out.println("[6] Exit");
        System.out.println("Enter your selection: ");
        return readInteger(1, 6);
    }

    /**
     * The main method of the program. It creates a new Main instance and starts the program.
     *
     * @param args The command-line arguments (unused in this program).
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.startProgram();
    }

    /**
     * Starts the program and runs the main loop to interact with vending machines.
     */
    public void startProgram() {
        RegularVendingMachine vendingMachine = null;
        SpecialVendingMachine specialVendingMachine = null;
    
        while (true) {
            int choice = mainMenu();
    
            switch (choice) {
                case 1:
                    int vmTypeChoice = selectVMType();
                    if (vmTypeChoice == 1) {
                        vendingMachine = createRegVM();
                    } else if (vmTypeChoice == 2) {
                        specialVendingMachine = createSpecVM();
                    }
                    break;
                case 2:
                    int testChoice = selectTestVendingMachine();
                    if (testChoice == 1) {
                        if (vendingMachine != null) {
                            testRVM(vendingMachine);
                        }else {
                            System.out.println("Error: Regular Vending machine not found.");
                            break;
                        }
                    } else if (testChoice == 2) {
                        if (specialVendingMachine != null) {
                            testSVM(specialVendingMachine);
                        }else {
                            System.out.println("Error: Special Vending machine not found.");
                            break;
                        }
                    }else {
                        break;
                    }                           
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection! Please try again.");
            }
        }
    }
    
    
    private int selectTestVendingMachine() {
        System.out.println("\nChoose the Vending Machine to test:");
        System.out.println("[1] Regular Vending Machine");
        System.out.println("[2] Special Vending Machine");
        System.out.println("[3] Return To Previous Menu");
        System.out.print("Enter your selection: ");
        return readInteger(1, 3);
    }
 
    /**
     * Selects a Regular Vending Machine and creates it with the specified items and machine money.
     *
     * @return The created Regular Vending Machine.
     */
    public RegularVendingMachine createRegVM() {        
        Money machineMoney = addMachineMoney();
        RegularVendingMachine vendingMachine = new RegularVendingMachine(machineMoney);

        // Initialized items
        vendingMachine.addItem("1", new Item("Vanilla", 75, 120, 10, false));
        vendingMachine.addItem("2", new Item("Chocolate", 75, 145, 10, false));
        vendingMachine.addItem("3", new Item("Strawberry", 80, 138, 10, false));
        vendingMachine.addItem("4", new Item("Mango", 80, 157, 10, false));
        vendingMachine.addItem("5", new Item("Cookies & Cream", 85, 192, 10, false));
        vendingMachine.addItem("6", new Item("Coffee", 85, 148, 10, false));
        vendingMachine.addItem("7", new Item("Mint Chip", 90, 179, 10, false));
        vendingMachine.addItem("8", new Item("Matcha", 95, 186, 10, false));

        // Ask the user to input machine money    
        System.out.println("\n===================================");
        System.out.println("\tMachine Money Overview:");
        System.out.println("===================================");

        System.out.println("Coins...");
        System.out.println("1 PHP: " + machineMoney.getPhpOne());
        System.out.println("5 PHP: " + machineMoney.getPhpFive());
        System.out.println("10 PHP: " + machineMoney.getPhpTen());
        System.out.println("20 PHP: " + machineMoney.getPhpTwenty());
        System.out.println("50 PHP: " + machineMoney.getPhpFifty());

        System.out.println("Bills...");
        System.out.println("100 PHP: " + machineMoney.getPhpOneHundred());
        System.out.println("200 PHP: " + machineMoney.getPhpTwoHundred());
        System.out.println("500 PHP: " + machineMoney.getPhpFiveHundred());
        System.out.println("1000 PHP: " + machineMoney.getPhpOneThousand());

        // Calculate and display the total amount of machine money
        int totalMachineMoney = machineMoney.calculateTotalAmount();
        System.out.println("Total Machine Money: " + totalMachineMoney);
        System.out.println("Your Regular Vending Machine is created successfully!");
        System.out.println("Enjoy your goodies...");
        return vendingMachine;
    }

    /**
     * Selects a Special Vending Machine and creates it with the specified items, machine money, and sandwich quantities.
     *
     * @return The created Special Vending Machine.
     */
    public SpecialVendingMachine createSpecVM() {
        Money machineMoney = addMachineMoney();
        SpecialVendingMachine vendingMachine = new SpecialVendingMachine(machineMoney);
    
        System.out.println("\n===================================");
        System.out.println("\tAdd Sandwich Quantity:");
        System.out.println("===================================");
        for (String sandwich : vendingMachine.sandwichCaloriesMap.keySet()) {
            int quantity = readValidInteger(1, 10, "Enter quantity for " + sandwich + " (Max: 10): ");
            vendingMachine.sandwichQuantityMap.put(sandwich, quantity);
        }

        System.out.println("\n===================================");
        System.out.println("\tAdd Product Quantity:");
        System.out.println("===================================");
        for (String product : vendingMachine.productCaloriesMap.keySet()) {
            int quantity = readValidInteger(1, 10, "Enter quantity for " + product + " (Max: 10): ");
            vendingMachine.productQuantityMap.put(product, quantity);
        }
    
        // Ask the user to input machine money
        System.out.println("\n===================================");    
        System.out.println("\tMachine Money Overview:");
        System.out.println("===================================");

        System.out.println("Coins...");
        System.out.println("1 PHP: " + machineMoney.getPhpOne());
        System.out.println("5 PHP: " + machineMoney.getPhpFive());
        System.out.println("10 PHP: " + machineMoney.getPhpTen());
        System.out.println("20 PHP: " + machineMoney.getPhpTwenty());
        System.out.println("50 PHP: " + machineMoney.getPhpFifty());

        System.out.println("Bills...");
        System.out.println("100 PHP: " + machineMoney.getPhpOneHundred());
        System.out.println("200 PHP: " + machineMoney.getPhpTwoHundred());
        System.out.println("500 PHP: " + machineMoney.getPhpFiveHundred());
        System.out.println("1000 PHP: " + machineMoney.getPhpOneThousand());

        // Calculate and display the total amount of machine money
        int totalMachineMoney = machineMoney.calculateTotalAmount();
        System.out.println("Total Machine Money: " + totalMachineMoney);
        System.out.println("Your Special Vending Machine is created successfully!");
        System.out.println("Enjoy your goodies...");
        return vendingMachine;
    }

    /**
     * Adds machine money and returns the created Money object.
     *
     * @return The created Money object with the specified machine money.
     */
    public Money addMachineMoney() {
        Money machineMoney = new Money();

        System.out.println("\n===================================");
        System.out.println("\tAdd Machine Money:");
        System.out.println("===================================");
        System.out.println("COINS...");
        machineMoney.setPhpOne(readValidInteger(1, 10, "Enter number of 1 PHP coins: "));
        machineMoney.setPhpFive(readValidInteger(1, 10, "Enter number of 5 PHP coins: "));
        machineMoney.setPhpTen(readValidInteger(1, 10, "Enter number of 10 PHP coins: "));
        machineMoney.setPhpTwenty(readValidInteger(1, 10, "Enter number of 20 PHP coins: "));
        machineMoney.setPhpFifty(readValidInteger(1, 10, "Enter number of 50 PHP coins: "));

        System.out.println("BILLS...");
        machineMoney.setPhpOneHundred(readValidInteger(1, 10, "Enter number of 100 PHP bills: "));
        machineMoney.setPhpTwoHundred(readValidInteger(1, 10, "Enter number of 200 PHP bills: "));
        machineMoney.setPhpFiveHundred(readValidInteger(1, 10, "Enter number of 500 PHP bills: "));
        machineMoney.setPhpOneThousand(readValidInteger(1, 10, "Enter number of 1000 PHP bills: "));

        return machineMoney;
    }

    /**
     * Reads an integer input from the user and validates it within the specified range.
     *
     * @param min The minimum allowed value for the input.
     * @param max The maximum allowed value for the input.
     * @return The validated integer input from the user.
     */
    public int readInteger(int min, int max) {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return value;
    }

    /**
     * Reads a valid integer input from the user within the specified range with a custom message.
     *
     * @param min     The minimum allowed value for the input.
     * @param max     The maximum allowed value for the input.
     * @param message The message to display while requesting the input.
     * @return The validated integer input from the user.
     */
    public int readValidInteger(int min, int max, String message) {
        int value;
        while (true) {
            System.out.print(message);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return value;
    }

    /**
     * Reads a valid double input from the user within the specified range with a custom message.
     *
     * @param min     The minimum allowed value for the input.
     * @param max     The maximum allowed value for the input.
     * @param message The message to display while requesting the input.
     * @return The validated double input from the user.
     */
    public double readValidDouble(double min, double max, String message) {
        double value;
        while (true) {
            System.out.print(message);
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }

    /**
     * Reads a string input from the user with a custom message.
     *
     * @param message The message to display while requesting the input.
     * @return The string input from the user.
     */
    public String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    /**
     * Tests the functionalities of the Regular Vending Machine.
     *
     * @param vm The Regular Vending Machine instance to test.
     */
    public void testRVM(RegularVendingMachine vm) {
        while (true) {
            int choice = displayTestMenu();
            switch (choice) {
                case 1:
                    vm.venMachineFeatures();
                    break;
                case 2:
                    checkMaintenance(vm);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection! Please try again.");
            }
        }
    }

    /**
     * Tests the functionalities of the Special Vending Machine.
     *
     * @param svm The Special Vending Machine instance to test.
     */
    public void testSVM(SpecialVendingMachine svm) {
        int choice;
        do {
            choice = displaySVMMenu();
    
            switch (choice) {
                case 1:
                    venMachineFeaturesSpec(svm);
                case 2:
                    checkMaintenanceSpec(svm);
                case 3:
                    selectTestVendingMachine();
                default:
                    System.out.println("Invalid selection! Please try again.");                    
            }
        } while (choice != 3);
    }
    
    /**
     * Displays the Special Vending Machine (SVM) menu to choose a feature for testing.
     *
     * @return The user's choice of feature from the SVM menu.
     */
    public int displaySVMMenu() {
        System.out.println("\n[Special] Choose a feature to test:");
        System.out.println("[1] Test Vending Machine Features");
        System.out.println("[2] Perform Vending Machine Maintenance");
        System.out.println("[3] Return To Previous Menu");
        System.out.print("Enter your choice: ");
        return readInteger(1, 3);
    }    
    
    /**
     * Allows the user to perform maintenance operations on a Regular Vending Machine (RVM).
     *
     * @param vm The Regular Vending Machine instance on which maintenance operations are performed.
     */
    public void checkMaintenance(RegularVendingMachine vm) {
        while (true) {
            int choice = displayMaintMenu();
            switch (choice) {
                case 1:
                    vm.restockItems();
                    break;
                case 2:
                    vm.changeVenItem();
                    break;
                case 3:
                    vm.collectVenMoney();
                    break;
                case 4:
                    vm.addVenMoney();
                    break;
                case 5:
                    vm.printVenTransaction();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Selection! Please try again.");
            }
       
        }
    }

    /**
     * Allows the user to test specific features of the Special Vending Machine (SVM).
     *
     * @param svm The Special Vending Machine instance on which features are tested.
     */
    public void venMachineFeaturesSpec(SpecialVendingMachine svm) {
        int choice;
        do {
            System.out.println("\n[Special] Select an option:");
            System.out.println("[1] Display Available Sandwiches");
            System.out.println("[2] Purchase Sandwich");
            System.out.println("[3] Return To Previous Menu");
            System.out.print("Enter your choice: ");
            choice = readInteger(1, 3);
    
            switch (choice) {
                case 1:
                    svm.displayAvailableSandwiches();
                    break;
                case 2:
                    svm.purchaseSandwich();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection! Please try again.");
            }
        } while (choice != 0);
    }
    
    /**
     * Allows the user to perform maintenance operations on the Special Vending Machine (SVM).
     *
     * @param svm The Special Vending Machine instance on which maintenance operations are performed.
     */
    public void checkMaintenanceSpec(SpecialVendingMachine svm) {
        int choice;
        do {
            System.out.println("\n[Special] Select an option:");
            System.out.println("[1] Restock Items");
            System.out.println("[2] Add Money To Machine");
            System.out.println("[3] Collect Money");
            System.out.println("[4] Print Transaction History");
            System.out.println("[5] Return To Previous menu");
            System.out.print("Enter your choice: ");
            choice = readInteger(1, 5);
    
            switch (choice) {
                case 1:
                    svm.restockItemsSpec();
                    break;
                case 2:
                    svm.addVenMoney();
                    break;
                case 3:
                    svm.collectVenMoneySpec();
                    break;
                case 4:
                    svm.printVenTransactionSpec();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid selection! Please try again.");
            }
        } while (choice != 0);
    }
    
}