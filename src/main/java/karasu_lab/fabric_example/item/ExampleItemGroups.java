package karasu_lab.fabric_example.item;

import karasu_lab.fabric_example.FabricExampleMod;
import karasu_lab.fabric_example.block.ExampleBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ExampleItemGroups {
    /**
     * The item group for the mod.
     */
    public static final ItemGroup EXAMPLE_GROUP = ItemGroup.create(ItemGroup.Row.TOP, 9)
            .icon(() -> new ItemStack(ExampleBlocks.EXAMPLE_ORE))
            .displayName(Text.translatable("itemGroup.fabric_example_mod.example_group"))
            .entries((displayContext, entries) -> {
                entries.add(new ItemStack(ExampleBlocks.EXAMPLE_BLOCK));
                entries.add(new ItemStack(ExampleBlocks.EXAMPLE_ORE));
                entries.add(new ItemStack(ExampleBlocks.EXAMPLE_DEEPSLATE_ORE));
                entries.add(new ItemStack(ExampleItems.EXAMPLE_ITEM));
            })
            .build();

    /**
     * Registers the item group.
     */
    public static void register() {
        Registry.register(Registries.ITEM_GROUP, FabricExampleMod.id("example_group"), EXAMPLE_GROUP);
    }
}
