package com.example.vaadin_crypto_diary.views;

import com.example.vaadin_crypto_diary.controllers.BudgetController;
import com.example.vaadin_crypto_diary.models.Budget;
import com.example.vaadin_crypto_diary.models.BudgetChange;
import com.example.vaadin_crypto_diary.models.Position;
import com.example.vaadin_crypto_diary.models.Statistics;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;

public class BudgetForm extends FormLayout {

    private TextField amountChange = new TextField("Amount of BTC");
    private Button add = new Button("Add BTC");
    private Button withdraw = new Button("Withdraw btc");
    private Binder<BudgetChange> binder = new Binder<>(BudgetChange.class);


    private BudgetController budgetController = BudgetController.getInstance();

    private BudgetChange budgetChange;
    StatisticsView statisticsView;

    HorizontalLayout buttons = new HorizontalLayout();

    public BudgetForm(StatisticsView statisticsView){
        this.statisticsView = statisticsView;

        buttons.add(add, withdraw);
        add(amountChange, buttons);

        binder.forField(amountChange).withConverter(new StringToDoubleConverter("Must enter a number"))
                .bind(BudgetChange::getAmountChange, BudgetChange::setAmountChange);

        add.getElement().setAttribute("theme","primary" );
        withdraw.getElement().setAttribute("theme","primary" );

//        add.addClickListener(e -> this.addBudget());
    }

    public void setBtcChange(BudgetChange change){
        this.budgetChange = change;
        binder.setBean(change);
        boolean enabled = change != null;
        add.setEnabled(enabled);
    }

    private void addBudget() {
        amountChange.addValueChangeListener(e -> budgetController.addBudget(this.budgetChange));
        statisticsView.updateValues();
        setBtcChange(null);
    }

//    private void withdrawBudget() {
//        budgetController.withdrawBudget(amountOfBtc.addValueChangeListener(e -> e.getValue()));
//    }
}
