import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Entity.Transaction;
import Repository.TransactionDatabase;

public class Main {

	public static void main(String[] args) {
		List<Transaction> transactions = TransactionDatabase.getTransactions().stream().collect(Collectors.toList());
		
		
		// 1.	All transactions for a given category - latest first - Category = Groceries
		System.out.println(transactionsByCategory(transactions, "Groceries"));
		
		// 2. Total Outgoing Per Category - Category = MyMonthlyDD
		System.out.println(totalOutgoingByCategory(transactions, "MyMonthlyDD"));
		
		// 3. Total Outgoing Per Category - Category = MyMonthlyDD
		System.out.println(monthlyAverageSpendByCategory(transactions, "Groceries", 2020, 10));
		
		// 4. Highest spend in a given category, for a given year
		System.out.println(highestSpendInCategoryInYear(transactions, "MyMonthlyDD", 2020));
		
		// 5. Lowest spend in a given category, for a given year
		System.out.println(lowestSpendInCategoryInYear(transactions, "Groceries", 2020));
		
		Map<String, List<Transaction>> map = new HashMap<>();
		
//		for(Map.Entry<String, ArrayList<Transaction>> entry : map.entrySet()) {
//						
//		}
		for(Transaction transaction : transactions) {
			if( !map.containsValue(transaction)){
				
			}
			map.put(transaction.getCategory(), Arrays.asList(transaction));
		}
		
		System.out.println(map.values());
		
	}
	
	public static List<Transaction> transactionsByCategory(List<Transaction> tx, String cat){
		List<Transaction> result = tx.stream()
		.filter(x -> x.getCategory().equals(cat))
		.sorted((x,y) -> y.getDate().compareTo(x.getDate()))
		.collect(Collectors.toList());
		return result;
	}
	
	public static double totalOutgoingByCategory(List<Transaction> tx, String cat) {
		 double result = tx.stream()
		.filter(x -> x.getCategory().equals(cat))
		.mapToDouble(x -> x.getAmount())
		.sum();
		return result;
	}
	
	public static double monthlyAverageSpendByCategory(List<Transaction> tx, String cat, int year, int month) {
		 double result = tx.stream()
		.filter(x -> x.getCategory().equals(cat) && x.getDate().getYear() == (year) && x.getDate().getMonthValue() == month)
		.mapToDouble(x -> x.getAmount())
		.average()
		.getAsDouble();
		return result;
	}
	
	public static Transaction highestSpendInCategoryInYear(List<Transaction> tx, String cat, int year) {
		 Transaction result = tx.stream()
		.filter(x -> x.getCategory().equals(cat) && x.getDate().getYear() == (year))
		.max((x,y) -> Double.valueOf(x.getAmount()).compareTo(Double.valueOf(y.getAmount())))
		.get();
		return result;
	}
	
	public static Transaction lowestSpendInCategoryInYear(List<Transaction> tx, String cat, int year) {
		 Transaction result = tx.stream()
		.filter(x -> x.getCategory().equals(cat) && x.getDate().getYear() == (year))
		.min((x,y) -> Double.valueOf(x.getAmount()).compareTo(Double.valueOf(y.getAmount())))
		.get();
		return result;
	}
}
