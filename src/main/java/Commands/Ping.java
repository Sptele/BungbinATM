package Commands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;

public class Ping extends SlashCommand {

	public Ping() {
		this.name = "ping";
		this.help = "Performs a ping to check the bot's latency";
	}

	@Override
	protected void execute(SlashCommandEvent event) {
		event.reply("Pong!").queue();
	}
}
