package org.crychicteam.amemobsettings;

import net.minecraftforge.common.ForgeConfigSpec;

public class EnderKingConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue ENABLE_DAMAGE_LIMIT;
    public static final ForgeConfigSpec.DoubleValue DAMAGE_LIMIT_VALUE;
    public static final ForgeConfigSpec.DoubleValue PHASE_CHANGE_PERCENT;

    static {
        BUILDER.push("EnderKingSettings");

        ENABLE_DAMAGE_LIMIT = BUILDER
                .comment("Enable damage limit")
                .define("enableDamageLimit", true);

        DAMAGE_LIMIT_VALUE = BUILDER
                .comment("Maximum damage value")
                .comment("Need enableDamageLimit to be set as true")
                .defineInRange("damageLimitValue", 100.0D, 0.0D, Double.MAX_VALUE);

        PHASE_CHANGE_PERCENT = BUILDER
                .comment("EnderKings phase change percentage")
                .comment("The percentage of health that will make EnderKings to change phase")
                .comment("The logic is EnderKing change phase when the health is lower than this value.")
                .defineInRange("phaseChangePercentage", 0.5D, 0.1D, 1.0D);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}