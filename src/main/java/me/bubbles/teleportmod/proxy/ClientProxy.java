package me.bubbles.teleportmod.proxy;

import me.bubbles.teleportmod.client.settings.KeyBindings;
import me.bubbles.teleportmod.init.ModBlocks;
import me.bubbles.teleportmod.init.ModItems;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

    @Override
    public void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(KeyBindings.get_coordinates);
    }
}
