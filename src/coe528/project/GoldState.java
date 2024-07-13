/**
 *
 * @author Maryam
 * 
 */

package coe528.project;

public class GoldState extends AccountState {
    // doing an online purchase
    public void onlineShop(int amount){
        if(balance >= amount + 10) {
            balance = balance - (amount + 10);
            DisplayBox.display("ONLINE PURCHASE CONFIRMATION", "purchase of $" + amount +"\nwith an additional service fee of $10.\n\nThe total cost is $" + (amount+10) + ".");
        }
        else {
            DisplayBox.display("WARNING", "purchase exceeds balance $" + amount +"\nas the total cost is $" + (amount+10) + "."); }
    }
    public String getState(){
        return "Your account is in GOLD state"; // displays the current level of the customer
    }
}
