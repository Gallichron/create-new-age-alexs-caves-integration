@file:Suppress("unused", "HasPlatformType")

package com.gallichron.newagealexscaves.init

import com.gallichron.newagealexscaves.MODID
import com.gallichron.newagealexscaves.blocks.ExampleBlock
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object BlockItemRegistry {

    private val BLOCK_ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MODID)

    fun register(bus: IEventBus) = BLOCK_ITEMS.register(bus)

    // ==================== //
    //      Block Items     //
    // ==================== //

    val EXAMPLE_BLOCK: BlockItem
            by BLOCK_ITEMS.registerObject("example_block") { BlockItem(ExampleBlock, Item.Properties()) }

}