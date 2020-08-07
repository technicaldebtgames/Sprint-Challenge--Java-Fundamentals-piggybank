package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController
{

    @Autowired
    CoinRepository coinrepos;

    /*@GetMapping(value = "/coins/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCoins()
    {

        List<Coin> myList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(myList::add);

        return new ResponseEntity<>(myList, HttpStatus.OK);

    }*/

    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> listTotal()
    {

        List<Coin> myList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(myList::add);

        double total = 0.0;

        for(int i = 0; i < myList.size(); i++)
        {

            Coin coin = myList.get(i);

            if(coin.getQuantity() == 1)
            {
                System.out.println(coin.getQuantity() + " " + coin.getName());
            }
            else
            {
                System.out.println(coin.getQuantity() + " " + coin.getNameplural());
            }

            total += coin.getQuantity() * coin.getValue();

        }

        System.out.println("The piggy bank holds " + total);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
