package Atm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;



@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int transID;

    private String accID;
    @NotNull
    private double amt;
    @Size(max=9000)
    private String reason;

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    public void setNeg(){
        amt = -amt;
    }

    public String toString(){
        String type = (amt>0)? "Deposit" : "Withdraw";
        return accID + " " +  type + " " + Math.abs(amt) +" " + reason +"<br>";
    }
}
