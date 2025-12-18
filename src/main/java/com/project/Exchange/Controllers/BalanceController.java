package com.project.Exchange.Controllers;

import com.project.Exchange.Models.Balance;
import com.project.Exchange.Services.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @GetMapping("/balance")
    public ResponseEntity<Balance> getBalance(@RequestParam("userID") int userID){
        try{
            Balance balance = balanceService.handleBalance(userID);
            return ResponseEntity.status(HttpStatus.OK).body(balance);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new Balance());
        }
    }
}
