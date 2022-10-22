package tests.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import providers.defectStatisticsProviders.FirstLaunchDSDataProvider;
import providers.defectStatisticsProviders.FourthLaunchDSDataProvider;
import providers.defectStatisticsProviders.SecondLaunchDSDataProvider;
import providers.defectStatisticsProviders.ThirdLaunchDSDataProvider;
import providers.executionStatisticsProviders.FirstLaunchESDataProvider;
import providers.executionStatisticsProviders.FourthLaunchESDataProvider;
import providers.executionStatisticsProviders.SecondLaunchESDataProvider;
import providers.executionStatisticsProviders.ThirdLaunchESDataProvider;

@Execution(ExecutionMode.CONCURRENT)
public class LaunchesTests extends BaseTest{

    private static final int FIRST_LAUNCH = 1;
    private static final int SECOND_LAUNCH = 2;
    private static final int THIRD_LAUNCH = 3;
    private static final int FOURTH_LAUNCH = 4;

    @BeforeEach
    public void goToLaunchesPage(){
        getLaunchesPage().goToLaunchesPage();
    }

    @ParameterizedTest
    @ArgumentsSource(FirstLaunchESDataProvider.class)
    public void checkFirstLaunchContainsExpectedESData(String fieldName, int value){
        Assertions.assertEquals(value, getLaunchesPage().getLaunchESValue(fieldName, FIRST_LAUNCH));
    }

    @ParameterizedTest
    @ArgumentsSource(SecondLaunchESDataProvider.class)
    public void checkSecondLaunchContainsExpectedESData(String fieldName, int value){
        Assertions.assertEquals(value, getLaunchesPage().getLaunchESValue(fieldName, SECOND_LAUNCH));
    }

    @ParameterizedTest
    @ArgumentsSource(ThirdLaunchESDataProvider.class)
    public void checkThirdLaunchContainsExpectedESData(String fieldName, int value){
        Assertions.assertEquals(value, getLaunchesPage().getLaunchESValue(fieldName, THIRD_LAUNCH));
    }

    @ParameterizedTest
    @ArgumentsSource(FourthLaunchESDataProvider.class)
    public void checkFourthLaunchContainsExpectedESData(String fieldName, int value){
        Assertions.assertEquals(value, getLaunchesPage().getLaunchESValue(fieldName, FOURTH_LAUNCH));
    }

    @ParameterizedTest
    @ArgumentsSource(FirstLaunchDSDataProvider.class)
    public void checkFirstLaunchContainsExpectedDSData(String fieldName, int value){
        Assertions.assertEquals(value, getLaunchesPage().getLaunchDSValue(fieldName, FIRST_LAUNCH));
    }

    @ParameterizedTest
    @ArgumentsSource(SecondLaunchDSDataProvider.class)
    public void checkSecondLaunchContainsExpectedDSData(String fieldName, int value){
        Assertions.assertEquals(value, getLaunchesPage().getLaunchDSValue(fieldName, SECOND_LAUNCH));
    }

    @ParameterizedTest
    @ArgumentsSource(ThirdLaunchDSDataProvider.class)
    public void checkThirdLaunchContainsExpectedDSData(String fieldName, int value){
        Assertions.assertEquals(value, getLaunchesPage().getLaunchDSValue(fieldName, THIRD_LAUNCH));
    }

    @ParameterizedTest
    @ArgumentsSource(FourthLaunchDSDataProvider.class)
    public void checkFourthLaunchContainsExpectedDSData(String fieldName, int value){
        Assertions.assertEquals(value, getLaunchesPage().getLaunchDSValue(fieldName, FOURTH_LAUNCH));
    }

}
