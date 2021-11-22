package org.vaadin.bpexampleapp;

import org.vaadin.bpexampleapp.forms.FormMainLayout;
import org.vaadin.bpexampleapp.lists.ListMainLayout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

@CssImport("styles/shared-styles.css")
public class MainLayout extends AppLayout {

	private static final long serialVersionUID = 1L;

	public MainLayout() {

        Image img = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
        img.setHeight("144px");
        addToNavbar(new DrawerToggle(), img);
        addToNavbar(new H2("    ") );
		addToNavbar(new H2("Example") );
		
        final VerticalLayout menuBar = new VerticalLayout();
		menuBar.add(new RouterLink(FormMainLayout.TITLE, FormMainLayout.class));
		menuBar.add(new RouterLink(ListMainLayout.TITLE, ListMainLayout.class)); 
		//TODO further menu items: Home, About
		addToDrawer(menuBar);
	}
}
