package com.example.vaadin_crypto_diary.views;

import com.example.vaadin_crypto_diary.controllers.BudgetController;
import com.example.vaadin_crypto_diary.dao.BudgetDao;
import com.example.vaadin_crypto_diary.models.Budget;
import com.example.vaadin_crypto_diary.models.BudgetChange;
import com.example.vaadin_crypto_diary.models.Position;
import com.example.vaadin_crypto_diary.models.Statistics;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Statistics")
@Route(value = "statistics", layout = MenuBar.class)
public class StatisticsView extends VerticalLayout {

    @Autowired
    private BudgetDao budgetDao;

    BudgetController budgetController = BudgetController.getInstance();
    Statistics latestStatistics = budgetController.getLatestStatistics();
    Budget latestBudget = latestStatistics.findNewestBudget();

    Label generalBudget = new Label("Your general BTC budget : "+latestBudget.getGeneralBudget());
    Label freeBtc = new Label("Your free budget : "+latestBudget.getFreeBtc());
    Label frozenBtc = new Label("Your frozen budget : "+latestBudget.getFrozenBtc());
    Label averagePercent = new Label("Average percent per day : "+latestStatistics.getAveragePercent());
    Label prediction30 = new Label("Prediction of your budget in 1 month : "+latestStatistics.getDaysPrediction(30));
    Label prediction90 = new Label("3 months : "+latestStatistics.getDaysPrediction(90));
    Label prediction180 = new Label("6 months : "+latestStatistics.getDaysPrediction(180));
    Label prediction360 = new Label("One year : "+latestStatistics.getDaysPrediction(360));

    Button addButton = new Button("Add budget");
    Button withdrawButton = new Button("Withdraw budget");

    BudgetForm budgetForm = new BudgetForm(this);

    VerticalLayout mainLayout = new VerticalLayout();

    public StatisticsView(){

        budgetForm.setBtcChange(new BudgetChange());
        mainLayout.add(budgetForm, generalBudget,freeBtc,frozenBtc,averagePercent,prediction30,prediction90, prediction180, prediction360);
        mainLayout.setAlignItems(Alignment.START);

        add(mainLayout);

        updateValues();

//        addButton.addClickListener(e -> {
//            budgetForm.setBtcChange(new BudgetChange());
//        });
    }

    public void updateValues(){
        generalBudget = new Label("Your general BTC budget : "+latestBudget.getGeneralBudget());
        freeBtc = new Label("Your free budget : "+latestBudget.getFreeBtc());
        frozenBtc = new Label("Your frozen budget : "+latestBudget.getFrozenBtc());
        averagePercent = new Label("Average percent per day : "+latestStatistics.getAveragePercent());
        prediction30 = new Label("Prediction of your budget in 1 month : "+latestStatistics.getDaysPrediction(30));
        prediction90 = new Label("3 months : "+latestStatistics.getDaysPrediction(90));
        prediction180 = new Label("6 months : "+latestStatistics.getDaysPrediction(180));
        prediction360 = new Label("One year : "+latestStatistics.getDaysPrediction(360));

    }


}
