package org.vaadin.bpexampleapp.model;




import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; 


public interface ProductRepository extends JpaRepository<Product, Long> {

		List<Product> findByNameStartsWithIgnoreCase(String name);
	}

