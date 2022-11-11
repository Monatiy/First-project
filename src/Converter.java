public class Converter {
    public static double convertStepsToKm(int steps) {
        return steps * 75 / (100.0 * 1000);
    }

    public static double convertStepsToKilocalories(int steps) {
        return steps * 50 / 1000.0;
    }
}
