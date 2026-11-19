public class WebsiteWidget implements WeatherObserver {
    @Override
    public void onTemperatureChanged(double temperature) {
        System.out.println("[Website] Widget updated to show " + temperature + "°C");
    }
}
