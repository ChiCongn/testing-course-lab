import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AICostCalculatorControlFlowTest {
    static final double DELTA = 0.01;

    @Test
    @Tag("InvalidInputTests")
    public void testCF_C2_TC1_NullType() {
        // Path 1: 0 -> 1(T) -> 2
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 12.50, 8);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testCF_C2_TC2_NegativeDataSize() {
        // Path 2: 0 -> 1(F) -> 3(T) -> 4
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, -2.00, 8);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testCF_C2_TC3_NonPositiveProcessingTime() {
        // Path 3: 0 -> 1(F) -> 3(F) -> 5(T) -> 6
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, 8.00, 0);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testCF_C2_TC4_ExcessiveDataSize() {
        // Path 4: 0 -> 1(F) -> 3(F) -> 5(F) -> 7(T) -> 8
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, 1_000_001.50, 10);
        });
    }

    @Test
    public void testCF_C2_TC5_TextLargeDataSizeShortProcessingTime() {
        // Path 5: 0 -> 1(F) -> 3(F) -> 5(F) -> 7(F) -> 9(TEXT) -> 10 -> 13 -> 14(T) -> 15 -> 18(T) -> 19 -> 20(F) -> 22(F) -> 24
        assertEquals(724.00, AICostCalculator.calculateCost(AnalysisType.TEXT, 100.00, 1), DELTA);
    }

    @Test
    public void testCF_C2_TC6_TextMediumDataSizeLongProcessingTime() {
        // Path 6: 0 -> 1(F) -> 3(F) -> 5(F) -> 7(F) -> 9(TEXT) -> 10 -> 13 -> 14(F) -> 16(T) -> 17 -> 18(F) -> 20(F) -> 22(F) -> 24
        assertEquals(187.00, AICostCalculator.calculateCost(AnalysisType.TEXT, 40.00, 8), DELTA);
    }

    @Test
    public void testCF_C2_TC7_TextMediumDataSizeMediumProcessingTime() {
        // Path 7: 0 -> 1(F) -> 3(F) -> 5(F) -> 7(F) -> 9(TEXT) -> 10 -> 13 -> 14(F) -> 16(F) -> 18(F) -> 20(F) -> 22(F) -> 24
        assertEquals(220.00, AICostCalculator.calculateCost(AnalysisType.TEXT, 40.00, 4), DELTA);
    }

    @Test
    public void testCF_C2_TC8_ImageLargeDataSizeMediumProcessingTime() {
        // Path 8: 0 -> 1(F) -> 3(F) -> 5(F) -> 7(F) -> 9(IMAGE) -> 11 -> 13 -> 14(F) -> 16(F) -> 18(F) -> 20(F) -> 22(T) -> 23 -> 24
        assertEquals(945.00, AICostCalculator.calculateCost(AnalysisType.IMAGE, 100.00, 5), DELTA);
    }

    @Test
    public void testCF_C2_TC9_VideoSmallDataSizeShortProcessingTime() {
        // Path 9: 0 -> 1(F) -> 3(F) -> 5(F) -> 7(F) -> 9(VIDEO) -> 12 -> 13 -> 14(T) -> 15 -> 18(F) -> 20(T) -> 21 -> 22(F) -> 24
        assertEquals(329.00, AICostCalculator.calculateCost(AnalysisType.VIDEO, 9.00, 1), DELTA);
    }
}
