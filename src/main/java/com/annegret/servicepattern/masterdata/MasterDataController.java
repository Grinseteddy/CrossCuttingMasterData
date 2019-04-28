package com.annegret.servicepattern.masterdata;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class MasterDataController {

    static Logger logger = LoggerFactory.getLogger(MasterDataController.class);

    @GetMapping(value = "/Character/{index}")
    @ResponseBody
    public MasterData masterDataAt(@PathVariable("index") String index) throws Exception {
        try {
            MasterData answer = new MasterData(Integer.valueOf(index));
            logger.info("Master data valid response: " + answer.getSmallLetter() + " " + answer.getCapitalLetter());
            return answer;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Index must be between 0 and 26, index: " + index);
        } catch (NumberFormatException e) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Index must be an integer.");
        }
    }

    @GetMapping(value = "/small")
    @ResponseBody
    public String smallAlphabet() {
        try {
            char[] answer = MasterDataFull.alphabetSmall;
            logger.info("Master data valid response Small Alphabet");
            return new String(answer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Alphabet not found.");
        }
    }

    @GetMapping(value = "/capital")
    @ResponseBody
    public String capitalAlphabet() {
        try {
            char[] answer = MasterDataFull.alphabetCapital;
            logger.info("Master data valid response Capital Alphabet");
            return new String(answer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Alphabet not found.");
        }
    }

    @PutMapping(value = "/capital/{id}/{character}")
    public String newCharacterInAlphabetCapital(@PathVariable int id, @PathVariable char character) {
        try {
            MasterDataFull.alphabetCapital[id] = character;
            return String.valueOf(MasterDataFull.alphabetCapital);
        } catch (Exception e) {
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST), getCharacterErrorTest(MasterDataFull.alphabetCapital));
        }
    }

    @PutMapping(value= "/small/{id}/{character}")
    public String newCharacterInAlphabetSmall(@PathVariable int id, @PathVariable char character) {
        try {
            MasterDataFull.alphabetSmall[id]=character;
            return String.valueOf(MasterDataFull.alphabetSmall);
        } catch (Exception e) {
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST), getCharacterErrorTest(MasterDataFull.alphabetSmall));
        }
    }

    private String getCharacterErrorTest(final char[] masterData) {
        return "Index has to be an index between 0 and" + (masterData.length - 1);
    }
}


