package net.darkhax.darkutilities.features.flatblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class BlockFlatTileRotatable extends BlockFlatTile {
    public BlockFlatTileRotatable(Properties properties, @Nullable CollisionEffect collisionEffect) {
        super(properties, collisionEffect);

        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult blockHitResult) {
        if (player.isCrouching()) {

            world.setBlockAndUpdate(pos, this.rotate(state, Rotation.CLOCKWISE_90));
            return InteractionResult.SUCCESS;
        }
        return super.useWithoutItem(state, world, pos, player, blockHitResult);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (player.isCrouching()) {

            world.setBlockAndUpdate(pos, this.rotate(state, Rotation.CLOCKWISE_90));
            return InteractionResult.SUCCESS;
        }
        return super.useItemOn(itemStack, state, world, pos, player, hand, blockHitResult);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {

        super.createBlockStateDefinition(builder);
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState placedState = super.getStateForPlacement(context);

        if (placedState != null) {
            for (final Direction facing : context.getNearestLookingDirections()) {
                if (facing.getAxis().isHorizontal()) {
                    return placedState.setValue(BlockStateProperties.HORIZONTAL_FACING, facing);
                }
            }
        }

        return placedState;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(BlockStateProperties.HORIZONTAL_FACING, rot.rotate(state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(BlockStateProperties.HORIZONTAL_FACING, mirror.mirror(state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }
}
