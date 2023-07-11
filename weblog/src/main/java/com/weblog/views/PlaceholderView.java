package com.weblog.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.weblog.data.models.Users;
import jakarta.annotation.security.PermitAll;

@PageTitle("placeholder")
@Route(value = "", layout = MainLayout.class)
@PermitAll
public class PlaceholderView extends Div {

  public PlaceholderView() {
    Grid<Users> users = new Grid<>(Users.class, false);
    add(users);
  }
}
