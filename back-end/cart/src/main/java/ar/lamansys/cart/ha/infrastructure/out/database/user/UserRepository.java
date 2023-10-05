package ar.lamansys.cart.ha.infrastructure.out.database.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
