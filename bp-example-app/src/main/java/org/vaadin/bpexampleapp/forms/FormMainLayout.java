package org.vaadin.bpexampleapp.forms;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import org.vaadin.bpexampleapp.MainLayout;
import org.vaadin.bpexampleapp.forms.*;
 
@Route(value="forms", layout = MainLayout.class)


public class FormMainLayout extends VerticalLayout {
	
	public static final String ROUTE = "forms";
	public static final String TITLE = "Forms";
		Div page = new Div();

			final HorizontalLayout layout;
			Div navigation;
			static Div content;
			Button homeButton;
			Button deliveryInButton;
			Button deleteButton;
			
			public FormMainLayout() {
				setPadding(false);
				setSpacing(false);
				setSizeFull();
				setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
						
				final Div header = new Div();
				header.getStyle().set("flexShrink", "0");
				header.setText("If you can't see the FORM after 'Delivery' button refresh browser /del");
				header.setClassName("header");
				header.setHeight("50px");

				layout = new HorizontalLayout();
				layout.getStyle().set("flex-grow", "1");
				layout.setSpacing(false);
				createTextLayout();

				final Div footer = new Div();
				footer.getStyle().set("flexShrink", "0");
				footer.setText("This is the footer area. My height is 50 pixels");
				footer.setClassName("footer");
				footer.setHeight("50px");
				add(header, layout, footer);
			}
			
			private void createTextLayout() {
				navigation = new Div();
				navigation.setClassName("navigation");
				navigation.setWidth("15%");
				

				navigation.getStyle().set("display", "flex"); 
				navigation.getElement().getStyle().set("flex-shrink", "0");
				navigation.getElement().getStyle().set("flex-direction", "column");
				navigation.getStyle().set("flexWrap", "wrap");
				navigation.getStyle().set("alignContent", "center");
				
				createHomeButton();
				createDeliveryButton();
				createDeleteButton();
				navigation.add(homeButton,deliveryInButton,deleteButton);
				
				content = new Div();
				content.setHeightFull();
				content.getStyle().set("display", "flex"); 
				content.setClassName("content");
				content.setWidth("75%");
				content.getStyle().set("alignContent", "center");
				content.getStyle().set("flexWrap", "wrap");
				content.getElement().getStyle().set("flex-direction", "column");
				content.getStyle().set("owerflow", "auto");
 
								
				layout.add(navigation, content);
				layout.expand(content);
				layout.setDefaultVerticalComponentAlignment(Alignment.STRETCH);
				
				
			}
			
			private void createHomeButton()  {
			    homeButton = new Button("Form Home");
			    homeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			    homeButton.addClickListener(e ->
			    	{
			    	content.removeAll();
			    	//content.add(FormContentHome.FormContent());	
				     
			    	homeButton.getUI().ifPresent(ui ->  ui.navigate("fh"));
			    	});
				}
			
			private void createDeleteButton()  {
			    deleteButton = new Button("Delete");
			    deleteButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			    deleteButton.addClickListener(e ->
			    	{
			    	content.removeAll();	
			    	content.setText("Deleted");

			    	});
				}
			
			private void createDeliveryButton()  {
			    deliveryInButton = new Button("Delivery");
			    deliveryInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			    deliveryInButton.addClickListener(e ->
			    	{	     
			    	deliveryInButton.getUI().ifPresent(ui ->  ui.navigate("del"));
			    	 //UI.getCurrent().getPage().reload();
			    	// TODO avoid full page refresh -currently it does not work well in most cases and manual refreh needed
			    	});
				}
			


			
		}



