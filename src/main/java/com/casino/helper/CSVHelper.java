package com.casino.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.casino.entity.entities.Game;
import com.casino.entity.entities.GameNamesEnum;
import com.casino.entity.entities.GameTypesEnum;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Game> csvToGames(InputStream is) {
        try (
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())
        ) {

            List<Game> games = new ArrayList<Game>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            csvRecords.forEach(csvRecord -> {
                games.add(new Game(
                    csvRecord.get("id"),
                    csvRecord.get("player_id"),
                    GameTypesEnum.from(csvRecord.get("type")),
                    BigDecimal.valueOf(Double.parseDouble(csvRecord.get("amount"))),
                    GameNamesEnum.from(csvRecord.get("game_name"))
                ));
            });

            return games;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }


}
