package Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Entity.Transaction;

public class TransactionDatabase {
	
	public static List<Transaction> getTransactions(){
		return Stream.of(new Transaction(1, "Morrisons", "card", LocalDate.of(2020, 11, 01), "Groceries", 10.40),
				new Transaction(2, "CYBG", "direct debit", LocalDate.of(2020, 10, 28), "MyMonthlyDD", 600),
				new Transaction(3, "PureGym", "direct debit", LocalDate.of(2020, 10, 28), "MyMonthlyDD", 40),
				new Transaction(4, "M&S", "card", LocalDate.of(2020, 10, 01), "Groceries", 5.99),
				new Transaction(5, "McMillan", "internet", LocalDate.of(2020, 9, 30), "", 10))
				.collect(Collectors.toList());
	}
}
