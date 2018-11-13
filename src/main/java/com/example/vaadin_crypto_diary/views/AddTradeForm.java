package com.example.vaadin_crypto_diary.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

public class AddTradeForm extends FormLayout{

    private TextField coinName = new TextField("Coin name");
    private TextField buyPrice = new TextField("Amount of BTC paid");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    
}
