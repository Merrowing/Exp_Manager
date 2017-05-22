package main;

import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import com.google.gson.Gson;


public class Main {
	private class Exchange {
        String base;
        String date;
        Map<String, String> rates;
    }
	
    public static void main(String[] args) throws ParseException, IOException {
    	try{
    	Scanner in = new Scanner(System.in);
    	 String[] mas = null;
        
        List<ExpenseEntry>  list = new LinkedList<ExpenseEntry>();
        do{
        String line = in.nextLine();	
        mas = line.trim().split(" ");
        if(mas[0].equals("add")){
        	ExpenseEntry exp  = new ExpenseEntry(mas[1], mas[2], mas[3],mas[4]);
        	list.add(exp);
 	
        }
        if(mas[0].equals("list")){
        	Collections.sort(list, new Comparator<ExpenseEntry>(){
        		  @Override
        		  public int compare(ExpenseEntry o1, ExpenseEntry o2){
        			  return o1.getDateparse().compareTo(o2.getDateparse());
        		  }
        	});
        	for (int i = 0; i < list.size(); i++){
        		if(i!=0 && list.get(i).getDate().equals(list.get(i-1).getDate()))
        			list.get(i).print2();
        		else list.get(i).print();
        			if(i!=list.size()-1 && !list.get(i).getDate().equals(list.get(i+1).getDate())  )
        				System.out.println();
        			 
        	}
        	
        }
        if(mas[0].equals("clear")){
        	for (int i = 0; i < list.size(); i++){
        	if(list.get(i).getDate().equals(mas[1])){
        		list.remove(i);
        		i=i-1;
        	}
         }
        }
        if(mas[0].equals("total")){
        	double total = 0;
        	for (int i = 0; i < list.size(); i++){
        		if(mas[1].equals(list.get(i).getMoneyType()))
        			total=total+list.get(i).getAmount(); 
        		else{
        		URL url = new URL("http://api.fixer.io/latest?base="+list.get(i).getMoneyType());
        		InputStreamReader reader = new InputStreamReader(url.openStream());
        		Exchange exc = new Gson().fromJson(reader, Exchange.class);
        		double tmp = Double.parseDouble(exc.rates.get(mas[1]));
        		double ex_money = list.get(i).getAmount() * tmp;
        		total = total+ex_money;
        		}		
        		
        	}
        	String ftotal = String.format("%.2f", total);
        	System.out.println(ftotal + " " + mas[1]);
        	
        }
        //else System.out.println("Input ERROR");
       
    	}while(!mas[0].equals("exit"));
    	}catch (Exception e){
    		System.out.println("ERROR");
    	}
       
    }
}
