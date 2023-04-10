import Entities.Client;
import Entities.DebtList;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ClientCmdTest {

	static JDA jda;

	Client client;


	@BeforeAll
	static void setUp() {
		jda = JDABuilder
				.createDefault("MTA5NDAzOTMxODk5NTE1MzAwOA.GvzcI3.aB5l0CIRAAAwov_XRPMOMgQOF6Rv4CNKUxjZo8")
				.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES)
				.build();


	}

	@BeforeEach
	void init() {
		client = new Client("Gautam", new DebtList(), jda.retrieveUserById("683835438091599904").complete());
	}

	@DisplayName("toString")
	@Test
	void ToString() {
		System.out.println(client);
	}

}
