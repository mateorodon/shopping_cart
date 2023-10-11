package ar.lamansys.cart.ha.infrastructure.out.database.cart_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProductEntity,CartProductID> {

    @Query("SELECT cp " +
            "FROM CartProductEntity cp " +
            "WHERE cp.cartProductID.cart_id = :cart_id " +
            "AND cp.cartProductID.user_id = :user_id")
    List<CartProductEntity> getCartProducts(@Param("cart_id") Integer cart_id, @Param("user_id")Integer user_id);
}
