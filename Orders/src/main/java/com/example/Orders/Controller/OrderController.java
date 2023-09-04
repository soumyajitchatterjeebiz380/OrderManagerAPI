package com.example.Orders.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Orders.Entity.Order;
import com.example.Orders.Services.OrderService;

import reactor.core.publisher.Mono;

@RestController
public class OrderController {
    @Autowired
    OrderService os;

    @GetMapping("/orders")
    public List<Order> retreiveOrdersOrder() {
        return os.getOrders();
    }

    @PostMapping("orders/order")
    public Mono<String> createOrder(@RequestBody Order order) {
        return os.insertOrder(order);
    }

    @DeleteMapping("orders/order/{orderid}")
    public Mono<String> deleteOrder(@PathVariable int orderid) {
         os.deleteOrder(orderid).subscribe(
            responseBody-> {
                System.out.println(responseBody);
            }
         );
         return Mono.just("Order had been deleted");
    }

}
