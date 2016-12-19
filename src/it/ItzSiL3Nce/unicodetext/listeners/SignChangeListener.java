package it.ItzSiL3Nce.unicodetext.listeners;

import it.ItzSiL3Nce.unicodetext.UnicodeText;
import it.ItzSiL3Nce.unicodetext.configuration.Config;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChangeListener implements Listener {

	@EventHandler(priority = EventPriority.LOW)
	public void onSignChange(SignChangeEvent e) {
		Player p = e.getPlayer();
		if(p.isOp() || p.hasPermission("unicodetext.sign") || p.hasPermission("unicodetext.*")){
			if(Config.signEnabled())
			{
				    // I don't put just 3 because... what if in the future they change the lines amount :o
				for(int i = 0; i < e.getLines().length; i++) {
					if(e.getLine(i) != null && !e.getLine(i).isEmpty())
						e.setLine(i, UnicodeText.getUnicodeString(e.getLine(i)));
				}
			}
		}
	}
}
