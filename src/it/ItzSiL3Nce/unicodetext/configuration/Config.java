package it.ItzSiL3Nce.unicodetext.configuration;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Config {

	private static File f;
	
	public static final void init(JavaPlugin plugin) {
		if(plugin == null)
			throw new NullPointerException();
		f = new File(plugin.getDataFolder(), "config.yml");
		if(!f.exists())
			plugin.saveDefaultConfig();
	}
	
	private static final FileConfiguration a() {
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static final boolean signEnabled() {
		FileConfiguration fc = a();
		return fc.contains("Unicode Signs") && fc.getBoolean("Unicode Signs");
	}
	
	public static final boolean chatEnabled() {
		FileConfiguration fc = a();
		return fc.contains("Unicode Chat") && fc.getBoolean("Unicode Chat");
	}
	
	public static final boolean commandEnabled() {
		FileConfiguration fc = a();
		return fc.contains("Unicode Commands") && fc.getBoolean("Unicode Commands");
	}
}
