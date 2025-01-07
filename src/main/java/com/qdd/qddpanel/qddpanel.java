package com.example.mysupermod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.ModEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = MySuperMod.MOD_ID, name = MySuperMod.MOD_NAME, version = MySuperMod.VERSION)
public class MySuperMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mysupermod";
    public static final String MOD_NAME = "My Super Mod";
    public static final String VERSION = "1.0.0";
    private static final Minecraft client = Minecraft.getMinecraft();

    // Initialize the mod
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static void clientSetup(FMLClientSetupEvent event)
    {
        // Example: Print to the log when the mod is initialized
        System.out.println(MOD_NAME + " is loaded!");
    }

    // Subscribe to client events to handle rendering
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ClientEventSubscriber
    {
        // Handle game overlay rendering
        @SubscribeEvent(priority = EventPriority.NORMAL)
        public static void onRenderGameOverlay(RenderGameOverlayEvent.Pre event)
        {
            if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
                renderPlayerInventoryData(event.getResolution());
                renderCustomInfo(event.getResolution());
            }
        }
    }

    // Example method to render custom text
    public static void renderCustomInfo(Object resolution)
    {
        String message = "Your custom data here!";
        client.fontRenderer.drawString(message, 10, 10);
    }

    // Example method to render inventory data (e.g., diamond count)
    public static void renderPlayerInventoryData(Object resolution)
    {
        int itemCount = 0;
        for (int i = 0; i < client.player.inventory.mainInventory.size(); i++) {
            if (client.player.inventory.mainInventory.get(i).getItem() == net.minecraft.init.Items.DIAMOND) {
                itemCount += client.player.inventory.mainInventory.get(i).getCount();
            }
        }

        String message = "Diamonds in inventory: " + itemCount;
        client.fontRenderer.drawString(message, 10, 30);
    }
}
