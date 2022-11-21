package ConcertDriver;

//Product.java
/*A simple instantiable class definition for a Product*/

public class Performers {
    private int PerformerID;

    private String Agent;

    private String PerformerName;
    private int Fee;

    public Performers(int PerformerID, String PerformerName, String Agent, int Fee) {
        setPerformerID(PerformerID);
        setPerformerName(PerformerName);
        setAgent(Agent);
        setFee(Fee);
    }

    public int getPerformerID() {
        return PerformerID;
    }

    public void setPerformerID(int PerformerID) {
        this.PerformerID = PerformerID;
    }

    public String getPerformerName() {
        return PerformerName;
    }

    public void setPerformerName(String PerformerName) {
        this.PerformerName = PerformerName;
    }

    public String getAgent() {
        return Agent;
    }

    public void setAgent(String Agent) {
        this.Agent = Agent;
    }

    public int getFee() {
        return Fee;
    }
    public void setFee(int Fee) {
        this.Fee = Fee;

    }

    public String toString() {
        return "Performer ID: " + getPerformerID() + "  Performer: " + getPerformerName() + "  Type: " + getAgent() + "  Concert: " + getFee();
    }
}
