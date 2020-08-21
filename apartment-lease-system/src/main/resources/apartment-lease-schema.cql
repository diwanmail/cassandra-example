
CREATE TABLE IF NOT EXISTS apartments_by_buildling (
    building_name text,
    apartment_create_date timestamp,
    apartment_name text,
    apartment_address text,
    apartment_type text,
    building_manager text,
    building_phone text,
    room_count int,
    bathroom_count int,
    appartment_facing text,
    appartment_facilities set<text>,
    is_apartment_available_for_lease boolean,
    PRIMARY KEY ((building_name), apartment_name, apartment_create_date)
) WITH CLUSTERING ORDER BY (apartment_name desc, apartment_create_date desc);


CREATE TABLE IF NOT EXISTS guest_detail (
    email_address text,
    created_date timestamp,
    first_name text,
    middle_name text,
    last_name text,
    permanent_address text,
    proof_of_id text,
    proof_of_id_number int,
    gender int,
    date_of_birth text,
    PRIMARY KEY ((email_address), created_date)
) WITH CLUSTERING ORDER BY (created_date desc);


CREATE TABLE IF NOT EXISTS leasing_detail_by_apartment (
    lease_id UUID,
    apartment_name text,
    guest_email_address text,
    lessor_name text,
    lease_start_date timestamp,
    lease_end_date timestamp,
    last_name text,
    lease_duration_in_month int,    
    lease_sign_date timestamp,
    lease_amount bigint,    
    is_lease_active boolean,
    PRIMARY KEY ((apartment_name), lease_sign_date)
) WITH CLUSTERING ORDER BY (lease_sign_date desc);

CREATE TABLE IF NOT EXISTS leasing_detail_by_guest (
    lease_id UUID,
    guest_email_address text,
    apartment_name text,
    lessor_name text,
    lease_start_date timestamp,
    lease_end_date timestamp,
    last_name text,
    lease_duration_in_month int,    
    lease_sign_date timestamp,
    lease_amount bigint,    
    is_lease_active boolean,
    PRIMARY KEY ((guest_email_address), lease_sign_date)
) WITH CLUSTERING ORDER BY (lease_sign_date desc);

