package utils;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CommonRetryAnalyzer implements IRetryAnalyzer, IAnnotationTransformer {
    private int retryCount = 1;
    private static final int MAX_RETRY_COUNT =2;

    @Override
    public boolean retry(ITestResult result) {
        if(retryCount< MAX_RETRY_COUNT){
            retryCount++;
            return true;
        }
        return false;
    }

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(CommonRetryAnalyzer.class);

    }
}
