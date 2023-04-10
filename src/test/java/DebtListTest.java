import Entities.DebtItem;
import Entities.DebtList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DebtListTest {

	DebtList dl;

	@BeforeEach
	void init() {
		dl = new DebtList(); // Resets DebtList before each test
	}

	@DisplayName("Total")
	@Test
	void Total() {
		dl.add(new DebtItem("Boba", 6.79, LocalDateTime.now()));

		// Test that one has been added
		Assertions.assertEquals(dl.total(), 6.79);

		dl.add(new DebtItem("MTL", 4.86, LocalDateTime.now()));
		dl.add(new DebtItem("MTL", 10.15, LocalDateTime.now()));
		dl.add(new DebtItem("Boba", 2.34, LocalDateTime.now()));

		// Test that multiple have been added correctly
		Assertions.assertEquals(dl.total(), 24.14);

		dl.add(new DebtItem("Tea", -10.86, LocalDateTime.now()));

		// Test negative values
		// We need a delta value because we are now subtracting
		Assertions.assertEquals(dl.total(), 13.28, 0.000001f);

		dl.add(new DebtItem("Lunch", 0, LocalDateTime.now()));

		// Test Zero Values
		Assertions.assertEquals(dl.total(), 13.28, 0.000001f);
	}

	@DisplayName("Printing")
	@Test
	void Printing() {
		dl.add(new DebtItem("Boba", 6.79, LocalDateTime.now()));
		dl.add(new DebtItem("MTL", 4.86, LocalDateTime.now()));
		dl.add(new DebtItem("MTL", 10.15, LocalDateTime.now()));
		dl.add(new DebtItem("Boba", 2.34, LocalDateTime.now()));

		System.out.println(dl.toString());

		dl.add(new DebtItem("Tea", -10.86, LocalDateTime.now()));
		dl.add(new DebtItem("Lunch", 0, LocalDateTime.now()));

		System.out.println(dl.toString());
	}
}
