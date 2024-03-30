package com.gallichron.newagealexscaves

import com.gallichron.newagealexscaves.config.NewAgeAlexsCavesConfig
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS

const val MODID = "newagealexscaves"

@Mod(MODID)
object NewAgeAlexsCaves {
    val LOGGER: Logger = LogManager.getLogger("newagealexscaves")

    init {
        LOGGER.log(Level.INFO, "$MODID has started!")

        MOD_BUS.addListener(::onClientSetup)

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NewAgeAlexsCavesConfig.spec, "newagealexscaves.toml")
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client... with newagealexscaves!")
    }
}
