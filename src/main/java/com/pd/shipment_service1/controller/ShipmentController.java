package com.pd.shipment_service1.controller;

import com.pd.shipment_service1.dto.ShipmentDetailsDto;
import com.pd.shipment_service1.service.ShipmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {


    @Autowired
    private ShipmentDetailsService shipmentService;

    @GetMapping(value = "/api/shipment-status/{orderid}")
    public ShipmentDetailsDto getShipmentStatus(@PathVariable int orderid) {

        if (orderid <= 0) {
            throw new RuntimeException("invalid orderid!!");
        }
        return shipmentService.getShipmentDetails(orderid);

    }

    @PostMapping(value = "/api/shipment-status")
    public ShipmentDetailsDto getShipmentStatus(@RequestBody ShipmentDetailsDto shipmentDetailsDto) {


        return shipmentService.saveShipment(shipmentDetailsDto);

    }
}
