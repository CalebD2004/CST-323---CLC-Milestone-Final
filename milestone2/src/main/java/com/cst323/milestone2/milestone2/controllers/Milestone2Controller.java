package com.cst323.milestone2.milestone2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.cst323.milestone2.milestone2.services.OrderService;
import com.cst323.milestone2.milestone2.models.order;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Milestone2Controller {

    // order service instance for handling order operations
    private final OrderService orderService;

    // Constructor to initialize the OrderService
    public Milestone2Controller(OrderService orderService) {
        this.orderService = orderService;
    }
    
    // Method to handle the home page request
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    // Method to handle the orders page request
    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    // Method to handle the create order page request
    @RequestMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("order", new order());
        return modelAndView;
    }

    // Method to handle the create order form submission
    @RequestMapping("/createForm")
    public String createPost(@Valid @ModelAttribute order order) {
        orderService.createOrder(order);
        return "redirect:/orders";
    }

    // Method to handle the edit order page request
    @RequestMapping("/edit")
    public String edit(@RequestParam("orderId") Long orderId, Model model) {
        model.addAttribute("orderId", orderId);
        model.addAttribute("order", orderService.getOrderById(orderId));
        return "edit";
    }

    // Method to handle the edit order form submission
    @RequestMapping("/editForm")
    public String editPost(@Valid @ModelAttribute order order) {
        orderService.updateOrder(order);
        return "redirect:/orders";
    }

    // Method to handle the delete order request
    @RequestMapping("/delete")
    public String delete(@RequestParam("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
        System.out.println("Deleted order with ID: " + orderId);
        return "redirect:/orders";
    }
}
