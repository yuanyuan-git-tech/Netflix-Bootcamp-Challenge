package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UnitTest {

    Customer customerTest = new Customer();
    @Test
    public void getPositiveBalanceTest() {
        AccountRecord record01 = new AccountRecord();
        record01.setCharge(100);
        customerTest.getCharges().add(record01);
        AccountRecord record02 = new AccountRecord();
        record02.setCharge(400);
        customerTest.getCharges().add(record02);
        AccountRecord record03 = new AccountRecord();
        record03.setCharge(-100);
        customerTest.getCharges().add(record03);
        assertEquals(400, customerTest.getBalance());
    }
    @Test
    public void getNegativeBalanceTest() {
        AccountRecord record = new AccountRecord();
        record.setCharge(-900);
        customerTest.getCharges().add(record);
        assertEquals(-900, customerTest.getBalance());
    }
    @Test
    public void toStringWithBalanceZeroTest() {
        customerTest.setName("Yuanyuan");
        customerTest.setId(1);
        String expected = "1 Yuanyuan 0";
        assertEquals(expected, customerTest.toString());
    }
    @Test
    public void toStringTestWithPositiveBalanceTest() {
        customerTest.setName("Zhao");
        customerTest.setId(2);
        String expected = "2 Zhao 400";
        AccountRecord record01 = new AccountRecord();
        record01.setCharge(100);
        customerTest.getCharges().add(record01);
        AccountRecord record02 = new AccountRecord();
        record02.setCharge(400);
        customerTest.getCharges().add(record02);
        AccountRecord record03 = new AccountRecord();
        record03.setCharge(-100);
        customerTest.getCharges().add(record03);
        assertEquals(expected, customerTest.toString());
    }
    @Test
    public void toStringTestWithNegativeBalanceTest() {
        customerTest.setName("Zhao");
        customerTest.setId(2);
        String expected = "2 Zhao -900";
        AccountRecord record01 = new AccountRecord();
        record01.setCharge(-900);
        customerTest.getCharges().add(record01);
        assertEquals(expected, customerTest.toString());
    }
}
