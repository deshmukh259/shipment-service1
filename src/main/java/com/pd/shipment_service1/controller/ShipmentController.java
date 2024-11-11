package com.pd.shipment_service1.controller;

import com.pd.shipment_service1.dto.ShipmentStatusDto;
import com.pd.shipment_service1.service.ShipmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipmentController {


    @Autowired
    private ShipmentDetailsService shipmentService;

    @GetMapping(value = "/api/shipment-status/{orderid}")
    public List<ShipmentStatusDto> getShipmentStatus(@PathVariable int orderid) {

        if (orderid <= 0) {
            throw new RuntimeException("invalid orderid!!");
        }
        return shipmentService.getShipmentDetails(orderid);

    }
}
