/**
 *
 * @author Maryam
 * 
 */

package coe528.project;

public class PlatinumState extends AccountState{
    // doing an online purchase
    public void onlineShop(int amount){
        if(balance >= amount){
            balance = balance - amount;
            DisplayBox.display("Online Shopping CONFIRMATION", "Successful purchase of $" + amount +"\n has been made with no additional service fee.\n\nThe total cost is $" + (amount) + ".");
        }
        else
            DisplayBox.display("WARNING", "purchase exceeds balance $" + amount + ".");
    }
    public String getState(){
        return "Your account is at Platinum State";  // displays the current level of the customer
    }
}
