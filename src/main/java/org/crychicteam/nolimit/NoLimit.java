package org.crychicteam.nolimit;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.util.logging.Logger;

@Mod(NoLimit.MOD_ID)
public class NoLimit {
	public static final String MOD_ID = "amemobsettings";
	public static ResourceLocation id(String path)
	{
		return new ResourceLocation(MOD_ID, path);
	}
	public static Logger LOGGER = Logger.getLogger(NoLimit.MOD_ID);

	public NoLimit () {
		configRegistry();
	}

	public void configRegistry() {
		var mod = ModLoadingContext.get();
		mod.registerConfig(ModConfig.Type.COMMON, EnderKingConfig.SPEC, "enderking-settings.toml");
	}
}
