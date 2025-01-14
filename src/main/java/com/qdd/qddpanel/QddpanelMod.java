package com.qdd.qddpanel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;


@Mod(modid = QddpanelMod.MODID, name = QddpanelMod.NAME, version = QddpanelMod.VERSION, dependencies = "required-after:narutomod")
public class QddpanelMod {

    public static final String MODID = "qddpanel";
    public static final String NAME = "QDDPanel Mod";
    public static final String VERSION = "1.0.0";
    public static final SimpleNetworkWrapper PACKET_HANDLER = NetworkRegistry.INSTANCE.newSimpleChannel("qddpanel:a");
    @SidedProxy(clientSide = "com.qdd.qddpanel.ClientProxy", 
            serverSide = "com.qdd.qddpanel.CommonProxy")
    public static CommonProxy proxy;

    @Instance(QddpanelMod.MODID)
    public static QddpanelMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}