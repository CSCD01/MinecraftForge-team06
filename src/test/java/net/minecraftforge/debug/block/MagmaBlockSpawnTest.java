package net.minecraftforge.debug.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.extensions.IForgeBlock;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.Validate;

@Mod(MagmaBlockSpawnTest.MODID)
public class MagmaBlockSpawnTest {

    static final String MODID = "magma_block_spawn_test";

    @SubscribeEvent
    public static void onEntitySpawned(LivingSpawnEvent event)
    {
        // We make a check to see if canCreatureSpawn returns the right value if we pass it an entity type of null
        // We expect it to return false as per the changes to the method
        BlockPos currBlockPos = new BlockPos(event.getX(), event.getY(), event.getZ());
        IWorld world = event.getWorld();
        BlockState state = world.getBlockState(currBlockPos);
        EntitySpawnPlacementRegistry.PlacementType type = EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS;
        Validate.isTrue(!((IForgeBlock)state).canCreatureSpawn(state, world, currBlockPos, type, null));
    }

    @SubscribeEvent
    public static void onZombieSpawned(LivingSpawnEvent event)
    {
        // We make a check to see if canCreatureSpawn returns the right value if we pass it an entity type of ZOMBIE
        // We expect it to return true as per the changes to the method
        BlockPos currBlockPos = new BlockPos(event.getX(), event.getY(), event.getZ());
        IWorld world = event.getWorld();
        BlockState state = world.getBlockState(currBlockPos);
        Entity enti = event.getEntity();
        EntitySpawnPlacementRegistry.PlacementType type = EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS;
        if(enti.getType() == EntityType.ZOMBIE)
        {
            Validate.isTrue(((IForgeBlock)state).canCreatureSpawn(state, world, currBlockPos, type, EntityType.ZOMBIE));
        }
    }
}
