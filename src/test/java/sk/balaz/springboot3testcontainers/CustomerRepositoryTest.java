package sk.balaz.springboot3testcontainers;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(
    properties = {
        "spring.test.database.replace=none",
        "spring.datasource.url=jdbc:tc:postgresql:15.2-alpine:///db"
    }
)
class CustomerRepositoryTest {

  @Autowired
  CustomerRepository customerRepository;

  @BeforeEach
  void setUp() {
    customerRepository.deleteAll();
  }

  @Test
  void shouldGetAllCustomers() {
    List<Customer> customers = List.of(
        new Customer(null, "John", "john@mail.com"),
        new Customer(null, "Dennis", "dennis@mail.com")
    );
    customerRepository.saveAll(customers);

    List<Customer> customerList = customerRepository.findAll();
    assertThat(customerList).hasSize(2);

  }
}