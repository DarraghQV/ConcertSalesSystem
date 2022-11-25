package ConcertDriver;

public class Sale {


    private int SaleAmount;

    private String TicketType;

    private String CustomerName;

    private String CustomerEmail;


    public Sale(int SaleAmount, String TicketType, String CustomerName, String CustomerEmail) {
        setSaleAmount(SaleAmount);
        setTicketType(TicketType);
        setCustomerName(CustomerName);
        setCustomerEmail(CustomerEmail);

    }

    public int getSaleAmount() {
        return SaleAmount;
    }

    public void setSaleAmount(int SaleAmount) {
        this.SaleAmount = SaleAmount;
    }

    public String getTicketType() {
        return TicketType;
    }

    public void setTicketType(String TicketType) {
        this.TicketType = TicketType;
    }


    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }


    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String CustomerEmail) {
        this.CustomerEmail = CustomerEmail;
    }


    public String toString() {
        return "\nSale Amount: £" + getSaleAmount() + "\nTicket For: " + getTicketType() + "\nCustomer Name: " + getCustomerName() + "\nCustomer Email: " + getCustomerEmail();
    }
}
