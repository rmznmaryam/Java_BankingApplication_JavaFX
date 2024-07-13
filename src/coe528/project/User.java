/**
 *
 * @author Maryam 
 *
 */

package coe528.project;
      
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;
        
public class User{
    // declaring the instance variables
    private String username;
    private String password;
    private AccountState state;
    
    // constructor
    public User(String username, String password) {
        try{
            File loginInfo = new File(username + ".txt");
            if (loginInfo.createNewFile() == true) {
                System.out.println("Provided user: " + loginInfo.getName());  // will be printed out in the output console
                this.username = username;
                this.password = password;
                state = new SilverState(); // the bankAccount level can change to gold/platinum 
                                           // after depositing, withdrawing or purchasing online;
                                           // right now, it's set to silver
                FileWriter writeFile = new FileWriter(username + ".txt");
                writeFile.write(username + "\n");
                writeFile.write(password + "\n");
                writeFile.write("" + 100);
                writeFile.close(); 
            } 
            else if (loginInfo.exists()) {
                this.username = username;
                this.password = password;
                state = new SilverState();
            } 
            else if (loginInfo.getName().equals(username)){
                PopUp.display("ERROR", "Username already taken! Please try again.");
            }
        }
        catch(IOException e){
            System.out.println("IOException error occurred!");
        } 
    }

    // all the getters of this class
    public int getBalance(){
        return state.getBalance();
    }
    
    public String getUsername(){
        return username;
    }
    public String getPassword(){ 
       return password;
    }
    
    public String getLevel(){
        return state.getState();
    }
    
    // the setter of this class
    public void setLevel(){ 
        int balance = state.getBalance();
//We can divide to find out what state our bank account is in
        switch(balance/10000) {
            case 0:  //means we have less than 10000
                state = new SilverState();
                break;
            case 1:  // we have either $10000 or more- if it was 2 we wud have 20k
                state = new GoldState();
                break;
            default:  // if balance is more than $20000
                state = new PlatinumState();
                break;
        }
        state.setBalance(balance);
    }
    
    public void deposit(int amount){
        state.addAmount(amount);
        PopUp.display("DEPOSIT", "$" + amount + " has been deposited for your account.");
        this.setLevel();
    }

    public void withdraw(int amount){
        if(state.getBalance() >= amount){
            state.removeAmount(amount);
            PopUp.display("WITHDRAWAL", "$" + amount + " has been withdrawn from your account."); 
            this.setLevel();
        }
        else
             PopUp.display("WARNING", "Sorry, you do not have enough credit to withdraw $" + amount + "."); 
            
    }
    public void onlineShop(int amount){
        if(amount < 50){
            // returns an error message saying that the online purchase couldn't be made because of the conditions
            PopUp.display("ERROR", "Online purchase must be $50 or more!"); 
            return; }
        state.onlineShop(amount);
        this.setLevel();
    }
    
}

