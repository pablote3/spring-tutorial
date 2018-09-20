/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
// DONE: Enable Automatic JPA Repository creation, from types in com.javatunes.persistence and sub-packages 
@EnableJpaRepositories(basePackages = {"com.javatunes.persistence"})
// DONE: Enable finding of Entity Classes in com.javatunes and sub-packaves
@EntityScan(basePackages="com.javatunes")
public class SpringRepositoryConfig {

}