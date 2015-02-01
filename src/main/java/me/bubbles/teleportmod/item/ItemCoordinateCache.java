package me.bubbles.teleportmod.item;

import me.bubbles.teleportmod.reference.Key;
import me.bubbles.teleportmod.utility.IKeyBound;
import me.bubbles.teleportmod.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCoordinateCache extends ItemTP implements IKeyBound {
    private boolean hasNBT = false;

    public ItemCoordinateCache() {
        super();
        this.setUnlocalizedName("coordinateCache");
        this.setMaxStackSize(hasNbt(hasNBT));
    }

    private int hasNbt(boolean hasNBT) {
        if(hasNBT) {
            return 1;
        } else {
            return 64;
        }
    }


    @Override
    public void doKeyBindingAction(EntityPlayer entityPlayer, ItemStack itemStack, Key key) {
        LogHelper.info(String.format("%s %s %s", entityPlayer.toString(), itemStack.toString(), key.toString()));
    }
}
