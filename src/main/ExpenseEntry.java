package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExpenseEntry {
    private String name;
    private String date;
    private String moneyType;
    private Double amount;
    private Date dateparse;
    
 
    public ExpenseEntry(String date,String amount,String moneyType,String name  ) throws ParseException {
        this.date = date;
        this.amount = Double.parseDouble(amount);
        this.moneyType = moneyType;
        this.name = name;
        DateFormat format = new SimpleDateFormat("yyyy-M-dd");
        this.dateparse = format.parse(date);
    }
    
    public void print(){
    	System.out.println(date);
    	System.out.print(name+ " ");
    	System.out.print(amount+ " " );
    	System.out.println(moneyType);
    }
    public void print2(){
    	System.out.print(name+ " ");
    	System.out.print(amount+ " " );
    	System.out.println(moneyType);
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

	public Date getDateparse() {
		return dateparse;
	}

	public void setDateparse(Date dateparse) {
		this.dateparse = dateparse;
	}  
}
