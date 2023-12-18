package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class Reporter {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static String testCaseName, testDescription, testAuthor, testCategory,excelFileName,screenshot; // null

    @BeforeSuite
    public void startReport() {
        File folder = new File("./" + "reports");
        if (!folder.exists()) {
            folder.mkdir();
        }
        //Create the Physical html file
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
        //Create object for exptent reports
        extent = new ExtentReports();
        //Integrate the physical file and data
        extent.attachReporter(reporter);
    }

    @BeforeClass
    public void testcaseDetails() {
        test = extent.createTest(testCaseName, testDescription);
        test.assignAuthor(testAuthor);
        test.assignAuthor(testCategory);
    }

    public void reportStep(String stepDesc, String status,String screenshotName) throws IOException {
        if (status.equalsIgnoreCase("pass")) {
            test.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././screenshot/"+screenshotName).build());
        } else if (status.equalsIgnoreCase("fail")) {
            test.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././screenshot/"+screenshotName).build());
        }
    }

    public void reportStep(String stepDesc, String status) {
        if (status.equalsIgnoreCase("pass")) {
            test.pass(stepDesc);
        } else if (status.equalsIgnoreCase("fail")) {
            test.fail(stepDesc);
        }
    }

    @AfterSuite
    public void endReport() {
        extent.flush();

    }


}
