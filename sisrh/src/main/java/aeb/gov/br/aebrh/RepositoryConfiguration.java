package aeb.gov.br.aebrh;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "aeb.gov.br")
@EnableJpaRepositories(basePackages = "aeb.gov.br")
@EnableTransactionManagement
public class RepositoryConfiguration {

}
