package me.bubbles.teleportmod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void init() {
        // Shaped Recipe
        GameRegistry.addRecipe(new ItemStack(ModItems.coordinateCache, 1), "gpg", "pep", "gpg", 'g', new ItemStack(Items.gold_ingot), 'p', new ItemStack(Items.ender_pearl), 'e', new ItemStack(Items.ender_eye));
    }
}
