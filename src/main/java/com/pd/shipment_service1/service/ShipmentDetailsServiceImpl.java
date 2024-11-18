package com.pd.shipment_service1.service;

import com.pd.shipment_service1.dto.ShipmentDetailsDto;
import com.pd.shipment_service1.dto.ShipmentStatusDto;
import com.pd.shipment_service1.entity.ShipmentDetailsEntity;
import com.pd.shipment_service1.entity.ShipmentStatusEntity;
import com.pd.shipment_service1.repo.ShipmentDetailsRepository;
import com.pd.shipment_service1.repo.ShipmentStatusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShipmentDetailsServiceImpl implements ShipmentDetailsService {
    private final ShipmentDetailsRepository shipmentRepository;

    private final ShipmentStatusRepository shipmentStatusRepository;

    private final ModelMapper modelMapper;

    public ShipmentDetailsServiceImpl(ModelMapper modelMapper, ShipmentDetailsRepository shipmentRepository, ShipmentStatusRepository shipmentStatusRepository) {
        this.modelMapper = modelMapper;
        this.shipmentRepository = shipmentRepository;
        this.shipmentStatusRepository = shipmentStatusRepository;
    }


    public ShipmentDetailsDto getShipmentDetails(int orderId) {

        ShipmentDetailsEntity shipmentDetails =
                shipmentRepository.findById(Long.valueOf(orderId)).orElseThrow(() -> new RuntimeException("orderid not found"));

        return modelMapper.map(shipmentDetails, ShipmentDetailsDto.class);


    }

    @Override
    public ShipmentDetailsDto saveShipment(ShipmentDetailsDto shipmentDetailsDto) {
        ShipmentDetailsEntity shipmentDetails = modelMapper.map(shipmentDetailsDto, ShipmentDetailsEntity.class);

        ShipmentStatusEntity shipmentStatusEntity = new ShipmentStatusEntity();
        shipmentStatusEntity.setStatus(shipmentDetails.getStatus());
        shipmentStatusEntity.setEstimatedDeliveryDate(shipmentDetailsDto.getEstimatedDeliveryDate());
        //shipmentStatusEntity.setShipmentDetails(shipmentDetails);
        shipmentStatusEntity.setEstimatedDeliveryDate(shipmentDetails.getEstimatedDeliveryDate());

        shipmentDetails.setShipmentStatusEntityList(Arrays.asList(shipmentStatusEntity));
        shipmentDetails  = shipmentRepository.save(shipmentDetails);
        return modelMapper.map(shipmentDetails,ShipmentDetailsDto.class);


    }
}
