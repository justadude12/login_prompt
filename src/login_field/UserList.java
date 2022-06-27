package login_field;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserList {
    private static String PATH = "userlist.txt";
    public static File createUserFile() {
        try{
            File Users = new File(PATH);
            Users.createNewFile();
            return Users;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    public static boolean addUser(String username, String password){
        try{
            FileWriter newUser = new FileWriter(createUserFile());
            newUser.write(username);
            newUser.write(System.getProperty("line.separator"));
            newUser.write(password);
            newUser.write(System.getProperty("line.separator"));
            newUser.close();
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean userExists(String username, String password) {
        boolean user = false;
        boolean word = false;
        int i = 0;
        Scanner userReader = new Scanner(PATH);
        while(userReader.hasNextLine()) {
            String data = userReader.nextLine();
            if(i % 2 == 0) {
                if(data.equals(username)) {
                    user = true;
                } else {
                    user = false;
                }
            }
            if(i % 2 == 1 && user) {
                if(data.equals(password)) {
                    word = true;
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}
