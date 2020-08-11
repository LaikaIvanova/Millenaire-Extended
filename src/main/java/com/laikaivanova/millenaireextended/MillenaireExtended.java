package com.laikaivanova.millenaireextended;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.laikaivanova.millenaireextended.common.ContentDeployer;
import com.laikaivanova.millenaireextended.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MillenaireExtended.MODID, name = MillenaireExtended.NAME, version = MillenaireExtended.VERSION, dependencies = MillenaireExtended.DEPENDENCIES)
public class MillenaireExtended
{
    public static final String MODID = "millenaireextended";
    public static final String NAME = "Millénaire Extended";
    public static final String VERSION = "1.4.0";
    public static final Logger LOGGER = LogManager.getLogger((String)"millenaire");
    public static final String DEPENDENCIES = "before:millenaire";
    public static final String CLIENT_PROXY_CLASS = "com.laikaivanova.millenaireextended.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.laikaivanova.millenaireextended.proxy.CommonProxy";
    private static Logger logger;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        ContentDeployer.deployContent(event.getSourceFile());
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    
}
