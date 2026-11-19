public class PhoneApp implements WeatherObserver {

    @Override
    public void onTemperatureChanged(double temperature) {
        System.out.println("[Phone App] Push notification: " + temperature + "°C");
    }
}
