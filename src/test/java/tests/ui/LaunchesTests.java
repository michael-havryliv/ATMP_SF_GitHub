package tests.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import providers.LaunchesDataProvider;

import java.util.ArrayList;

@Execution(ExecutionMode.CONCURRENT)
public class LaunchesTests extends BaseTest{

    @BeforeEach
    public void goToLaunchesPage(){
        getLaunchesPage().goToLaunchesPage();
    }

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(LaunchesDataProvider.class)
    public void demoTest(Integer launch, ArrayList<String> fieldNames, ArrayList<Integer> expectedValues){
        Assertions.assertArrayEquals(expectedValues.toArray(), getLaunchesPage().getLaunchValues(fieldNames,launch).toArray());
    }

}
