package ar.lamansys.cart.ha.infrastructure.out.database.cart_history;

import ar.lamansys.cart.ha.infrastructure.out.database.cart.CartEntity;
import ar.lamansys.cart.ha.infrastructure.out.database.cart.CartID;
import ar.lamansys.cart.hc.domain.cart_history.CartHistoryBO;

public class CartHistoryMapperJPA {

    public static CartHistoryBO toCartHistoryBO(CartHistoryEntity cart){
        return new CartHistoryBO(cart.getCartID().getCart_id(),cart.getCartID().getUser_id(),cart.getDate(),cart.getFinal_price());
    }

    public static CartHistoryEntity toCartHistoryEntity(CartHistoryBO cart){
        CartID id = new CartID(cart.getCart_id(),cart.getUser_id());
        return new CartHistoryEntity(id,cart.getDate(),cart.getFinal_price());
    }
}
