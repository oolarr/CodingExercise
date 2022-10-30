import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import Entity.Transaction;
import Repository.TransactionDatabase;
import Service.TransactionService;

public class Main {

	public static void main(String[] args) {
		
		TransactionService transactionService = new TransactionService();
		
		List<Transaction> transactions = TransactionDatabase
				.getTransactions()
				.stream()
				.collect(Collectors.toList());
		
		
		// Group transactions by Category
		Map<String, List<Transaction>> categories = 
				transactionService.allTransactionsByCategory(transactions);

		for(Map.Entry<String, List<Transaction>> entry : categories.entrySet() ) {
			  System.out.println("Key: " + entry.getKey() + " ->" + " " + "Value(s): " + entry.getValue());
		}
		
		System.out.println();
		// 2. Total Outgoing Per Category 
		Map<String, Double> mapByTotalOutgoing = 
				transactionService.totalOutgoingPerCategory(transactions);
		
		for(Map.Entry<String, Double> entry : mapByTotalOutgoing.entrySet() ) {
			  System.out.println("Total Spend -> "  + entry.getKey() + " ->" + " "  + entry.getValue());
		}
		
		System.out.println();
		// 3. Total Outgoing Per Category - Category = MyMonthlyDD
		Map<Object, Double> mapByAverageSpend =
				transactionService.monthlyAverageSpendByCategory(transactions, "MyMonthlyDD", 2020, 10);
		
		for(Map.Entry<Object, Double> entry : mapByAverageSpend.entrySet() ) {
			  System.out.println("Average Spend -> " + entry.getKey() + " ->" + " " + entry.getValue());
		}
		
		System.out.println();
		// 4. Highest Spend in a Category in a year
		Map<String, Optional<Transaction>> mapByHighestSpend = 
				transactionService.highestSpendByCategoryByYear(transactions, 2020);
		
		for(Map.Entry<String, Optional<Transaction>> entry : mapByHighestSpend.entrySet() ) {
			  System.out.println( "Highest Spend -> " + entry.getKey() + " ->" + " " + entry.getValue());
		}
		
		System.out.println();
		//5. Lowest Spend in a Category in a year
		Map<String, Optional<Transaction>> mapByLowestSpend = 
				transactionService.lowestSpendByCategoryByYear(transactions, 2020);
		
		for(Map.Entry<String, Optional<Transaction>> entry : mapByLowestSpend.entrySet() ) {
			  System.out.println( "Lowest Spend -> " + entry.getKey() + " ->" + " " + entry.getValue());
		}
		
		
		System.out.println();
		
		// 1.	All transactions for a given category - latest first - Category = Groceries
		System.out.println(transactionService
				.allTransactionsByCategory2
				(transactions, "Groceries"));
		
		// 2. Total Outgoing Per Category - Category = MyMonthlyDD
		System.out.println(transactionService
				.totalOutgoingPerCategory2
				(transactions, "MyMonthlyDD"));
		
		// 3. Average Spend Per Category - Category = MyMonthlyDD
		System.out.println("Average" + transactionService
				.monthlyAverageSpendByCategory2
				(transactions, "MyMonthlyDD", 2020, 10));
		
		// 4. Highest spend in a given category, for a given year
		System.out.println(transactionService
				.highestSpendByCategoryByYear2
				(transactions, "MyMonthlyDD", 2020));
		
		// 5. Lowest spend in a given category, for a given year
		System.out.println(transactionService
				.lowestSpendByCategoryByYear2
				(transactions, "Groceries", 2020));
		
		System.out.println();
	}
	
}
