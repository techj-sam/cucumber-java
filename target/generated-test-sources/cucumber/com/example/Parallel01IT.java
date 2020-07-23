package com.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.Test;
import com.github.mkolisnyk.cucumber.runner.AfterSuite;

import cucumber.api.CucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.junit.Cucumber;
import com.cucumber.listener.Reporter;

import java.io.File;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"E:/sameer/Sameer Joshi/cucumber-java-master/cucumber-java-master/src/test/resources/features/Login.feature:8"},
        plugin = {"json:E:/sameer/Sameer Joshi/cucumber-java-master/cucumber-java-master/target/surefire-reports/1.json"},
        monochrome = false,
            glue = {"step_definitions"})
public class Parallel01IT {

@AfterClass
public static void testParallel(){
        Collection<File> jsonFiles=FileUtils.listFiles
        (new File("target/surefire-reports"),new String[]{"json"},true);
        List<String> jsonPaths=new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file->jsonPaths.add(file.getAbsolutePath()));
        Configuration config=new Configuration(new File("target"),"demo");
        config.setParallelTesting(true);
        ReportBuilder reportBuilder=new ReportBuilder(jsonPaths,config);
        reportBuilder.generateReports();
    }
}