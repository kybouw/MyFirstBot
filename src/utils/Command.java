package utils;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract class Command {
	protected String HELP;
	/**
	 * Was this command called correctly? Are the arguments valid?
	 * @param args array of args passed to the command
	 * @param event raw event from JDA
	 * @return true when the command was correctly called, false if there is an error in the call
	 */
	public abstract boolean called(String[] args, MessageReceivedEvent event);
	
	/**
	 * The action that the command performs
	 * @param args array of args passed to the command
	 * @param event raw event from JDA
	 */
	public abstract void action(String[] args, MessageReceivedEvent event);
	public String help() {
		return HELP;
	}
	
	/**
	 * Run after a command is called and/or run. Is called whether the command ran or not.
	 * @param success output from this.called(), true if the command ran, false if there was an error
	 * @param event raw event from JDA
	 */
	public abstract void executed(boolean success, MessageReceivedEvent event);
}
