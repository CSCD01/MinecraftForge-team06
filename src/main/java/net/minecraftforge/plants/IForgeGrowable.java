package net.minecraftforge.plants;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public interface IForgeGrowable
{
    boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient);

    boolean canUseFertilizer(World worldIn, Random rand, BlockPos pos, BlockState state, IFertilizer fertilizer);

    void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state, IFertilizer fertilizer);
}
