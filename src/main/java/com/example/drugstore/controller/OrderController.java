package com.example.drugstore.controller;

import com.example.drugstore.entity.Order;
import com.example.drugstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public String listOrders(Model model) {
        List<Order> ordersList = (List<Order>) orderRepository.findAll();
        model.addAttribute("ordersList", ordersList);
        return "orders";
    }

    @GetMapping("/orders/add")
    public String addOrder(Model model) {
        model.addAttribute("order", new Order());
        return "orders-form";
    }

    @PostMapping("/orders/save")
    public String saveOrder(Order order) {
        orderRepository.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/orders/edit/{orderID}")
    public String editOrder(@PathVariable("orderID") Long orderID, Model model) {
        if (orderRepository.findById(orderID).isPresent()) {
            Order order = orderRepository.findById(orderID).get();
            model.addAttribute("order", order);
            return "orders-form";
        } else {
            return "error";
        }
    }

    @RequestMapping("/orders/delete/{orderID}")
    public String deleteOrder(@PathVariable("orderID") Long orderID, Model model) {
        if (orderRepository.findById(orderID).isPresent()) {
            orderRepository.deleteById(orderID);
            List<Order> ordersList = (List<Order>) orderRepository.findAll();
            model.addAttribute("ordersList", ordersList);
            return "orders";
        } else {
            return "error";
        }
    }
}