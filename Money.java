/*ESCOBAR, PRINCESS_SANTIAGO, MONICA - S16A 
 *
 * The Money class represents the various denominations of money in a vending machine.
 * It includes methods to add, subtract, and calculate the total amount of money.
 */

public class Money {
    private int phpOne;
    private int phpFive;
    private int phpTen;
    private int phpTwenty;
    private int phpFifty;
    private int phpOneHundred;
    private int phpTwoHundred;
    private int phpFiveHundred;
    private int phpOneThousand;

    /**
     * Default constructor for the Money class.
     * Initializes all denominations to 0.
     */
    public Money(){
        this.phpOne = 0;
        this.phpFive = 0;
        this.phpTen = 0;
        this.phpTwenty = 0;
        this.phpFifty = 0;
        this.phpOneHundred = 0;
        this.phpTwoHundred = 0;
        this.phpFiveHundred = 0;
        this.phpOneThousand = 0;
    }
    
    /**
     * Parameterized constructor for the Money class.
     *
     * @param phpOne        The number of 1 PHP coins.
     * @param phpFive       The number of 5 PHP coins.
     * @param phpTen        The number of 10 PHP coins.
     * @param phpTwenty     The number of 20 PHP coins.
     * @param phpFifty      The number of 50 PHP coins.
     * @param phpOneHundred The number of 100 PHP bills.
     * @param phpTwoHundred The number of 200 PHP bills.
     * @param phpFiveHundred The number of 500 PHP bills.
     * @param phpOneThousand The number of 1000 PHP bills.
     */
    public Money (int phpOne, int phpFive, int phpTen, int phpTwenty, int phpFifty, int phpOneHundred, int phpTwoHundred, int phpFiveHundred, int phpOneThousand){
        this.phpOne = phpOne;
        this.phpFive = phpFive;
        this.phpTen = phpTen;
        this.phpTwenty = phpTwenty;
        this.phpFifty = phpFifty;
        this.phpOneHundred = phpOneHundred;
        this.phpTwoHundred = phpTwoHundred;
        this.phpFiveHundred = phpFiveHundred;
        this.phpOneThousand = phpOneThousand;
    }

    /**
     * Adds the money in another Money object to this Money object.
     *
     * @param m The Money object to be added.
     */
    public void addMoney(Money m){
        this.phpOne += m.phpOne;
        this.phpFive += m.phpFive;
        this.phpTen += m.phpTen;
        this.phpTwenty += m.phpTwenty;
        this.phpFifty += m.phpFifty;
        this.phpOneHundred += m.phpOneHundred;
        this.phpTwoHundred += m.phpTwoHundred;
        this.phpFiveHundred += m.phpFiveHundred;
        this.phpOneThousand += m.phpOneThousand;
    }

    /**
     * Subtracts the money in another Money object from this Money object.
     *
     * @param m The Money object to be subtracted.
     */
    public void subtractMoney(Money m){
        this.phpOne -= m.phpOne;
        this.phpFive -= m.phpFive;
        this.phpTen -= m.phpTen;
        this.phpTwenty -= m.phpTwenty;
        this.phpFifty -= m.phpFifty;
        this.phpOneHundred -= m.phpOneHundred;
        this.phpTwoHundred -= m.phpTwoHundred;
        this.phpFiveHundred -= m.phpFiveHundred;
        this.phpOneThousand -= m.phpOneThousand;
    }

    /**
     * Calculates the total amount of money in the vending machine.
     *
     * @return The total amount of money in the vending machine.
     */
    public int totalMoney(){
        return (phpOne) + (phpFive * 5) + (phpTen * 10) + (phpTwenty * 20) + (phpFifty * 50) + (phpOneHundred * 100) + (phpTwoHundred * 200) + (phpFiveHundred * 500) + (phpOneThousand * 1000);
    }

    public int getPhpOne(){
        return phpOne;
    }

    public int getPhpFive(){
        return phpFive;
    }

    public int getPhpTen(){
        return phpTen;
    }

    public int getPhpTwenty(){
        return phpTwenty;
    }

    public int getPhpFifty(){
        return phpFifty;
    }

    public int getPhpOneHundred(){
        return phpOneHundred;
    }

    public int getPhpTwoHundred(){
        return phpTwoHundred;
    }

    public int getPhpFiveHundred(){
        return phpFiveHundred;
    }

    public int getPhpOneThousand(){
        return phpOneThousand;
    } 

    public void setPhpOne(int phpOne){
        this.phpOne = phpOne;
    }

    public void setPhpFive(int phpFive){
        this.phpFive = phpFive;
    }

    public void setPhpTen(int phpTen){
        this.phpTen = phpTen;
    }

    public void setPhpTwenty(int phpTwenty){
        this.phpTwenty = phpTwenty;
    }

    public void setPhpFifty(int phpFifty){
        this.phpFifty = phpFifty;
    }

    public void setPhpOneHundred(int phpOneHundred){
        this.phpOneHundred = phpOneHundred;
    }

    public void setPhpTwoHundred(int phpTwoHundred){
        this.phpTwoHundred = phpTwoHundred;
    }

    public void setPhpFiveHundred(int phpFiveHundred){
        this.phpFiveHundred = phpFiveHundred;
    }

    public void setPhpOneThousand(int phpOneThousand){
        this.phpOneThousand = phpOneThousand;
    }

    /**
     * Calculates and returns the total amount of money in the vending machine.
     *
     * @return The total amount of money in the vending machine.
     */
    public int calculateTotalAmount() {
        return (phpOne * 1) + (phpFive * 5) + (phpTen * 10) + (phpTwenty * 20) + (phpFifty * 50) + (phpOneHundred * 100) + (phpTwoHundred * 200) + (phpFiveHundred * 500) + (phpOneThousand * 1000);
    }
}

