public class Converter {
    public static double convertStepsToKm(int steps) {
        double distance = steps * 75 / (100.0 * 1000);
        return distance;
    }

    public static double convertStepsToKilocalories(int steps) {
        double kilocalories = steps * 50 / 1000.0;
        return kilocalories;
    }
}
