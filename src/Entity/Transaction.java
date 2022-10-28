package Entity;

import java.time.LocalDate;

public class Transaction {
	private long id;
	private String vendor;
	private String type;
	private LocalDate date;
	private String category;
	private double amount;
	
	public Transaction(long id, String vendor, String type, LocalDate date, String category, double amount) {
		super();
		this.id = id;
		this.vendor = vendor;
		this.type = type;
		this.date = date;
		this.category = category;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", vendor=" + vendor + ", type=" + type + ", date=" + date + ", category="
				+ category + ", amount=" + amount + "]";
	}
	
	

}
