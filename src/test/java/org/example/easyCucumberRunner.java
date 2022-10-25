package org.example;

import org.example.steps.easyCucumberStepDef;
import scs.comp5903.cucumber.EasyCucumber;
import scs.comp5903.cucumber.execution.JFeature;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class easyCucumberRunner {

    public static void main(String[] args){
/*
        //Single player Easy Cucumber
        Path myFeatureFile= Paths.get("src/test/java/org/example/features/easyCucumberOnePlayer.feature");
        JFeature jFeature= EasyCucumber.build(myFeatureFile, easyCucumberStepDef.class);

        System.out.println("Loaded Feature file");


        try {
            jFeature.executeAll();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

 */

        //Multiplayer Easy Cucumber
        Path myFeatureFileMulti= Paths.get("src/test/java/org/example/features/easyCucumberMultiPlayer.feature");
        JFeature jFeatureMulti= EasyCucumber.build(myFeatureFileMulti, easyCucumberStepDef.class);

        try {
            jFeatureMulti.executeAll();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
