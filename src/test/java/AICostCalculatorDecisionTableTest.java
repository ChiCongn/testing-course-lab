import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("AICostCalculatorDecisionTableTests")
class AICostCalculatorDecisionTableTest {

    // TEXT test cases
    @Test
    @Tag("TextTests")
    @Tag("InvalidInputTests")
    public void testTextInvalidDataSizeNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, -2.0, 2);
        });
    }

    @Test
    @Tag("TextTests")
    @Tag("InvalidInputTests")
    public void testTextInvalidDataSizeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, 0.0, 4);
        });
    }

    @Test
    @Tag("TextTests")
    @Tag("InvalidInputTests")
    public void testTextInvalidProcessingTimeNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, 4.0, -2);
        });
    }

    @Test
    @Tag("TextTests")
    @Tag("InvalidInputTests")
    public void testTextInvalidProcessingTimeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, 6.0, 0);
        });
    }

    @Test
    @Tag("TextTests")
    public void testTextSmallDataFastProcessing() {
        assertEquals(72.0, AICostCalculator.calculateCost(AnalysisType.TEXT, 8.0, 1), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextSmallDataNormalProcessing3() {
        assertEquals(60.0, AICostCalculator.calculateCost(AnalysisType.TEXT, 8.0, 3), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextSmallDataNormalProcessing5() {
        assertEquals(60.0, AICostCalculator.calculateCost(AnalysisType.TEXT, 8.0, 5), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextSmallDataSlowProcessing() {
        assertEquals(51.0, AICostCalculator.calculateCost(AnalysisType.TEXT, 8.0, 9), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextLargeDataBonusFastProcessing() {
        assertEquals(484.0, AICostCalculator.calculateCost(AnalysisType.TEXT, 60.0, 2), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextLargeDataBonusNormalProcessing3() {
        assertEquals(420.0, AICostCalculator.calculateCost(AnalysisType.TEXT, 60.0, 3), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextLargeDataBonusNormalProcessing6() {
        assertEquals(420.0, AICostCalculator.calculateCost(AnalysisType.TEXT, 60.0, 6), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextLargeDataBonusSlowProcessing() {
        assertEquals(372.0, AICostCalculator.calculateCost(AnalysisType.TEXT, 60.0, 8), 0.01);
    }

    // IMAGE test cases
    @Test
    @Tag("ImageTests")
    @Tag("InvalidInputTests")
    public void testImageInvalidDataSizeNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.IMAGE, -2.0, 2);
        });
    }

    @Test
    @Tag("ImageTests")
    @Tag("InvalidInputTests")
    public void testImageInvalidDataSizeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.IMAGE, 0.0, 4);
        });
    }

    @Test
    @Tag("ImageTests")
    @Tag("InvalidInputTests")
    public void testImageInvalidProcessingTimeNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.IMAGE, 4.0, -2);
        });
    }

    @Test
    @Tag("ImageTests")
    @Tag("InvalidInputTests")
    public void testImageInvalidProcessingTimeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.IMAGE, 6.0, 0);
        });
    }

    @Test
    @Tag("ImageTests")
    public void testImageSmallDataFastProcessing() {
        assertEquals(156.0, AICostCalculator.calculateCost(AnalysisType.IMAGE, 8.0, 1), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageSmallDataNormalProcessing3() {
        assertEquals(130.0, AICostCalculator.calculateCost(AnalysisType.IMAGE, 8.0, 3), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageSmallDataNormalProcessing5() {
        assertEquals(117.0, AICostCalculator.calculateCost(AnalysisType.IMAGE, 8.0, 5), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageSmallDataSlowProcessing() {
        assertEquals(110.5, AICostCalculator.calculateCost(AnalysisType.IMAGE, 8.0, 9), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageLargeDataBonusFastProcessing() {
        assertEquals(780.0, AICostCalculator.calculateCost(AnalysisType.IMAGE, 60.0, 2), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageLargeDataBonusNormalProcessing3() {
        assertEquals(650.0, AICostCalculator.calculateCost(AnalysisType.IMAGE, 60.0, 3), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageLargeDataBonusNormalProcessing6() {
        assertEquals(585.0, AICostCalculator.calculateCost(AnalysisType.IMAGE, 60.0, 6), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageLargeDataBonusSlowProcessing() {
        assertEquals(552.5, AICostCalculator.calculateCost(AnalysisType.IMAGE, 60.0, 8), 0.01);
    }

    // VIDEO test cases
    @Test
    @Tag("VideoTests")
    @Tag("InvalidInputTests")
    public void testVideoInvalidDataSizeNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.VIDEO, -2.0, 2);
        });
    }

    @Test
    @Tag("VideoTests")
    @Tag("InvalidInputTests")
    public void testVideoInvalidDataSizeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.VIDEO, 0.0, 4);
        });
    }

    @Test
    @Tag("VideoTests")
    @Tag("InvalidInputTests")
    public void testVideoInvalidProcessingTimeNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.VIDEO, 4.0, -2);
        });
    }

    @Test
    @Tag("VideoTests")
    @Tag("InvalidInputTests")
    public void testVideoInvalidProcessingTimeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.VIDEO, 6.0, 0);
        });
    }

    @Test
    @Tag("VideoTests")
    public void testVideoSmallDataFastProcessing() {
        assertEquals(308.0, AICostCalculator.calculateCost(AnalysisType.VIDEO, 8.0, 1), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoSmallDataNormalProcessing3() {
        assertEquals(264.0, AICostCalculator.calculateCost(AnalysisType.VIDEO, 8.0, 3), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoSmallDataNormalProcessing5() {
        assertEquals(264.0, AICostCalculator.calculateCost(AnalysisType.VIDEO, 8.0, 5), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoSmallDataSlowProcessing() {
        assertEquals(231.0, AICostCalculator.calculateCost(AnalysisType.VIDEO, 8.0, 9), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoLargeDataBonusFastProcessing() {
        assertEquals(1200.0, AICostCalculator.calculateCost(AnalysisType.VIDEO, 60.0, 2), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoLargeDataBonusNormalProcessing3() {
        assertEquals(1000.0, AICostCalculator.calculateCost(AnalysisType.VIDEO, 60.0, 3), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoLargeDataBonusNormalProcessing6() {
        assertEquals(1000.0, AICostCalculator.calculateCost(AnalysisType.VIDEO, 60.0, 6), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoLargeDataBonusSlowProcessing() {
        assertEquals(850.0, AICostCalculator.calculateCost(AnalysisType.VIDEO, 60.0, 8), 0.01);
    }

    // Invalid analysisType test cases
    @Test
    @Tag("InvalidInputTests")
    public void testInvalidAnalysisTypeNullDataSizeZeroProcessingTimeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 0.0, 0);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testInvalidAnalysisTypeNullDataSizeMediumProcessingTimeFast() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 2.0, 2);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testInvalidAnalysisTypeNullDataSizeSmallProcessingTimeSlow() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 6.0, 12);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testInvalidAnalysisTypeNullDataSizeZeroProcessingTimeSlow() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 0.0, 8);
        });
    }
}