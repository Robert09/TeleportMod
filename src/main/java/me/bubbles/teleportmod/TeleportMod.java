package me.bubbles.teleportmod;

import me.bubbles.teleportmod.handler.ConfigurationHandler;
import me.bubbles.teleportmod.init.ModBlocks;
import me.bubbles.teleportmod.init.ModItems;
import me.bubbles.teleportmod.proxy.IProxy;
import me.bubbles.teleportmod.reference.Reference;
import me.bubbles.teleportmod.utility.LogHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class TeleportMod {

    @Mod.Instance(Reference.MOD_ID)
    public static TeleportMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        LogHelper.info("Pre Initialization complete!");

        ModItems.init();

        ModBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenders();
        LogHelper.info("Initialization complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) { LogHelper.info("Post Initialization complete!"); }
}
