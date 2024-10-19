package karasu_lab.fabric_example.block;

import karasu_lab.fabric_example.FabricExampleMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

/**
 * This class is used to register all the blocks in the mod.
 */
public class ExampleBlocks {
    public static final Block EXAMPLE_BLOCK = registerBlock(new Block(AbstractBlock.Settings.copy(Blocks.STONE)), "example_block");
    public static final Block EXAMPLE_ORE = registerBlock(new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)), "example_ore");
    public static final Block EXAMPLE_DEEPSLATE_ORE = registerBlock(new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)), "example_deepslate_ore");
    public static final Block EXAMPLE_NETHER_ORE = registerBlock(new Block(AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE)), "example_nether_ore");

    /**
     * Registers a block and its item.
     * @param block The block to register
     * @param name The name of the block
     * @return {@link Block}
     */
    private static Block registerBlock(Block block, String name){
        Registry.register(Registries.BLOCK, FabricExampleMod.id(name), block);
        Registry.register(Registries.ITEM, FabricExampleMod.id(name), new BlockItem(block, new Item.Settings()));
        return block;
    }

    /**
     * Initializes the block registry.
     */
    public static void register() {
        // Register the block
    }
}
