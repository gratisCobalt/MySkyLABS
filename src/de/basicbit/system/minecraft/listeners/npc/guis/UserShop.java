package de.basicbit.system.minecraft.listeners.npc.guis;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import de.basicbit.system.minecraft.Listener;
import de.basicbit.system.minecraft.events.PlayerNPCRightClickEvent;
import de.basicbit.system.minecraft.npc.NPC;
import de.basicbit.system.minecraft.npc.NPCType;

public class UserShop extends Listener {
    
    @EventHandler
    public void onInteractAtNPC(PlayerNPCRightClickEvent e) {
        NPC npc = e.getNPC();
        Player p = e.getPlayer();

        if (npc.getType().equals(NPCType.UserShop)) {
            de.basicbit.system.minecraft.usershop.UserShop.openUserShop(p);
        }
    }
}