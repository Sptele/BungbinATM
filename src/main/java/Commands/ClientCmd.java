package Commands;

import Entities.Client;
import Main.Launcher;
import Main.StringUtils;
import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClientCmd extends SlashCommand {
	public ClientCmd() {
		this.name = "client";
		this.help = "Manage various clients";

		this.children = new SlashCommand[] { new Add(), new Get() };
	}

	@Override
	protected void execute(SlashCommandEvent event) {}

	private static class Add extends SlashCommand {
		public Add() {
			this.name = "add";
			this.help = "Adds a new client";

			List<OptionData> options = new ArrayList<>();
			options.add(new OptionData(OptionType.STRING, "name", "The name to refer to this user. Stored as lower-case.", true));
			options.add(new OptionData(OptionType.USER, "user", "The discord user for this user", true));

			this.options = options;
		}

		@Override
		protected void execute(SlashCommandEvent event) {
			Client c = new Client(event.getOption("name").getAsString(), event.getOption("user").getAsUser());
			Launcher.debtors.add(c);
			event.reply("Added " + StringUtils.toCapitalCase(c.getName()) + " as a debtor!").addEmbeds(c.toEmbed()).queue();
		}
	}

	private static class Get extends SlashCommand {
		public Get() {
			this.name = "get";
			this.help = "Gets a specific client";

			List<OptionData> options = new ArrayList<>();
			options.add(new OptionData(OptionType.USER, "user", "Mention of the user to retrieve information for.", false));
			options.add(new OptionData(OptionType.STRING, "name", "The string name of the user to retrieve information for.", false));

			this.options = options;
		}

		@Override
		protected void execute(SlashCommandEvent event) {
			if (event.getOptions().isEmpty()) {
				StringBuilder bd = new StringBuilder();

				Launcher.debtors.forEach(d -> bd.append(d.toString()).append('\n'));

				EmbedBuilder eb = new EmbedBuilder()
						.setColor(Color.GREEN)
						.setTitle("All Debtors")
						.addField("All Debtors", bd.toString(), false);

				event.replyEmbeds(eb.build()).queue();

				return;
			}

			Client user = Launcher.debtors.
		}
	}
}
