package me.bubbles.teleportmod.network.message;

import io.netty.buffer.ByteBuf;
import me.bubbles.teleportmod.reference.Key;
import me.bubbles.teleportmod.utility.IKeyBound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageKeyPressed implements IMessage, IMessageHandler<MessageKeyPressed, IMessage> {
    private byte keyPressed;

    public MessageKeyPressed()
    {
    }

    public MessageKeyPressed(Key key) {
        if (key == Key.GET_COORDINATES) {
            this.keyPressed = (byte) Key.GET_COORDINATES.ordinal();
        } else {
            this.keyPressed = (byte) Key.UNKOWN.ordinal();
        }
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.keyPressed = buf.readByte();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeByte(keyPressed);
    }

    @Override
    public IMessage onMessage(MessageKeyPressed message, MessageContext ctx) {
        EntityPlayer entityPlayer = ctx.getServerHandler().playerEntity;

        if (entityPlayer != null && entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem().getItem() instanceof IKeyBound) {
            if (message.keyPressed == Key.GET_COORDINATES.ordinal()) {
                ((IKeyBound) entityPlayer.getCurrentEquippedItem().getItem()).doKeyBindingAction(entityPlayer, entityPlayer.getCurrentEquippedItem(), Key.GET_COORDINATES);
            }
        }

        return null;
    }
}
