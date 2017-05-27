package core;

import java.util.HashMap;

import commands.PingCommand;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import utils.BotParser;
import utils.Command;

public class Bot {

	private static JDA jda;
	public static HashMap<String, Command> commands = new HashMap<String, Command>();
	public static final BotParser parser = new BotParser();
	
	public Bot() {
		try {
			jda = new JDABuilder(AccountType.BOT).setToken(utils.Constants.TOKEN).addEventListener(new BotListener()).buildBlocking();
			jda.setAutoReconnect(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jda.getTextChannelsByName("bot", true).get(0);
		commands.put("ping", new PingCommand());
	}

	public static void main(String[] args) {
		new Bot();
	}

	public static void handleCommand(BotParser.CommandContainer cmd, MessageReceivedEvent event) {
		if(commands.containsKey(cmd.invoke)) {
			boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
			
			if(safe){
				commands.get(cmd.invoke).action(cmd.args, cmd.event);
				commands.get(cmd.invoke).executed(safe, cmd.event);
			} else {
				commands.get(cmd.invoke).executed(safe, cmd.event);
			}
		}
	}

}
