package com.kmek.minecafe.item;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.ModBlocksInit;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItemsInit {
    /**
     * Registry
     */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MineCafeMod.MODID);

    /**
     * Display Blocks
     */
    public static final RegistryObject<BlockItem> DISPLAY_CASE_CURVED_ITEM = ITEMS.register("display_case_curved",
            () -> new BlockItem(ModBlocksInit.DISPLAY_CASE_CURVED.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CAKE_STAND_ITEM = ITEMS.register("cake_stand",
            () -> new BlockItem(ModBlocksInit.CAKE_STAND.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> OAK_WALL_SHELF_ITEM = ITEMS.register("oak_wall_shelf",
            () -> new BlockItem(ModBlocksInit.OAK_WALL_SHELF.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BIRCH_WALL_SHELF_ITEM = ITEMS.register("birch_wall_shelf",
            () -> new BlockItem(ModBlocksInit.BIRCH_WALL_SHELF.get(), new Item.Properties()));

    /**
     * Cassava Crop
     */
    public static final RegistryObject<Item> CASSAVA_CUTTING = ITEMS.register("cassava_cutting",
            () -> new ItemNameBlockItem(ModBlocksInit.CASSAVA_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CASSAVA = ITEMS.register("cassava", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(0).saturationMod(0f)
                    .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 400, 0), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 600, 0), 1.0f)
                    .build())) {
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
            components.add(Component.literal("Poisonous when raw").withStyle(ChatFormatting.YELLOW));
            super.appendHoverText(stack, level, components, flag);
        }
    });

    /**
     * Cassava-related Foods
     */
    public static final RegistryObject<Item> CASSAVA_BIBINGKA = ITEMS.register("cassava_bibingka", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(3).saturationMod(1.5f).build())));
    public static final RegistryObject<Item> TAPIOCA_PUDDING = ITEMS.register("tapioca_pudding", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(3).saturationMod(1.2f).build())));

    /**
     * Tea Crafting Ingredients
     */
    public static final RegistryObject<Item> TAPIOCA_BALLS = ITEMS.register("tapioca_balls", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MILK_TEA_CUP = ITEMS.register("milk_tea_cup", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATCHA_POWDER = ITEMS.register("matcha_powder", () -> new Item(new Item.Properties()));

    /**
     * Bubble Milk Teas
     */
    // Very sweet
    public static final RegistryObject<Item> BROWN_SUGAR_MILK_TEA = ITEMS.register("brown_sugar_milk_tea",
            () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> TIGER_MILK_TEA = ITEMS.register("tiger_milk_tea",
            () -> new MilkTeaItem(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(2).saturationMod(0.5f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 0), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500, 0), 1.0f)
                            .build()),
                    Component.literal("Move like a tiger!").withStyle(ChatFormatting.YELLOW)));
    public static final RegistryObject<Item> HONEY_MILK_TEA = ITEMS.register("honey_milk_tea",
            () -> new MilkTeaItem(6, 0.5f));
    public static final RegistryObject<Item> CHOCOLATE_MILK_TEA = ITEMS.register("chocolate_milk_tea",
            () -> new MilkTeaItem(2, 0.6f));
    public static final RegistryObject<Item> VANILLA_MILK_TEA = ITEMS.register("vanilla_milk_tea",
            () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> EGG_CUSTARD_MILK_TEA = ITEMS.register("egg_custard_milk_tea",
            () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> COOKIE_MILK_TEA = ITEMS.register("cookie_milk_tea",
            () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> CAKE_MILK_TEA = ITEMS.register("cake_milk_tea",
            () -> new MilkTeaItem(15, 2.9f));
    public static final RegistryObject<Item> PUMPKIN_SPICE_MILK_TEA = ITEMS.register("pumpkin_spice_milk_tea",
            () -> new MilkTeaItem(2, 0.6f));
    // Fruit teas
    public static final RegistryObject<Item> APPLE_MILK_TEA = ITEMS.register("apple_milk_tea",
            () -> new MilkTeaItem(4, 2.5f));
    public static final RegistryObject<Item> SWEET_BERRY_MILK_TEA = ITEMS.register("sweet_berry_milk_tea",
            () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> WATERMELON_MILK_TEA = ITEMS.register("watermelon_milk_tea",
            () -> new MilkTeaItem(2, 1.5f));
    public static final RegistryObject<Item> GLOW_BERRY_MILK_TEA = ITEMS.register("glow_berry_milk_tea",
            () -> new MilkTeaItem(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(2).saturationMod(0.5f)
                            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 600, 0), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 1.0f)
                            .build()),
                    Component.literal("Glowing!").withStyle(ChatFormatting.YELLOW)));
    public static final RegistryObject<Item> CHORUS_FRUIT_MILK_TEA = ITEMS.register("chorus_fruit_milk_tea",
            () -> new MilkTeaItem(4, 2.5f));
//    todo (teleports you randomly? use ChorusFruitItem)
    // Floral
    public static final RegistryObject<Item> ROSE_MILK_TEA = ITEMS.register("rose_milk_tea",
            () -> new MilkTeaItem(3, 0.6f));
    public static final RegistryObject<Item> BUTTERFLY_PEA_FLOWER_MILK_TEA = ITEMS.register("butterfly_pea_flower_milk_tea",
            () -> new MilkTeaItem(3, 0.6f));
    public static final RegistryObject<Item> MATCHA_MILK_TEA = ITEMS.register("matcha_milk_tea",
            () -> new MilkTeaItem(3, 1f));
    public static final RegistryObject<Item> LAVENDER_MILK_TEA = ITEMS.register("lavender_milk_tea",
            () -> new MilkTeaItem(3, 0.6f));
    // Misc normal food tea flavors
    public static final RegistryObject<Item> THAI_MILK_TEA = ITEMS.register("thai_milk_tea",
            () -> new MilkTeaItem(2, 0.6f));
    // todo green tea (green dye)
    public static final RegistryObject<Item> BEETROOT_MILK_TEA = ITEMS.register("beetroot_milk_tea",
            () -> new MilkTeaItem(1, 1.5f));
    public static final RegistryObject<Item> CARROT_MILK_TEA = ITEMS.register("carrot_milk_tea",
            () -> new MilkTeaItem(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(4).saturationMod(3.8f)
                            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0), 1.0f)
                            .build()),
                    Component.literal("Good for your eyes").withStyle(ChatFormatting.YELLOW)));
    public static final RegistryObject<Item> KELP_MILK_TEA = ITEMS.register("kelp_milk_tea",
            () -> new MilkTeaItem(1, 1f));
    // Funky tea flavors with effects
    public static final RegistryObject<Item> PHANTOM_MILK_TEA = ITEMS.register("phantom_milk_tea",
            () -> new MilkTeaItem(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(1).saturationMod(0.4f)
                            .alwaysEat()
                            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 700, 0), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1000, 0), 1.0f)
                            .build()),
                    Component.literal("A good pick-me-up in the morning").withStyle(ChatFormatting.YELLOW)));
    public static final RegistryObject<Item> BLAZING_MILK_TEA = ITEMS.register("blazing_milk_tea",
            () -> new MilkTeaItem(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(0).saturationMod(0f)
                            .alwaysEat()
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 1.0f)
                            .build()),
                    Component.literal("Now with authentic firey taste").withStyle(ChatFormatting.YELLOW)));
    public static final RegistryObject<Item> DARKSIDE_MILK_TEA = ITEMS.register("darkside_milk_tea",
            () -> new MilkTeaItem(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(0).saturationMod(0f)
                            .alwaysEat()
                            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 800, 0), 1.0f)
                            .build()),
                    Component.literal("Join the dark side").withStyle(ChatFormatting.YELLOW)));
    public static final RegistryObject<Item> WET_MILK_TEA = ITEMS.register("wet_milk_tea",
            () -> new MilkTeaItem(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(0).saturationMod(0f)
                            .alwaysEat()
                            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 800, 0), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 800, 0), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 1.0f)
                            .build()),
                    Component.literal("Underwater vibes").withStyle(ChatFormatting.YELLOW)));
    public static final RegistryObject<Item> IMAGINARY_MILK_TEA = ITEMS.register("imaginary_milk_tea",
        () -> new MilkTeaItem(new Item.Properties().food(
                new FoodProperties.Builder().nutrition(0).saturationMod(0f)
                        .alwaysEat()
                        .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 800, 0), 1.0f)
                        .build()),
                Component.literal("It's there, I promise!").withStyle(ChatFormatting.YELLOW)));
