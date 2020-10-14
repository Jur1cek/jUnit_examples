package examples;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APOD {
    public final String alt;
    public final String day;
    public final String img;
    public final String link;
    public final String month;
    public final String news;
    public final Integer num;
    public final String safe_title;
    public final String title;
    public final String transcript;
    public final String year;


    public APOD(@JsonProperty("alt") String alt,
                @JsonProperty("day") String day,
                @JsonProperty("img") String img,
                @JsonProperty("link") String link,
                @JsonProperty("month") String month,
                @JsonProperty("news") String news,
                @JsonProperty("num") Integer num,
                @JsonProperty("safe_title") String safe_title,
                @JsonProperty("title") String title,
                @JsonProperty("transcript") String transcript,
                @JsonProperty("year") String year) {

        this.alt = alt;
        this.day = day;
        this.img = img;
        this.link = link;
        this.month = month;
        this.news = news;
        this.num = num;
        this.safe_title = safe_title;
        this.title = title;
        this.transcript = transcript;
        this.year = year;
    }
}