package com.iamhotcenplotz.chapter15.junit_;
import com.iamhotcenplotz.chapter15.junit_.DAO;
import com.iamhotcenplotz.chapter15.junit_.User;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise_ {
    public static void main(String[] args) {

    }

    @Test
    public void testList(){
        DAO<User> userDAO = new DAO<>();
        userDAO.save("001",new User(1,18,"zhang san"));
        userDAO.save("002",new User(2,18,"zhang si"));
        userDAO.save("003",new User(3,18,"zhang wu"));

        List<User> all = userDAO.getAll();
        System.out.println(userDAO.getAll());
    }
}
