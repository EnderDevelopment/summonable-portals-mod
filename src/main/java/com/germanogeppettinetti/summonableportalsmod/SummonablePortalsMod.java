package com.germanogeppettinetti.summonableportalsmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public
class SummonablePortalsMod implements ModInitializer {
    public static final String MOD_ID = "summonableportalsmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Block PORTAL_BLOCK = new PortalBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).noCollission().strength(-1.0F, 3600000.0F));
    public static final Item PORTAL_ITEM = new BlockItem(PORTAL_BLOCK, new Item.Properties());
    public static final SoundEvent PORTAL_SOUND = SoundEvent.createVariableRangeEvent(new ResourceLocation(MOD_ID, "portal_sound"));

    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MOD_ID, "portal_block"), PORTAL_BLOCK);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, "portal_item"), PORTAL_ITEM);
        Registry.register(BuiltInRegistries.SOUND_EVENT, new ResourceLocation(MOD_ID, "portal_sound"), PORTAL_SOUND);
        LOGGER.info("Summonable Portals Mod initialized.");
    }
}
