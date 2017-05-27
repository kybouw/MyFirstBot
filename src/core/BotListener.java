package core;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event){
		if(event.getMessage().getContent().startsWith("&") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId())
			Bot.handleCommand(Bot.parser.parse(event), event);
	}
}
