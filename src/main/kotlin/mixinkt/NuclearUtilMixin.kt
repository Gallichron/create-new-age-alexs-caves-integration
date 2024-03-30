package com.gallichron.newagealexscaves.mixinkt

import com.gallichron.newagealexscaves.config.NewAgeAlexsCavesConfig
import com.github.alexmodguy.alexscaves.AlexsCaves
import com.github.alexmodguy.alexscaves.server.item.HazmatArmorItem
import com.github.alexmodguy.alexscaves.server.message.UpdateEffectVisualityEntityMessage
import com.github.alexmodguy.alexscaves.server.potion.ACEffectRegistry
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player

val baseRadiationChance = NewAgeAlexsCavesConfig.getNewAgeBaseRadiationChance
val radiationWorseningChance = NewAgeAlexsCavesConfig.getNewAgeRadiationWorseningChance
val maxRadiationAmplifier = NewAgeAlexsCavesConfig.getNewAgeMaxRadiationAmplifier

fun nuclearUtilMixin(entity: LivingEntity) {
    val level = entity.level()
    if (!level.isClientSide() && !(entity is Player && entity.isCreative)) {
        val hazmatMultiplier = 1F - HazmatArmorItem.getWornAmount(entity) / 4F
        val irradiatedEffect = ACEffectRegistry.IRRADIATED.get()
        val amplifier = entity.getEffect(irradiatedEffect)?.amplifier ?: -1
        if (level.random.nextFloat() < (if (amplifier >= 0) radiationWorseningChance else baseRadiationChance) * hazmatMultiplier) {
            val effectAmplifier =
                when {
                    amplifier >= maxRadiationAmplifier -> amplifier
                    else -> amplifier + 1
                }
            val instance = MobEffectInstance(ACEffectRegistry.IRRADIATED.get(), 1800, effectAmplifier)
            entity.addEffect(instance)
            AlexsCaves.sendMSGToAll(UpdateEffectVisualityEntityMessage(entity.id, entity.id, 0, instance.duration))
        }
    }
}
