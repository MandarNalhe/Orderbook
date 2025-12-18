package com.project.Exchange.Services;

import com.project.Exchange.DAO.Users;
import com.project.Exchange.Models.Balance;
import com.project.Exchange.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {
    @Autowired
    Users users;
    public Balance handleBalance(int userID){
       for(User u : users.getUsers() ){
           if(u.getUserID() == userID){
               return u.getBalance();
           }
       }
       return new Balance();
    }
}
