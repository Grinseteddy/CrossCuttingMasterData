package com.annegret.servicepattern.masterdata;

public class MasterData {

    private String smallLetter;
    private String capitalLetter;

    public MasterData(int index){
        smallLetter = String.valueOf(MasterDataFull.alphabetSmall[index]);
        capitalLetter = String.valueOf(MasterDataFull.alphabetCapital[index]);
    }

    public String getSmallLetter(){
        return this.smallLetter;
    }

    public String getCapitalLetter() {
       return this.capitalLetter;
    }

}
