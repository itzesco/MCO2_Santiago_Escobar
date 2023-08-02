/** ESCOBAR, PRINCESS_SANTIAGO, MONICA - S16A 
 * 
 * SpecialVendingMachine extends the RegularVendingMachine class and represents a specialized vending machine
 * that sells sandwiches and various products. It keeps track of the available sandwiches and products, their
 * prices, calories, and quantities in stock. The vending machine also tracks the total sales, gross income, and
 * change available.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class SpecialVendingMachine extends RegularVendingMachine {
    // Fields for sandwich and product information
    protected Map<String, Integer> sandwichCaloriesMap;
    protected Map<String, Integer> sandwichPriceMap;
    protected Map<String, Integer> productCaloriesMap;
    protected Map<String, Integer> productPriceMap;
    protected Map<String, Integer> sandwichQuantityMap;
    protected Map<String, Integer> productQuantityMap;
    // Fields to keep track of sales and income
    private HashMap<String, Integer> sandwichSoldMap = new HashMap<>();
    private HashMap<String, Integer> productSoldMap = new HashMap<>();
    private double totalPrice = 0;
    private double grossIncome = 0;

    /**
     * Constructs a SpecialVendingMachine object with the specified initial machine money.
     *
     * @param machineMoney the initial machine money.
     */
    public SpecialVendingMachine(Money machineMoney) {
        super(machineMoney);
        initializeSandwichMaps();
        initializeProductMaps(); 
        initializeProductQuantityMap();
        initializeSandwichQuantityMap();
    }

    /**
     * Initializes the maps for sandwich calories and prices.
     * The sandwichCaloriesMap and sandwichPriceMap are populated with various sandwich names as keys and their
     * corresponding calories and prices as values.
     */
    public void initializeSandwichMaps() {
        sandwichCaloriesMap = new LinkedHashMap<>();
        sandwichPriceMap = new LinkedHashMap<>();

        sandwichCaloriesMap.put("Smoked Salmon Sandwich", 470);
        sandwichCaloriesMap.put("California Chicken Club", 720);
        sandwichCaloriesMap.put("Egg and Ham Sandwich", 272);
        sandwichCaloriesMap.put("Chicken Sandwich", 283);
        sandwichCaloriesMap.put("Grilled Cheese Sandwich", 250);
        sandwichCaloriesMap.put("Nutella Sandwich", 296);
        sandwichCaloriesMap.put("Tuna Sandwich", 187);
        sandwichCaloriesMap.put("Meatball Sandwich", 571);
        sandwichCaloriesMap.put("Hamburger", 295);
        sandwichCaloriesMap.put("Hungarian Sausage Sandwich", 325);

        sandwichPriceMap.put("Smoked Salmon Sandwich", 180);
        sandwichPriceMap.put("California Chicken Club", 180);
        sandwichPriceMap.put("Egg and Ham Sandwich", 120);
        sandwichPriceMap.put("Chicken Sandwich", 150);
        sandwichPriceMap.put("Grilled Cheese Sandwich", 100);
        sandwichPriceMap.put("Nutella Sandwich", 100);
        sandwichPriceMap.put("Tuna Sandwich", 130);
        sandwichPriceMap.put("Meatball Sandwich", 170);
        sandwichPriceMap.put("Hamburger", 150);
        sandwichPriceMap.put("Hungarian Sausage Sandwich", 160);
    }

    /**
     * Initializes the maps for product calories and prices.
     * The productCaloriesMap and productPriceMap are populated with various product names as keys and their
     * corresponding calories and prices as values.
     */
    public void initializeProductMaps() {
        productCaloriesMap = new LinkedHashMap<>(); // Preserve insertion order
        productPriceMap = new LinkedHashMap<>();    // Preserve insertion order

        // Choices of items for the product that the user wants
        productCaloriesMap.put("White Bread", 70);
        productCaloriesMap.put("Wheat Bread", 55);
        productCaloriesMap.put("Ketchup", 20);
        productCaloriesMap.put("Mayonnaise", 90);
        productCaloriesMap.put("Mustard", 5);
        productCaloriesMap.put("Tomatoes", 12);
        productCaloriesMap.put("Lettuce", 2);
        productCaloriesMap.put("Cheese", 100);
        productCaloriesMap.put("Cucumber", 3);
        productCaloriesMap.put("Fries", 312);
        productCaloriesMap.put("Soda", 40);
        productCaloriesMap.put("Water", 0);

        productPriceMap.put("White Bread", 15);
        productPriceMap.put("Wheat Bread", 20);
        productPriceMap.put("Ketchup", 5);
        productPriceMap.put("Mayonnaise", 10);
        productPriceMap.put("Mustard", 5);
        productPriceMap.put("Tomatoes", 8);
        productPriceMap.put("Lettuce", 5);
        productPriceMap.put("Cheese", 25);
        productPriceMap.put("Cucumber", 5);
        productPriceMap.put("Fries", 50);
        productPriceMap.put("Soda", 15);
        productPriceMap.put("Water", 10);
    }

     /**
     * Initializes the sandwichQuantityMap with initial quantities set to 0 for each sandwich.
     */
    private void initializeSandwichQuantityMap() {
        sandwichQuantityMap = new HashMap<>();
        // Initialize the quantity of each sandwich to 0.
        for (String sandwich : sandwichCaloriesMap.keySet()) {
            sandwichQuantityMap.put(sandwich, 0);
        }
    }
    
    /**
     * Initializes the productQuantityMap with initial quantities set to 0 for each product.
     */
    private void initializeProductQuantityMap() {
        productQuantityMap = new HashMap<>();
        // Initialize the quantity of each product to 0.
        for (String product : productCaloriesMap.keySet()) {
            productQuantityMap.put(product, 0);
        }
    }
    
    /**
     * Allows a customer to purchase a sandwich and select add-on products.
     * The method displays the available sandwiches, prompts the user to select a sandwich by slot number.
     * Presents the available products as add-ons. 
     */
    public void purchaseSandwich() {
        displayAvailableSandwiches();
        System.out.println("");
        String sandwichSlot = readValidString("Enter the slot number of the sandwich you want to purchase: ");
        String sandwichChoice = getSandwichBySlot(sandwichSlot);
        
        if (sandwichChoice != null) {
            int sandwichBasePrice = sandwichPriceMap.get(sandwichChoice);
            totalPrice += sandwichBasePrice; // Add the base price to the totalPrice
            System.out.println("Total Price after sandwich base price: Php " + totalPrice);
            System.out.println("\nAvailable Products for " + sandwichChoice + ":");
            displayAvailableProducts();
            System.out.println("\nNote: No wanted add-ons just procees to 'Enter'.");
            System.out.println("\nInput the product slots (separated by spaces) you want to add or press 'Enter' to proceed:");
    
            String productSlotInput = readValidString("");
            String[] productSlots = productSlotInput.split("\\s+");
            List<String> selectedProductSlots = new ArrayList<>();
            for (String productSlot : productSlots) {
                try {
                    int slotNumber = Integer.parseInt(productSlot);
                    if (slotNumber >= 1 && slotNumber <= productCaloriesMap.size()) {
                        String selectedSlot = getSlotByNumber(slotNumber);
                        selectedProductSlots.add(selectedSlot);
                    } else {
                        System.out.println("Error induced: No selected input or invalid");
                        
                    }
                } catch (NumberFormatException e) {
                    System.out.println("No selected products or Invalid product slot: " + productSlot + ". Proceeding...");
                }
            }
    
            String[] productChoices = selectedProductSlots.toArray(new String[0]);
            prepareCustomizableSandwich(sandwichChoice, productChoices);
        } else {
            System.out.println("Invalid sandwich slot. Please try again.");
        }
    }
        
    /**
     * Retrieves the product slot label (name) based on the slot number.
     *
     * @param slotNumber The slot number for which to retrieve the product slot label.
     * @return The product slot label corresponding to the given slot number, or null if not found.
     */
    private String getSlotByNumber(int slotNumber) {
        int index = 1;
        for (String productSlot : productCaloriesMap.keySet()) {
            if (index == slotNumber) {
                return productSlot;
            }
            index++;
        }
        return null;
    }
        
    /**
     * Retrieves the sandwich name based on the provided slot number.
     *
     * @param slot The slot number for which to retrieve the sandwich name.
     * @return The name of the sandwich in the given slot, or null if the slot is invalid.
     */
    public String getSandwichBySlot(String slot) {
        try {
            int index = Integer.parseInt(slot) - 1; // Convert the slot number to 0-based index
            List<String> availableSandwiches = new ArrayList<>(sandwichCaloriesMap.keySet());
            if (index >= 0 && index < availableSandwiches.size()) {
                return availableSandwiches.get(index);
            } else {
                return null; // Return null for invalid sandwich slot
            }
        } catch (NumberFormatException e) {
            return null; // Return null for invalid input
        }
    }
    
     /**
     * Displays the available products with their respective calorie counts, prices, and quantities in stock.
     */
    public void displayAvailableProducts() {
        int slotNumber = 1;
        for (String productSlot : productCaloriesMap.keySet()) {
            int calories = productCaloriesMap.get(productSlot);
            int price = productPriceMap.get(productSlot);
            int quantity = productQuantityMap.get(productSlot);
            System.out.println("[" + slotNumber + "] " + productSlot + " (Calories: " + calories + ", Php " + price + ", Quantity: " + quantity + ")");
            slotNumber++;
        }
    }
    
    /**
     * Displays the available sandwiches with their respective calorie counts, prices, and quantities in stock.
     */
    public void displayAvailableSandwiches() {
        System.out.println("\nAvailable Sandwiches:");
        int slotNumber = 1;
        for (String sandwich : sandwichCaloriesMap.keySet()) {
            int calories = sandwichCaloriesMap.get(sandwich);
            int price = sandwichPriceMap.get(sandwich);
            int quantity = sandwichQuantityMap.get(sandwich);
            System.out.println("[" + slotNumber + "] " + sandwich + " (Calories: " + calories + ", Php " + price + ", Quantity: " + quantity + ")");
            slotNumber++;
        }
    }    
    
    /**
     * Prepares a customizable sandwich with selected add-on products.
     *
     * @param sandwich the name of the selected sandwich.
     * @param choices an array of product names representing the selected add-ons.
     */
    public void prepareCustomizableSandwich(String sandwich, String[] choices) {
        int totalCalories = 0;
        totalPrice = 0;
    
        System.out.println("Preparing Customizable Sandwich...");
        System.out.println("User input: " + Arrays.toString(choices));
    
        if (sandwichCaloriesMap.containsKey(sandwich)) {
            totalCalories += sandwichCaloriesMap.get(sandwich);
            if (sandwichPriceMap.containsKey(sandwich)) {
                totalPrice += sandwichPriceMap.get(sandwich);
            }
        } else {
            System.out.println("Invalid sandwich choice: " + sandwich);
            return;
        }
    
        for (String choice : choices) {
            if (productCaloriesMap.containsKey(choice)) {
                totalCalories += productCaloriesMap.get(choice);
                if (productPriceMap.containsKey(choice)) {
                    totalPrice += productPriceMap.get(choice);
                }
                displayPreparationStep(choice);
            } else {
                System.out.println("Invalid choice: " + choice);
                return;
            }
        }
    
        System.out.println("\nTotal Price: Php " + totalPrice); // Display the total price here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of money: ");
        double enteredAmount = 0;
        try {
            enteredAmount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            return;
        }
    
        if (totalPrice > enteredAmount) {
            System.out.println("Insufficient amount of money. Please enter a higher amount.");
            return;
        }
    
        Money changeNeeded = new Money();
        calculateChange(totalPrice, enteredAmount, changeNeeded);
    
        if (!isChangeAvailable(changeNeeded)) {
            System.out.println("Insufficient change in the vending machine. Please use exact change or a different payment method.");
            return;
        }
    
        // Check if there is enough quantity for the sandwich
        if (!sandwichQuantityMap.containsKey(sandwich)) {
            System.out.println("Invalid sandwich choice: " + sandwich);
            return;
        }
    
        int sandwichQuantity = sandwichQuantityMap.get(sandwich);
        if (sandwichQuantity == 0) {
            System.out.println("No more " + sandwich + " available in the vending machine.");
            return;
        }
    
        // Check if there is enough quantity for each product
        for (String productChoice : choices) {
            if (!productQuantityMap.containsKey(productChoice)) {
                System.out.println("Invalid product choice: " + productChoice);
                return;
            }
    
            int productQuantity = productQuantityMap.get(productChoice);
            if (productQuantity == 0) {
                System.out.println("No more " + productChoice + " available in the vending machine.");
                return;
            }
    
            if (productQuantity < 1) {
                System.out.println("Insufficient quantity for product: " + productChoice + ". Please try again.");
                return;
            }
        }
    
        decrementSandwichQuantity(sandwich);
        for (String productChoice : choices) {
            decrementProductQuantity(productChoice);
        }

        System.out.println("Total Price: Php " + totalPrice); // Display the total price here        
        System.out.println("Total Calories: " + totalCalories);

        // Access the vending machine's money and update it with the change
        Money machineMoney = getMachineMoney();
        machineMoney.subtractMoney(changeNeeded);

        System.out.println("Change: Php " + changeNeeded.totalMoney());
        System.out.println("Sandwich Done!");

        // Increment the quantity sold for the sandwich
        incrementSandwichSold(sandwich);

        // Increment the quantity sold for each product
        for (String productChoice : choices) {
            incrementProductSold(productChoice);
        }
    }
    
    /**
     * Restocks either sandwiches or products based on user choice.
     */
    public void restockItemsSpec() {
        System.out.println("What do you want to restock?");
        System.out.println("[1] Sandwiches");
        System.out.println("[2] Products");
        System.out.println("[3] Cancel");
        
        int choice = readValidInteger("Enter your choice: ");
        
        switch (choice) {
            case 1:
                restockSandwiches();
                break;
            case 2:
                restockProducts();
                break;
            case 3:
                System.out.println("Restocking canceled.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    
    /**
     * Restocks sandwiches by increasing their quantity in stock.
     */
    private void restockSandwiches() {
        System.out.println("Restocking Sandwiches...");
        displayAvailableSandwiches();
    
        int slot = readValidInteger("Enter the slot number of the sandwich to restock: ");
        String sandwichChoice = getSandwichBySlot(slot);
        if (sandwichChoice != null) {
            int quantity = readValidInteger("Enter the quantity to restock (up to 10): ", 1, 10);
            incrementSandwichQuantity(sandwichChoice, quantity);
            System.out.println(quantity + " " + sandwichChoice + " sandwich(es) successfully restocked.");
        } else {
            System.out.println("Invalid sandwich slot. Please try again.");
        }
    }
    
    /**
     * Restocks add-on products by increasing their quantity in stock.
     */
    private void restockProducts() {
        System.out.println("Restocking Products...");
        displayAvailableProducts();
    
        int slot = readValidInteger("Enter the slot number of the product to restock: ");
        String productChoice = getProductBySlot(slot);
        if (productChoice != null) {
            int quantity = readValidInteger("Enter the quantity to restock (up to 10): ", 1, 10);
            incrementProductQuantity(productChoice, quantity);
            System.out.println(quantity + " " + productChoice + " product(s) successfully restocked.");
        } else {
            System.out.println("Invalid product slot. Please try again.");
        }
    }
       
    /**
     * Collects the vending machine money after a successful purchase.
     * The method updates the gross income with the total price of the current transaction and displays the new
     * gross income.
     */
    public void collectVenMoneySpec() {
        System.out.println("Collecting Vending Machine Money...");
        System.out.println("Collected a total of: " + totalPrice);

        // Update the grossIncome with the total price
        grossIncome += totalPrice;
    
        // Display the gross income
        System.out.println("Gross Income: Php " + grossIncome);
    }
    
    // Increment the quantity sold for a sandwich
    private void incrementSandwichSold(String sandwichChoice) {
        int currentQuantity = sandwichSoldMap.getOrDefault(sandwichChoice, 0);
        sandwichSoldMap.put(sandwichChoice, currentQuantity + 1);
    }

    // Increment the quantity sold for a product
    private void incrementProductSold(String productChoice) {
        int currentQuantity = productSoldMap.getOrDefault(productChoice, 0);
        productSoldMap.put(productChoice, currentQuantity + 1);
    }

    /**
     * Prints a transaction summary of sandwiches and products sold.
     * This method is useful for keeping track of the vending machine's sales history.
     */
    public void printVenTransactionSpec() {
        System.out.println("==========================================");
        System.out.println("Sandwich and Product Transaction Summary:");
        System.out.println("==========================================");

        for (String sandwich : sandwichQuantityMap.keySet()) {
            int quantitySold = sandwichSoldMap.getOrDefault(sandwich, 0);
            System.out.println(sandwich + " - Quantity Sold: " + quantitySold);
        }

        for (String product : productQuantityMap.keySet()) {
            int quantitySold = productSoldMap.getOrDefault(product, 0);
            System.out.println(product + " - Quantity Sold: " + quantitySold);
        }
    }

    /**
     * Calculates the change required for a purchase.
     *
     * @param itemPrice the price of the purchased item.
     * @param amount the amount of money entered by the customer.
     * @param changeNeeded the Money object to store the required change denominations.
     */
    public void calculateChange(double itemPrice, double amount, Money changeNeeded) {
        double change = amount - itemPrice;
    
        int phpOneThousandCount = (int) (change / 1000);
        change %= 1000;
        int phpFiveHundredCount = (int) (change / 500);
        change %= 500;
        int phpTwoHundredCount = (int) (change / 200);
        change %= 200;
        int phpOneHundredCount = (int) (change / 100);
        change %= 100;
        int phpFiftyCount = (int) (change / 50);
        change %= 50;
        int phpTwentyCount = (int) (change / 20);
        change %= 20;
        int phpTenCount = (int) (change / 10);
        change %= 10;
        int phpFiveCount = (int) (change / 5);
        change %= 5;
        int phpOneCount = (int) change;
    
        changeNeeded.setPhpOneThousand(phpOneThousandCount);
        changeNeeded.setPhpFiveHundred(phpFiveHundredCount);
        changeNeeded.setPhpTwoHundred(phpTwoHundredCount);
        changeNeeded.setPhpOneHundred(phpOneHundredCount);
        changeNeeded.setPhpFifty(phpFiftyCount);
        changeNeeded.setPhpTwenty(phpTwentyCount);
        changeNeeded.setPhpTen(phpTenCount);
        changeNeeded.setPhpFive(phpFiveCount);
        changeNeeded.setPhpOne(phpOneCount);

        
    }
    
    /**
     * Checks if the vending machine has sufficient change to provide to the user.
     *
     * @param changeNeeded The {@link Money} object representing the change needed by the user.
     * @return True if the vending machine has sufficient change to provide, otherwise false.
     */
    public boolean isChangeAvailable(Money changeNeeded) {
        Money machineMoney = getMachineMoney();
        return machineMoney.getPhpOne() >= changeNeeded.getPhpOne()
                && machineMoney.getPhpFive() >= changeNeeded.getPhpFive()
                && machineMoney.getPhpTen() >= changeNeeded.getPhpTen()
                && machineMoney.getPhpTwenty() >= changeNeeded.getPhpTwenty()
                && machineMoney.getPhpFifty() >= changeNeeded.getPhpFifty()
                && machineMoney.getPhpOneHundred() >= changeNeeded.getPhpOneHundred()
                && machineMoney.getPhpTwoHundred() >= changeNeeded.getPhpTwoHundred()
                && machineMoney.getPhpFiveHundred() >= changeNeeded.getPhpFiveHundred()
                && machineMoney.getPhpOneThousand() >= changeNeeded.getPhpOneThousand();
    }
    
    /**
     * Decrements the quantity of a specific sandwich in the vending machine.
     *
     * @param sandwich The name of the sandwich whose quantity needs to be decremented.
     */
    private void decrementSandwichQuantity(String sandwich) {
        if (sandwichQuantityMap.containsKey(sandwich)) {
            int currentQuantity = sandwichQuantityMap.get(sandwich);
            if (currentQuantity > 0) {
                sandwichQuantityMap.put(sandwich, currentQuantity - 1);
            } else {
                System.out.println("No more " + sandwich + " available in the vending machine.");
            }
        } else {
            System.out.println("Invalid sandwich choice: " + sandwich);
        }
    }
    
    /**
     * Decrements the quantity of a specific product in the vending machine.
     *
     * @param productChoice The name of the product whose quantity needs to be decremented.
     */
    private void decrementProductQuantity(String productChoice) {
        if (productQuantityMap.containsKey(productChoice)) {
            int currentQuantity = productQuantityMap.get(productChoice);
            if (currentQuantity > 0) {
                productQuantityMap.put(productChoice, currentQuantity - 1);
            } else {
                System.out.println("No more " + productChoice + " available in the vending machine.");
            }
        } else {
            System.out.println("Invalid product choice: " + productChoice);
        }
    }
    
    /**
     * Displays the preparation step for a specific choice of product during sandwich customization.
     * @param choice The name of the product for which the preparation step is to be displayed.
     */
    protected void displayPreparationStep(String choice) {
        switch (choice) {
            case "White Bread":
            case "Wheat Bread":
                System.out.println("Toasting " + choice + "...");
                System.out.println("Placing " + choice + "...");
                break;
            case "Ketchup":
            case "Mayonnaise":
                System.out.println("Spreading " + choice + "...");
                break;
            case "Mustard":
                System.out.println("Squeezing " + choice + "...");
                break;
            case "Tomatoes":
                System.out.println("Slicing " + choice + "...");
                System.out.println("Topping " + choice + "...");
                break;
            case "Lettuce":
                System.out.println("Chopping " + choice + "...");
                System.out.println("Topping " + choice + "...");
                break;
            case "Cheese":
                System.out.println("Melting " + choice + "...");
                break;
            case "Cucumber":
                System.out.println("Slicing " + choice + "...");
                System.out.println("Topping " + choice + "...");
                break;
            case "Fries":
                System.out.println("Frying " + choice + "...");
                System.out.println("Placing " + choice + " at the side...");
                break;
            case "Soda":
            case "Water":
                System.out.println("Pouring a glass of " + choice + "...");
                break;
            default:
                break;
        }
    }
    
    /**
     * Reads and validates user input as a string.
     *
     * @param prompt The prompt message to display to the user.
     * @return The string input entered by the user after trimming leading and trailing whitespaces.
     */
    public String readValidString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine(); // Read the entire line of input
    }
    
    /**
     * Sets the initial quantity of sandwiches and products in the vending machine.
     *
     * @param sandwichQuantityMap A map containing the sandwich names and their initial quantities.
     * @param productQuantityMap  A map containing the product names and their initial quantities.
     */
    public void setQuantity(Map<String, Integer> sandwichQuantityMap, Map<String, Integer> productQuantityMap) {
        this.sandwichQuantityMap = sandwichQuantityMap;
        this.productQuantityMap = productQuantityMap;
    }

    /**
     * Reads and validates user input as an integer.
     *
     * @param prompt The prompt message to display to the user.
     * @return The valid integer input entered by the user.
     */
    private int readValidInteger(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }
    
    /**
     * Reads and validates user input as an integer within a specified range.
     *
     * @param prompt The prompt message to display to the user.
     * @param min The minimum value of the allowed range (inclusive).
     * @param max The maximum value of the allowed range (inclusive).
     * @return The valid integer input entered by the user within the specified range.
     */
    private int readValidInteger(String prompt, int min, int max) {
        int value;
        while (true) {
            value = readValidInteger(prompt);
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
        }
        return value;
    }
    
    /**
     * Retrieves the name of the sandwich stored in the vending machine at the specified slot number.
     *
     * @param slotNumber The slot number from which to retrieve the sandwich name.
     * @return The name of the sandwich stored in the vending machine at the specified slot number,
     *         or null if the slot number is invalid.
     */
    private String getSandwichBySlot(int slotNumber) {
        List<String> availableSandwiches = new ArrayList<>(sandwichCaloriesMap.keySet());
        if (slotNumber >= 1 && slotNumber <= availableSandwiches.size()) {
            return availableSandwiches.get(slotNumber - 1);
        } else {
            return null;
        }
    }

    /**
     * Retrieves the name of the product stored in the vending machine at the specified slot number.
     *
     * @param slotNumber The slot number from which to retrieve the product name.
     * @return The name of the product stored in the vending machine at the specified slot number,
     *         or null if the slot number is invalid.
     */
    private String getProductBySlot(int slotNumber) {
        List<String> availableProducts = new ArrayList<>(productCaloriesMap.keySet());
        if (slotNumber >= 1 && slotNumber <= availableProducts.size()) {
            return availableProducts.get(slotNumber - 1);
        } else {
            return null;
        }
    }

    /**
     * Increments the quantity of a specific sandwich in the vending machine.
     *
     * @param sandwichChoice The name of the sandwich whose quantity needs to be incremented.
     * @param quantity The quantity to be added to the current quantity of the sandwich.
     */
    private void incrementSandwichQuantity(String sandwichChoice, int quantity) {
        int currentQuantity = sandwichQuantityMap.getOrDefault(sandwichChoice, 0);
        int newQuantity = Math.min(currentQuantity + quantity, 10); // Maximum restock quantity is 10
        sandwichQuantityMap.put(sandwichChoice, newQuantity);
    }

    /**
     * Increments the quantity of a specific product in the vending machine.
     *
     * @param productChoice The name of the product whose quantity needs to be incremented.
     * @param quantity The quantity to be added to the current quantity of the product.
     */
    private void incrementProductQuantity(String productChoice, int quantity) {
        int currentQuantity = productQuantityMap.getOrDefault(productChoice, 0);
        int newQuantity = Math.min(currentQuantity + quantity, 10); // Maximum restock quantity is 10
        productQuantityMap.put(productChoice, newQuantity);
    }

}
