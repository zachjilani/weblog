package com.weblog.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.weblog.security.SecurityService;

public class MainLayout extends AppLayout {
  private final SecurityService securityService;

  public MainLayout(SecurityService sercurityService) {
    this.securityService = sercurityService;
    createHeader();
    createDrawer();
  }

  private void createDrawer() {
    H1 logo = new H1("Weblog");
    logo.addClassNames("text-l", "m-m");

    String u = securityService.getAuthenticatedUser().getUsername();
    Button logout = new Button("Log out " + u, e -> securityService.logout());

    HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);
    header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
    header.expand(logo);
    header.setWidthFull();
    header.addClassNames("py-0", "px-m");

    addToNavbar(header);
  }

  private void createHeader() {
    RouterLink placeHolderView = new RouterLink("Placeholder", PlaceholderView.class);
    RouterLink dashboardView = new RouterLink("Dashboard", DashboardView.class);
    // placeHolderView.setHighlightCondition(HighlightConditions.sameLocation());

    addToDrawer(new VerticalLayout(placeHolderView, dashboardView));
  }
}
