package com.qdd.qddpanel.keybind;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyLoader {
    public static KeyBinding ninjainfo;

    public KeyLoader()
    {
        KeyLoader.ninjainfo = new KeyBinding("key.qddpanel.ninjainfo", Keyboard.KEY_K, "key.categories.qddpanel");

        ClientRegistry.registerKeyBinding(KeyLoader.ninjainfo);
    }
}
