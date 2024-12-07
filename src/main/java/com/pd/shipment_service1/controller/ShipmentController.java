package com.pd.shipment_service1.controller;

import com.pd.shipment_service1.dto.ShipmentDetailsDto;
import com.pd.shipment_service1.service.ShipmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {


    @Autowired
    private ShipmentDetailsService shipmentService;

    @GetMapping(value = "/api/shipment/{orderid}")
    public ShipmentDetailsDto getShipmentStatus(@PathVariable int orderid) {

        if (orderid <= 0) {
            throw new RuntimeException("invalid orderid!!");
        }
        return shipmentService.getShipmentDetails(orderid);

    }

    @GetMapping(value = "/api/shipment")
    public List<ShipmentDetailsDto> getShipmentStatus() {

        return shipmentService.getShipmentDetails();

    }

    @PostMapping(value = "/api/shipment")
    public ShipmentDetailsDto save(@RequestBody ShipmentDetailsDto shipmentDetailsDto) {

        return shipmentService.saveShipment(shipmentDetailsDto);

    }
}
