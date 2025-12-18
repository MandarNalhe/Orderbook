package com.project.Exchange.Controllers;

import com.project.Exchange.Models.Order;
import com.project.Exchange.Services.DepthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DepthController {
    @Autowired
    DepthService depthService;
    @GetMapping("/depth")
    public ResponseEntity<List<Order>> getDepth(){
        return ResponseEntity.status(HttpStatus.OK).body(depthService.handleDepth());
    }
}
