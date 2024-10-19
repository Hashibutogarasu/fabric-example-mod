package karasu_lab.fabric_example.world;


import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModOrePlacement {
    /**
     * Returns a list of placement modifiers.
     * @param countModifier The count modifier
     * @param heightModifier The height modifier
     * @return {@link List} of {@link PlacementModifier}
     */
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    /**
     * Returns a list of placement modifiers with the given count and height modifier.
     * @param count The count of the modifier
     * @param heightModifier The height modifier
     * @return {@link List} of {@link PlacementModifier}
     */
    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    /**
     * Returns a list of placement modifiers with the given chance and height modifier.
     * @param chance The chance of the modifier
     * @param heightModifier The height modifier
     * @return {@link List} of {@link PlacementModifier}
     */
    public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
