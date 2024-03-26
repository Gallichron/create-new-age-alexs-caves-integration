package com.gallichron.newagealexscaves

import com.gallichron.newagealexscaves.init.BlockItemRegistry
import com.gallichron.newagealexscaves.init.BlockRegistry
import com.gallichron.newagealexscaves.init.ItemRegistry
import com.gallichron.newagealexscaves.keybind.KeyBindHandler.registerKeybindings
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS

const val MODID = "newagealexscaves"

@Mod(MODID)
object newagealexscaves {

    val LOGGER: Logger = LogManager.getLogger("newagealexscaves")

    init {
        LOGGER.log(Level.INFO, "$MODID has started!")

        MOD_BUS.addListener(::onClientSetup)

        ItemRegistry.register(MOD_BUS)
        BlockRegistry.register(MOD_BUS)
        BlockItemRegistry.register(MOD_BUS)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client... with newagealexscaves!")
        MOD_BUS.addListener(::registerKeybindings)
    }

}