package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import utils.Command;

public class CoinCommand extends Command {

	public CoinCommand(){
		HELP = new String("USAGE: &coin for one flip\nUSAGE: &coin {int} for multiple flips");
	}
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		boolean ret = true;
		if(args.length == 0) return true;
		try {
			if(Integer.parseInt(args[0]) < 1) ret = false;
		} catch(NumberFormatException e) {
			ret = false;
		}
		if(!ret) event.getChannel().sendMessage(help()).queue();
		return ret;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		int numFlips = 1;
		try {
			if(args.length == 1) numFlips = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String text = new String();
		byte flip;
		for (int i = 0; i < numFlips; i++) {
			flip = (byte) (2 * Math.random());
			if (flip == 0) text += "Heads ";
			else text += "Tails ";
		}
		event.getChannel().sendMessage(text).queue();
	}
	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		return;
	}

}
