package com.pd.shipment_service1.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ShipmentStatusDto {

    private long id;
    private long shipmentId;
    private String updatedAt;
    private String status;
}
