package ar.lamansys.cart.ha.infrastructure.out.database.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CartRepository extends JpaRepository<CartEntity,CartID> {

    //@Transactional(readOnly = true)
    @Query(value = "SELECT c.cartID.cart_id " +
                    "FROM CartEntity c " +
                    "WHERE c.cartID.user_id = :user_id " +
                    "GROUP BY c.cartID.cart_id ")
    Integer getCartId(@Param("user_id") Integer user_id);
}
