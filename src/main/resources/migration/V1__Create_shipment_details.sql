CREATE TABLE shipment_details
(
    id                      integer generated by default as identity,
    order_id                integer not null,
    item_id                 integer not null,
    estimated_delivery_date TIMESTAMP WITHOUT TIME ZONE,
    created_at              TIMESTAMP WITHOUT TIME ZONE,
    updated_at              TIMESTAMP WITHOUT TIME ZONE,
    status                  varchar(20),
    shipment_address        varchar not null

);

