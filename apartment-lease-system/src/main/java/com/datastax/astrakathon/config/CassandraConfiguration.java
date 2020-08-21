package com.datastax.astrakathon.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.astrakathon.utils.CqlFileUtils;
import com.datastax.astrakathon.utils.DBConnection;
import com.datastax.oss.driver.api.core.CqlSession;

@Configuration
@EnableCassandraRepositories(basePackages = { "com.datastax.astrakathon.repository" })
public class CassandraConfiguration {
	
	@Bean
	public CqlSession cassandraSession() {
		Path resourceDirectory = Paths.get("src","main","resources");
		
	    CqlSession cqlSession = CqlSession.builder()
				.withCloudSecureConnectBundle(Paths.get( resourceDirectory.toFile().getAbsolutePath() + File.separator + DBConnection.SECURE_CONNECT_BUNDLE))
				.withAuthCredentials(DBConnection.USERNAME, DBConnection.PASSWORD)
				.withKeyspace(DBConnection.KEYSPACE)
				.build();

	    createSchemaIfNeeded(cqlSession);
	    
	    return cqlSession;
	}
	
	 protected void createSchemaIfNeeded(CqlSession cqlSession) {
	        try {
	            CqlFileUtils.executeCQLFile(cqlSession, "apartment-lease-schema.cql");
	        } catch (FileNotFoundException e) {
	            throw new IllegalStateException(e);
	        }
	    }
}
