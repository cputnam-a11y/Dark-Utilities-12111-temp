package net.darkhax.darkutilities.features.tomes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NullMarked;

import javax.annotation.Nullable;
import java.util.function.Supplier;
@NullMarked
public class ItemTome extends Item {
    public static final Supplier<Properties> PROPERTIES = () -> new Properties().stacksTo(1).rarity(Rarity.UNCOMMON);

    @Nullable
    private final TomeEffect<Player, InteractionResult> userEffect;

    @Nullable
    private final TomeEffect<Entity, InteractionResult> entityEffect;

    @Nullable
    private final TomeEffect<BlockPos, InteractionResult> blockEffect;

    public ItemTome(@Nullable TomeEffect<Player, InteractionResult> userEffect, @Nullable TomeEffect<Entity, InteractionResult> entityEffect, @Nullable TomeEffect<BlockPos, InteractionResult> blockEffect, Properties properties) {

        super(properties);
        this.userEffect = userEffect;
        this.entityEffect = entityEffect;
        this.blockEffect = blockEffect;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player user, LivingEntity target, InteractionHand hand) {
        InteractionResult result = null;
        if (this.entityEffect != null) {
            result = this.entityEffect.apply(stack, user, hand, target);
        }

        return result != null
               ? result
               : super.interactLivingEntity(stack, user, target, hand);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult result = null;

        if (this.blockEffect != null) {
            result = this.blockEffect.apply(context.getItemInHand(), context.getPlayer(), context.getHand(), context.getClickedPos());
        }

        return result != null
               ? result
               : super.useOn(context);
    }

    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        InteractionResult result = null;

        if (this.userEffect != null) {
            result = this.userEffect.apply(player.getItemInHand(hand), player, hand, player);
        }

        return result != null
               ? result
               : super.use(world, player, hand);
    }
}