import java.util.ArrayList;

public abstract class RollingPictures implements Media {

private String title;

private int year;

private ArrayList <String> category;

private int rating;

    public RollingPictures(String title, int year, ArrayList <String> category, int rating) {
        this.title = title;
        this.year = year;
        this.category = category;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "";
    }
}

