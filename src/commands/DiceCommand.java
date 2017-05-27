package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import utils.Command;

public class DiceCommand extends Command {

	public DiceCommand() {
		HELP = new String("USAGE: &dice for one roll\nUSAGE: &dice {int} for multiple rolls");
	}

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		boolean ret = true;
		if(args.length == 0) return true;
		try {if(Integer.parseInt(args[0]) < 1) ret = false;} 
		catch(NumberFormatException e) {ret = false;}
		if(!ret) event.getChannel().sendMessage(help()).queue();
		return ret;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		int numRolls = 1;
		try { if(args.length == 1) numRolls = Integer.parseInt(args[0]);} 
		catch(NumberFormatException e) {e.printStackTrace();}
		String text = new String();
		for (int i = 0; i < numRolls; i++) text += ((byte)(6*Math.random() + 1)) + " ";
		event.getChannel().sendMessage(text).queue();
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		return;
	}

}
