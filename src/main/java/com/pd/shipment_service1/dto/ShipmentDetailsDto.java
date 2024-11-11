package com.pd.shipment_service1.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ShipmentDetailsDto {


    private long id;
    private Long orderId;
    private Long itemId;

    private LocalDateTime estimatedDeliveryDate;

    private String shipmentAddress;
    private String shipmentStatus;

    private List<ShipmentStatusDto> shipmentStatusDtoList;

}
