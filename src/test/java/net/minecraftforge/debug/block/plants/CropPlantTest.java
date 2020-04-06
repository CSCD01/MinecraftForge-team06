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

@Mod(CropPlantTest.MODID)
@Mod.EventBusSubscriber
public class CropPlantTest
{
    static final String MODID = "crop_plant_test";

    /***
     * This test method is triggered when a flower is placed on a surface in the game. It will check to make sure
     * that it has been placed on valid ground, i.e., dirt or grass.
     * @param event the event in which this method is listening on, i.e., the event in which an entity places a flower
     */
    @SubscribeEvent
    public static void onCropPlanted(BlockEvent.EntityPlaceEvent event) {
        Block plantBlock = event.getPlacedBlock().getBlock();

        // Check to see if the block placed was a crop block
        if(plantBlock == Blocks.WHEAT || plantBlock == Blocks.BEETROOTS || plantBlock == Blocks.CARROTS
                || plantBlock == Blocks.POTATOES || plantBlock == Blocks.MELON_STEM)
        {

            // Check to see that the crop was placed on valid ground (dirt or grass)
            Block plantOn = event.getPlacedAgainst().getBlock();
            Validate.isTrue(plantOn == Blocks.FARMLAND);

         // Otherwise, if it's sugar cane, check to see that it was planted on its valid ground (different from farmland)
        } else if(plantBlock == Blocks.SUGAR_CANE)
        {
            Block plantOn = event.getPlacedAgainst().getBlock();
            Validate.isTrue(plantOn == Blocks.SAND);
        }
    }
}