CREATE TABLE shipment_status
(
    id          integer generated by default as identity,
    shipment_id integer not null,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    status      varchar not null,

);