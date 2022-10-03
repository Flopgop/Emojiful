package com.hrznstudio.emojiful;

import com.hrznstudio.emojiful.api.Emoji;
import com.hrznstudio.emojiful.datapack.EmojiRecipe;
import com.hrznstudio.emojiful.datapack.EmojiRecipeSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mod(Constants.MOD_ID)
public class EmojifulForge {

    public static final String MODID = "emojiful";
    public static final Logger LOGGER = LogManager.getLogger("Emojiful");

    public static final Map<String, List<Emoji>> EMOJI_MAP = new HashMap<>();
    public static final List<Emoji> EMOJI_LIST = new ArrayList<>();
    public static boolean error = false;

    public static DeferredRegister<RecipeSerializer<?>> RECIPE_SER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);
    public static final RegistryObject<EmojiRecipeSerializer> EMOJI_RECIPE_SERIALIZER = Emojiful.RECIPE_SER.register("emoji_recipe", EmojiRecipeSerializer::new);

    public static DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MODID);
    public static final RegistryObject<RecipeType<EmojiRecipe>> EMOJI_RECIPE_TYPE = Emojiful.RECIPE_TYPE.register("emoji_recipe_type",() -> RecipeType.simple(new ResourceLocation(MODID, "emoji_recipe_type" )));


    public EmojifulForge() {

        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
    }

}