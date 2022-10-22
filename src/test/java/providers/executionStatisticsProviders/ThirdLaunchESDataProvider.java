package providers.executionStatisticsProviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ThirdLaunchESDataProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception{
        return Stream.of(
                Arguments.of("total", 20),
                Arguments.of("passed", 10),
                Arguments.of("failed", 8),
                Arguments.of("skipped", 2)
        );
    }
}
