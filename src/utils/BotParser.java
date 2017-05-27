package utils;

import java.util.ArrayList;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class BotParser {

	public CommandContainer parse(MessageReceivedEvent event) {
		String rw = event.getMessage().getContent().toLowerCase(), behead = rw.replaceFirst("&", "");
		ArrayList<String> split = new ArrayList<String>();
		String[] splitBehead = behead.split(" ");
		for(String i : splitBehead) split.add(i);
		String invoke = split.get(0);
		String[] args = new String[split.size() -1];
		split.subList(1, split.size()).toArray(args);
		
		return new CommandContainer(rw, behead, splitBehead, invoke, args, event);
		
	}
	
	public class CommandContainer
	{

		public final String raw;
		public final String behead;
		public final String[] splitBehead;
		public final String invoke;
		public final String[] args;
		public final MessageReceivedEvent event;
		
		public CommandContainer(String rw2, String behead, String[] splitBehead, String invoke, String[] args,
				MessageReceivedEvent event) {
			this.raw = rw2;
			this.behead = behead;
			this.splitBehead = splitBehead;
			this.invoke = invoke;
			this.args = args;
			this.event = event;
		}	
		
	}
}
