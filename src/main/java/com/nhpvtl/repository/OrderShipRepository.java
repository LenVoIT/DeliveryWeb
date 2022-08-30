/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository;

import com.nhpvtl.pojo.Orders;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface OrderShipRepository {

    List<Orders> getOrders(Map<String, String> params, int page);

    Orders getById(int id);

    boolean addOrUpdate(Orders orders);

    int countOrders();
}
