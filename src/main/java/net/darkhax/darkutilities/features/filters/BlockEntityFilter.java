package net.darkhax.darkutilities.features.filters;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.function.Predicate;
import java.util.function.Supplier;

@NullMarked
public class BlockEntityFilter extends Block {
    public static final Supplier<Properties> BLOCK_PROPERTIES = () -> Properties.of().mapColor(MapColor.WOOD).strength(3f, 10f).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false).noOcclusion();
    private final Predicate<Entity> filter;

    public BlockEntityFilter(Predicate<Entity> filter, Properties properties) {

        super(properties);
        this.filter = filter;

        BlockState defaultState = this.defaultBlockState();
        defaultState = defaultState.setValue(BlockStateProperties.POWERED, false);
        defaultState = defaultState.setValue(BlockStateProperties.INVERTED, false);

        this.registerDefaultState(defaultState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BlockStateProperties.POWERED, BlockStateProperties.INVERTED);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState placedState = super.getStateForPlacement(context);

        if (placedState != null) {
            placedState = placedState.setValue(BlockStateProperties.POWERED, context.getLevel().hasNeighborSignal(context.getClickedPos()));
        }

        return placedState;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (player.isCrouching()) {

            if (!level.isClientSide()) {

                level.setBlock(blockPos, blockState.setValue(BlockStateProperties.INVERTED, !blockState.getValue(BlockStateProperties.INVERTED)), 3);
                level.levelEvent(1008, blockPos, 0);
            }

            return InteractionResult.SUCCESS;
        }
        return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);
    }

    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, @Nullable Orientation orientation, boolean bl) {
        final boolean isBlockPowered = level.hasNeighborSignal(blockPos);

        if (!level.isClientSide() && blockState.getValue(BlockStateProperties.POWERED) != isBlockPowered) {
            level.playSound(null, blockPos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.3F, 0.5f);
            level.setBlockAndUpdate(blockPos, blockState.setValue(BlockStateProperties.POWERED, isBlockPowered));
        }

        super.neighborChanged(blockState, level, blockPos, block, orientation, bl);
    }

    @Override
    public boolean isPossibleToRespawnInThis(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (!state.getValue(BlockStateProperties.POWERED) && context instanceof EntityCollisionContext entityContext) {
            final Entity entity = entityContext.getEntity();

            if (entity != null) {
                final boolean filterMatch = this.filter.test(entity);
                if (state.getValue(BlockStateProperties.INVERTED) != filterMatch) {
                    return Shapes.empty();
                }
            }
        }

        return super.getCollisionShape(state, world, pos, context);
    }

    @Override
    public boolean skipRendering(BlockState ourState, BlockState neighborState, Direction side) {
        return neighborState.is(this);
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state) {
        return state.getFluidState().isEmpty();
    }
}