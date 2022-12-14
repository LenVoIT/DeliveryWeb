/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service.impl;

import com.nhpvtl.pojo.Orders;
import com.nhpvtl.repository.OrderShipRepository;
import com.nhpvtl.service.OrderShipService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class OrderShipServiceImpl implements OrderShipService{
    @Autowired
    private OrderShipRepository orderShipRepository;

    @Override
    public List<Orders> getOrders(Map<String, String> params, int page) {
        return this.orderShipRepository.getOrders(params, page);
    }

    @Override
    public Orders getById(int id) {
        return this.orderShipRepository.getById(id);
    }

    @Override
    public boolean addOrUpdate(Orders orders) {
        return this.orderShipRepository.addOrUpdate(orders);
    }

    @Override
    public int countOrders() {
        return this.orderShipRepository.countOrders();
    }
}
