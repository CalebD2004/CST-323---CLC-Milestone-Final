package com.cst323.milestone2.milestone2.services;
import com.cst323.milestone2.milestone2.repositories.OrderRepository;
import com.cst323.milestone2.milestone2.models.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    // constructor for OrderService to initialize the OrderRepository
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //Method to retrieve all orders
    public List<order> getAllOrders() {
        return orderRepository.findAll();
    }

    //Method to create a new order
    public order createOrder(order newOrder) {
        //int lengthOfList = getAllOrders().size();
        //newOrder.setOrderID((long) (lengthOfList + 1)); // Ensure the order ID is null for a new order
        return orderRepository.save(newOrder);
    }

    //Method to update an existing order
    public order updateOrder(order Order) {
        order orderToUpdate = orderRepository.findById(Order.getOrderID()).orElse(null);
        if (orderToUpdate != null) {
            orderToUpdate.setAssociated_Customer(Order.getAssociated_Customer());
            orderToUpdate.setAssociated_Order_List(Order.getAssociated_Order_List());
            orderToUpdate.setTotal_Price(Order.getTotal_Price());
            orderToUpdate.setDelivery_Address(Order.getDelivery_Address());
            orderToUpdate.setPayment_Type(Order.getPayment_Type());
            orderToUpdate.setDate_Placed(Order.getDate_Placed());

            return orderRepository.save(orderToUpdate);
        }
        return null;
    }


    //Method to delete an existing order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    //Method to retrieve an order by its ID
    public order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
