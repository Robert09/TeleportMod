package me.bubbles.teleportmod.init;

import me.bubbles.teleportmod.item.ItemCoordinateCache;
import me.bubbles.teleportmod.item.ItemTP;
import me.bubbles.teleportmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static final ItemTP coordinateCache = new ItemCoordinateCache();

    public static void init() {
        GameRegistry.registerItem(coordinateCache, coordinateCache.getUnlocalizedName().substring(5));
    }

    public static void registerRenders() {
        registerRender(coordinateCache);
    }

    public static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