//    todo public static final RegistryObject<Item> ENDER_MILK_TEA

    /**
     * Waffle Snacks
     */
    public static final RegistryObject<BlockItem> WAFFLE_IRON_ITEM = ITEMS.register("waffle_iron",
            () -> new BlockItem(ModBlocksInit.WAFFLE_IRON.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAW_WAFFLE_BATTER = ITEMS.register("raw_waffle_batter", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(0).saturationMod(0)
                    .effect(() -> new MobEffectInstance(MobEffects.POISON, 300, 0), 0.6f)
                    .build())) {
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
            components.add(Component.literal("Consume raw eggs at your own risk").withStyle(ChatFormatting.YELLOW));
            super.appendHoverText(stack, level, components, flag);
        }
    });
    public static final RegistryObject<Item> TAIYAKI = ITEMS.register("taiyaki", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> TAIYAKI_MOLD = ITEMS.register("taiyaki_mold", () -> new WaffleMoldItem(TAIYAKI.get()));
    public static final RegistryObject<Item> EGG_WAFFLE = ITEMS.register("egg_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> EGG_WAFFLE_MOLD = ITEMS.register("egg_waffle_mold", () -> new WaffleMoldItem(EGG_WAFFLE.get()));
    public static final RegistryObject<Item> PAW_WAFFLE = ITEMS.register("paw_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> PAW_WAFFLE_MOLD = ITEMS.register("paw_waffle_mold", () -> new WaffleMoldItem(PAW_WAFFLE.get()));
    public static final RegistryObject<Item> CLASSIC_WAFFLE = ITEMS.register("classic_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> CLASSIC_WAFFLE_MOLD = ITEMS.register("classic_waffle_mold", () -> new WaffleMoldItem(CLASSIC_WAFFLE.get()));
    public static final RegistryObject<Item> CREEPER_WAFFLE = ITEMS.register("creeper_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> CREEPER_WAFFLE_MOLD = ITEMS.register("creeper_waffle_mold", () -> new WaffleMoldItem(CREEPER_WAFFLE.get()));
    public static final RegistryObject<Item> HEART_WAFFLE = ITEMS.register("heart_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> HEART_WAFFLE_MOLD = ITEMS.register("heart_waffle_mold", () -> new WaffleMoldItem(HEART_WAFFLE.get()));
    public static final RegistryObject<Item> PUMPKIN_WAFFLE = ITEMS.register("pumpkin_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> PUMPKIN_WAFFLE_MOLD = ITEMS.register("pumpkin_waffle_mold", () -> new WaffleMoldItem(PUMPKIN_WAFFLE.get()));
    public static final RegistryObject<Item> MUSHROOM_WAFFLE = ITEMS.register("mushroom_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> MUSHROOM_WAFFLE_MOLD = ITEMS.register("mushroom_waffle_mold", () -> new WaffleMoldItem(MUSHROOM_WAFFLE.get()));
    public static final RegistryObject<Item> FLOWER_WAFFLE = ITEMS.register("flower_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> FLOWER_WAFFLE_MOLD = ITEMS.register("flower_waffle_mold", () -> new WaffleMoldItem(FLOWER_WAFFLE.get()));
    public static final RegistryObject<Item> DIAMOND_WAFFLE = ITEMS.register("diamond_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> DIAMOND_WAFFLE_MOLD = ITEMS.register("diamond_waffle_mold", () -> new WaffleMoldItem(DIAMOND_WAFFLE.get()));
    public static final RegistryObject<Item> PICKAXE_WAFFLE = ITEMS.register("pickaxe_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> PICKAXE_WAFFLE_MOLD = ITEMS.register("pickaxe_waffle_mold", () -> new WaffleMoldItem(PICKAXE_WAFFLE.get()));
    public static final RegistryObject<Item> SWORD_WAFFLE = ITEMS.register("sword_waffle", () -> new WaffleItem(2, 0.8f));
    public static final RegistryObject<Item> SWORD_WAFFLE_MOLD = ITEMS.register("sword_waffle_mold", () -> new WaffleMoldItem(SWORD_WAFFLE.get()));

    /**
     * Creams
     */
    public static final RegistryObject<Item> CREAM = ITEMS.register("cream", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(0).saturationMod(0.2f).build())));
    public static final RegistryObject<Item> WHIPPED_CREAM = ITEMS.register("whipped_cream", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build())));
    public static final RegistryObject<Item> CHOCOLATE_CREAM = ITEMS.register("chocolate_cream", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(0).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> VANILLA_CREAM = ITEMS.register("vanilla_cream", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(0).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> MATCHA_CREAM = ITEMS.register("matcha_cream", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(0).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> HONEY_CREAM = ITEMS.register("honey_cream", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(0).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> ROSE_CREAM = ITEMS.register("rose_cream", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(0).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> MARSHMALLOW = ITEMS.register("marshmallow", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build())));
    public static final RegistryObject<Item> MARSHMALLOWS = ITEMS.register("marshmallows", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 60, 0), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0), 1.0f)
                    .build())));
    public static final RegistryObject<Item> CUSTARD = ITEMS.register("custard", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(0).saturationMod(0.3f).build())));

    /**
     * Jams
     */
    public static final RegistryObject<Item> APPLE_JAM = ITEMS.register("apple_jam", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(1).saturationMod(0.4f).build())));
    public static final RegistryObject<Item> CHORUS_FRUIT_JAM = ITEMS.register("chorus_fruit_jam", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(1).saturationMod(0.4f).build())));
    public static final RegistryObject<Item> GLOW_BERRY_JAM = ITEMS.register("glow_berry_jam", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(1).saturationMod(0.4f).build())));
    public static final RegistryObject<Item> SWEET_BERRY_JAM = ITEMS.register("sweet_berry_jam", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(1).saturationMod(0.4f).build())));
    public static final RegistryObject<Item> WATERMELON_JAM = ITEMS.register("watermelon_jam", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(1).saturationMod(0.4f).build())));

    public static final RegistryObject<Item> PASTRY_BAG = ITEMS.register("pastry_bag", () -> new Item(new Item.Properties()));

    /**
     * Misc Food
     */
    public static final RegistryObject<Item> BATTER_MESS = ITEMS.register("batter_mess", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(0).saturationMod(0)
                    .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 0.8f)
                    .build())) {
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
            components.add(Component.literal("Consume raw eggs at your own risk").withStyle(ChatFormatting.YELLOW));
            super.appendHoverText(stack, level, components, flag);
        }
    });
    public static final RegistryObject<Item> BURNT_CRISP = ITEMS.register("burnt_crisp", () -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().nutrition(1).saturationMod(0.5f)
                    .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 1.0f)
                    .build())));

    /**
     * Coffee Stuff
     */
    public static final RegistryObject<BlockItem> ESPRESSO_MACHINE_ITEM = ITEMS.register("espresso_machine",
            () -> new BlockItem(ModBlocksInit.ESPRESSO_MACHINE.get(), new Item.Properties()));

    /**
     * Registering the event bus
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
