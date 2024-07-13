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

public class Manager {
    // declaring the instance variables
    private final String username = "admin";
    private final String password = "admin"; 

    // constructor
    public Manager(){
        try{
            File loginInfo = new File(username + ".txt");
            if(loginInfo.createNewFile() == true){
                FileWriter writeFile = new FileWriter(username + ".txt");
                writeFile.write(username + "\n");
                writeFile.write(password);
                writeFile.close();
            }
        }

        catch(IOException e){
            System.out.println("IOException occured!");
        }
 
    }
    //Create a new user of this bank
    public User addUser(String username, String password){ 
        return new User(username,password);
    }
   
    public void deleteCustomer(User userToDelete){
        File file = new File(userToDelete.getUsername() + ".txt");
        if(file.delete()) {
            PopUp.display("CONFIRMATION", "File of user successfully deleted!"); }
    }
}
