package fr.ensai.library;
import java.util.Date;

public class Loan {
    private Student student;
    private Item item;
    private Date startDate;
    private Date returnDate;

    public Loan( Item item, Student student, Date startDate){
        this.student = student;
        this.item = item;
        this.startDate = startDate;
        this.returnDate = null;
    }

    public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;
    }

    public String toString(){
        String message = "Item " + item.toString() + " borrowed by " + this.student.toString() + ".";
        return message;

    }


    public Item getItem(){
        return this.item;
    }
}
