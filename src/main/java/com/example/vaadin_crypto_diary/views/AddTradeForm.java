package com.example.vaadin_crypto_diary.views;

import com.example.vaadin_crypto_diary.controllers.PositionController;
import com.example.vaadin_crypto_diary.models.Position;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class AddTradeForm extends FormLayout{

    private TextField coinName = new TextField("Coin name");
    private TextField buyPrice = new TextField("Amount of BTC paid");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Binder<Position> binder = new Binder<>(Position.class);

    private PositionController positionController = PositionController.getInstance();
    private Position trade;
    private PositionView positionView;

    HorizontalLayout buttons = new HorizontalLayout();

    public AddTradeForm(PositionView positionView){
        this.positionView = positionView;

        buttons.add(save,delete);
        add(coinName,buyPrice);

        binder.forField(buyPrice)
                .withConverter(Double::valueOf, String::valueOf)
                .bind(Position::getBuyPrice, Position::setBuyPrice);

        binder.bindInstanceFields(this);

        save.getElement().setAttribute("theme","primary" );
        setPosition(null);

        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());
    }

    public void setPosition(Position trade) {
        this.trade = trade;
        binder.setBean(trade);
        boolean enabled = trade != null;
        save.setEnabled(enabled);
        delete.setEnabled(enabled);
        if (enabled) {
            coinName.focus();
        }
    }

    private void delete() {
        positionController.deleteTrade(trade);
        positionView.updateList();
        setPosition(null);
    }

    private void save() {
        positionController.addTrade(trade);
        positionView.updateList();
        setPosition(null);
    }

}
