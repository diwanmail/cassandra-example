# Application Development - Apartment Lease Management System

### Application functionality
1. Create Apartment in a building
2. Add facilities to apartment
3. Update facilities to apartment
4. Delete facilities from apartment.
5. List facilities
6. Update apartment availability for lease

7. Create Guest details

8. Create lease for apartment bewteen Guest and Lessor
9. Transfer lease to new guest
10. End lease aggreement before end date
11. List all lease done for apartment

12. List all leases for a customer.


### Apartment Lease Management System cql scehma

```
⚠️⚠️⚠️ 
CREATE KEYSPACE IF NOT EXISTS killrvideo WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

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


⚠️⚠️⚠️
```

### Connect to DataStax Astra Cassandra cloud service.
```
In com.datastax.astrakathon.utils.DBConnection.java correct the SECURE_CONNECT_BUNDLE location. 
secure-connect-killrvideocluster.zip is present in project root folder.

	@Bean
	public CqlSession cassandraSession() {
	    CqlSession cqlSession = CqlSession.builder()
				.withCloudSecureConnectBundle(Paths.get(DBConnection.SECURE_CONNECT_BUNDLE))
				.withAuthCredentials(DBConnection.USERNAME, DBConnection.PASSWORD)
				.withKeyspace(DBConnection.KEYSPACE)
				.build();

	    createSchemaIfNeeded(cqlSession);
	    
	    return cqlSession;
	}
```

### Run application
This is spring boot application connecting to Astra using SecureBundleConnect and using Spring-Data-Cassandra repository approach to connect to Cassandra.
```
Run: mvn spring-boot:run

Go to localhost:8083 It will take to Swagger where all API's are defined.
```

