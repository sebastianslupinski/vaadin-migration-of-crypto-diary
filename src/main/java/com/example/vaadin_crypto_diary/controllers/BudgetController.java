package com.example.vaadin_crypto_diary.controllers;

import com.example.vaadin_crypto_diary.dao.BudgetDao;
import com.example.vaadin_crypto_diary.models.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("restbudgets")
@RestController
public class BudgetController {

    private BudgetDao budgetDao;

    @Autowired
    public BudgetController(BudgetDao budgetDao){
        this.budgetDao = budgetDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addBudget(@RequestBody Budget budget){
        budgetDao.save(budget);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Budget> getBudgets(){
        return budgetDao.findAll();
    }


}
