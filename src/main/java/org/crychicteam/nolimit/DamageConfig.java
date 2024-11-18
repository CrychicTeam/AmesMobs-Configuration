package org.crychicteam.nolimit;

import net.minecraftforge.common.ForgeConfigSpec;

public class DamageConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue ENABLE_DAMAGE_LIMIT;
    public static final ForgeConfigSpec.DoubleValue DAMAGE_LIMIT_VALUE;

    static {
        BUILDER.push("damage_settings");

        ENABLE_DAMAGE_LIMIT = BUILDER
                .comment("Enable damage limit")
                .define("enableDamageLimit", true);

        DAMAGE_LIMIT_VALUE = BUILDER
                .comment("Maximum damage value")
                .defineInRange("damageLimitValue", 100.0D, 0.0D, Double.MAX_VALUE);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}