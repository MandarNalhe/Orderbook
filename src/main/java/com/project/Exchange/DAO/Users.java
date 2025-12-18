package com.project.Exchange.DAO;

import com.project.Exchange.Models.Balance;
import com.project.Exchange.Models.Order;
import com.project.Exchange.Models.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Users {
    List<User> users = new ArrayList<>();
    @PostConstruct
    public void setUsers(){
        User user = new User();
        user.setUserID(1);
        user.setBalance(new Balance());

        User user1 = new User();
        user1.setUserID(2);
        user1.setBalance(new Balance());
        users.add(user1);
        users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }
}
