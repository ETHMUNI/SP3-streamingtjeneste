public class Series extends RollingPictures {

    private boolean series;
    int season;
    int episode;

    public Series(String title, int year, String category, int rating, boolean series, int season, int episode) {
        super(title, year, category, rating);

        this.series = series;
        this.season = season;
        this.episode = episode;

    }

    public boolean hasSeries() {
        return this.series;
    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
    }


    @Override
    public String toString() {
        return super.toString() +hasSeries()+"Season "+getSeason() +"Episode "+getEpisode();
    }


}
