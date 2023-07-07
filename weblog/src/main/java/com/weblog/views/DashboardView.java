package com.weblog.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.H1;

import jakarta.annotation.security.PermitAll;

@PageTitle("Dashboard")
@Route(value = "dashboard", layout = MainLayout.class)
@PermitAll
public class DashboardView extends VerticalLayout {
    public DashboardView() {
        H1 test = new H1("test");
        add(test);
    }

}
