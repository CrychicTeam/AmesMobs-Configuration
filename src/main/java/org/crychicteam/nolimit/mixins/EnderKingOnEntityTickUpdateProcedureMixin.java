package org.crychicteam.nolimit.mixins;

import net.mcreator.animatedmobsmod.procedures.EnderKingOnEntityTickUpdateProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.crychicteam.nolimit.EnderKingConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EnderKingOnEntityTickUpdateProcedure.class)
public class EnderKingOnEntityTickUpdateProcedureMixin {
    @ModifyConstant(
            method = "execute",
            constant = @Constant(floatValue = 250.0F),
            remap = false
    )
    private static float noLimit$modifyHealthThreshold(float constant, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity instanceof LivingEntity living) {
            return living.getMaxHealth() * EnderKingConfig.PHASE_CHANGE_PERCENT.get().floatValue();
        }
        return constant;
    }
}