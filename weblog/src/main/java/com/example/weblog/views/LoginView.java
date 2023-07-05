package com.example.weblog.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Weblog")
@Route(value = "")
public class LoginView extends VerticalLayout {
	private int counter = 0;

	private String infoText() {
		if (counter >= 10) {
			return String.format("okay buddy, %d times is enough", counter);
		}
		return String.format("clicked %d times", counter);
	}

	public LoginView() {
		H1 hello = new H1("hello world");
		H2 info = new H2(infoText());
		TextField name = new TextField("Name");
		Button submit = new Button("Submit", null, clickEvent -> {
			counter += 1;
			info.setText(infoText());
			Notification.show("Hello " + name.getValue());
		});
		HorizontalLayout hl = new HorizontalLayout(name, submit);
		hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
		add(hello, hl, info);
	}

}