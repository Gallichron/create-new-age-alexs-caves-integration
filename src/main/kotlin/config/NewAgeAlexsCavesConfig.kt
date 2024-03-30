package com.gallichron.newagealexscaves.config

import net.minecraftforge.common.ForgeConfigSpec

@Suppress("unused")
object NewAgeAlexsCavesConfig {
    private val builder = ForgeConfigSpec.Builder()

    private val newAgeRadiationChance: ForgeConfigSpec.ConfigValue<Double>
    private val newAgeMaxRadiationAmplifier: ForgeConfigSpec.ConfigValue<Int>

    val spec: ForgeConfigSpec

    val getNewAgeRadiationChance: Float get() = newAgeRadiationChance.get().toFloat()
    val getNewAgeMaxRadiationAmplifier: Int get() = newAgeMaxRadiationAmplifier.get().toInt()

    init {
        builder.push("radiation")
        newAgeRadiationChance =
            builder.comment(
                "Chance per tick (can be between 0 and 1) that living entities are irradiated by radiation created " +
                    "by the Create: New Age mod.",
            )
                .translation("new_age_radiation_chance")
                .defineInRange("new_age_radiation_chance", 0.01375, 0.0, 1.0)
        newAgeMaxRadiationAmplifier =
            builder.comment("Max severity of irradiated effect (0 is Irradiated, 3 is Irradiated IV)")
                .translation("new_age_max_radiation_amplifier")
                .defineInRange("new_age_max_radiation_amplifier", 2, 0, 3)
        builder.pop()
        spec = builder.build()
    }
}
