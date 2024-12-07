package com.pd.shipment_service1.service;

import com.pd.shipment_service1.dto.ShipmentDetailsDto;
import com.pd.shipment_service1.entity.ShipmentDetailsEntity;
import com.pd.shipment_service1.entity.ShipmentStatusEntity;
import com.pd.shipment_service1.repo.ShipmentDetailsRepository;
import com.pd.shipment_service1.repo.ShipmentStatusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                shipmentRepository.findById((long) orderId).orElseThrow(() -> new RuntimeException("orderid not found"));

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
        shipmentDetails = shipmentRepository.save(shipmentDetails);
        return modelMapper.map(shipmentDetails, ShipmentDetailsDto.class);


    }

    @Override
    public List<ShipmentDetailsDto> getShipmentDetails() {
        List<ShipmentDetailsEntity> shipmentRepositoryAll = shipmentRepository.findAll();
        List<ShipmentDetailsDto> collect = shipmentRepositoryAll.stream()
                .map(e -> modelMapper.map(e, ShipmentDetailsDto.class))
                .collect(Collectors.toList());
        return collect;

    }
}
