package ar.lamansys.cart.ha.infrastructure.out.database.cart_product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProductEntity,CartProductID> {
}
