package ar.lamansys.cart;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"ar.lamansys.cart"})
@EnableJpaRepositories(basePackages = {"ar.lamansys.cart"})
@EntityScan(basePackages = {"ar.lamansys.cart"})
@PropertySource(value = "classpath:cart.properties", ignoreResourceNotFound = true)
public class CartAutoConfiguration {
}
