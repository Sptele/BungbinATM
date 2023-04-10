package Commands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Info extends SlashCommand {
	public Info() {
		this.name = "info";
		this.help = "Information for paying Justin";
	}

	@Override
	protected void execute(SlashCommandEvent event) {
		EmbedBuilder eb = new EmbedBuilder()
				.setColor(Color.GREEN)
				.setTitle("Justin's Info and Payment Options")
				.addField("Justin", "Discord: <@541746500766662657>", false)
				.addField("Venmo", "@Justin-Lee-933", false)
				.addField("Cash Instructions", "Pay in USD, round up if >$0.50 and round down if <$0.50", true)
				.addField("Negative Values", "A negative debt means that Justin owes you", false);

		event.replyEmbeds(eb.build()).queue();
	}
}
