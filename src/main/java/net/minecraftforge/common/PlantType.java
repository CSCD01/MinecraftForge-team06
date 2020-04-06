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

package net.minecraftforge.common;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.regex.Pattern;

public final class PlantType
{
    private static final Pattern VALID_NAME = Pattern.compile("[^a-z_]"); //Only a-z and _ are allowed, meaning names must be lower case. And use _ to separate words.
    private static final Map<String, PlantType> values = Maps.newHashMap();

    public static final PlantType Plains = get("plains");
    public static final PlantType Desert = get("desert");
    public static final PlantType Beach = get("beach");
    public static final PlantType Cave = get("cave");
    public static final PlantType Water = get("water");
    public static final PlantType Nether = get("nether");
    public static final PlantType Crop = get("crop");

    public static PlantType get(String name)
    {
        if (VALID_NAME.matcher(name).find())
            throw new IllegalArgumentException("PlantType.get() called with invalid name: " + name);
        return values.computeIfAbsent(name, k -> new PlantType(name));
    }

    private final String name;

    private PlantType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
