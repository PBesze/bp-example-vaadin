package org.vaadin.bpexampleapp.forms;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
//import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.bpexampleapp.MainLayout;
import org.vaadin.bpexampleapp.model.Product;
import org.vaadin.bpexampleapp.model.ProductRepository;


@Route(value="out", layout = MainLayout.class)

@SpringComponent
@UIScope
public class FormDeliveryOut extends VerticalLayout implements KeyNotifier, HasComponents{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5357695083954705104L;
	public static final String TITLE = "Delivery OUT";
	public static final String ROUTE = "out";
	
	private ProductRepository repository;

	/**
	 * The currently edited product
	 */
	private Product product;

	/* Fields to edit properties in Product entity */
	TextField nameField = new TextField("Name");
	TextField amountField = new TextField("Amount");

	/* Action buttons */
	// TODO why more code?
	Button save = new Button("Save", VaadinIcon.CHECK.create());
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", VaadinIcon.TRASH.create());
	HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);	


	private Binder<Product> binder = new Binder<>(Product.class);
	private ChangeHandler changeHandler;
	
	@Autowired
	public FormDeliveryOut(ProductRepository repository) {
		this.product = product;
		this.repository = repository;
		add(nameField, amountField, actions);

			
		binder.forField(nameField).bind(Product::getName,Product::setName);
		//binder.bindInstanceFields(this);
		//binder.forField(id).withConverter(new StringToLongConverter("Not a number"));
		//binder.forField(amountField)
		//.withConverter(new StringToDoubleConverter("Not a number"))
	     //   .bind(Product::getAmount,Product::setAmount);
		//binder.forField(id).withConverter( new StringToLongConverter("Not a number"));
		// Configure and style components
		setSpacing(true);
		save.getElement().getThemeList().add("primary");
		delete.getElement().getThemeList().add("error");

		addKeyPressListener(Key.ENTER, e -> save());

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> save());
		delete.addClickListener(e -> delete());
		//cancel.addClickListener(e -> editProduct(product));
		setVisible(true);
	}

	void delete() {
		repository.delete(product);
		changeHandler.onChange();
	}

	void save() {
		binder.forField(nameField).bind(Product::getName,Product::setName);
		//binder.bindInstanceFields(this);
		//binder.forField(id).withConverter(new StringToLongConverter("Not a number"));
		//binder.forField(amountField)
		//.withConverter(new StringToDoubleConverter("Not a number"))
	    //    .bind(Product::getAmount,Product::setAmount);
		repository.save(product);

		changeHandler.onChange();
	}

	public interface ChangeHandler {
		void onChange();
	}

	public final void editProduct(Product p) {
		if (p == null) {
			setVisible(true);
			return;
		}
		final boolean persisted = p.getId() != null;
		if (persisted) {
				product = repository.findById(p.getId()).get();
		}
		else {
			product = p;
		}
		cancel.setVisible(false);

		// Bind customer properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving

		binder.setBean(product);
		binder.forField(nameField).bind(Product::getName,Product::setName);
		//binder.bindInstanceFields(this);
		//binder.forField(id).withConverter(new StringToLongConverter("Not a number"));
		//binder.forField(amountField)
		//.withConverter(new StringToDoubleConverter("Not a number"))
	     //   .bind(Product::getAmount,Product::setAmount);
		setVisible(true);

		// Focus first name initially
		nameField.focus();
	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		changeHandler = h;
	}

}
