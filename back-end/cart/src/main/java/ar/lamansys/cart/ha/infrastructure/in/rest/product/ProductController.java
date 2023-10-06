package ar.lamansys.cart.ha.infrastructure.in.rest.product;


import ar.lamansys.cart.ha.infrastructure.in.rest.product.dto.ProductDTORequest;
import ar.lamansys.cart.ha.infrastructure.in.rest.product.dto.ProductDTOResponse;
import ar.lamansys.cart.hb.application.product.exceptions.NotUniqueProductException;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.interfaces.DeleteProductService;
import ar.lamansys.cart.hb.application.product.interfaces.EditProductService;
import ar.lamansys.cart.hb.application.product.interfaces.SaveProductService;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private ProductAdapterRest productAdapterRest;
    private SaveProductService saveProductService;
    private EditProductService editProductService;
    private DeleteProductService deleteProductService;

    @PostMapping()
    public ProductDTOResponse addProduct(@RequestBody ProductDTORequest product) throws NotUniqueProductException{
        return productAdapterRest.toProductDTOResponse(saveProductService.run(productAdapterRest.toProductBO(product)));
    }

    @PutMapping("/{id}")
    public ProductDTOResponse editProduct(@PathVariable Integer id, @RequestBody ProductDTORequest product)
            throws ProductDoesNotExistException, NotUniqueProductException{
        return productAdapterRest.toProductDTOResponse(editProductService.run(id,productAdapterRest.toProductBO(product)));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        deleteProductService.run(id);
    }
}
