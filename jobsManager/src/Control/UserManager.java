/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import DL.User;

/**
 *
 * @author BB
 */
public class UserManager {

    private static UserManager userManager;
    private User user;
    public static UserManager getUserManager(){
        if(userManager == null){
            WriteRead.getReadWrite().writeLog("constructor UserManager");
            userManager = new UserManager();
        }
        return userManager;
    }
    private UserManager() {
        
    }
    
    public void addUser(){
        WriteRead.getReadWrite().writeLog("-UserManager- adduser ");
        User u = new User("user 1", "13456");
        WriteRead.getReadWrite().writeUser(u);
    }
    
    public User getUser(){
        WriteRead.getReadWrite().writeLog("-UserManager- getUser ");
        user = WriteRead.getReadWrite().readUser("src/Data/1");
        return user;
    }
}
