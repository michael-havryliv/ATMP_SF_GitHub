package providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.ArrayList;
import java.util.stream.Stream;

public class LaunchesDataProvider implements ArgumentsProvider {

    private ArrayList<String> getFieldNames() {
        ArrayList<String> fieldNames = new ArrayList<>();
        fieldNames.add("total");
        fieldNames.add("passed");
        fieldNames.add("failed");
        fieldNames.add("skipped");
        fieldNames.add("pb");
        fieldNames.add("ab");
        fieldNames.add("si");
        fieldNames.add("ti");
        return fieldNames;
    }

    private ArrayList<Integer> getFirstLaunchExpectedData(){
        ArrayList<Integer> firstLaunchExpectedData = new ArrayList<>();
        firstLaunchExpectedData.add(30);
        firstLaunchExpectedData.add(30);
        firstLaunchExpectedData.add(0);
        firstLaunchExpectedData.add(0);
        firstLaunchExpectedData.add(0);
        firstLaunchExpectedData.add(0);
        firstLaunchExpectedData.add(0);
        firstLaunchExpectedData.add(0);
        return firstLaunchExpectedData;
    }

    private ArrayList<Integer> getSecondLaunchExpectedData(){
        ArrayList<Integer> firstLaunchExpectedData = new ArrayList<>();
        firstLaunchExpectedData.add(25);
        firstLaunchExpectedData.add(20);
        firstLaunchExpectedData.add(5);
        firstLaunchExpectedData.add(0);
        firstLaunchExpectedData.add(4);
        firstLaunchExpectedData.add(1);
        firstLaunchExpectedData.add(0);
        firstLaunchExpectedData.add(2);
        return firstLaunchExpectedData;
    }

    private ArrayList<Integer> getThirdLaunchExpectedData(){
        ArrayList<Integer> firstLaunchExpectedData = new ArrayList<>();
        firstLaunchExpectedData.add(20);
        firstLaunchExpectedData.add(10);
        firstLaunchExpectedData.add(8);
        firstLaunchExpectedData.add(2);
        firstLaunchExpectedData.add(4);
        firstLaunchExpectedData.add(4);
        firstLaunchExpectedData.add(0);
        firstLaunchExpectedData.add(10);
        return firstLaunchExpectedData;
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context){
        return Stream.of(
                Arguments.of(1,getFieldNames(), getFirstLaunchExpectedData()),
                Arguments.of(2,getFieldNames(), getSecondLaunchExpectedData()),
                Arguments.of(3,getFieldNames(), getThirdLaunchExpectedData())
        );
    }
}
