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

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.Validate;

@Mod(FlowerPlantTest.MODID)
@Mod.EventBusSubscriber
public class FlowerPlantTest
{
    static final String MODID = "flower_plant_test";

    /***
     * This test method is triggered when a flower is placed on a surface in the game. It will check to make sure
     * that it has been placed on valid ground, i.e., dirt or grass.
     * @param event the event in which this method is listening on, i.e., the event in which an entity places a flower
     */
    @SubscribeEvent
    public static void onFlowerPlanted(BlockEvent.EntityPlaceEvent event) {
        Block plantBlock = event.getPlacedBlock().getBlock();

        // Check to see if the block placed was a flower
        if(plantBlock == Blocks.SUNFLOWER || plantBlock == Blocks.PEONY || plantBlock == Blocks.LILAC
                || plantBlock == Blocks.POPPY || plantBlock == Blocks.OXEYE_DAISY || plantBlock == Blocks.LILY_OF_THE_VALLEY){

            // Check to see that the flower was placed on valid ground (dirt or grass)
            Block plantOn = event.getPlacedAgainst().getBlock();
            Validate.isTrue(plantOn == Blocks.DIRT || plantOn == Blocks.GRASS_BLOCK);
        }
    }
}