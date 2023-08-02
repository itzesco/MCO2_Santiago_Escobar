/**
 * ESCOBAR, PRINCESS_SANTIAGO, MONICA - S16A
 * 
 * The Slot class represents a slot within a vending machine where items can be stored.
 * It contains an ArrayList of Item objects, along with information about the current quantity of items and the capacity of the slot.
 */

import java.util.ArrayList;

public class Slot {

    private ArrayList<Item> itemSlot = new ArrayList<>();
    private int itemQuantity;
    private int itemCapacity;

    /**
     * Constructor for the Slot class.
     *
     * @param itemSlot     The ArrayList of Item objects representing the items stored in the slot.
     * @param itemQuantity The current quantity of items in the slot.
     * @param itemCapacity The maximum capacity of the slot to hold items.
     */
    public Slot(ArrayList<Item> itemSlot, int itemQuantity, int itemCapacity) {
        this.itemSlot = itemSlot;
        this.itemQuantity = itemQuantity;
        this.itemCapacity = itemCapacity;
    }

    /**
     * Retrieves the ArrayList of Item objects representing the items stored in the slot.
     *
     * @return The ArrayList of Item objects.
     */
    public ArrayList<Item> getItemSlot() {
        return itemSlot;
    }

    /**
     * Retrieves the current quantity of items in the slot.
     *
     * @return The current quantity of items.
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * Retrieves the maximum capacity of the slot to hold items.
     *
     * @return The maximum capacity of the slot.
     */
    public int getItemCapacity() {
        return itemCapacity;
    }

    /**
     * Sets the ArrayList of Item objects representing the items stored in the slot.
     *
     * @param items The ArrayList of Item objects to set.
     */
    public void setItemSlot(ArrayList<Item> items) {
        this.itemSlot = items;
    }

    /**
     * Sets the current quantity of items in the slot.
     *
     * @param itemQuantity The current quantity of items to set.
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * Sets the maximum capacity of the slot to hold items.
     *
     * @param itemCapacity The maximum capacity of the slot to set.
     */
    public void setItemCapacity(int itemCapacity) {
        this.itemCapacity = itemCapacity;
    }
}
