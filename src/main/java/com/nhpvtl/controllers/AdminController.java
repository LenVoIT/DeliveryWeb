/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.controllers;

import com.nhpvtl.pojo.Orders;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.service.AccountService;
import com.nhpvtl.service.ShipperByAdminService;
import com.nhpvtl.service.OrderShipService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/admin")
@PropertySource("classpath:messages.properties")
public class AdminController {

    @Autowired
    private ShipperByAdminService shipperByAdminService;

    @Autowired
    private OrderShipService orderShipService;

    @Autowired
    private Environment env;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/shippermanagebyadmin")
    public String adminListShippers(Model model, @RequestParam(required = false) Map<String, String> params) {

//        String kw = params.getOrDefault("kw", null);
//        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("shipperList", this.shipperByAdminService.getShippers(params, 0));
        return "shippermanagebyadmin";
    }

    @RequestMapping("/ordership")
    public String orderShip(Model model, @RequestParam(required = false) Map<String, String> params) {

        model.addAttribute("orderList", this.orderShipService.getOrders(params, 0));
        return "ordership";
    }

    @RequestMapping("/manageaccount")
    public String accountList(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("account", this.accountService.getAccounts(params, 0));

        return "manageaccount";
    }

//    @GetMapping("/ordersmanagebyadmin")
//    public String adminListOrders(Model model) {
//
//        List<Orders> orderList = shipOrderService.getOrders(null, 0);
//        model.addAttribute(orderList);
//        return "ordersmanagebyadmin";
//    }
//    @GetMapping("/ordersmanagebyadmin")
//    public String list(Model model) {
//        model.addAttribute("order", new Orders());
//        
//        return "ordersmanagebyadmin";
//    }
//    
//    @PostMapping("/ordersmanagebyadmin")
//    public String add(@ModelAttribute(value = "orders") @Valid Orders o,
//            BindingResult r) {
//        if (r.hasErrors()) {
//            return "ordersmanagebyadmin";
//        }
//        
//        if (this.ordersByAdminService.addOrder(o) == true)
//            return "redirect:/";
//        
//        return "ordersmanagebyadmin";
//    }
}
