package com.example.Orders.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.Orders.Entity.Order;
import com.example.Orders.Extract.ItemExtract;
import com.example.Orders.Repository.OrderRepo;

import reactor.core.publisher.Mono;

@Service
public class OrderService {
    @Autowired
    OrderRepo or;

    // WebClient client =  WebClient.create("http://localhost:8081");
    private final WebClient.Builder client;

    @Autowired
    public OrderService(WebClient.Builder wc) {
        this.client = wc.baseUrl("http://MY-ITEM-SERVICE");
    }
    
    // WebClient.create("http://MY-ITEM-SERVICE");

    public List<Order> getOrders() {
        List<Order> retList = new ArrayList<>();
        or.findAll().forEach(item -> retList.add(item));
        return retList;
    }

    public Mono<String> insertOrder(Order order) {
        // check if order is valid
       Mono<ItemExtract> result = client.build().get()
		.uri("items/item/" + order.getItem_id())
		.retrieve()
		.bodyToMono(ItemExtract.class);

        if(result == null) return Mono.just("Error no item found");

        return result.flatMap(
            item -> {
                if(item.getQuantity() < order.getQuantity()) {
                    final String msg = "Error Item needs to be restocked, Try to add less items to order. Current item: " + item.getId() + "has only " + item.getQuantity();
                    return Mono.just(msg);
                }
                //update the quantity of items
                System.out.println("/update/" + order.getItem_id() + "/" + order.getQuantity());
                client.
                build()
                .put()
                .uri("/update/" + order.getItem_id() + "/" + order.getQuantity()).
                retrieve()
                .bodyToMono(String.class)
                .subscribe(
                    data -> {
                        System.out.println(data);
                    }
                );
                or.save(order);
                return Mono.just("Successfully Entered order");
            }
        );
    }

    public Mono<String> deleteOrder(int orderid) {
        Order extract = or.findById(orderid).orElse(null);
        if(extract == null) return Mono.just("Order with this id does not exist");
        return get(extract.getItem_id())
                .flatMap(
                    item -> {
                        if(item == null) return Mono.just("Item with this id does not exist");
                        or.deleteById(orderid);
                        return put(extract.getItem_id(), extract.getQuantity());
                    }
                );   
    }

    public Mono<ItemExtract> get(String id) {
        return client.build()
                    .get()
                    .uri("items/item/" + id)
                    .retrieve()
                    .bodyToMono(ItemExtract.class);
    }

    public Mono<String> put(String itemid, int quantity) {
        return client.build()
                     .put()
                     .uri("items/item/"+itemid+"/"+ (-quantity))
                     .retrieve()
                     .bodyToMono(String.class);
    }
    
}
