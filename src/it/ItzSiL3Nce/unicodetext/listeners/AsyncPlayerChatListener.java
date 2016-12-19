package it.ItzSiL3Nce.unicodetext.listeners;

import it.ItzSiL3Nce.unicodetext.UnicodeText;
import it.ItzSiL3Nce.unicodetext.configuration.Config;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

	@EventHandler(priority = EventPriority.LOW)
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(p.isOp() || p.hasPermission("unicodetext.chat") || p.hasPermission("unicodetext.*")){
			if(Config.chatEnabled())
			{
				e.setMessage(UnicodeText.getUnicodeString(e.getMessage()));
				e.setFormat(UnicodeText.getUnicodeString(e.getFormat()));
			}
		}
	}
}
