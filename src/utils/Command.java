package utils;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract class Command {
	protected String HELP;
	public abstract boolean called(String[] args, MessageReceivedEvent event);
	public abstract void action(String[] args, MessageReceivedEvent event);
	public String help() {
		return HELP;
	}
	public abstract void executed(boolean success, MessageReceivedEvent event);
}
