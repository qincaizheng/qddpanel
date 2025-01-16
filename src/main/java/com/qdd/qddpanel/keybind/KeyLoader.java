package com.qdd.qddpanel.keybind;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyLoader {
    public static KeyBinding ninjainfo;

    public KeyLoader()
    {
        KeyLoader.ninjainfo = CreateKey("ninjainfo", Keyboard.KEY_K);
    }

    public static KeyBinding CreateKey(String name , int key){
        KeyBinding keybind = new KeyBinding("key.qddpanel."+name, Keyboard.KEY_K, "key.categories."+name);
        ClientRegistry.registerKeyBinding(keybind);
        return keybind;
    }
}