package com.gallichron.newagealexscaves.blocks


import net.minecraft.world.level.block.Block

object ExampleBlock : Block(
    Properties
        .of()
        .instabreak()
        .friction(10f)
)