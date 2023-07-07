package com.weblog.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

  public MainLayout() {
    createHeader();
    createDrawer();
  }

  private void createDrawer() {
    H1 logo = new H1("Weblog");
    logo.addClassNames("text-l", "m-m");

    HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
    header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
    header.expand(logo);
    header.setWidthFull();
    header.addClassNames("py-0", "px-m");

    addToNavbar(header);
  }

  private void createHeader() {
    // new RouterLink("List", )
  }
}
