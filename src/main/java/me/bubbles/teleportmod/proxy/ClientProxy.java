package me.bubbles.teleportmod.proxy;

import me.bubbles.teleportmod.init.ModBlocks;
import me.bubbles.teleportmod.init.ModItems;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }
}
