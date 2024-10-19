package karasu_lab.fabric_example.data;

import karasu_lab.fabric_example.block.ExampleBlocks;
import karasu_lab.fabric_example.item.ExampleItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLangProvider {
    public static void addProviders(FabricDataGenerator.Pack pack) {
        pack.addProvider(EnglishLang::new);
        pack.addProvider(JapaneseLangProvider::new);
    }

    public static class JapaneseLangProvider extends FabricLanguageProvider {
        protected JapaneseLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, "ja_jp", registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        }
    }

    public static class EnglishLang extends FabricLanguageProvider {
        protected EnglishLang(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, "en_us", registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
            translationBuilder.add("itemGroup.fabric_example_mod.example_group", "Fabric Example Mod");
            translationBuilder.add(ExampleBlocks.EXAMPLE_BLOCK, "Example Block");
            translationBuilder.add(ExampleBlocks.EXAMPLE_ORE, "Example Ore");
            translationBuilder.add(ExampleBlocks.EXAMPLE_DEEPSLATE_ORE, "Example Deepslate Ore");
            translationBuilder.add(ExampleItems.EXAMPLE_ITEM, "Example Item");
            translationBuilder.add(ExampleBlocks.EXAMPLE_NETHER_ORE, "Example Nether Ore");
        }
    }
}
