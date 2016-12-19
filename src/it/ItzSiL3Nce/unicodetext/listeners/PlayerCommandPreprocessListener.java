package it.ItzSiL3Nce.unicodetext.listeners;

import it.ItzSiL3Nce.unicodetext.UnicodeText;
import it.ItzSiL3Nce.unicodetext.configuration.Config;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocessListener implements Listener {

	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if(p.isOp() || p.hasPermission("unicodetext.command") || p.hasPermission("unicodetext.*")){
			if(Config.commandEnabled())
				e.setMessage(UnicodeText.getUnicodeString(e.getMessage()));
		}
	}
}

