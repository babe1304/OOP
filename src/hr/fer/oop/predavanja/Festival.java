package hr.fer.oop.predavanja;

public class Festival extends Event implements EventPromoter {
    private Band[] bandList;

    public Festival(String name, String location, String date, Band[] bandList) {
        super(name, location, date);
        this.bandList = bandList;
    }


    @Override
    public void printEventPoster() {
        String info = "Event date: " + getDate() + "\nFestival: " + getName() + " in " + getLocation() + "\nBand list for the festival is:\n";

        for (int i = 0; i < bandList.length; i++) {
            if (i != bandList.length - 1)  info += "Song " + (i + 1) + ": " + bandList[i].getBandName() + "\n";
            else info += "Song " + (i + 1) + ": " + bandList[i].getBandName();
        }
        System.out.println(info);
    }
}
