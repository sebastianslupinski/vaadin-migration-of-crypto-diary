package com.example.vaadin_crypto_diary.dao;

import com.example.vaadin_crypto_diary.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PositionDao extends CrudRepository<Position, Integer> {

    public List<Position> findAll();

    public Optional<Position> findById(Integer id);

    public List<Position> findByOpen(boolean open);
}
