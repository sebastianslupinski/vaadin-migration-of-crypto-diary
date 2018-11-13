package com.example.vaadin_crypto_diary.views;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Welcome")
@Route(value = "", layout = MenuBar.class)
public class WelcomeView extends VerticalLayout {
    private Label welcomeLabel = new Label();

    public WelcomeView() {
        welcomeLabel.getElement().setProperty("innerHTML", "<h1>This is a Heading</h1>");
        add(welcomeLabel);
    }
}
