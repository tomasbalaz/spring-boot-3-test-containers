package sk.balaz.springboot3testcontainers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  private final CustomerRepository repo;

  public CustomerController(CustomerRepository repo) {
    this.repo = repo;
  }

  @GetMapping("/api/customers")
  public List<Customer> getAll() {
    return repo.findAll();
  }
}