package com.weblog.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.weblog.data.models.Company;
import com.weblog.data.service.CompanyService;

import jakarta.annotation.security.PermitAll;

@PageTitle("Dashboard")
@Route(value = "dashboard", layout = MainLayout.class)
@PermitAll
public class DashboardView extends VerticalLayout {

  Grid<Company> companies = new Grid<>(Company.class);
  TextField filterText = new TextField();

  @Autowired
  CompanyService service;

  public DashboardView(CompanyService service) {
    this.service = service;
    addClassName("dashboard-view");
    setSizeFull();
    configureGrid();
    add(getToolbar(), getContent());
    updateList();
    // H1 test = new H1("test");
    // add(test);
  }

  private Component getContent() {
    HorizontalLayout content = new HorizontalLayout(companies);
    content.setFlexGrow(2, companies);
    // content.setFlexGrow(1, form);
    content.addClassNames("content");
    content.setSizeFull();
    return content;
  }

  private void configureGrid() {
    companies.addClassNames("companies-grid");
    companies.setSizeFull();
    companies.getColumns().forEach(col -> col.setAutoWidth(true));
  }

  private HorizontalLayout getToolbar() {
    filterText.setPlaceholder("Filter by name...");
    filterText.setClearButtonVisible(true);
    filterText.setValueChangeMode(ValueChangeMode.LAZY);
    filterText.addValueChangeListener(e -> updateList());

    Button addContactButton = new Button("Add company");

    var toolbar = new HorizontalLayout(filterText, addContactButton);
    toolbar.addClassName("toolbar");
    return toolbar;
  }

  private void updateList() {
    companies.setItems(service.findAllCompanies(filterText.getValue()));
  }

}
