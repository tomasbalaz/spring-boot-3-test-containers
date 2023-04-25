package sk.balaz.springboot3testcontainers;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface CustomerRepository extends JpaRepository<Customer, Long> {

  Optional<Customer> findByEmailAndName(String email, String name);

}