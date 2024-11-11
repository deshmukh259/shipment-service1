package com.pd.shipment_service1.entity;

import com.pd.shipment_service1.enums.ShipmentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipment_details")
public class ShipmentDetailsEntity {

    @Id
    private Long id;
    private Long orderId;
    private Long itemId;

    private LocalDateTime estimatedDeliveryDate;

    private String shipmentAddress;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus shipmentStatus;


}
