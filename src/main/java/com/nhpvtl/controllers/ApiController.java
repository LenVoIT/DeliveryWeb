/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.controllers;

import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.service.ShipperByAdminService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@Transactional
public class ApiController {

    @Autowired
    private ShipperByAdminService shipperByAdminService;

//    @PostMapping(value = "/api/dat-ve", produces = {
//            MediaType.APPLICATION_JSON_VALUE
//    })
//    public ResponseEntity<Void> datVeAPI(@RequestBody Map<String, String> params) {
//        try {
//            int coachLineId = Integer.parseInt(params.get("coachLineId"));
//            int accountId = Integer.parseInt(params.get("accountId"));
//
//            CoachLine coachLine = coachLineService.getById(coachLineId);
//            coachLine.setRemainingSeats(coachLine.getRemainingSeats() - 1);
//            coachLineService.addOrUpdate(coachLine);
//
//            Ticket ticket = new Ticket();
//            ticket.setId(0);
//            ticket.setName("dang ko co");
//            ticket.setCoachLine(coachLineService.getById(coachLineId));
//            ticket.setCustomer(customerService.getByAccountId(accountId));
//            ticketService.addOrUpdate(ticket);
//
//            return new ResponseEntity<Void>(HttpStatus.CREATED);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
}
