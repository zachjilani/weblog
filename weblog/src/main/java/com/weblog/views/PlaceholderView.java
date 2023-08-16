package com.weblog.views;

import com.vaadin.flow.component.grid.Grid;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.weblog.data.models.Users;
import com.weblog.data.service.UserService;

import jakarta.annotation.security.PermitAll;

@PageTitle("Map")
@Route(value = "", layout = MainLayout.class)
@PermitAll
public class PlaceholderView extends VerticalLayout {
  Grid<Users> users = new Grid<>(Users.class);
  TextField filterText = new TextField();
  // UsersForm form;
  @Autowired
  UserService service;

  public PlaceholderView(UserService service) {
    this.service = service;
    // changing name later
    addClassName("placeholder-view");
    setSizeFull();
    configureGrid();
    // configureForm();
    add(getToolbar(), getContent());
    updateList();
  }

  private Component getContent() {
    HorizontalLayout content = new HorizontalLayout(users);
    content.setFlexGrow(2, users);
    // content.setFlexGrow(1, form);
    content.addClassNames("content");
    content.setSizeFull();
    return content;
  }

  private void configureGrid() {
    users.addClassNames("users-grid");
    users.setSizeFull();
    users.getColumns().forEach(col -> col.setAutoWidth(true));
  }

  private HorizontalLayout getToolbar() {
    filterText.setPlaceholder("Filter by name...");
    filterText.setClearButtonVisible(true);
    filterText.setValueChangeMode(ValueChangeMode.LAZY);
    filterText.addValueChangeListener(e -> updateList());

    Button addContactButton = new Button("Add user");

    var toolbar = new HorizontalLayout(filterText, addContactButton);
    toolbar.addClassName("toolbar");
    return toolbar;
  }

  private void updateList() {
    users.setItems(service.findAllUsers(filterText.getValue()));
  }

  // private void configureGrid(){
  // form = new UsersForm(service.findAllUsers());
  // }
}
