package de.basicbit.system.minecraft.crafting.listeners;

import de.basicbit.system.minecraft.Listener;

public class ColorChestListener extends Listener {

    /*public static void init() {
        TaskManager.runAsyncLoop("ColorHelmetUpdate", new Runnable() {

            @Override
            public void run() {
                for (Player p : getPlayers()) {
                    updateTickAsync(p);
                }
            }

        }, 1);
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            ItemStack itemStack = p.getItemInHand();
            if (itemStack != null) {
                if (itemStack.getTypeId() == 298) {
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    if (itemMeta != null) {
                        String name = itemMeta.getDisplayName();
                        if (name.startsWith("§r§l§r")) {
                            Gui.open(p, new Gui("§8Farbe Wählen", 1) {

                                @Override
                                public void onInit(DynamicObject args) {
                                    this.setItemAt(1, 1, new ItemStack(351, 1, (short) 0), "§f§lSchwarz");
                                    this.setItemAt(2, 1, new ItemStack(351, 1, (short) 8), "§f§lGrau");
                                    this.setItemAt(3, 1, new ItemStack(351, 1, (short) 15), "§f§lWeiß");
                                    this.setItemAt(4, 1, new ItemStack(351, 1, (short) 3), "§f§lBraun");
                                    this.setItemAt(5, 1, new ItemStack(351, 1, (short) 1), "§f§lRot");
                                    this.setItemAt(6, 1, new ItemStack(351, 1, (short) 2), "§f§lGrün");
                                    this.setItemAt(7, 1, new ItemStack(351, 1, (short) 4), "§f§lBlau");

                                    this.setItemAt(1, 2, new ItemStack(351, 1, (short) 9), "§f§lRosa");
                                    this.setItemAt(2, 2, new ItemStack(351, 1, (short) 10), "§f§lNeon Grün");
                                    this.setItemAt(3, 2, new ItemStack(351, 1, (short) 11), "§f§lGelb");
                                    this.setItemAt(4, 2, new ItemStack(351, 1, (short) 14), "§f§lOrange");
                                    this.setItemAt(5, 2, new ItemStack(351, 1, (short) 13), "§f§lMagenta");
                                    this.setItemAt(6, 2, new ItemStack(351, 1, (short) 5), "§f§lLila");
                                    this.setItemAt(7, 2, new ItemStack(351, 1, (short) 6), "§f§lCyan");

                                    this.setBackgroundInAllPagesToGlassColor(15);
                                }

                                @Override
                                public DynamicObject onClick(DynamicObject args) {
                                    int slotX = args.getInt(Field.PLAYER_GUI_SLOT_POS_X);
                                    int slotY = args.getInt(Field.PLAYER_GUI_SLOT_POS_Y);
                                    if (slotY == 1) {
                                        switch (slotX) {
                                            case 1:
                                                ColorChestListener.setColor(Color.fromRGB(0x000000), p);
                                                break;
                                            case 2:
                                                ColorChestListener.setColor(Color.fromRGB(0x888888), p);
                                                break;
                                            case 3:
                                                ColorChestListener.setColor(Color.fromRGB(0xFFFFFF), p);
                                                break;
                                            case 4:
                                                ColorChestListener.setColor(Color.fromRGB(0x8B4513), p);
                                                break;
                                            case 5:
                                                ColorChestListener.setColor(Color.fromRGB(0xFF0000), p);
                                                break;
                                            case 6:
                                                ColorChestListener.setColor(Color.fromRGB(0x00FF00), p);
                                                break;
                                            case 7:
                                                ColorChestListener.setColor(Color.fromRGB(0x0040FF), p);
                                                break;
                                        }
                                    } else if (slotY == 2) {
                                        switch (slotX) {
                                            case 1:
                                                ColorChestListener.setColor(Color.fromRGB(0xEE82EE), p);
                                                break;
                                            case 2:
                                                ColorChestListener.setColor(Color.fromRGB(0x00f700), p);
                                                break;
                                            case 3:
                                                ColorChestListener.setColor(Color.fromRGB(0xFFFF00), p);
                                                break;
                                            case 4:
                                                ColorChestListener.setColor(Color.fromRGB(0xFF8800), p);
                                                break;
                                            case 5:
                                                ColorChestListener.setColor(Color.fromRGB(0xFF00FF), p);
                                                break;
                                            case 6:
                                                ColorChestListener.setColor(Color.fromRGB(0x551A8B), p);
                                                break;
                                            case 7:
                                                ColorChestListener.setColor(Color.fromRGB(0x00FFFF), p);
                                            break;
                                        }
                                    }
									return new DynamicObject();
								}
                                
                            }, 0);
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void setColor(Color color, Player p) {
        ItemStack itemStack = p.getItemInHand();
        if (itemStack != null) {
            if (itemStack.getTypeId() == 298) {
                ItemMeta itemMeta = itemStack.getItemMeta();
                if (itemMeta != null) {
                    String name = itemMeta.getDisplayName();
                    if (name.startsWith("§r§l§r")) {
                        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
                        leatherArmorMeta.setColor(color);
                        itemStack.setItemMeta(leatherArmorMeta);
                    }
                }
            }
        }
    }

    private static void updateTickAsync(Player p) {
        PlayerInventory inv = p.getInventory();
        ItemStack helmet = inv.getHelmet();

        if (helmet != null && helmet.hasItemMeta() && helmet.getItemMeta().hasDisplayName()) {
            String name = helmet.getItemMeta().getDisplayName();
            if (name.startsWith("§r§l§r") && helmet.getItemMeta() instanceof LeatherArmorMeta) {
                LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) helmet.getItemMeta();
                Location location = p.getLocation();
                float x = (float) location.getX();
                float y = (float) (location.getY() + p.getEyeHeight() + 0.5);
                float z = (float) location.getZ();
                Color color = leatherArmorMeta.getColor();
                float r = (color.getRed() / 255.F) - 1.F;
                float g = color.getGreen() / 255.F;
                float b = color.getBlue() / 255.F;

                for (Entity entity : getNearbyEntities(p, 20)) {
                    if (entity instanceof Player) {
                        Player t = (Player) entity;

                        Point3D center = new Point3D(x, y, z);
                        for (int yaw = 0; yaw < 360; yaw += 36) {
                            Point3D point = center.getDirectionPoint(yaw, 0, 1.0);
                            sendPacket(t, new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, point.getXFloat(), point.getYFloat(), point.getZFloat(), r, g, b, 1, 0));
                        }
                    }
                }

                Point3D center = new Point3D(x, y, z);
                for (int yaw = 0; yaw < 360; yaw += 36) {
                    Point3D point = center.getDirectionPoint(yaw, 0, 0.3);
                    sendPacket(p, new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, point.getXFloat(), point.getYFloat(), point.getZFloat(), r, g, b, 1, 0));
                }
            }
        }
    }

    public static ArrayList<Entity> getNearbyEntities(Entity e, double distance) {
        ArrayList<Entity> result = new ArrayList<Entity>();
        World w = e.getWorld();

        for (Entity en : w.getEntities()) {
            if (en.getEntityId() != e.getEntityId() && en.getLocation().distance(e.getLocation()) <= distance) {
                result.add(en);
            }
        }

        return result;
    }*/

}

