package karasu_lab.fabric_example;

import karasu_lab.fabric_example.block.ExampleBlocks;
import karasu_lab.fabric_example.item.ExampleItemGroups;
import karasu_lab.fabric_example.item.ExampleItems;
import karasu_lab.fabric_example.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main class of the mod.
 * This class is the entry point of the mod.
 * It implements {@link ModInitializer} to initialize the mod.
 */
public class FabricExampleMod implements ModInitializer {
	public static final String MOD_ID = "fabric-example-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ExampleBlocks.register();
		ExampleItems.register();
		ExampleItemGroups.register();

		ModOreGeneration.generateOres();
	}

	/**
	 * Get an identifier for the mod with the given path.
	 * @param path The path of the identifier
	 * @return {@link Identifier}
	 */
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}