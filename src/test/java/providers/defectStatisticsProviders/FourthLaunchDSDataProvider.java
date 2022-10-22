package providers.defectStatisticsProviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class FourthLaunchDSDataProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception{
        return Stream.of(
                Arguments.of("pb", 1),
                Arguments.of("ab", 5),
                Arguments.of("si", 4),
                Arguments.of("ti", 8)
        );
    }
}
