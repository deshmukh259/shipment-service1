package com.pd.shipment_service1.service;

import com.pd.shipment_service1.dto.ShipmentStatusDto;

import java.util.List;

public interface ShipmentDetailsService {
    List<ShipmentStatusDto> getShipmentDetails(int orderId);
}
