package org.vaadin.bpexampleapp.forms;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

import org.vaadin.bpexampleapp.MainLayout;
import org.vaadin.bpexampleapp.lists.*;
import org.vaadin.bpexampleapp.model.ProductRepository;

@Route(value="fh", layout = MainLayout.class)

public class FormContentHome  extends FormMainLayout {
	
	private final ProductRepository repository;
	final DatePicker dateOfAction = new DatePicker("Date");
	final TextField nameOfAction = new TextField("Name");
	
	//public class FormContent  {
		//VerticalLayout FormContent = new VerticalLayout();
		//Select<String> actionType = new Select<String>("Action");
		//actionType.setItems("Control", "Visit");
		//FormContent.add(new Text("Home"));
		//return FormContent;
		
	
	
	public FormContentHome(ProductRepository repository) {
		this.repository = repository;
		content.add(dateOfAction,nameOfAction);
		}
	//}
}
