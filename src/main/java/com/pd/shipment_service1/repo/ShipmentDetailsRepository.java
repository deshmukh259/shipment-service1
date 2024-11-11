package com.pd.shipment_service1.repo;

import com.pd.shipment_service1.entity.ShipmentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentDetailsRepository extends JpaRepository<ShipmentDetailsEntity, Long> {
}
