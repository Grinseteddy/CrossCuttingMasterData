package com.annegret.servicepattern.masterdata;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@RestController

public class MasterDataController {

    static Logger logger=LoggerFactory.getLogger(MasterDataController.class);

    @GetMapping(value = "/Character/{index}")
    @ResponseBody
    public MasterData masterDataAt(@PathVariable("index") String index) throws Exception {

        try {

            MasterData answer = new MasterData(Integer.valueOf(index));
            logger.info("Master data valid response: "+String.valueOf(answer.getSmallLetter())+ " "+String.valueOf(answer.getCapital()));
            return answer;

        } catch (Exception e) {
            if (e.getClass() == ArrayIndexOutOfBoundsException.class) {
                throw new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "Index must be between 0 and 26, index: " + String.valueOf(index));
            }
            else if(e.getClass() == NumberFormatException.class) {
                throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Index must be an integer.");
            }
        }
        return null;
    }

    @GetMapping(value = "/small")
    @ResponseBody
    public String smallAlphabet() throws Exception {
        try {
            char[] answer = MasterDataFull.alphabetSmall;
            logger.info("Master data valid response Small Alphabet");
            return String.valueOf(answer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Alphabet not found.");
        }
    }

    @GetMapping(value = "/capital")
    @ResponseBody
    public String capitalAlphabet() throws Exception {
        try {
            char[] answer = MasterDataFull.alphabetCapital;
            logger.info("Master data valid response Capital Alphabet");
            return String.valueOf(answer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Alphabet not found.");
        }
    }

    @PutMapping(value = "/capital/{id}/{character}")
    public String newCharacterInAlphabetCapital(@PathVariable int id, @PathVariable char character) throws Exception {
        try {
            MasterDataFull.alphabetCapital[id]=character;
            return String.valueOf(MasterDataFull.alphabetCapital);
        } catch (Exception e) {
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST), "Index has to be an index between 0 and 25");
        }
    }

    @PutMapping(value= "/small/{id}/{character}")
    public String newCharacterInAlphabetSmall(@PathVariable int id, @PathVariable char character) throws Exception {
        try {
            MasterDataFull.alphabetSmall[id]=character;
            return String.valueOf(MasterDataFull.alphabetSmall);
        } catch (Exception e) {
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST), "Index has to be an index between 0 and 25");
        }
    }
}


