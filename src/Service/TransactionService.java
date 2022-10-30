package Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import Entity.Transaction;

public class TransactionService {
	
	
	public Map<String, List<Transaction>> allTransactionsByCategory(List<Transaction> tx){
		Map<String, List<Transaction>> result =
				  tx.stream()
					.collect
					(Collectors
							.groupingBy(Transaction::getCategory)
							);
		return result;
	}
	
	
	public Map<String, Double> totalOutgoingPerCategory(List<Transaction> tx){
	Map<String, Double> result = 
			tx.stream()
			.collect(Collectors
					.groupingBy(Transaction::getCategory,
							Collectors
							  .summingDouble(x -> x.getAmount())));
		return result;
	}
	
	
	public Map<Object, Double> monthlyAverageSpendByCategory(List<Transaction> tx, String cat, int year, int month){
		
		Map<Object, Double> result = 
				tx.stream()
				.filter(x -> x.getDate().getYear() == year && x.getCategory() == cat)
				.collect(Collectors
						.groupingBy(x -> x.getDate().getMonth(),
						Collectors
						.averagingDouble(Transaction::getAmount)));
				
		return result;
	}
	
	
	public Map<String, Optional<Transaction>> highestSpendByCategoryByYear(List<Transaction> tx, int year){
		
		Comparator<Transaction> compareByAmount = Comparator.comparing(Transaction::getAmount);
		
		Map<String, Optional<Transaction>> result = 
				tx.stream()
				.filter(x -> x.getDate().getYear() == year)
				.collect(Collectors
						.groupingBy(Transaction::getCategory, 
								Collectors
								.reducing(BinaryOperator.maxBy(compareByAmount))));
		return result;
	}
	
	
	public Map<String, Optional<Transaction>> lowestSpendByCategoryByYear(List<Transaction> tx, int year){
		
		Comparator<Transaction> compareByAmount = Comparator.comparing(Transaction::getAmount);
		
		Map<String, Optional<Transaction>> result = 
				tx.stream()
				.filter(x -> x.getDate().getYear() == year)
				.collect(Collectors
						.groupingBy(Transaction::getCategory, 
								Collectors
								.reducing(BinaryOperator.minBy(compareByAmount))));
		return result;
	}
		
		
	public List<Transaction> allTransactionsByCategory2(List<Transaction> tx, String cat){
		List<Transaction> result = tx.stream()
		.filter(x -> x.getCategory().equals(cat))
		.sorted((x,y) -> y.getDate().compareTo(x.getDate()))
		.collect(Collectors.toList());
		return result;
	}
	
	
	public double totalOutgoingPerCategory2(List<Transaction> tx, String cat) {
		 double result = tx.stream()
		.filter(x -> x.getCategory().equals(cat))
		.mapToDouble(x -> x.getAmount())
		.sum();
		return result;
	}
	
	
	public double monthlyAverageSpendByCategory2(List<Transaction> tx, String cat, int year, int month) {
		 double result = tx.stream()
		.filter(x -> x.getCategory().equals(cat) && x.getDate().getYear() == (year) && x.getDate().getMonthValue() == month)
		.mapToDouble(x -> x.getAmount())
		.average()
		.getAsDouble();
		return result;
	}
	
	
	public Transaction highestSpendByCategoryByYear2(List<Transaction> tx, String cat, int year) {
		 Transaction result = tx.stream()
		.filter(x -> x.getCategory().equals(cat) && x.getDate().getYear() == (year))
		.max((x,y) -> Double.valueOf(x.getAmount()).compareTo(Double.valueOf(y.getAmount())))
		.get();
		return result;
	}
	
	
	public Transaction lowestSpendByCategoryByYear2(List<Transaction> tx, String cat, int year) {
		 Transaction result = tx.stream()
		.filter(x -> x.getCategory().equals(cat) && x.getDate().getYear() == (year))
		.min((x,y) -> Double.valueOf(x.getAmount()).compareTo(Double.valueOf(y.getAmount())))
		.get();
		return result;
	}

}
