package me.eru.nukkit.banitem;

import java.util.ArrayList;
import java.util.List;

import cn.nukkit.plugin.PluginBase;

public class BanItem extends PluginBase {

	public static final String PLUGIN_VERSION = "0.1-beta";

	public boolean ignoreOp = false;
	public List<Integer> banplaceList = new ArrayList<>();
	public List<Integer> banheldList = new ArrayList<>();

	@Override
	public void onEnable() {
		this.getLogger().info("BanItem " + PLUGIN_VERSION + " loaded.");

		this.saveDefaultConfig();
		ignoreOp = this.getConfig().getBoolean("ignoreOp");
		banplaceList = this.getConfig().getIntegerList("place");
		banheldList = this.getConfig().getIntegerList("held");

		this.getServer().getPluginManager().registerEvents(new ItemListener(this), this);
	}

	@Override
	public void onDisable() {

	}

}
