package karasu_lab.fabric_example.data;

import karasu_lab.fabric_example.block.ExampleBlocks;
import karasu_lab.fabric_example.item.ExampleItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ExampleBlocks.EXAMPLE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ExampleBlocks.EXAMPLE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ExampleBlocks.EXAMPLE_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ExampleBlocks.EXAMPLE_NETHER_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ExampleItems.EXAMPLE_ITEM, Models.GENERATED);
    }
}
