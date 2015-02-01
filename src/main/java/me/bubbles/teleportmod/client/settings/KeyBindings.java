package me.bubbles.teleportmod.client.settings;

import me.bubbles.teleportmod.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class KeyBindings {
    public static KeyBinding get_coordinates = new KeyBinding(Names.Keys.GET_COORDINATES, Keyboard.KEY_G, Names.Keys.CATEGORY);
}
