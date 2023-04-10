package Entities;


import Main.StringUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Client {
	private String name;
	private DebtList debtList = new DebtList();
	private User discord;

	public Client(String name, DebtList debtList, User discord) {
		this.name = name.toLowerCase();
		this.debtList = debtList;
		this.discord = discord;
	}

	public Client(String name, User discord) {
		this.name = name.toLowerCase();
		this.discord = discord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public DebtList getDebtList() {
		return debtList;
	}

	public void setDebtList(DebtList debtList) {
		this.debtList = debtList;
	}

	public User getDiscord() {
		return discord;
	}

	public void setDiscord(User discord) {
		this.discord = discord;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Client client = (Client) o;

		if (!Objects.equals(name, client.name)) return false;
		if (!Objects.equals(debtList, client.debtList)) return false;
		return Objects.equals(discord, client.discord);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (debtList != null ? debtList.hashCode() : 0);
		result = 31 * result + (discord != null ? discord.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s (%s): $%05.2f", name, discord.getAsMention(), debtList.total());
	}

	public MessageEmbed toEmbed() {
		EmbedBuilder eb = new EmbedBuilder()
				.setTitle(StringUtils.toCapitalCase(name) + " (" + discord.getAsTag() + ")")
				.setColor(Color.GREEN)
				.addField("Mention", discord.getAsMention(), false)
				.addField("Total Debt: $" + debtList.total(), debtList.toString(), false);

		if (!debtList.isEmpty())
			eb.setDescription("Began Banking with Bungbin Corp. on "
					+ debtList.get(0).getTimestamp().format(DateTimeFormatter.ofPattern("MMMM d, yyyy 'at' kk:mm")) + ".");
		else
			eb.setDescription("No transactions on record.");

		return eb.build();
	}
}
