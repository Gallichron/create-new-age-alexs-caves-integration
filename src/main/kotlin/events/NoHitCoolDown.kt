package com.gallichron.newagealexscaves.events

import com.gallichron.newagealexscaves.MODID
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
object NoHitCoolDown {

    @SubscribeEvent
    fun noHitCoolDown(event: LivingAttackEvent) {
        event.entity.invulnerableTime = 0
        event.entity.invulnerable = false
    }

}