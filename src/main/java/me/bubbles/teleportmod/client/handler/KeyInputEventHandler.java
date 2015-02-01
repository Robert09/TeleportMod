package me.bubbles.teleportmod.client.handler;

import me.bubbles.teleportmod.client.settings.KeyBindings;
import me.bubbles.teleportmod.network.PacketHandler;
import me.bubbles.teleportmod.network.message.MessageKeyPressed;
import me.bubbles.teleportmod.reference.Key;
import me.bubbles.teleportmod.utility.IKeyBound;
import me.bubbles.teleportmod.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler {
    private static Key getPressedKeybinding() {
        if (KeyBindings.get_coordinates.isPressed()) {
            return Key.GET_COORDINATES;
        }

        return Key.UNKOWN;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        if (getPressedKeybinding() == Key.UNKOWN) {
            return;
        }

        if (FMLClientHandler.instance().getClient().inGameHasFocus) {
            if (FMLClientHandler.instance().getClientPlayerEntity() != null) {
                EntityPlayer entityPlayer = FMLClientHandler.instance().getClientPlayerEntity();

                if (entityPlayer.getCurrentEquippedItem() != null) {
                    ItemStack currentlyEquippedItemStack = entityPlayer.getCurrentEquippedItem();

                    if (currentlyEquippedItemStack.getItem() instanceof IKeyBound) {
                        if (entityPlayer.worldObj.isRemote) {
                            PacketHandler.INSTANCE.sendToServer(new MessageKeyPressed(getPressedKeybinding()));
                        } else {
                            ((IKeyBound) currentlyEquippedItemStack.getItem()).doKeyBindingAction(entityPlayer, currentlyEquippedItemStack, getPressedKeybinding());
                        }
                    }
                }
            }
        }
    }
}
