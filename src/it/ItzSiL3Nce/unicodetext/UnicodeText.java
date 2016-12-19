package it.ItzSiL3Nce.unicodetext;

import it.ItzSiL3Nce.unicodetext.configuration.Config;
import it.ItzSiL3Nce.unicodetext.listeners.AsyncPlayerChatListener;
import it.ItzSiL3Nce.unicodetext.listeners.PlayerCommandPreprocessListener;
import it.ItzSiL3Nce.unicodetext.listeners.SignChangeListener;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class UnicodeText extends JavaPlugin {

	@Override
	public void onEnable() {
		Config.init(this);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new AsyncPlayerChatListener(), this);
		pm.registerEvents(new SignChangeListener(), this);
		pm.registerEvents(new PlayerCommandPreprocessListener(), this);
		getLogger().info("Enabled.");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Disabled.");
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command,
			String alias, String[] args, Location location) {
		return null;
	}
	
	public static final String getUnicodeString(String in) {
		return UnicodeString.unescapeJava(in);
	}
}
