//UserRepository

package com.example.RegistroUsuariosApplication.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ProductRepository extends JpaRepository<Products, Long> {

    Optional<Products> findProductsByName(String name);

}