package org.crychicteam.amemobsettings.mixins;

import net.mcreator.animatedmobsmod.entity.EnderKingEntity;
import org.crychicteam.amemobsettings.EnderKingConfig;
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
    private float ameMobsConfiguration$min(float amount, float limit) {
        if (!EnderKingConfig.ENABLE_DAMAGE_LIMIT.get()) {
            return amount;
        }
        return Math.min(amount, EnderKingConfig.DAMAGE_LIMIT_VALUE.get().floatValue());
    }
}