package Commands;

import Main.Launcher;
import Main.StringUtils;
import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Debt extends SlashCommand {

	public Debt() {
		this.name = "debt";
		this.help = "Manage the debt for (a) user(s)";

		this.children = new SlashCommand[] {new Add(), new Get()};
	}

	@Override
	protected void execute(SlashCommandEvent event) {}

	private static class Add extends SlashCommand {
		public Add() {
			this.name = "add";
			this.help = "Deposits money for a specific user";

			List<OptionData> options = new ArrayList<>();
			options.add(new OptionData(OptionType.STRING, "user", "The user to add for", true));
			options.add(new OptionData(OptionType.INTEGER, "amount", "The amount to add debt", true));
			this.options = options;
		}


		@Override
		protected void execute(SlashCommandEvent event) {
			int amount = event.getOption("amount").getAsInt();
			String name = event.getOption("user").getAsString();

			event.reply("Added $" + amount + " of debt for " + StringUtils.toCapitalCase(name) + "!").queue();
		}
	}

	private static class Get extends SlashCommand {
		public Get() {
			this.name = "get";
			this.help = "Gets the debt of the specified user";

			this.options = Collections.singletonList(new OptionData(OptionType.STRING, "user", "The required user", true));
		}

		@Override
		protected void execute(SlashCommandEvent event) {
			String user = event.getOption("user").getAsString();
//			event.reply(StringUtils.toCapitalCase(user) + " owes **$" + Launcher.map.get(user.toLowerCase()).toString() + "** of debt!").queue();
		}
	}
}
