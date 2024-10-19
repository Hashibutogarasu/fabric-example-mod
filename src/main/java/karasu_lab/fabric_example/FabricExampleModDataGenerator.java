package karasu_lab.fabric_example;

import karasu_lab.fabric_example.data.ModLangProvider;
import karasu_lab.fabric_example.data.ModModelProvider;
import karasu_lab.fabric_example.data.ModWorldGenerator;
import karasu_lab.fabric_example.world.ModConfiguredFeatures;
import karasu_lab.fabric_example.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

/**
 * The main class of the mod data generator.
 * This class is the entry point of the mod data generator.
 * It implements {@link DataGeneratorEntrypoint} to initialize the mod data generator.
 */
public class FabricExampleModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		ModLangProvider.addProviders(pack);
		pack.addProvider(ModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
	}
}
