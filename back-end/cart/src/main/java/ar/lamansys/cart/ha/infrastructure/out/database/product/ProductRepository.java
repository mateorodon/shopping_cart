package ar.lamansys.cart.ha.infrastructure.out.database.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

    @Query("UPDATE ProductEntity p " +
            "SET p.stock = (p.stock - :amount)" +
            "WHERE p.product_id = :product_id")
    void updateStock(@Param("product_id") Integer product_id, @Param("amount") Integer amount);
}
