package com.weblog.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;

@PageTitle("placeholder")
@Route(value = "", layout = MainLayout.class)
@PermitAll
public class PlaceholderView extends VerticalLayout {

  public PlaceholderView() {
    Button button = new Button("Click Me");
    HorizontalLayout layout = new HorizontalLayout(button, new DatePicker("Date"));
    layout.setDefaultVerticalComponentAlignment(Alignment.END);
    add(layout);
  }
}
