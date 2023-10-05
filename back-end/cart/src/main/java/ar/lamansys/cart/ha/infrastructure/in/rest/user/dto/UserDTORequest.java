package ar.lamansys.cart.ha.infrastructure.in.rest.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTORequest {
    private Long user_id;
    private String username;
}
