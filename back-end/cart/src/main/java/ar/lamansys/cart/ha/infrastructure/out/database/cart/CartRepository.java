package ar.lamansys.cart.ha.infrastructure.out.database.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends JpaRepository<CartEntity,Integer> {

    //@Transactional(readOnly = true)
    @Transactional
    @Query(value = "SELECT c " +
                    "FROM CartEntity c " +
                    "WHERE c.user_id = :user_id AND c.finalized = false ")
    CartEntity getCartId(@Param("user_id") Integer user_id);
}
