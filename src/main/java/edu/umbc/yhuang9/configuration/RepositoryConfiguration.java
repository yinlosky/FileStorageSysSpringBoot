package edu.umbc.yhuang9.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yhuang9 on 5/6/17.
 *
 *  For the purpose of integrating tests, we don't need to write code to
 *  create the beans for (1) H2 data source (2) the hibernate entity manager
 *  (3) A JPA Transaction Manager, we use annotations
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"edu.umbc.yhuang9.fileentity"})
@EnableJpaRepositories(basePackages = {"edu.umbc.yhuang9.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
