package ConcertDriver;

/**

 * Represents a performer assigned to a concert.
 * @author Darragh Quinn
 */

public class Performers {

    /**The ID assigned to the Performer.
     * Must be a digit.
     */
    private int PerformerID;

    /**The Performer's Agent.
     * Must be a String.
     */
    private String Agent;
    /**The full name of the Performer.
     * Must be a String.
     */
    private String PerformerName;

    /**The fee the Performer demands in order to play at the concert.
     * Must be a digit.
     */
    private int Fee;


    /** * Performers 4-argument constructor. Calls the 4 mutators.
     * @param PerformerID the ID of the Performer
     * @param PerformerName the Name of the Performer
     * @param Agent the Agent of the Performer
     * @param Fee the amount of money the Performer charges as a Fee */
    public Performers(int PerformerID, String PerformerName, String Agent, int Fee) {
        setPerformerID(PerformerID);
        setPerformerName(PerformerName);
        setAgent(Agent);
        setFee(Fee);
    }

    /**Gets this Performer's ID.
     * @return an Integer value indicating this Performer's ID.
     */

    public int getPerformerID() {
        return PerformerID;
    }
    /** Changes the ID of this Performer.
     * @param PerformerID This Performer's new ID, must be a digit.
     */
    public void setPerformerID(int PerformerID) {
        this.PerformerID = PerformerID;
    }

    /**Gets this Performer's Name.
     * @return a String value indicating this Performer's name.
     */

    public String getPerformerName() {
        return PerformerName;
    }

    /**Changes this Performer's Name.
     * @param PerformerName This Performer's new name, must be a string.
     */
    public void setPerformerName(String PerformerName) {
        this.PerformerName = PerformerName;
    }

    /**Gets this Agent's name.
     * @return a String value indicating this Agent's name.
     */
    public String getAgent() {
        return Agent;
    }

    /**Changes this Agent's ID.
     * @param Agent This Agent's new Name, must be a string.
     */
    public void setAgent(String Agent) {
        this.Agent = Agent;
    }

    /**Gets this Performer's Fee.
     * @return This Performer's Fee.
     */
    public int getFee() {
        return Fee;
    }

    /**Changes the Performer's Fee.
     * @param Fee This performer's new Fee, must be a digit.
     */
    public void setFee(int Fee) {
        this.Fee = Fee;

    }
    /**Method to get the state of a Performer object.
     * @return A string containing int and string values that indicates
     * details about a Performer.
     */
    public String toString() {
        return "\nPerformer ID: " + getPerformerID() + "\nPerformer: " + getPerformerName() + "\nType: " + getAgent() + "\nConcert: " + getFee();
    }
}
