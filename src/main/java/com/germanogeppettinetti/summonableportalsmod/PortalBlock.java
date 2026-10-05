package com.germanogeppettinetti.summonableportalsmod;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public
class PortalBlock extends Block {
    public PortalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide) {
            ServerLevel serverLevel = (ServerLevel) level;
            Vec3 teleportPos = new Vec3(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
            entity.teleportTo(teleportPos.x, teleportPos.y, teleportPos.z);
            serverLevel.sendParticles(ParticleTypes.SMOKE, teleportPos.x, teleportPos.y, teleportPos.z, 10, 0.5, 0.5, 0.5, 0.1);
            level.playSound(null, pos, SummonablePortalsMod.PORTAL_SOUND, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }
}
