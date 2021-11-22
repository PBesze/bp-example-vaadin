package org.vaadin.bpexampleapp.lists;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLayout;
import org.vaadin.bpexampleapp.MainLayout;
import org.vaadin.bpexampleapp.lists.*;
import org.vaadin.bpexampleapp.model.Product;
import org.vaadin.bpexampleapp.model.ProductRepository;


 public class ListContentHome extends VerticalLayout {

		public static VerticalLayout  ListContent(){
			VerticalLayout ListContent = new VerticalLayout();
			ListContent.add(new Text("Home"));
			return ListContent;	
		}

	
}

