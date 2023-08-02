/** ESCOBAR, PRINCESS_SANTIAGO, MONICA - S16A 
 * 
 * RegularVendingMachine is a class that represents a regular vending machine that sells various items.
 * It allows users to display available items, purchase items, restock items, collect revenue, and add money to the machine.
 * The vending machine can also be put into maintenance mode to replenish items and change.
 * It keeps track of inventory, sales, and the machine's money.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class RegularVendingMachine {
    private ArrayList<Slot> slots;
    private Map<String, Item> inventory;
    private Map<Item, Integer> startingInventory;
    private Map<Item, Integer> endingInventory;
    private double salesSum;
    private Map<String, Integer> changeValue;

    protected Money machineMoney;

    /**
     * Constructs a new RegularVendingMachine with the specified starting machine money.
     *
     * @param machineMoney The starting money available in the vending machine.
     */
    public RegularVendingMachine(Money machineMoney) {
        this.slots = new ArrayList<>();
        inventory = new HashMap<>();
        startingInventory = new HashMap<>();
        endingInventory = new HashMap<>();
        salesSum = 0.0;
        changeValue = new HashMap<>();
        this.machineMoney = machineMoney;

        // Initialized Items
        Item vanilla = new Item("Vanilla", 75, 120, 10, true);
        addItem("1", vanilla);

        Item chocolate = new Item("Chocolate", 75, 145, 10, true);
        addItem("2", chocolate);

        Item strawberry = new Item("Strawberry", 80, 138, 10, true);
        addItem("3", strawberry);

        Item mango = new Item("Mango", 80, 157, 10, true);
        addItem("4", mango);

        Item cookiesCream = new Item("Cookies & Cream", 85, 192, 10, true);
        addItem("5", cookiesCream);

        Item coffee = new Item("Coffee", 85, 148, 10, true);
        addItem("6", coffee);

        Item mintChip = new Item("Mint Chip", 90, 179, 10, true);
        addItem("7", mintChip);

        Item matcha = new Item("Matcha", 95, 186, 10, true);
        addItem("8", matcha);
    }

    /**
     * Adds an item to the vending machine inventory with the specified slot and item.
     *
     * @param slot The slot where the item will be stored in the vending machine.
     * @param item The item to be added to the inventory.
     */
    public void addItem(String slot, Item item) {
        inventory.put(slot, item);
        startingInventory.put(item, 0);
        endingInventory.put(item, 0);
    }

    /**
     * Displays the available features of the vending machine and prompts the user to select an action.
     */
    public void venMachineFeatures() {
        System.out.println("\n(Regular)Vending Machine Features:");
        System.out.println("[1] Display available items");
        System.out.println("[2] Purchase an item");
        System.out.println("[3] Return to previous menu");
        System.out.print("Enter your choice: ");
        int choice = readValidChoice(1, 3);

        switch (choice) {
            case 1:
                displayAvailableItems();
                break;
            case 2:
                purchaseItem();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid selection! Please try again.");
                venMachineFeatures();
        }
    }

    /**
     * Displays the available items and their details in the vending machine inventory.
     */
    private void displayAvailableItems() {
        System.out.println();
        System.out.println("Available Items:");
        Map<String, Item> inventory = getInventory();
        for (Map.Entry<String, Item> entry : inventory.entrySet()) {
            String slot = entry.getKey();
            Item item = entry.getValue();
            // Use item.getItemQuantity() to get the quantity of the item in the slot
            System.out.println(slot + " - " + item.getItemName() + " - Php " + item.getItemPrice() + " - Quantity: " + item.getItemQuantity());
        }
    }

    /**
     * Allows the user to purchase an item from the vending machine.
     */
    public void purchaseItem() {
        System.out.println("");
        displayAvailableItems();
        System.out.println("");
        String slot = readValidString("Enter the slot of the item you want to purchase: ");
        double amount = readValidDouble(0, Double.MAX_VALUE, "Enter the amount of money: ");
    
        Item item = getItem(slot);
        if (item != null) {
            if (item.isAvailable() && amount >= item.getItemPrice()) {
                double change = amount - item.getItemPrice();
    
                // Check if there is enough change available
                Money changeNeeded = new Money();
                calculateChange(item.getItemPrice(), amount, changeNeeded);
                if (isChangeAvailable(changeNeeded)) {
                    System.out.println("\nYou purchased: " + item.getItemName());
                    System.out.println("Change: Php " + change);
                    item.decrementItemQuantity(); // Deduct the item quantity
                    item.incrementUnitsSold(); // Increment units sold count
    
                    // Deduct the change denominations from the machine's money
                    Money machineMoney = getMachineMoney();
                    machineMoney.subtractMoney(changeNeeded);
    
                    // Display the updated machine money
                    System.out.println("\nMachine Money Overview (after purchase):");
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
                } else {
                    System.out.println("Sorry, there is not enough change available in the machine. Please insert exact change.");
                }
            } else {
                System.out.println("Item not available or insufficient funds. Please insert more money.");
            }
        } else {
            System.out.println("Invalid slot. Please try again.");
        }
    }
    
    /**
     * Helper method to check if there is enough change available in the vending machine.
     *
     * @param changeNeeded The change needed to give back to the user.
     * @return True if there is enough change available, False otherwise.
     */
    private boolean isChangeAvailable(Money changeNeeded) {
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
     * Calculates the change needed to give back to the user after a purchase.
     *
     * @param itemPrice The price of the item being purchased.
     * @param amount The amount of money inserted by the user.
     * @param changeNeeded The Money object to store the denominations of change needed.
     */
    private void calculateChange(double itemPrice, double amount, Money changeNeeded) {
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
     * Restocks the items in the vending machine inventory.
     * Displays the available items for reference and prompts the user to enter the slot of the item to restock.
     * The user is then asked to enter the quantity they want to restock (up to a maximum of 10 units).
     * If the restock quantity exceeds the maximum allowed (10 units), the restock is rejected.
     * Otherwise, the quantity of the specified item in the inventory is updated with the new restocked quantity.
     * 
     * @throws InputMismatchException if an invalid input is provided for the slot or quantity to restock.
     */
    public void restockItems() {
        displayAvailableItems(); // Show the available items for reference
        String slot = readValidString("Enter the slot of the item you want to restock: ");

        Item item = getItem(slot);
        if (item != null) {
            int quantityToAdd = readValidInteger(1, 10, "Enter the quantity you want to restock (max 10): ");
            int newTotalQuantity = item.getItemQuantity() + quantityToAdd;
            if (newTotalQuantity > 10) {
                System.out.println("Restocking more than 10 units is not allowed. Restock rejected.");
            } else {
                item.setItemQuantity(newTotalQuantity);
                System.out.println("Restock successful. New quantity for " + item.getItemName() + ": " + newTotalQuantity);
            }
        } else {
            System.out.println("Invalid slot. Please try again.");
        }
    }

    /**
     * Changes the price of a specified item in the vending machine.
    * 
    * @throws InputMismatchException If the user enters invalid input for the new price.
    * 
    * @param itemSlot The slot identifier of the item whose price needs to be changed.
    * @param newPrice The new price for the item.
        */
    public void changeVenItem() {
        String itemSlot = readValidString("Enter the item slot: ");
        double newPrice = readValidDouble(0, Integer.MAX_VALUE, "Enter the new price for the item: ");
        setPrice(itemSlot, newPrice);
        System.out.println("Item price changed successfully.");
    }

    /**
     * Collects the total revenue earned by the vending machine.
     * Calculates the total revenue by iterating through the items in the inventory and multiplying each item's
     * units sold by its price. The sum of all item revenues represents the total money collected.
     */
    public void collectVenMoney() {
        double totalRevenue = 0.0;
        Map<String, Item> inventory = getInventory();
        for (Map.Entry<String, Item> entry : inventory.entrySet()) {
            Item item = entry.getValue();
            int unitsSold = item.getUnitsSold();
            double price = item.getItemPrice();
            totalRevenue += unitsSold * price;
        }

        System.out.println("Total Money Revenue: Php " + totalRevenue);
        System.out.println("Money collected.");
    }

     /**
     * Displays the vending machine's machineMoney and allows the user to replenish coins and bills.
     */
    public void addVenMoney() {
        Money machineMoney = getMachineMoney();

        System.out.println("Machine Money Overview:");
        System.out.println("=======================");
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
        System.out.println("=======================");
        System.out.println("[1] Replenish coins and bills");
        System.out.println("[2] Return to previous menu");
        int choice = readValidInteger(1, 2, "Enter your choice: ");

        switch (choice) {
            case 1:
                System.out.println("What denomination should be replenished?");
                System.out.println("[1] Coins");
                System.out.println("[2] Bills");
                int typeChoice = readValidInteger(1, 2, "Enter your choice: ");

                if (typeChoice == 1) { // Replenish coins
                    System.out.println("Select the specific coin denomination to replenish:");
                    System.out.println("[1] PHP 1");
                    System.out.println("[2] PHP 5");
                    System.out.println("[3] PHP 10");
                    int coinChoice = readValidInteger(1, 3, "Enter your choice: ");

                    int denomination;
                    String denominationName;
                    switch (coinChoice) {
                        case 1:
                            denomination = machineMoney.getPhpOne();
                            denominationName = "PHP 1";
                            break;
                        case 2:
                            denomination = machineMoney.getPhpFive();
                            denominationName = "PHP 5";
                            break;
                        case 3:
                            denomination = machineMoney.getPhpTen();
                            denominationName = "PHP 10";
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            return;
                    }

                    System.out.println(denominationName + " is selected and has " + denomination + " coins.");
                    int replenishAmount = readValidInteger(0, Integer.MAX_VALUE, "Enter the number of " + denominationName + " coins to replenish: ");
                    switch (coinChoice) {
                        case 1:
                            machineMoney.setPhpOne(denomination + replenishAmount);                            
                            break;
                        case 2:
                            machineMoney.setPhpFive(denomination + replenishAmount);
                            break;
                        case 3:
                            machineMoney.setPhpTen(denomination + replenishAmount);
                            break;
                    }
                } else if (typeChoice == 2) { // Replenish bills
                    System.out.println("Select the specific bill denomination to replenish:");
                    System.out.println("[1] PHP 20");
                    System.out.println("[2] PHP 50");
                    System.out.println("[3] PHP 100");
                    System.out.println("[4] PHP 200");
                    System.out.println("[5] PHP 500");
                    System.out.println("[6] PHP 1000");
                    int billChoice = readValidInteger(1, 6, "Enter your choice: ");

                    int denomination;
                    String denominationName;
                    switch (billChoice) {
                        case 1:
                            denomination = machineMoney.getPhpTwenty();
                            denominationName = "PHP 20";
                            break;
                        case 2:
                            denomination = machineMoney.getPhpFifty();
                            denominationName = "PHP 50";
                            break;
                        case 3:
                            denomination = machineMoney.getPhpOneHundred();
                            denominationName = "PHP 100";
                            break;
                        case 4:
                            denomination = machineMoney.getPhpTwoHundred();
                            denominationName = "PHP 200";
                            break;
                        case 5:
                            denomination = machineMoney.getPhpFiveHundred();
                            denominationName = "PHP 500";
                            break;
                        case 6:
                            denomination = machineMoney.getPhpOneThousand();
                            denominationName = "PHP 1000";
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            return;
                    }

                    System.out.println(denominationName + " is selected and has " + denomination + " bills.");
                    int replenishAmount = readValidInteger(0, Integer.MAX_VALUE, "Enter the number of " + denominationName + " bills to replenish: ");
                    switch (billChoice) {
                        case 1:
                            machineMoney.setPhpTwenty(denomination + replenishAmount);
                            break;
                        case 2:
                            machineMoney.setPhpFifty(denomination + replenishAmount);
                            break;
                        case 3:
                            machineMoney.setPhpOneHundred(denomination + replenishAmount);
                            break;
                        case 4:
                            machineMoney.setPhpTwoHundred(denomination + replenishAmount);
                            break;
                        case 5:
                            machineMoney.setPhpFiveHundred(denomination + replenishAmount);
                            break;
                        case 6:
                            machineMoney.setPhpOneThousand(denomination + replenishAmount);
                            break;
                    }
                    System.out.println("Successfully replenished " + replenishAmount + " bills of " + denominationName + ". Updated quantity: " + (denomination + replenishAmount));
                } else {
                    System.out.println("Invalid choice.");
                }
                break;
            case 2:
                return;
            default:
                System.out.println("Invalid Selection! Please try again.");
        }
        
    }

     /**
     * Prints a summary of the vending machine's transaction and the items sold with quantities.
     */
    public void printVenTransaction() {
        System.out.println("========================================");
        System.out.println("Regular Vending Machine Transaction Summary:");
        System.out.println("========================================");
        System.out.println("Items Sold:");
        Map<Item, Integer> endingInventory = getEndingInventory();
        for (Map.Entry<Item, Integer> entry : endingInventory.entrySet()) {
            Item item = entry.getKey();        
            int unitsSold = item.getUnitsSold(); // Get the number of units sold for this item
            System.out.println(item.getItemName() + ": Quantity: " + item.getItemQuantity() + " Units Sold: " + unitsSold);
        }
    }

    /**
     * Retrieves the item corresponding to the given item slot from the vending machine inventory.
     *
     * @param itemSlot The slot of the item to retrieve.
     * @return The Item object corresponding to the given slot, or null if not found.
     */
    public Item getItem(String itemSlot) {
        return inventory.get(itemSlot);
    }

    /**
     * Sets the price of an item in the inventory.
     *
     * @param itemSlot The slot of the item in the inventory.
     * @param price The new price to set for the item.
     */
    public void setPrice(String itemSlot, double price) {
        Item item = inventory.get(itemSlot);
        if (item != null) {
            item.setItemPrice((int) price);
        }
    }
    
    /**
     * Retrieves the price of the item corresponding to the given item slot from the vending machine inventory.
     *
     * @param itemSlot The slot of the item to retrieve the price for.
     * @return The price of the item corresponding to the given slot, or 0.0 if not found.
     */
    public double getPrice(String itemSlot) {
        Item item = inventory.get(itemSlot);
        if (item != null) {
            return item.getItemPrice();
        }
        return 0.0;
    }

    /**
     * Retrieves the calorie count of the item corresponding to the given item slot from the vending machine inventory.
     *
     * @param itemSlot The slot of the item to retrieve the calorie count for.
     * @return The calorie count of the item corresponding to the given slot, or 0 if not found.
     */
    public int getCalories(String itemSlot) {
        Item item = inventory.get(itemSlot);
        if (item != null) {
            return item.getItemCalories();
        }
        return 0;
    }

    /**
     * Inserts a coin into the vending machine and updates the coin count for the given denomination.
     *
     * @param coinValue The denomination of the coin to insert.
     */
    public void insertCoin(String coinValue) {
        Integer count = changeValue.getOrDefault(coinValue, 0);
        changeValue.put(coinValue, count + 1);
    }

    /**
     * Inserts a bill into the vending machine and updates the bill count for the given denomination.
     *
     * @param billValue The denomination of the bill to insert.
     */
    public void insertBill(String billValue) {
        Integer count = changeValue.getOrDefault(billValue, 0);
        changeValue.put(billValue, count + 1);
    }

    /**
     * Selects an item for purchase from the vending machine based on the provided item slot.
     * Checks if the item is available in the inventory and whether there are sufficient funds to purchase it.
     * If the item is available and there are enough funds, it dispenses the item, gives change, and updates inventory.
     * If the item is not available or there are insufficient funds, appropriate error messages are displayed.
     *
     * @param itemSlot The slot of the item to select for purchase.
     */
    public void selectItem(String itemSlot) {
        Item item = inventory.get(itemSlot);
        if (item != null) {
            double price = item.getItemPrice();
            if (salesSum >= price) {
                int startingCount = startingInventory.getOrDefault(item, 0);
                int endingCount = endingInventory.getOrDefault(item, 0);
                if (startingCount > endingCount) {
                    // Item available
                    startingInventory.put(item, startingCount - 1);
                    endingInventory.put(item, endingCount + 1);
                    salesSum += price; // Update the sales count
                    dispenseItem(item);
                    giveChange(price);
                } else {
                    // Item out of stock
                    System.out.println("Item is out of stock.");
                }
            } else {
                // Insufficient funds
                System.out.println("Insufficient funds. Please insert more coins or bills.");
            }
        }
    }

    /**
     * Cancels the current transaction and returns the change to the user.
     */
    public void cancelTransaction() {
        returnChange();
    }

    /**
     * Dispenses the specified item.
     *
     * @param item The item to be dispensed.
     */
    private void dispenseItem(Item item) {
        System.out.println("Dispensing " + item.getItemName() + ".");
    }

    /**
     * Gives change to the user after a successful purchase.
     *
     * @param price The price of the purchased item.
     */
    private void giveChange(double price) {
        double change = salesSum - price;
        if (change > 0) {
            System.out.println("Change: " + change);
            salesSum = 0.0;
            returnChange();
        }
    }

    /**
     * Returns the change to the user, printing the number of coins/bills returned for each denomination.
     */
    private void returnChange() {
        System.out.println("Returning change:");
        for (Map.Entry<String, Integer> entry : changeValue.entrySet()) {
            String coinOrBill = entry.getKey();
            int count = entry.getValue();
            if (count > 0) {
                System.out.println(coinOrBill + " x " + count);
                changeValue.put(coinOrBill, 0);
            }
        }
    }

    /**
     * Performs maintenance on the vending machine, which includes replenishing items, collecting payment,
     * and replenishing change.
     */
    public void performMaintenance() {
        replenishItems();
        collectPayment();
        replenishChange();
    }

    /**
    * Replenishes the items in the vending machine by moving the remaining items from endingInventory to startingInventory.
    * The endingInventory will be reset to zero.
    */
    private void replenishItems() {
        for (Map.Entry<Item, Integer> entry : endingInventory.entrySet()) {
            Item item = entry.getKey();
            int count = entry.getValue();
            startingInventory.put(item, count);
            endingInventory.put(item, 0);
        }
        System.out.println("Items replenished.");
    }

    /**
     * Collects the payment for the purchased items and resets the salesSum to zero.
     */
    public void collectPayment() {
        salesSum = 0.0;
    }

    /**
     * Replenishes the change in the vending machine by adding 10 coins/bills of each denomination that has a count of 0.
     */
    public void replenishChange() {
        for (Map.Entry<String, Integer> entry : changeValue.entrySet()) {
            String coinOrBill = entry.getKey();
            int count = entry.getValue();
            if (count == 0) {
                changeValue.put(coinOrBill, 10); // Assuming a capacity of 10 coins/bills for each denomination
            }
        }
        System.out.println("Change replenished.");
    }

    /**
     * Retrieves the starting inventory of the vending machine, which represents the initial counts of items.
     *
     * @return A map containing the starting inventory of items, where the keys are the items and the values are their counts.
     */
    public Map<Item, Integer> getStartingInventory() {
        return startingInventory;
    }

    /**
     * Retrieves the ending inventory of the vending machine, which represents the remaining counts of items after a transaction.
     *
     * @return A map containing the ending inventory of items, where the keys are the items and the values are their remaining counts.
     */
    public Map<Item, Integer> getEndingInventory() {
        return endingInventory;
    }

    /**
     * Reads and validates the user's integer choice within the specified range.
     *
     * @param min The minimum valid integer value.
     * @param max The maximum valid integer value.
     * @return The valid integer input from the user.
     */
    private int readValidChoice(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }

        return input;
    }

    /**
     * Reads and validates the user's integer input within the specified range and displays the provided message.
     *
     * @param min     The minimum valid integer value.
     * @param max     The maximum valid integer value.
     * @param message The message to display to the user before input.
     * @return The valid integer input from the user.
    */
    private int readValidInteger(int min, int max, String message) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            System.out.print(message);
           try {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }

        return input;
    }

    /**
     * Reads and validates the user's double input within the specified range and displays the provided message.
     *
     * @param min     The minimum valid double value.
     * @param max     The maximum valid double value.
     * @param message The message to display to the user before input.
    * @return The valid double input from the user.
    */
    private double readValidDouble(double min, double max, String message) {
        Scanner scanner = new Scanner(System.in);
        double input;
        while (true) {
            System.out.print(message);
            try {
                input = scanner.nextDouble();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }

        return input;
    }

    /**
     * Reads and validates the user's non-empty string input and displays the provided message.
     *
     * @param message The message to display to the user before input.
     * @return The valid non-empty string input from the user.
     */
    private String readValidString(String message) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        return input;
    }

    /**
     * Retrieves the current inventory of the vending machine.
     *
     * @return A map containing the inventory of items, where the keys are the item slots and the values are the corresponding items.
     */
    public Map<String, Item> getInventory() {
        return inventory;
    }

     /**
     * Updates the vending machine's inventory by incrementing the quantity of the specified item.
     *
     * @param itemName The name of the item to update the inventory for.
     */
    public void updateInventory(String itemName) {
        for (Slot slot : slots) {
            ArrayList<Item> itemSlot = slot.getItemSlot();
            for (Item item : itemSlot) {
                if (item.getItemName().equals(itemName)) {
                    item.setItemQuantity(item.getItemQuantity() + 1);
                    System.out.println("Inventory updated for item: " + itemName);
                    return;
                }
            }
        }
        // Item not found in any slot
        System.out.println("Item found in inventory: " + itemName);
    }

    private int lastSlotNumber = 0; // Add this instance variable

    /**
     * Generates a new item slot and returns it as a string representation.
     *
     * @return A new item slot generated as a string.
     */
    public String generateNewItemSlot() {
        lastSlotNumber++; // Increment the last slot number
        String newSlot = String.valueOf(lastSlotNumber); // Convert the slot number to a string
        System.out.println("New item slot generated: " + newSlot);
        return newSlot;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    /**
     * Returns the vending machine's machineMoney object.
     *
     * @return The Money object representing the machine's current money.
     */
    public Money getMachineMoney() {
        return this.machineMoney;
    }
}

