public class DeskDisplay implements WeatherObserver {
    @Override
    public void onTemperatureChanged(double temperature) {
        System.out.println("[Desk Display] Now showing " + temperature + "°C");
    }
}
