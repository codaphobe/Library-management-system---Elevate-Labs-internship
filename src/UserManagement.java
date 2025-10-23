import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public class UserManagement {

    private final ArrayList<User> allUsers = new ArrayList<>();

    public boolean userExists(String email){
        return allUsers.stream()
                .anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }

    public boolean addUser(User user){
        if(userExists(user.getEmail())){
            System.err.println("User with this email already exists");
            return false;
        }
        allUsers.add(user);
        System.out.println("User successfully added!!");
        return true;
    }

    public User getUserByEmail(String email){
        Optional<User> user = allUsers.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
        if(user.isPresent()){
            return user.get();
        }
        System.err.println("No user found with this email");
        return null;
    }

    public User updateUserName(String name, String email){
        User u = getUserByEmail(email);
        if(u!=null){
            u.setName(name);
            System.out.println("User name updated successfully");
            return u;
        }
        return null;
    }

    public boolean deleteUser(String email){
        boolean removed = allUsers.removeIf(u -> u.getEmail().equalsIgnoreCase(email));
        if(removed){
            System.out.println("User successfully deleted");
            return true;
        }
        return false;
    }

    public void showAllUsers(){
        if(allUsers.isEmpty()){
            System.err.println("No user records found!!");
            return;
        }
        System.out.println("-----------Displaying all users-------------");
        allUsers.forEach(System.out::println);
    }

    public ArrayList<User> getAllUsers(){
        return allUsers;
    }



}
