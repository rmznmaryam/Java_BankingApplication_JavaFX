/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package coe528.project;

import java.util.*;

/**
 * Name: Maryam
* @Overview * This is a mutable and abstract class that displays uers'  balance which must be 0 or greator
* 
*  The abstraction function is:
*  AF(c) = bank account, A, such that
*          A.balance = c.balance
*
*  The rep invariant is:
*  RI(c) = true if c.balance >= 0
*        = false otherwise
* 
*/

public abstract class AccountState {
    // the rep
    protected int balance;  // this allows access within the same package and by subclasses within the program
    
    // constructor
    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: sets this.balance to 100
    public AccountState(){
        this.balance = 100;   // each new customer's account will hold an initial balance of $100
    }
    
    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns balance
    protected int getBalance(){
        return this.balance;
    }
    
    // REQUIRES: updatedbalance
    // MODIFIES: this.balance
    // EFFECTS: assigns this.balance to the updated balance if the new balance is 0 or greator
    
    protected void setBalance(int updatedbalance){
     if(updatedbalance >= 0)
        this.balance = updatedbalance;
    }
    
    // REQUIRES: amount
    // MODIFIES: this.balance
    // EFFECTS: adds amount to this.balance if the amount is not a negative integer
    protected void addAmount(int amount){
        this.balance = this.balance + amount;
    }
    
    
    // REQUIRES: amount
    // MODIFIES: this.balance
    // EEFECTS: removes amount from this.balance if the amount is smaller than or equal to this.balance
    //          not negative integer 
    protected void removeAmount(int amount){
        this.balance = this.balance - amount;
    }
    
    // REQUIRES: amount
    // MODIFIES: nothing will be modified
    // EFFECTS: If the amount is greater than or equal to $50, and the service fee,
    //  the total= amount+ fee is subtracted from this.balance 
    public void onlineShop(int amount){
    
    } 
    
    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns state of customer's current level
    public  String getState(){
        return ""; // empty string for now
    }
    
    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns balance of this.balance (ie. abstraction function)
    @Override
    public String toString(){
        return "Your Balance is $" + balance;
    }
    
    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: if the Rep Invariant holds for this object it returns true 
    //    otherwise returns false
    public boolean repOK(){
        if(this.balance > 0)
            return true;
        return false;
    }
    
}
