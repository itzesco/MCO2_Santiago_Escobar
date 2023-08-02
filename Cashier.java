/** ESCOBAR, PRINCESS_SANTIAGO, MONICA - S16A
 * 
 * The Cashier class represents a cashier who calculates the change for a customer's purchase.
 * It holds information about the ordered item, the quantity of the item, the amount paid by
 * the customer, and the calculated change amount.
 */

 
public class Cashier {
    private Item orderedItem; // The item ordered by the customer
    private double paidAmount; // The amount paid by the customer
    private double changeAmount; // The calculated change amount
    private int orderQuantity; // The quantity of the ordered item

    /**
     * Constructs a new Cashier object with the specified ordered item and paid amount.
     *
     * @param orderedItem The item ordered by the customer.
     * @param paidAmount  The amount paid by the customer.
     */
    public Cashier(Item orderedItem, double paidAmount) {
        this.orderedItem = orderedItem;
        this.paidAmount = paidAmount;
    }

    /**
     * Retrieves the ordered item.
     *
     * @return The item ordered by the customer.
     */
    public Item getItem() {
        return orderedItem;
    }

    /**
     * Retrieves the quantity of the ordered item.
     *
     * @return The quantity of the ordered item.
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }

    /**
     * Retrieves the amount paid by the customer.
     *
     * @return The amount paid by the customer.
     */
    public double getPaidAmount() {
        return paidAmount;
    }

    /**
     * Retrieves the calculated change amount.
     *
     * @return The calculated change amount.
     */
    public double getChangeAmount() {
        return changeAmount;
    }

    /**
     * Sets the ordered item.
     *
     * @param orderedItem The item to set as the ordered item.
     */
    public void setItem(Item orderedItem) {
        this.orderedItem = orderedItem;
    }

    /**
     * Sets the quantity of the ordered item.
     *
     * @param orderQuantity The quantity to set for the ordered item.
     */
    public void setQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    /**
     * Sets the calculated change amount.
     *
     * @param change The change amount to set.
     */
    public void setChangeAmount(double change) {
        this.changeAmount = change;
    }

    /**
     * Sets the amount paid by the customer.
     *
     * @param payment The amount paid by the customer.
     */
    public void setPaidAmount(double payment) {
        this.paidAmount = payment;
    }

    /**
     * Calculates the change amount for the customer's purchase.
     *
     * @return The calculated change amount.
     */
    public double calculateChange() {
        double totalPrice = orderedItem.getItemPrice() * orderQuantity;
        return paidAmount - totalPrice;
    }
}

