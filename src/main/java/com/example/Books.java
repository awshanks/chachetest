package com.example;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by awshanks on 12/08/16.
 */
public class Books {

    private String title;

    private int cost;

    public Books(){
        this.cost = 10;
        this.title = "example title";
    }

}
