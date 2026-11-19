
public class Main {
    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        WeatherObserver phone = new PhoneApp();
        WeatherObserver website = new WebsiteWidget();

        station.addObserver(phone);
        station.addObserver(website);

        station.setTemperature(25);
        station.addObserver(new DeskDisplay());
        station.setTemperature(30);

        station.removeObserver(phone);
        station.setTemperature(40);
    }
}