public class AICostCalculator {

    // Base cost
    static final double TEXT_BASE = 20;
    static final double TEXT_PER_GB = 5;

    static final double IMAGE_BASE = 50;
    static final double IMAGE_PER_GB = 10;

    static final double VIDEO_BASE = 100;
    static final double VIDEO_PER_GB = 15;

    // Time thresholds
    static final int FAST_PROCESSING_HOURS = 2;
    static final int SLOW_PROCESSING_HOURS = 6;

    // Time analysis
    static final double FAST_ANALYSIS = 0.2;   // +20% for fast
    static final double SLOW_ANALYSIS = 0.15;  // -15% for slow

    // Special rules thresholds and adjustments
    static final double TEXT_LARGE_DATA_THRESHOLD = 50;
    static final double TEXT_LARGE_DATA_BONUS = 100;

    static final double VIDEO_SMALL_DATA_THRESHOLD = 10;
    static final double VIDEO_SMALL_DATA_BONUS = 0.2; // 20% of base

    static final double IMAGE_MEDIUM_TIME_PENALTY = 0.1; // 10% of base, 4 < t <= 6

    static final int IMAGE_MEDIUM_TIME_MIN = 4;
    static final int IMAGE_MEDIUM_TIME_MAX = 6;

    public static double calculateCost(AnalysisType type, double dataSize, int processingTime) {
        if (type == null) throw new IllegalArgumentException("Analysis type cannot be null");
        if (dataSize <= 0) throw new IllegalArgumentException("Data size must be positive");
        if (processingTime <= 0) throw new IllegalArgumentException("Processing time must be positive");

        double baseCost = switch (type) {
            case TEXT -> TEXT_BASE + TEXT_PER_GB * dataSize;
            case IMAGE -> IMAGE_BASE + IMAGE_PER_GB * dataSize;
            case VIDEO -> VIDEO_BASE + VIDEO_PER_GB * dataSize;
        };

        double cost = baseCost;

        // Processing time adjustment
        if (processingTime <= FAST_PROCESSING_HOURS) {
            cost += baseCost * FAST_ANALYSIS;
        } else if (processingTime > SLOW_PROCESSING_HOURS) {
            cost -= baseCost * SLOW_ANALYSIS;
        }

        // Special rules
        if (type == AnalysisType.TEXT && dataSize > TEXT_LARGE_DATA_THRESHOLD) {
            cost += TEXT_LARGE_DATA_BONUS;
        }

        if (type == AnalysisType.VIDEO && dataSize < VIDEO_SMALL_DATA_THRESHOLD) {
            cost += baseCost * VIDEO_SMALL_DATA_BONUS;
        }

        if (type == AnalysisType.IMAGE && processingTime > IMAGE_MEDIUM_TIME_MIN
                && processingTime <= IMAGE_MEDIUM_TIME_MAX) {
            cost -= baseCost * IMAGE_MEDIUM_TIME_PENALTY;
        }

        return Math.round(cost * 100.0) / 100.0;
    }
}