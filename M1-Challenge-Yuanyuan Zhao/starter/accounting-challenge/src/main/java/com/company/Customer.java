package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        //update this
        return charges.stream().map(x -> x.getCharge()).reduce(0, Integer::sum);
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }



    @Override
    public String toString() {
        //update this
        return id + " " +  name + " "  + getBalance();
    }
}
