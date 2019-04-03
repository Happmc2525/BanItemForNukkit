package me.eru.nukkit.banitem;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.player.PlayerItemHeldEvent;

public class ItemListener implements Listener {

	private BanItem instance;
	public ItemListener(BanItem i) {
		instance = i;
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(instance.ignoreOp && p.isOp()) {
			return;
		}

		if(instance.banplaceList.contains(e.getBlock().getId())) {
			e.setCancelled();
		}
	}

	@EventHandler
	public void onHeld(PlayerItemHeldEvent e) {
		Player p = e.getPlayer();
		if(instance.ignoreOp && p.isOp()) {
			return;
		}

		if(instance.banplaceList.contains(e.getItem().getId())) {
			e.setCancelled();
			//p.scheduleUpdate();
		}
	}

}
