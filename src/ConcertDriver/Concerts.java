package ConcertDriver;

import java.io.Serializable;

public class Concerts implements Serializable {

    private int ConcertID;

    private String ArtistName;

    private String Venue;


    public Concerts(int ConcertID, String ArtistName, String Venue) {
        setConcertID(ConcertID);
        setArtistName(ArtistName);
        setVenue(Venue);

    }

    public int getConcertID() {
        return ConcertID;
    }

    public void setConcertID(int ConcertID) {
        this.ConcertID = ConcertID;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String ArtistName) {
        this.ArtistName = ArtistName;
    }


    public String getVenue() {
        return Venue;
    }

    public void setVenue(String Venue) {
        this.Venue = Venue;
    }


    public String toString() {
        return "\nConcert ID: " + getConcertID() + "\nPerformer: " + getArtistName() + "\nVenue: " + getVenue();
    }
}
