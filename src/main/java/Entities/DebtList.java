package Entities;

import java.util.ArrayList;

public class DebtList extends ArrayList<DebtItem> {
	public DebtList() {}

	public DebtList(int initialCapacity) {
		super(initialCapacity);
	}

	public double total() {
		double sum = 0;
		for (DebtItem i : super.stream().toList()) {
			sum += i.getAmount();
		}

		return sum;
	}

	@Override
	public String toString() {
		if (isEmpty()) return "Empty";

		StringBuilder b = new StringBuilder();
		for (DebtItem i : super.stream().toList()) {
			b.append(i.toString()).append('\n');
		}

		return b.toString();
	}
}
