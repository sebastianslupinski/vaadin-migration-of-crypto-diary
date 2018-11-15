package com.example.vaadin_crypto_diary.views;

import com.example.vaadin_crypto_diary.controllers.PositionController;
import com.example.vaadin_crypto_diary.models.Position;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Trades")
@Route(value = "trades", layout = MenuBar.class)
public class PositionView extends VerticalLayout{

    PositionController positionController = PositionController.getInstance();
    Grid<Position> tradesGrid = new Grid<>();
    Button addTradeButton = new Button("Add new trade");
    AddTradeForm addTradeForm = new AddTradeForm(this);
    HorizontalLayout mainLayout = new HorizontalLayout();

    public PositionView() {
        tradesGrid.setSizeFull();
        tradesGrid.setWidth("400px");
        mainLayout.add(tradesGrid, addTradeForm);
        mainLayout.setAlignItems(Alignment.START);

        add(addTradeButton, mainLayout);
        mainLayout.setHeight("100vh");

        tradesGrid.addColumn(Position::getName).setSortable(true).setHeader("Coin name");
        tradesGrid.addColumn(Position::getOpenDate).setSortable(true).setHeader("Open Date");
        tradesGrid.addColumn(Position::getBuyPrice).setSortable(true).setHeader("BTC Paid");
        tradesGrid.addColumn(Position::getSellPrice).setSortable(true).setHeader("BTC Received").setKey("received");
        tradesGrid.addColumn(Position::getCloseDate).setSortable(true).setHeader("Close Date");
        tradesGrid.addColumn(Position::getPercent).setSortable(true).setHeader("Percent done");

        tradesGrid.getColumnByKey("received").setWidth("110px");
        updateList();

        addTradeButton.addClickListener(e -> {
            tradesGrid.asSingleSelect().clear();
            addTradeForm.setPosition(new Position());
        });

        tradesGrid.asSingleSelect().addValueChangeListener(event -> {
            addTradeForm.setPosition(event.getValue());
        });
    }

    public void updateList() {
        tradesGrid.setItems(positionController.getPositions());
    }


}
