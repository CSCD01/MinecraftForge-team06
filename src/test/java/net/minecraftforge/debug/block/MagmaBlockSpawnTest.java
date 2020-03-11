package net.minecraftforge.debug.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MagmaBlock;
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

    /***
     * This test is triggered whenever an entity spawns into the game and checks to see that the canCreatureSpawn
     * method returns the right value for when something spawns of entity type null.
     * @param event the event that this method is listening on, i.e., the spawning of some entity.
     */
    @SubscribeEvent
    public static void onEntitySpawned(LivingSpawnEvent event)
    {

        // We make a check to see if canCreatureSpawn returns the right value if we pass it an entity type of null
        // We expect it to return false as per the changes to the method
        BlockPos currBlockPos = new BlockPos(event.getX(), event.getY(), event.getZ());
        IWorld world = event.getWorld();
        BlockState state = world.getBlockState(currBlockPos);
        EntitySpawnPlacementRegistry.PlacementType type = EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS;

        // pass null for the entity type and ensure we get false when we check to see if a creature can spawn on
        // a magma block
        MagmaBlock block = new MagmaBlock((Block.Properties) state.getProperties());
        Validate.isTrue(block.canEntitySpawn(state, world, currBlockPos, null));

    }

    /***
     * This test is triggered whenever an entity spawns into the game and checks to see that the canCreatureSpawn
     * method returns the right value for when something spawns of entity type ZOMBIE.
     * @param event the event that this method is listening on, i.e., the spawning of some entity.
     */
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

        // pass ZOMBIE for the entity type if it was a zombie that spawned and ensure we get true
        if(enti.getType() == EntityType.ZOMBIE)
        {
            MagmaBlock block = new MagmaBlock((Block.Properties) state.getProperties());
            Validate.isTrue(block.canEntitySpawn(state, world, currBlockPos, EntityType.ZOMBIE));
        }
    }
}
