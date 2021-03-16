package com.casino.controller;

import java.io.IOException;
import java.util.List;

import com.casino.entity.entities.Game;
import com.casino.entity.entities.Profit;
import com.casino.helper.CSVHelper;
import com.casino.service.CasinoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin
@Controller
@RequestMapping("/api/v1")
public class MainController {

    @Autowired
    CasinoService casinoService;

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping(value = "/casino/profit")
    public ResponseEntity<List<Profit>> calculateProfit(@RequestParam("file") MultipartFile file) {
        if (CSVHelper.hasCSVFormat(file)) {
            try {

                //parse CSV to Entity
                List<Game> games = CSVHelper.csvToGames(file.getInputStream());

                //calculate the profit
                List<Profit> profits = casinoService.calculateProfit(games);

                //return the result
                return ResponseEntity.status(HttpStatus.OK).body(profits);
            } catch (Exception e) {
                log.error(HttpStatus.INTERNAL_SERVER_ERROR.toString());
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
