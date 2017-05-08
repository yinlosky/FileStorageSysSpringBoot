package edu.umbc.yhuang9.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.junit.Assert.*;

/**
 * Created by yhuang9 on 5/8/17.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"edu.umbc.yhuang9.fileentity"})
@EnableJpaRepositories(basePackages = {"edu.umbc.yhuang9.repositories"})
@EnableTransactionManagement
public class RepositoryConfigurationTest {

}