package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DebtItem {
	private String message;
	private double amount;
	private LocalDateTime timestamp;
	// TODO model interest with an interest object


	public DebtItem(String message, double amount, LocalDateTime timestamp) {
		this.message = message;
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getFormattedTimestamp() {
		return timestamp.format(DateTimeFormatter.ofPattern("MM/dd/yyyy k:mm"));
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DebtItem debtItem = (DebtItem) o;

		if (Double.compare(debtItem.amount, amount) != 0) return false;
		if (!Objects.equals(message, debtItem.message)) return false;
		return Objects.equals(timestamp, debtItem.timestamp);
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = message != null ? message.hashCode() : 0;
		temp = Double.doubleToLongBits(amount);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s (%s): $%.2f", message, getFormattedTimestamp(), amount);
	}
}
