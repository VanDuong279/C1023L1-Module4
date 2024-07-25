package codegym.vn.exercise3.dao;

import codegym.vn.exercise3.model.Login;
import codegym.vn.exercise3.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static List<User> users = new ArrayList<>();
    static {
        users.add(new User("nv1","123","TEO","teonv@gmail.com",20));
        users.add(new User("nv2","123","TEO","teonv@gmail.com",20));
        users.add(new User("nv3","123","TEO","teonv@gmail.com",20));
        users.add(new User("nv4","123","TEO","teonv@gmail.com",20));
    }
    public static User checkLogin(Login login){
        for (User user : users) {
            if (user.getUsername().equals(login.getUsername()) && user.getPassword().equals(login.getPassword())){
                return user;
            }
        }
        return null;
    }
}
