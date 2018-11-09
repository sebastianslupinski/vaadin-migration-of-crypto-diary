package com.example.vaadin_crypto_diary.dao;

import com.example.vaadin_crypto_diary.models.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BudgetDao extends CrudRepository<Budget, Integer> {

    public List<Budget> findAll();
    public Optional<Budget> findById(Integer id);

}
