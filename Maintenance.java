/** ESCOBAR, PRINCESS_SANTIAGO, MONICA - S16A 
 * 
 * Represents the maintenance operations for a Regular Vending Machine.
 * This class allows restocking items, collecting payment, and replenishing change.
 */

import java.util.Map;


public class Maintenance {
    private RegularVendingMachine vendingMachine;

    /**
     * Constructs a Maintenance instance for the given RegularVendingMachine.
     *
     * @param vendingMachine The RegularVendingMachine to perform maintenance on.
     */
    public Maintenance(RegularVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    /**
     * Restocks a specific item in the vending machine.
     *
     * @param itemSlot The slot of the item to restock.
     * @param quantity The quantity of items to restock.
     */
    public void restockItem(String itemSlot, int quantity) {
        Item item = vendingMachine.getItem(itemSlot);
        if (item != null) {
            int startingCount = vendingMachine.getStartingInventory().getOrDefault(item, 0);
            vendingMachine.getStartingInventory().put(item, startingCount + quantity);
            System.out.println("Item restocked: " + item.getItemName());
            System.out.println("Quantity: " + quantity);
        } else {
            System.out.println("Invalid item slot.");
        }
    }

    /**
     * Collects payment from the vending machine.
     * This method should be called after each transaction to collect the payment.
     */
    public void collectPaymentMaintenance() {
        vendingMachine.collectPayment();
        System.out.println("\nPayment collected.");
    }

    /**
     * Replenishes the change in the vending machine.
     * This method should be called when the change needs to be refilled.
     */
    public void replenishChange() {
        vendingMachine.replenishChange();
        System.out.println("\nChange replenished.");
    }

    /**
     * Performs all maintenance operations on the vending machine.
     * This method restocks items, collects payment, and replenishes change.
     */
    public void performMaintenance() {
        restockItems();
        collectPaymentMaintenance();
        replenishChange();
    }

    /**
     * Restocks all items in the vending machine.
     * This method moves the ending inventory to the starting inventory.
     */
    private void restockItems() {
        Map<Item, Integer> endingInventory = vendingMachine.getEndingInventory();
        for (Map.Entry<Item, Integer> entry : endingInventory.entrySet()) {
            Item item = entry.getKey();
            int count = entry.getValue();
            vendingMachine.getStartingInventory().put(item, count);
            endingInventory.put(item, 0);
        }
        System.out.println("\nItems successfully restocked.");
    }
}