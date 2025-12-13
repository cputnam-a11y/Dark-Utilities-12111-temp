package net.darkhax.darkutilities.datagen.client;

import net.darkhax.darkutilities.DarkUtils;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NullMarked;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@NullMarked
public class DarkModelProvider extends FabricModelProvider {
    Map<Block, Identifier> specialCased = new IdentityHashMap<>();

    public DarkModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void specialCase(Block block, Function<Block, Identifier> modelGetter) {
        specialCased.put(block, modelGetter.apply(block));
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        specialCase(DarkUtils.getInstance().content.redstoneRandomizer, it -> ModelLocationUtils.getModelLocation(it, "_enabled"));
        for (var item : DarkUtils.getInstance().content.items) {
            if (item instanceof BlockItem blockItem) {
                var model = ModelLocationUtils.getModelLocation(blockItem.getBlock());
                if (specialCased.containsKey(blockItem.getBlock())) {
                    model = specialCased.get(blockItem.getBlock());
                }
                itemModelGenerator.itemModelOutput.accept(
                        item,
                        new BlockModelWrapper.Unbaked(
                                model,
                                List.of()
                        )
                );
            } else {
                itemModelGenerator.itemModelOutput.accept(item, new BlockModelWrapper.Unbaked(ModelLocationUtils.getModelLocation(item), List.of()));
            }

        }
    }
}
