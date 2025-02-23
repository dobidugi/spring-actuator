package com.dobi.springactuator.actuactor.endpotins;


public class MyLib {

    private String name;
    private String version;



    public MyLib(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

}
