package de.basicbit.system.minecraft.crafting.recipes.tools.iron;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import de.basicbit.system.minecraft.crafting.CraftingSystem;
import de.basicbit.system.minecraft.crafting.recipes.SuperIron;

@SuppressWarnings("all")
public class IronShovel extends ShapedRecipe {
    
    public IronShovel() {
        super(get());
        shape(
            " G ",
            " A ",
            "   "
        );

        CraftingSystem.set(this, 'A', new ItemStack(256, 1));
        CraftingSystem.set(this, 'G', SuperIron.get(1));
    }

    public static ItemStack get() {
        ItemStack is = new ItemStack(Material.IRON_SPADE, 1);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§r§h§r§b§lMagische-Eisen-Schaufel");
        ArrayList l = new ArrayList<String>();
        l.add("§r");
        l.add("§f-----------------§6§l Effekt §f-----------------");
        l.add("§eDroppt Clay, Erde und Sand direkt in dein Inventar.");
        l.add("§r");
        im.setLore(l);
        is.setItemMeta(im);
        is.addUnsafeEnchantment(Enchantment.getById(34), 3);
        is.addUnsafeEnchantment(Enchantment.getById(32), 3);
        return is;
    }

}