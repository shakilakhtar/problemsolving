package com.test;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        // write your code here
        CandidateSelector cs = new CandidateSelector();

        List<List<String>> applications = new ArrayList<>();
        List<String> pl = new ArrayList<>();
        pl.add("Ronaldo");
        pl.add("5.8");
        pl.add("21");
        pl.add("120");
        pl.add("0");
        applications.add(pl);
        List<String> a = new ArrayList<>();
        a.add("Kaka");
        a.add("6");
        a.add("22");
        a.add("1");
        a.add("1");
        applications.add(a);

        List<List<String>> l = cs.getSelectionStatus(applications);

        for (List<String> players : l) {

            System.out.println(players.get(0) + " " + players.get(1) + " " + players.get(2));
        }
    }
}
