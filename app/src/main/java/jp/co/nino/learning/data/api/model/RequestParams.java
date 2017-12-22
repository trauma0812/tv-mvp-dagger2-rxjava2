package jp.co.nino.learning.data.api.model;

/**
 * Created by liu.rui on 2017/12/18.
 */

public class RequestParams {

    private String area;

    private String service;

    private String genre;

    private String date;

    private String apiKey;

    public RequestParams(String area, String service, String genre, String date, String apiKey) {
        this.area = area;
        this.service = service;
        this.genre = genre;
        this.date = date;
        this.apiKey = apiKey;
    }

    public String getArea() {
        return area;
    }

    public String getService() {
        return service;
    }

    public String getGenre() {
        return genre;
    }

    public String getDate() {
        return date;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }


}
