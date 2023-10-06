package ar.lamansys.cart.ha.infrastructure.in.rest.product;

import ar.lamansys.cart.ha.infrastructure.in.rest.product.dto.ProductDTORequest;
import ar.lamansys.cart.ha.infrastructure.in.rest.product.dto.ProductDTOResponse;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductAdapterRest {
       ProductDTOResponse toProductDTOResponse(ProductBO product);
       ProductBO toProductBO(ProductDTORequest product);
}
