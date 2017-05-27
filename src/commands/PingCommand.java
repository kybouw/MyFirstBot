package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import utils.Command;

public class PingCommand extends Command {

	public PingCommand(){
		HELP = new String("USAGE: &ping");
	}
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		event.getChannel().sendMessage("pong").queue();
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		return;

	}

}
