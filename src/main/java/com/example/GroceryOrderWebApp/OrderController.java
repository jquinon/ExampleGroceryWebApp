package com.example.GroceryOrderWebApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/order")
    public Order OrderController(@RequestParam(value = "item", defaultValue = "Banana") String name, @RequestParam(value = "quantity", defaultValue="1") int quantity){
        Order o = new Order(name, quantity);
        SQLiteJDBC.insertOrder(o);
        return o;
    }
}
