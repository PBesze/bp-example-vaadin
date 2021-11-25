package org.vaadin.bpexampleapp.forms;

import org.vaadin.bpexampleapp.model.ProductRepository;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class FormContentHome  extends VerticalLayout {
	
	final DatePicker dateOfAction = new DatePicker("Date");
	final TextField nameOfAction = new TextField("Name");
	
	
	public FormContentHome(ProductRepository repository) {
		add(dateOfAction,nameOfAction);
		}
}
