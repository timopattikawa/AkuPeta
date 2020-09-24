package akupeta;


public class City {
    private final String cityName;
    private final int cityCode;

    public City(String cityName, int cityCode) {
        this.cityName = cityName;
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }
    public int getCityCode() {
        return cityCode;
    }

}
