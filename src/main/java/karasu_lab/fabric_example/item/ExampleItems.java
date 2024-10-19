package karasu_lab.fabric_example.item;

import karasu_lab.fabric_example.FabricExampleMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ExampleItems {
    public static Item EXAMPLE_ITEM = registerItem(new Item(new Item.Settings()), "example_item");

    /**
     * Registers an item with the given name.
     * @param item The item to register
     * @param name The name of the item
     * @return {@link Item}
     */
    public static Item registerItem(Item item, String name) {
        return Registry.register(Registries.ITEM, FabricExampleMod.id(name), item);
    }

    /**
     * Initializes the item registry.
     */
    public static void register() {
        // Register the item
    }
}
