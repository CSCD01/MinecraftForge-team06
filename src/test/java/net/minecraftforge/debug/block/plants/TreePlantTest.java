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

import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.Validate;

@Mod(TreePlantTest.MODID)
@Mod.EventBusSubscriber
public class TreePlantTest
{
    static final String MODID = "tree_plant_test";

    /***
     * This test method is triggered when bonemeal is used on a sapling and checks to see that bonemeal can still be
     * applied to a sapling. This will cover any sort of vanilla tree sapling growth.
     * @param event the event in which this method is listening on, i.e., the event in which an entity uses bonemeal
     *              on a sapling block.
     */
    @SubscribeEvent
    public static void onBonemealUsedOnSapling(SaplingGrowTreeEvent event) {
        Validate.isTrue(event.getResult().equals(Event.Result.DEFAULT) || event.getResult().equals(Event.Result.ALLOW));
    }

}