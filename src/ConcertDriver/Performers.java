package ConcertDriver;

//Product.java
/*A simple instantiable class definition for a Product*/

public class Performers {
    private int PerformerID;

    private String Agent;

    private int Fee;

    public Performers(int PerformerID, String Agent, int Fee) {
        setPerformerID(PerformerID);
        setAgent(Agent);
        setFee(Fee);
    }

    public int getPerformerID() {
        return PerformerID;
    }

    public void setPerformerID(int PerformerID) {
        this.PerformerID = PerformerID;
    }

    public String getAgent() {
        return Agent;
    }

    public void setAgent(String Agent) {
        this.Agent = this.Agent;
    }

    public int getFee() {
        return Fee;
    }
    public void setFee(int Fee) {
        this.Fee = Fee;

    }

    public String toString() {
        return "Ticket ID: " + getPerformerID() + "  Type: " + getAgent() + "  Concert: " + getFee();
    }
}
