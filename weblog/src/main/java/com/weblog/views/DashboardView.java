package com.weblog.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;

@PageTitle("Dashboard")
@Route(value = "dashboard")
@PermitAll
public class DashboardView extends VerticalLayout {

}
