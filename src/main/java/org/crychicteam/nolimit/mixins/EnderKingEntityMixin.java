package org.crychicteam.nolimit.mixins;

import net.mcreator.animatedmobsmod.entity.EnderKingEntity;
import org.crychicteam.nolimit.DamageConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnderKingEntity.class)
public class EnderKingEntityMixin {
    @Redirect(
            method = "hurt",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/lang/Math;min(FF)F"
            )
    )
    private float noLimit$modifyDamageLimit(float amount, float limit) {
        if (!DamageConfig.ENABLE_DAMAGE_LIMIT.get()) {
            return amount;
        }
        return Math.min(amount, DamageConfig.DAMAGE_LIMIT_VALUE.get().floatValue());
    }
}