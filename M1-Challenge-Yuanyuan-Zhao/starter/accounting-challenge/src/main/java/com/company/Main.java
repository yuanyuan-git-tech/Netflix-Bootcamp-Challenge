package com.company;

import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Update this
        List<Customer> customersList = new ArrayList<>();
        Map<Integer, List<AccountRecord>> idToRecordMap = new HashMap<>();
        Map<Integer, String> idToNameMap = new HashMap<>();
        for (String[] record : customerData) {
            int id = Integer.parseInt(record[0]);
            idToNameMap.put(id, record[1]);

            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(Integer.parseInt(record[2]));
            accountRecord.setChargeDate(record[3]);
            idToRecordMap.computeIfAbsent(id, k -> new ArrayList<>());
            idToRecordMap.get(id).add(accountRecord);
            idToRecordMap.put(id, idToRecordMap.get(id));
        }
        for (int key : idToNameMap.keySet()) {
            Customer customer = new Customer();
            String name = idToNameMap.get(key);
            customer.setId(key);
            customer.setName(name);
            // customer.setCharges(idToRecordMap.get(key));
            List<AccountRecord> list = customer.getCharges();
            for (AccountRecord record : idToRecordMap.get(key)) {
                list.add(record);
            }
            customersList.add(customer);
        }

        System.out.println("Positive accounts:");
        customersList.stream().filter(x -> x.getBalance() > 0).forEach(System.out::println);
        System.out.println("Negative accounts:");
        customersList.stream().filter(x -> x.getBalance() < 0).forEach(System.out::println);
    }
}
