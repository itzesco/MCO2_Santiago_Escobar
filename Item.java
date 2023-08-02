/** ESCOBAR, PRINCESS_SANTIAGO, MONICA - S16A
 * 
 * Represents an item in the vending machine.
 */

 
public class Item {
    private String itemName;         // The name of the item
    private double itemPrice;        // The price of the item
    private int itemCalories;        // The calories of the item
    private int itemQuantity;        // The quantity of the item
    private boolean itemAvailability;    // The availability of the item
    private int unitsSold;           // The number of units sold for the item

    /**
     * Default constructor for the Item class.
     * Initializes the item with default values.
     */
    public Item() {
        this.itemName = "Empty";
        this.itemPrice = 0;
        this.itemCalories = 0;
        this.itemQuantity = 0;
        this.itemAvailability = false;
    }

    /**
     * Parameterized constructor for the Item class.
     * @param itemName The name of the item.
     * @param itemPrice The price of the item.
     * @param itemCalories The calories of the item.
     * @param itemQuantity The quantity of the item.
     * @param itemAvailability The availability of the item.
     */
    public Item(String itemName, int itemPrice, int itemCalories, int itemQuantity, boolean itemAvailability) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCalories = itemCalories;
        this.itemQuantity = itemQuantity;
        this.itemAvailability = itemAvailability;
    }

    /**
     * Gets the name of the item.
     * @return The name of the item.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Gets the price of the item.
     * @return The price of the item.
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * Gets the calories of the item.
     * @return The calories of the item.
     */
    public int getItemCalories() {
        return itemCalories;
    }

    /**
     * Gets the quantity of the item.
     * @return The quantity of the item.
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * Gets the availability of the item.
     * @return The availability of the item.
     */
    public boolean getItemAvailability() {
        return itemAvailability;
    }

    /**
     * Sets the name of the item.
     * @param itemName The name of the item.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Sets the price of the item.
     * @param itemPrice The price of the item.
     */
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Sets the calories of the item.
     * @param itemCalories The calories of the item.
     */
    public void setItemCalories(int itemCalories) {
        this.itemCalories = itemCalories;
    }

    /**
     * Sets the quantity of the item.
     * @param itemQuantity The quantity of the item.
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * Sets the availability of the item.
     * @param itemAvailability The availability of the item.
     */
    public void setItemAvailability(boolean itemAvailability) {
        this.itemAvailability = itemAvailability;
    }

    /**
     * Checks if the item is available in the vending machine.
     * @return true if the item is available, false otherwise.
     */
    public boolean isAvailable() {
        return itemQuantity > 0;
    }

    /**
     * Restocks the item to a specified capacity.
     * @param capacity The desired capacity to restock the item.
     */
    public void itemRestock(int capacity) {
        if (itemQuantity < capacity) {
            int addedItems = capacity - itemQuantity;
            System.out.println("\nRestocking " + addedItems + " " + itemName + "(s)...");
            itemQuantity = capacity;
            System.out.println("Restocking complete! The vending machine now has " + itemQuantity + " " + itemName + "(s).");
        } else {
            System.out.println("\nNo restocking needed! The vending machine already has the maximum capacity of " + itemQuantity + " " + itemName + "(s).");
        }
    }

    /**
     * Calculates the total price for a given quantity of the item.
     * @param quantity The quantity of the item to calculate the total price for.
     * @return The total price for the given quantity of the item.
     */
    public double calculateTotalPrice(int quantity) {
        return itemPrice * quantity;
    }

    /**
     * Gets the number of units sold for the item.
     * @return The number of units sold for the item.
     */
    public int getUnitsSold() {
        return unitsSold;
    }

    /**
     * Increments the number of units sold for the item.
     */
    public void incrementUnitsSold() {
        unitsSold++;
    }

    /**
     * Decrements the quantity of the item by 1.
     */
    public void decrementItemQuantity() {
        if (itemQuantity > 0) {
            itemQuantity--;
        }
    }
}
