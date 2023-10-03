package ar.lamansys.app;


import ar.lamansys.sgx.shared.EnableSharedLibrary;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ar.lamansys.cart.EnableCart;


@Configuration
@EnableSharedLibrary
@ComponentScan(basePackages = {"ar.lamansys.app"})
@EnableJpaRepositories(basePackages = {"ar.lamansys.app"})
@EntityScan(basePackages = {"ar.lamansys.app"})
@EnableCart()
public class AppAutoConfiguration {
}