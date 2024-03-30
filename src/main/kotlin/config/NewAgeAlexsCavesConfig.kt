package com.gallichron.newagealexscaves.config

import net.minecraftforge.common.ForgeConfigSpec

object NewAgeAlexsCavesConfig {
    private val builder = ForgeConfigSpec.Builder()

    private val newAgeBaseRadiationChance: ForgeConfigSpec.ConfigValue<Double>
    private val newAgeRadiationWorseningChance: ForgeConfigSpec.ConfigValue<Double>
    private val newAgeMaxRadiationAmplifier: ForgeConfigSpec.ConfigValue<Int>

    val spec: ForgeConfigSpec

    val getNewAgeBaseRadiationChance: Float get() = newAgeBaseRadiationChance.get().toFloat()
    val getNewAgeRadiationWorseningChance: Float get() = newAgeRadiationWorseningChance.get().toFloat()
    val getNewAgeMaxRadiationAmplifier: Int get() = newAgeMaxRadiationAmplifier.get().toInt()

    init {
        builder.push("radiation")
        newAgeBaseRadiationChance =
            builder.comment(
                "Chance per tick (can be between 0 and 1) that living entities are irradiated by radiation created " +
                    "by the Create: New Age mod.",
            )
                .translation("new_age_base_radiation_chance")
                .defineInRange("new_age_base_radiation_chance", 0.0625, 0.0, 1.0)
        newAgeRadiationWorseningChance =
            builder.comment(
                "Chance per tick (can be between 0 and 1) that a living entity's irradiated status worsens from " +
                    "prolonged exposure to radiation created by the Create: New Age mod.",
            )
                .translation("new_age_radiation_worsening_chance")
                .defineInRange("new_age_radiation_worsening_chance", 0.015625, 0.0, 1.0)
        newAgeMaxRadiationAmplifier =
            builder.comment(
                "Max severity of irradiated effect (0 is Irradiated, 3 is Irradiated IV) that can be inflicted by" +
                    "radiation from the Create: New Age mod.",
            )
                .translation("new_age_max_radiation_amplifier")
                .defineInRange("new_age_max_radiation_amplifier", 2, 0, 3)
        builder.pop()
        spec = builder.build()
    }
}
