package providers.defectStatisticsProviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class SecondLaunchDSDataProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception{
        return Stream.of(
                Arguments.of("pb", 4),
                Arguments.of("ab", 1),
                Arguments.of("si", 0),
                Arguments.of("ti", 2)
        );
    }
}
