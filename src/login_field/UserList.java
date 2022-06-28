package login_field;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserList {
    private static String PATH = "userlist.txt";
    private static int MAX_USERS = 200;
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
            Scanner read = new Scanner(createUserFile());
            int userNumber = 0;
            while(read.hasNextLine()) {
                userNumber++;
            }
            if(userNumber < 2 * MAX_USERS) {
                newUser.write(String.valueOf(username.hashCode()));
                newUser.write(System.getProperty("line.separator"));
                newUser.write(String.valueOf(password.hashCode()));
                newUser.write(System.getProperty("line.separator"));
                newUser.close();
                return true;
            } else {
                return false;
            }
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void deleteUsers() {
        createUserFile().delete();
    }
}
