package com.example.vaadin_crypto_diary.controllers;

import com.example.vaadin_crypto_diary.dao.PositionDao;
import com.example.vaadin_crypto_diary.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("restpositions")
public class PositionController {

    private static PositionController instance;
    private static PositionDao positionDao;

    //singleton
    public static synchronized PositionController getInstance() {
        if(instance == null) {
            instance = new PositionController(positionDao);
        }
        return instance;
    }

    @Autowired
    public PositionController(PositionDao positionDao){
        this.positionDao = positionDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTrade(@RequestBody Position position){
        positionDao.save(position);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteTrade(@RequestBody Position position){
        positionDao.delete(position);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Position> getPositions(@RequestBody Position position){
        return positionDao.findAll();
    }




}
