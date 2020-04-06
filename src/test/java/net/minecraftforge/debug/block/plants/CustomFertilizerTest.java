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

import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod(CustomFertilizerTest.MODID)
@Mod.EventBusSubscriber(bus = Bus.MOD)
public class CustomFertilizerTest
{
    static final String MODID = "custom_fertilizer_test";
    private static final String CUSTOM_FERTILIZER_ITEM = "test_custom_fert";

    @ObjectHolder(CUSTOM_FERTILIZER_ITEM)
    public static CustomFertilizer CUSTOM_FERTILIZER = new CustomFertilizer();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(CUSTOM_FERTILIZER);
    }

    /**
     * A custom fertilizer that's like bone meal but with 2 times the potency.
     */
    public static class CustomFertilizer extends BoneMealItem
    {
        public CustomFertilizer()
        {
            super(new Item.Properties());
            this.setRegistryName(MODID, CUSTOM_FERTILIZER_ITEM);
        }

        @Override
        public float getPotency() { return 2.0f; }
    }
}