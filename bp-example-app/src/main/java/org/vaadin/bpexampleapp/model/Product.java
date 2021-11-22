package org.vaadin.bpexampleapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Configurable;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	
		//public static Product product;
		
		private String name;
		private Double amount;


		protected Product() {
		}
		
		public Product(String name, Double amount) {
			this.name = name;
			this.amount = amount;
		}
		
		public Long getId() {
			return id;
		}
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}
		
		@Override
		public String toString() {return String.format
		("Product[id=%d, name='%s', amount='%s']", id,name, amount);		}

	}


