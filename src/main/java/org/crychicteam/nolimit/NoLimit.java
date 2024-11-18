package org.crychicteam.nolimit;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.util.logging.Logger;

@Mod(NoLimit.MOD_ID)
public class NoLimit {
	public static final String MOD_ID = "nolimit";
	public static ResourceLocation id(String path)
	{
		return new ResourceLocation(MOD_ID, path);
	}
	public static Logger LOGGER = Logger.getLogger(NoLimit.MOD_ID);

	public NoLimit () {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DamageConfig.SPEC, "enderking-limit.toml");
	}
}
