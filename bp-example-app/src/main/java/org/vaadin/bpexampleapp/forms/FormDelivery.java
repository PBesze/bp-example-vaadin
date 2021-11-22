package org.vaadin.bpexampleapp.forms;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.bpexampleapp.MainLayout;
import org.vaadin.bpexampleapp.model.Product;
import org.vaadin.bpexampleapp.model.ProductRepository;


@Route(value="del", layout = MainLayout.class)
@SpringComponent
@UIScope
public class FormDelivery extends FormMainLayout {
	private static final long serialVersionUID = -7L;
	public static final String TITLE = "Delivery OUT";
	public static final String ROUTE = "out";
	
	private final ProductRepository repository;
	public Product product;
	//final TextField id = new TextField("id");
	final TextField name = new TextField("Name");
	final NumberField amount = new NumberField("Amount");
	final Button save = new Button("Save");
	
	Binder<Product> binder = new Binder<>(Product.class);

	
	
	@Autowired
	public FormDelivery(ProductRepository repository) {
		this.repository = repository;
		content.add(name, amount, save);
		save.addClickListener(e -> save());
		binder.bindInstanceFields(this);
	}

	void save() {
		this.product = new Product(name.getValue(),amount.getValue());
		repository.save(this.product);
		 //UI.getCurrent().getPage().reload();
	}


	}

	
	


