package ar.lamansys.cart.ha.infrastructure.in.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorDTO {
    private String type;
    private String message;


}

