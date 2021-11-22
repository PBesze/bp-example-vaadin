package org.vaadin.bpexampleapp.lists;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLayout;

import org.vaadin.bpexampleapp.MainLayout;

import org.vaadin.bpexampleapp.lists.ListMainLayout;
import org.vaadin.bpexampleapp.model.Product;
import org.vaadin.bpexampleapp.model.ProductRepository;

@Route(value="inv", layout = MainLayout.class)
	
	
	public class ListInventory extends VerticalLayout {
		public static final String TITLE = "Inventory";
		public static final String ROUTE = "inv";
		final Grid<Product> grid ;
		private final ProductRepository repo;
		public ListInventory(ProductRepository repo) {
			this.repo = repo;
			this.grid = new Grid<>(Product.class);
			grid.setColumns("id","name", "amount");
			add(grid);
			listProducts();
		}

		private void listProducts() {
			grid.setItems(repo.findAll());
		}

		}
		
		
	

