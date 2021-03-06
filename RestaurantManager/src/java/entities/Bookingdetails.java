package entities;
// Generated Jul 23, 2014 7:06:06 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Bookingdetails generated by hbm2java
 */
public class Bookingdetails  implements java.io.Serializable {


     private Integer bookingId;
     private TableT tableT;
     private Customer customer;
     private Date dayBooking;
     private int dayStart;
     private Date timeStart;
     private int numPerson;

    public Bookingdetails() {
    }

    public Bookingdetails(TableT tableT, Customer customer, Date dayBooking, int dayStart, Date timeStart, int numPerson) {
       this.tableT = tableT;
       this.customer = customer;
       this.dayBooking = dayBooking;
       this.dayStart = dayStart;
       this.timeStart = timeStart;
       this.numPerson = numPerson;
    }
   
    public Integer getBookingId() {
        return this.bookingId;
    }
    
    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
    public TableT getTableT() {
        return this.tableT;
    }
    
    public void setTableT(TableT tableT) {
        this.tableT = tableT;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Date getDayBooking() {
        return this.dayBooking;
    }
    
    public void setDayBooking(Date dayBooking) {
        this.dayBooking = dayBooking;
    }
    public int getDayStart() {
        return this.dayStart;
    }
    
    public void setDayStart(int dayStart) {
        this.dayStart = dayStart;
    }
    public Date getTimeStart() {
        return this.timeStart;
    }
    
    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }
    public int getNumPerson() {
        return this.numPerson;
    }
    
    public void setNumPerson(int numPerson) {
        this.numPerson = numPerson;
    }




}


