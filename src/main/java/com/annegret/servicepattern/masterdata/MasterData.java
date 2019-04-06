package com.annegret.servicepattern.masterdata;

public class MasterData {
    final static char[] alphabetSmall={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    final static char[] alphabetCapital={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','x','Y','Z'};

    String SmallLetter="a";
    String Capital="A";

    MasterData(int index){
        SmallLetter=String.valueOf(alphabetSmall[index]);
        Capital=String.valueOf(alphabetCapital[index]);
    }

    public String getSmallLetter(){
        return this.SmallLetter;
    }

    public String getCapital() {
       return this.Capital;
    }
}
