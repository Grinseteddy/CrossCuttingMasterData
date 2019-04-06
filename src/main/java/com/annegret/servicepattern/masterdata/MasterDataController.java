package com.annegret.servicepattern.masterdata;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;




@RestController

public class MasterDataController {


    @GetMapping(value = "/Character/{index}")
    @ResponseBody
    public MasterData masterDataAt(@PathVariable("index") int index) throws JSONException {

        MasterData answer=new MasterData(index);

        return answer;

    }
}


