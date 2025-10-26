import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AICostCalculatorAllUseTest {
    static final double DELTA = 0.01;

    @Test
    @Tag("InvalidInputTests")
    public void testAU1_NullType() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 0.00, 0);
        });
    }

    @Test
    public void testAU2_TextLargeDataSizeShortProcessingTime() {
        assertEquals(484.00, AICostCalculator.calculateCost(AnalysisType.TEXT, 60.00, 1), DELTA);
    }

    @Test
    public void testAU3_ImageLargeDataSizeMediumProcessingTime() {
        assertEquals(585.00, AICostCalculator.calculateCost(AnalysisType.IMAGE, 60.00, 5), DELTA);
    }

    @Test
    public void testAU4_VideoSmallDataSizeShortProcessingTime() {
        assertEquals(329.00, AICostCalculator.calculateCost(AnalysisType.VIDEO, 9.00, 2), DELTA);
    }

    @Test
    @Tag("InvalidInputTests")
    public void testAU5_TextDataSizeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, 0.00, 8);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testAU6_TextDataSizeTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, 1000001.00, 2);
        });
    }

    @Test
    public void testAU7_TextMediumDataSizeShortProcessingTime() {
        assertEquals(264.00, AICostCalculator.calculateCost(AnalysisType.TEXT, 40.00, 1), DELTA);
    }

    @Test
    @Tag("InvalidInputTests")
    public void testAU8_TextProcessingTimeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, 10.00, 0);
        });
    }

    @Test
    public void testAU9_ImageLargeDataSizeLongProcessingTime() {
        assertEquals(552.50, AICostCalculator.calculateCost(AnalysisType.IMAGE, 60.00, 10), DELTA);
    }

    @Test
    public void testAU10_TextMediumDataSizeLongProcessingTime() {
        assertEquals(187.00, AICostCalculator.calculateCost(AnalysisType.TEXT, 40.00, 10), DELTA);
    }

    @Test
    public void testAU11_ImageLargeDataSizeShortProcessingTime() {
        assertEquals(780.00, AICostCalculator.calculateCost(AnalysisType.IMAGE, 60.00, 2), DELTA);
    }

    @Test
    public void testAU12_VideoSmallDataSizeLongProcessingTime() {
        assertEquals(246.75, AICostCalculator.calculateCost(AnalysisType.VIDEO, 9.00, 10), DELTA);
    }

    @Test
    public void testAU13_TextLargeDataSizeMediumProcessingTime() {
        assertEquals(420.00, AICostCalculator.calculateCost(AnalysisType.TEXT, 60.00, 4), DELTA);
    }
}
