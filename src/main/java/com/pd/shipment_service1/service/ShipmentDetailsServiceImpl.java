package com.pd.shipment_service1.service;

import com.pd.shipment_service1.dto.ShipmentStatusDto;
import com.pd.shipment_service1.entity.ShipmentDetailsEntity;
import com.pd.shipment_service1.repo.ShipmentDetailsRepository;
import com.pd.shipment_service1.repo.ShipmentStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentDetailsServiceImpl implements ShipmentDetailsService {
    private ShipmentDetailsRepository shipmentRepository;
    private ShipmentStatusRepository shipmentStatusRepository;

    List<ShipmentStatusDto> getShipmentDetails(int orderId){

      ShipmentDetailsEntity shipmentDetails =  shipmentRepository.findByID();



    }
}
