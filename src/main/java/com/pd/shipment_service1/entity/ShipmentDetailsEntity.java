package com.pd.shipment_service1.entity;

import com.pd.shipment_service1.enums.ShipmentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shipment_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ShipmentDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Long itemId;

    private LocalDateTime estimatedDeliveryDate;

    private String shipmentAddress;

    @OneToMany(mappedBy = "shipmentDetails")
    private List<ShipmentStatusEntity> shipmentStatusEntityList;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;


}
