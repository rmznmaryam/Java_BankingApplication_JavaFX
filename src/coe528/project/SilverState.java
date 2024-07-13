/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Maryam
 */

package coe528.project;

public class SilverState extends AccountState {
    // doing an online purchase
    public void onlineShop(int amount){
        if(balance >= (amount + 20)){
            balance = balance - (amount + 20);
            DisplayBox.display("Online Shopping CONFIRMATION", "purchase of $" + amount +"\nhas been made with an additional service fee of $20.\n\nThe total cost is $" + (amount+20) + ".");    
        }
        else
            DisplayBox.display("WARNING", "purchase exceeds balance $" + amount +"\nas the total cost is $" + (amount+20) + ".");
    }
    public String getState(){
        return "You're account is in SILVER state"; // displays the current level of the customer
    }
}
