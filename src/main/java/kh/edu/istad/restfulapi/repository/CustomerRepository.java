package kh.edu.istad.restfulapi.repository;

import kh.edu.istad.restfulapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}