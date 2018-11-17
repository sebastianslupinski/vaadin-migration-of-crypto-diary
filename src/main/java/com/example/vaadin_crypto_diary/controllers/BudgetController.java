package com.example.vaadin_crypto_diary.controllers;

import com.example.vaadin_crypto_diary.dao.BudgetDao;
import com.example.vaadin_crypto_diary.models.Budget;
import com.example.vaadin_crypto_diary.models.BudgetChange;
import com.example.vaadin_crypto_diary.models.Statistics;
import com.vaadin.flow.shared.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("restbudgets")
@RestController
public class BudgetController {

    private static BudgetDao budgetDao;
    private static BudgetController instance;

    //singleton
    public static synchronized BudgetController getInstance() {
        if(instance == null) {
            instance = new BudgetController(budgetDao);
        }
        return instance;
    }

    @Autowired
    public BudgetController(BudgetDao budgetDao){
        this.budgetDao = budgetDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveBudget(@RequestBody Budget budget){
        budgetDao.save(budget);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Budget> getBudgets(){
        return budgetDao.findAll();
    }

    public void addBudget(BudgetChange change) {

        Statistics latestStatistics = new Statistics(budgetDao.findAll());
        Budget latestBudget = latestStatistics.findNewestBudget();

        Budget newBudget = new Budget(latestBudget.getFrozenBtc(), latestBudget.getFreeBtc());
        newBudget.addBudget(change.getAmountChange());
        budgetDao.save(newBudget);
    }

    public Statistics getLatestStatistics() {
        return new Statistics(budgetDao.findAll());
    }
}
