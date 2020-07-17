package com.test;

import java.util.ArrayList;
import java.util.List;

public class CandidateSelector {

    public List<List<String>> getSelectionStatus(List<List<String>> applications) {
        // Here String values are supplied for selections
        FitnessFactor ff = new FitnessFactor();
        DefenderExperienceFactor df = new DefenderExperienceFactor();
        StrikerExperienceFactor sf = new StrikerExperienceFactor();
        List<List<String>> selectedList = new ArrayList<>();

        for (List<String> playersDetails : applications) {
            List<String> playerAtt = new ArrayList<>();
            //attributes sequence Name, Height, BMI, Scores, Defends
            //Add player name
            Float height = new Float(Float.parseFloat(playersDetails.get(1)));
            Float minHeight = ff.getMinHeight(); //new Float(ff.getMinHeight());
            Float bmi = new Float(Float.parseFloat(playersDetails.get(2)));
            Float maxBmi = ff.getMaxBmi(); //new Float(ff.getMaxBmi());
            playerAtt.add(playersDetails.get(0));
            boolean selected = false;
            if (Float.compare(minHeight, height) <= -1
                    || Float.compare(minHeight, height) == 0
                    & Float.compare(maxBmi, bmi) >= 1
                    || Float.compare(maxBmi, bmi) == 0) {
                //Consider for selection
                if (Integer.parseInt(playersDetails.get(3)) >= sf.getMinGoalsScored()) {
                    playerAtt.add("SELECT");
                    playerAtt.add("STRIKER");
                    selected = true;
                } else if (Integer.parseInt(playersDetails.get(4)) >= df.getMinGoalsDefended()) {
                    playerAtt.add("SELECT");
                    playerAtt.add("DEFENDER");
                    selected = true;
                }
            }
            if (!selected) {
                //Consider for rejection
                playerAtt.add("REJECT");
                playerAtt.add("NA");
            }

            selectedList.add(playerAtt);
        }
        return selectedList;
    }

}
