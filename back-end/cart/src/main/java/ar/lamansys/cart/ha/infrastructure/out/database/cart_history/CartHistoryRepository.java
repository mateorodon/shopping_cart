package ar.lamansys.cart.ha.infrastructure.out.database.cart_history;

import ar.lamansys.cart.ha.infrastructure.out.database.cart.CartEntity;
import ar.lamansys.cart.ha.infrastructure.out.database.cart.CartID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartHistoryRepository extends JpaRepository<CartHistoryEntity, CartID> {
}
