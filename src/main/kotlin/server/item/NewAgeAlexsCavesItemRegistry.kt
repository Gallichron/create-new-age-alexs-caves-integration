package com.gallichron.newagealexscaves.server.item

import com.gallichron.newagealexscaves.MODID
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

@Suppress("unused")
object NewAgeAlexsCavesItemRegistry {
    private val newAgeAlexsCavesItems: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MODID)

    fun register(bus: IEventBus) = newAgeAlexsCavesItems.register(bus)

    // Items
    val INCOMPLETE_URANIUM_ROD: RegistryObject<SequencedAssemblyItem> =
        newAgeAlexsCavesItems.register(
            "incomplete_uranium_rod",
        ) { SequencedAssemblyItem(Item.Properties()) }
}
