CREATE TABLE shipment_status
(
    id          BIGINT primary key generated by default as identity,
    shipment_id BIGINT not null REFERENCES shipment_details(id) ,
    estimated_delivery_date TIMESTAMP WITHOUT TIME ZONE,
    shipment_address        varchar not null,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    status      varchar not null

);