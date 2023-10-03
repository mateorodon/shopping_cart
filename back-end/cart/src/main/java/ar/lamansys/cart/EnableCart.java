package ar.lamansys.cart;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(CartAutoConfiguration.class)
@Configuration
public @interface EnableCart {
}
