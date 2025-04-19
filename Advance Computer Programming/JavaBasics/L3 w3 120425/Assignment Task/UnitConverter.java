public class UnitConverter {
    public static void main(String[] args) {
        // Centimeter to meter using implicit casting
        int cm = 180;
        double meter = cm / 100.0;  // implicit casting
        System.out.println("Height in meters: " + meter);

        // Celsius to integer using explicit casting
        double temperature = 36.7;
        int tempWhole = (int) temperature;  // explicit casting
        System.out.println("Temperature (whole number): " + tempWhole + "°C");
    }
}
