package com.example.vaadin_crypto_diary.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

public class MenuBar extends VerticalLayout implements RouterLayout {
    private HorizontalLayout menuBar = new HorizontalLayout();

    private RouterLink welcomePage = new RouterLink("Welcome", WelcomeView.class);
    private RouterLink addTradePage = new RouterLink("Trades", PositionView.class);
    private RouterLink statistics = new RouterLink("Statistics", StatisticsView.class);


    public MenuBar() {
        menuBar.add(welcomePage, addTradePage, statistics);

        add(menuBar);
    }
}
