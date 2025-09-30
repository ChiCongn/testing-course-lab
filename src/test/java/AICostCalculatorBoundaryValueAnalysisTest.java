import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AICostCalculatorBoundaryValueAnalysisTest {

    // TEXT test cases (TC1-TC11)
    @Test
    @Tag("TextTests")
    @Tag("InvalidInputTests")
    public void testTextZeroDataNormalProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, 0.0, 8);
        });
    }

    @Test
    @Tag("TextTests")
    public void testTextSmallDataNormalProcessing() {
        assertEquals(17.04, AICostCalculator.calculateCost(AnalysisType.TEXT, 0.01, 8), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextSmallDataNormalProcessing2() {
        assertEquals(17.09, AICostCalculator.calculateCost(AnalysisType.TEXT, 0.02, 8), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextLargeDataSlowProcessing() {
        assertEquals(4_250_117.00, AICostCalculator.calculateCost(AnalysisType.TEXT, 1_000_000, 8), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextMaxDataSlowProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, Double.MAX_VALUE, 8);
        });
    }

    @Test
    @Tag("TextTests")
    public void testTextMediumDataSlowProcessing() {
        assertEquals(70.13, AICostCalculator.calculateCost(AnalysisType.TEXT, 12.50, 8), 0.01);
    }

    @Test
    @Tag("TextTests")
    @Tag("InvalidInputTests")
    public void testTextMediumDataInvalidProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.TEXT, 12.50, 0);
        });
    }

    @Test
    @Tag("TextTests")
    public void testTextMediumDataFastProcessing1() {
        assertEquals(99.00, AICostCalculator.calculateCost(AnalysisType.TEXT, 12.50, 1), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextMediumDataFastProcessing2() {
        assertEquals(99.00, AICostCalculator.calculateCost(AnalysisType.TEXT, 12.50, 2), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextMediumDataSlowProcessingMillion() {
        assertEquals(70.13, AICostCalculator.calculateCost(AnalysisType.TEXT, 12.50, 1_000_000), 0.01);
    }

    @Test
    @Tag("TextTests")
    public void testTextMediumDataSlowProcessingMax() {
        assertEquals(70.13, AICostCalculator.calculateCost(AnalysisType.TEXT, 12.50, Integer.MAX_VALUE), 0.01);
    }

    // IMAGE test cases (TC12-TC22)
    @Test
    @Tag("ImageTests")
    @Tag("InvalidInputTests")
    public void testImageZeroDataNormalProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.IMAGE, 0.0, 8);
        });
    }

    @Test
    @Tag("ImageTests")
    public void testImageSmallDataNormalProcessing() {
        assertEquals(42.59, AICostCalculator.calculateCost(AnalysisType.IMAGE, 0.01, 8), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageSmallDataNormalProcessing2() {
        assertEquals(42.67, AICostCalculator.calculateCost(AnalysisType.IMAGE, 0.02, 8), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageLargeDataSlowProcessing() {
        assertEquals(8_500_042.50, AICostCalculator.calculateCost(AnalysisType.IMAGE, 1_000_000, 8), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageMaxDataSlowProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.IMAGE, Double.MAX_VALUE, 8);
        });
    }

    @Test
    @Tag("ImageTests")
    public void testImageMediumDataSlowProcessing() {
        assertEquals(148.75, AICostCalculator.calculateCost(AnalysisType.IMAGE, 12.50, 8), 0.01);
    }

    @Test
    @Tag("ImageTests")
    @Tag("InvalidInputTests")
    public void testImageMediumDataInvalidProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.IMAGE, 12.50, 0);
        });
    }

    @Test
    @Tag("ImageTests")
    public void testImageMediumDataFastProcessing1() {
        assertEquals(210.00, AICostCalculator.calculateCost(AnalysisType.IMAGE, 12.50, 1), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageMediumDataFastProcessing2() {
        assertEquals(210.00, AICostCalculator.calculateCost(AnalysisType.IMAGE, 12.50, 2), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageMediumDataSlowProcessingMillion() {
        assertEquals(148.75, AICostCalculator.calculateCost(AnalysisType.IMAGE, 12.50, 1_000_000), 0.01);
    }

    @Test
    @Tag("ImageTests")
    public void testImageMediumDataSlowProcessingMax() {
        assertEquals(148.75, AICostCalculator.calculateCost(AnalysisType.IMAGE, 12.50, Integer.MAX_VALUE), 0.01);
    }

    // VIDEO test cases (TC23-TC33)
    @Test
    @Tag("VideoTests")
    @Tag("InvalidInputTests")
    public void testVideoZeroDataNormalProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.VIDEO, 0.0, 8);
        });
    }

    @Test
    @Tag("VideoTests")
    public void testVideoSmallDataNormalProcessing() {
        assertEquals(105.16, AICostCalculator.calculateCost(AnalysisType.VIDEO, 0.01, 8), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoSmallDataNormalProcessing2() {
        assertEquals(105.32, AICostCalculator.calculateCost(AnalysisType.VIDEO, 0.02, 8), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoLargeDataSlowProcessing() {
        assertEquals(12_750_085.00, AICostCalculator.calculateCost(AnalysisType.VIDEO, 1_000_000, 8), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoMaxDataSlowProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.VIDEO, Double.MAX_VALUE, 8);
        });
    }

    @Test
    @Tag("VideoTests")
    public void testVideoMediumDataSlowProcessing() {
        assertEquals(244.38, AICostCalculator.calculateCost(AnalysisType.VIDEO, 12.50, 8), 0.01);
    }

    @Test
    @Tag("VideoTests")
    @Tag("InvalidInputTests")
    public void testVideoMediumDataInvalidProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(AnalysisType.VIDEO, 12.50, 0);
        });
    }

    @Test
    @Tag("VideoTests")
    public void testVideoMediumDataFastProcessing1() {
        assertEquals(345.00, AICostCalculator.calculateCost(AnalysisType.VIDEO, 12.50, 1), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoMediumDataFastProcessing2() {
        assertEquals(345.00, AICostCalculator.calculateCost(AnalysisType.VIDEO, 12.50, 2), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoMediumDataSlowProcessingMillion() {
        assertEquals(244.38, AICostCalculator.calculateCost(AnalysisType.VIDEO, 12.50, 1_000_000), 0.01);
    }

    @Test
    @Tag("VideoTests")
    public void testVideoMediumDataSlowProcessingMax() {
        assertEquals(244.38, AICostCalculator.calculateCost(AnalysisType.VIDEO, 12.50, Integer.MAX_VALUE), 0.01);
    }

    // NULL test cases (TC34-TC42)
    @Test
    @Tag("InvalidInputTests")
    public void testNullZeroDataNormalProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 0.0, 8);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testNullSmallDataNormalProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 0.01, 8);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testNullSmallDataNormalProcessing2() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 0.02, 8);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testNullLargeDataNormalProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 1_000_000, 8);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testNullMaxDataNormalProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, Double.MAX_VALUE, 8);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testNullMediumDataNormalProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 12.50, 8);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testNullMediumDataInvalidProcessing() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 12.50, 0);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testNullMediumDataFastProcessing1() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 12.50, 1);
        });
    }

    @Test
    @Tag("InvalidInputTests")
    public void testNullMediumDataFastProcessing2() {
        assertThrows(IllegalArgumentException.class, () -> {
            AICostCalculator.calculateCost(null, 12.50, 2);
        });
    }
}