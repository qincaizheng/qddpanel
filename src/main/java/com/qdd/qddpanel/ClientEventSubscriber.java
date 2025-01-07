package com.example.mysupermod;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEventSubscriber
{
    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Pre event)
    {
        // 处理渲染事件，显示自定义信息
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            MySuperMod.renderPlayerInventoryData(event.getResolution());
            MySuperMod.renderCustomInfo(event.getResolution());
        }
    }
}
