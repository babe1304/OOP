package hr.fer.oop.predavanja;

public class Concert extends Event implements EventPromoter {
    private Band playingband;
    private String[] songList;

    public Concert(String name, String location, String date, Band playingband, String[] songList) {
        super(name, location, date);
        this.playingband = playingband;
        this.songList = songList;
    }

    public Band getPlayingband() {
        return playingband;
    }

    public String[] getSongList() {
        return songList;
    }

    public void setPlayingband(Band playingband) {
        this.playingband = playingband;
    }

    public void setSongList(String[] songList) {
        this.songList = songList;
    }

    @Override
    public void printEventPoster() {
        String info = "Event date: " + getDate() + "\nBand: " + getPlayingband().getBandName() + "\nSong list for this concert is:\n";

        for (int i = 0; i < songList.length; i++) {
            if (i != songList.length - 1)  info += "Song " + (i + 1) + ": " + songList[i] + "\n";
            else info += "Song " + (i + 1) + ": " + songList[i];
        }
        System.out.println(info);
    }
}
