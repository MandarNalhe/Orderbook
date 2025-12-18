package com.project.Exchange.Services;

import com.project.Exchange.Models.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepthService {
    List<Order> depth = new ArrayList<>();

    public List<Order> handleDepth() {
        return depth;
    }
}
