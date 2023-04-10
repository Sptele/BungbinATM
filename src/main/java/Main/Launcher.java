package Main;

import Commands.ClientCmd;
import Commands.Debt;
import Commands.Info;
import Commands.Ping;
import Entities.Client;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.ArrayList;

public class Launcher {
	//MTA5NDAzOTMxODk5NTE1MzAwOA.GvzcI3.aB5l0CIRAAAwov_XRPMOMgQOF6Rv4CNKUxjZo8

	public static JDA jda;
	public static ArrayList<Client> debtors = new ArrayList<>();

	public static void main(String[] args) {

		try {
			CommandClientBuilder cmds = new CommandClientBuilder()
					.forceGuildOnly("793699267872423956")
					.setOwnerId("683835438091599904")
					// Commands
					.addSlashCommand(new Ping())
					.addSlashCommand(new Info())
					.addSlashCommand(new Debt())
					.addSlashCommand(new ClientCmd());

			jda = JDABuilder
					.createDefault("MTA5NDAzOTMxODk5NTE1MzAwOA.GvzcI3.aB5l0CIRAAAwov_XRPMOMgQOF6Rv4CNKUxjZo8")
					.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES)
					.addEventListeners(cmds.build())
					.build();

			debtors.add(new Client("Gautam", jda.retrieveUserById("683835438091599904").complete()));
			debtors.add(new Client("Yoonjo", jda.retrieveUserById("683835438091599904").complete()));
			debtors.add(new Client("Justin", jda.retrieveUserById("683835438091599904").complete()));


			jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("your money"));
			jda.awaitReady();
		} catch (InterruptedException e) {
			System.err.println("Unable to start the bot!");
		}
	}
}
