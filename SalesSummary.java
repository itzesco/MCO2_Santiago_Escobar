/**
 * ESCOBAR, PRINCESS_SANTIAGO, MONICA - S16A
 * 
 * The SalesSummary class represents a summary of sales and inventory information for a regular vending machine.
 * It keeps track of items sold, total sales amount, starting inventory, and ending inventory.
 */

import java.util.HashMap;
import java.util.Map;

public class SalesSummary {

    private Map<Item, Integer> itemSales;
    private double totalSales;
    private Map<Item, Integer> startingInventory;
    private Map<Item, Integer> endingInventory;

    /**
     * Default constructor for the SalesSummary class.
     * Initializes the itemSales, totalSales, startingInventory, and endingInventory maps to empty HashMaps.
     */
    public SalesSummary() {
        itemSales = new HashMap<>();
        totalSales = 0.0;
        startingInventory = new HashMap<>();
        endingInventory = new HashMap<>();
    }

    /**
     * Prints a summary of the regular vending machine transaction.
     * This includes the items sold and their quantities, along with the total sales amount.
     */
    public void printVenTransaction() {
        System.out.println("\n========================================");
        System.out.println("Regular Vending Machine Transaction Summary:");
        System.out.println("========================================\n");

        System.out.println("Items Sold:");
        for (Map.Entry<Item, Integer> entry : itemSales.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            int unitsSold = item.getUnitsSold(); // Get the number of units sold for this item
            System.out.println(item.getItemName() + ": " + quantity + " units sold (" + unitsSold + " total)");
        }

        System.out.println("\nTotal Sales Amount: $" + totalSales);
    }


    /**
     * Updates the item sales information by adding the specified quantity for the given item.
     *
     * @param item     The item to update the sales for.
     * @param quantity The quantity of the item sold.
     */
    public void updateSales(Item item, int quantity) {
        itemSales.put(item, quantity);
    }

    /**
     * Updates the total sales amount by adding the specified amount.
     *
     * @param amount The amount to add to the total sales.
     */
    public void updateTotalSales(double amount) {
        totalSales += amount;
    }

    /**
     * Retrieves the starting inventory map.
     *
     * @return The starting inventory map.
     */
    public Map<Item, Integer> getStartingInventory() {
        return startingInventory;
    }

    /**
     * Retrieves the ending inventory map.
     *
     * @return The ending inventory map.
     */
    public Map<Item, Integer> getEndingInventory() {
        return endingInventory;
    }

    /**
     * Sets the starting inventory map.
     *
     * @param inventory The starting inventory map to set.
     */
    public void setStartingInventory(Map<Item, Integer> inventory) {
        startingInventory = inventory;
    }

    /**
     * Sets the ending inventory map.
     *
     * @param inventory The ending inventory map to set.
     */
    public void setEndingInventory(Map<Item, Integer> inventory) {
        endingInventory = inventory;
    }
}