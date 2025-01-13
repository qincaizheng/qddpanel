package com.qdd.qddpanel.gui;

import com.qdd.qddpanel.QddpanelMod;
import com.qdd.qddpanel.gui.NinjaInfo;
import com.qdd.qddpanel.gui.GuiNinjaInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;


public class GuiElementLoader implements IGuiHandler
{
    public static final int GUI_DEMO = 1;

    public GuiElementLoader()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(QddpanelMod.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
        case GUI_DEMO:
            return new NinjaInfo(player);
        default:
            return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
        case GUI_DEMO:
            return new GuiNinjaInfo(new NinjaInfo(player));
        default:
            return null;
        }
    }
}