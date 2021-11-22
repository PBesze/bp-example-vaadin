package org.vaadin.bpexampleapp.lists;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import org.vaadin.bpexampleapp.MainLayout;
import org.vaadin.bpexampleapp.model.Product;
import org.vaadin.bpexampleapp.model.ProductRepository;
 
@Route(value="lists", layout = MainLayout.class)
@RouteAlias(value="", layout = MainLayout.class)
public class ListMainLayout extends VerticalLayout {
	
	public static final String ROUTE = "lists";
	public static final String TITLE = "Lists";
			Div page = new Div();
			final HorizontalLayout layout;
			Div navigation;
			Div content;
			Button homeButton;
			Button deliveryInButton;
			Button deleteButton;
			Grid<Product> grid ;

			ProductRepository repo;
			
			public ListMainLayout(ProductRepository repo) {
				setPadding(false);
				setSpacing(false);
				setSizeFull();
				setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
						
				final Div header = new Div();
				header.getStyle().set("flexShrink", "0");
				header.setText("This is the header. My height is 50 pixels");
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
				
				
				this.repo = repo;
				this.grid = new Grid<>(Product.class);
				grid.setColumns("id","name", "amount");
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
				content.getStyle().set("alignContent", "start");
				content.getStyle().set("flexWrap", "wrap");
				content.getStyle().set("owerflow", "auto");
				
				layout.add(navigation, content);
				layout.expand(content);
				layout.setDefaultVerticalComponentAlignment(Alignment.STRETCH);
				
				
			}

			
			private void createHomeButton()  {
		    homeButton = new Button("List Home");
		    homeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		    homeButton.addClickListener(e ->
		    	{
		    	content.removeAll();
		    	content.add(ListContentHome.ListContent());				

		    	});
			}
			
			private void createDeleteButton()  {
			    deleteButton = new Button("Delete");
			    deleteButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			    deleteButton.addClickListener(e ->
			    	{
			    	content.removeAll();			

			    	});
				}
			
			private void createDeliveryButton()  {
			    deliveryInButton = new Button("Inventory");
			    deliveryInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			    
			    deliveryInButton.addClickListener(e ->
			    	{
			    	content.removeAll();			    	
			    	content.add(grid);
			    	grid.setItems(repo.findAll());

			    	});
				}


		}


