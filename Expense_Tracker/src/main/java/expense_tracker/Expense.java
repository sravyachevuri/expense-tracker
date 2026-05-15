package expense_tracker;

import java.time.LocalDate;

public class Expense 
{
	private String expense;
	private String category;
	private double amount;
	private LocalDate date;
	public Expense(String expense, String category, double amount, LocalDate date) 
	{
		this.expense = expense;
		this.category = category;
		this.amount = amount;
		this.date = date;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Expense [expense=" + expense + ", category=" + category + ", amount=" + amount + ", date=" + date + "]";
	}
	
}