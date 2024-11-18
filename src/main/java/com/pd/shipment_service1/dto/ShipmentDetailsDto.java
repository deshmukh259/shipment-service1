package com.pd.shipment_service1.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String status;

    private List<ShipmentStatusDto> shipmentStatusDtoList;

}
