package threes;

import org.junit.experimental.theories.ParametersSuppliedBy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(ThreesBoardGeneratorSupplier.class)
public @interface ThreesBoardGenerator {
	int n(); // Amount of boards to be generated
}
