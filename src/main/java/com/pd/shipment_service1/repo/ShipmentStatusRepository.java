package com.pd.shipment_service1.repo;

import com.pd.shipment_service1.entity.ShipmentStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentStatusRepository extends JpaRepository<ShipmentStatusEntity, Long> {
}
