package com.pd.shipment_service1.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ShipmentStatus {
    ORDERED("ORDERED"), PREPARE("PREPARE"), READY_TO_SHIP("READY_TO_SHIP"),
    SHIPPED("SHIPPED"), CANCELLED("CANCELLED"), SHIPMENT_CANCELLED_DUE_TO_DAMAGE("SHIPMENT_CANCELLED_DUE_TO_DAMAGE"),
    DELIVERED("DELIVERED");
    private final String value;

    ShipmentStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ShipmentStatus fromValue(String value) {
        for (ShipmentStatus status : ShipmentStatus.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
