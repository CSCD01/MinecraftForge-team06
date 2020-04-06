package net.minecraftforge.plants;

import java.util.List;

import net.minecraftforge.common.PlantType;

public interface IFertilizer
{
    List<PlantType> getValidPlantTypes();
    float getPotency();
}
