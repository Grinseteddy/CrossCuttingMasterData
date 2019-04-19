package com.annegret.servicepattern.masterdata;

public class MasterData {


    private String SmallLetter="a";
    private String Capital="A";

    MasterData(int index){
        SmallLetter=String.valueOf(MasterDataFull.alphabetSmall[index]);
        Capital=String.valueOf(MasterDataFull.alphabetCapital[index]);
    }

    public String getSmallLetter(){
        return this.SmallLetter;
    }

    public String getCapital() {
       return this.Capital;
    }


}
