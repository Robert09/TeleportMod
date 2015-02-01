package me.bubbles.teleportmod.init;

import me.bubbles.teleportmod.block.BlockTP;
import me.bubbles.teleportmod.block.BlockTeleporter;
import me.bubbles.teleportmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
    public static BlockTP teleporter = new BlockTeleporter();

    public static void init() {
        GameRegistry.registerBlock(teleporter, teleporter.getUnlocalizedName().substring(5));
    }

    public static void registerRenders() {
        registerRender(teleporter);
    }

    public static void registerRender(BlockTP block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
