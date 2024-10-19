package karasu_lab.fabric_example.world;

import karasu_lab.fabric_example.FabricExampleMod;
import karasu_lab.fabric_example.block.ExampleBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_ORE_KEY = registerKey("karasium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_ORE_KEY = registerKey("nether_karasium_ore");

    /**
     * Bootstrap the configured features.
     * @param context The context to register the configured features
     */
    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new BlockMatchRuleTest(Blocks.NETHERRACK);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldOres =
                List.of(
                        OreFeatureConfig.createTarget(stoneReplacables, ExampleBlocks.EXAMPLE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ExampleBlocks.EXAMPLE_DEEPSLATE_ORE.getDefaultState())
                );

        List<OreFeatureConfig.Target> netherOres =
                List.of(
                        OreFeatureConfig.createTarget(netherReplacables, ExampleBlocks.EXAMPLE_NETHER_ORE.getDefaultState())
                );

        List<OreFeatureConfig.Target> endOres =
                List.of();

        register(context, OVERWORLD_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldOres, 12, 0.7f));
        register(context, NETHER_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherOres, 14));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, FabricExampleMod.id(name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}