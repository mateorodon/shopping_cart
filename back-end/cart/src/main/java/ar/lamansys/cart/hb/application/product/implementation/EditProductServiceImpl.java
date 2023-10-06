package ar.lamansys.cart.hb.application.product.implementation;

import ar.lamansys.cart.hb.application.product.exceptions.NotUniqueProductException;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.interfaces.DeleteProductService;
import ar.lamansys.cart.hb.application.product.interfaces.EditProductService;
import ar.lamansys.cart.hb.application.product.interfaces.SaveProductService;
import ar.lamansys.cart.hb.application.product.port.ProductPort;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditProductServiceImpl implements EditProductService {

    private ProductPort productPort;

    private DeleteProductService deleteProductService;
    private SaveProductService saveProductService;
    @Override
    public ProductBO run(Integer id, ProductBO newProduct) throws ProductDoesNotExistException, NotUniqueProductException {
        if (!productPort.exists(id)){
            throw new ProductDoesNotExistException(id);
        }
        deleteProductService.run(id);
        return saveProductService.run(newProduct);
    }
}
