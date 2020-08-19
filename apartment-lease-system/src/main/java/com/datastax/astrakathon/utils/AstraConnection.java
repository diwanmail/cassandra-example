package com.datastax.astrakathon.utils;

/*
 * EXERCISE 2:
 *  
 * TODO Please change this constants with the values 
 * you used when you created the ASTRA instance.
 */
public interface AstraConnection {
    
    // This is the Zip file you downloaded
    String SECURE_CONNECT_BUNDLE = "C:\\Users\\diwan\\Downloads\\cassandra-workshop-series-master\\cassandra-workshop-series-master\\week3-AppDev-crud\\crud-java\\secure-connect-killrvideocluster.zip";

    // This is the username, recommended value was KVUser
    String USERNAME = "KVUser";

    // This is the password, recommended value was KVPassword
    String PASSWORD = "KVPassword";
    
    // This is the keyspace name, recommended value was killrvideo
    String KEYSPACE = "killrvideo";
    
}