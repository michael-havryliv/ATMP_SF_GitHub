package providers.executionStatisticsProviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class FirstLaunchESDataProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of("total", 30),
                Arguments.of("passed", 30),
                Arguments.of("failed", 0),
                Arguments.of("skipped", 0)
        );
    }

}
