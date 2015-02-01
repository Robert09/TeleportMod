package me.bubbles.teleportmod.creativetab;

import me.bubbles.teleportmod.init.ModItems;
import me.bubbles.teleportmod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabTM {
    public static final CreativeTabs TM_TAB = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return ModItems.coordinateCache;
        }

        @Override
        public String getTranslatedTabLabel() {
            return "Teleport Mod";
        }
    };
}
