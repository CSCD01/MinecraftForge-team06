/*
 * Minecraft Forge
 * Copyright (c) 2016-2019.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.debug.block.plants;

import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.Validate;

@Mod(OtherPlantTest.MODID)
@Mod.EventBusSubscriber
public class OtherPlantTest
{
    static final String MODID = "other_plant_test";

    /***
     * This test method is triggered whenever a block is placed in the game.
     * @param event the event in which this method is listening on, i.e., the event in which an entity places a block
     */
    @SubscribeEvent
    public static void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {

        // Check to see if the Cactus/Bamboo sapling placed on a block was in the appropriate environment, i.e.,
        // the Cactus is on top of Sand and the bamboo sapling is on top of dirt
        if (event.getPlacedBlock().getBlock() == Blocks.CACTUS)
        {
            // ensure that the block can sustain the plant
            Validate.isTrue(event.getPlacedAgainst().canSustainPlant(event.getWorld(), event.getPos(), Direction.UP,
                    (IPlantable)Blocks.CACTUS));
        } else if (event.getPlacedBlock().getBlock() == Blocks.BAMBOO_SAPLING)
        {
            Validate.isTrue(event.getPlacedAgainst().getBlock() == Blocks.DIRT);
        }
    }
}