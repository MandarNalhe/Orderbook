package com.project.Exchange.Controllers;

import com.project.Exchange.Models.Order;
import com.project.Exchange.Services.DepthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DepthController {
    @Autowired
    DepthService depthService;
    @GetMapping("/depth")
    public List<Order> getDepth(){
        return depthService.handleDepth();
    }
}
