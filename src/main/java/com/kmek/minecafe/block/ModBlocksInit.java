package com.kmek.minecafe.block;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.crop.CassavaCropBlock;
import com.kmek.minecafe.block.crop.CropTreeBottomBlock;
import com.kmek.minecafe.block.crop.CropTreeTopBlock;
import com.kmek.minecafe.block.crop.FlowerCropBlock;
import com.kmek.minecafe.fluid.ModFluids;
import com.kmek.minecafe.item.ModItemsInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocksInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MineCafeMod.MODID);

    /**
     * Flower Crop Blocks
     */
    public static final RegistryObject<Block> DANDELION_CROP = BLOCKS.register("dandelion_crop",
            () -> new FlowerCropBlock("dandelion_seeds", Blocks.DANDELION, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> POPPY_CROP = BLOCKS.register("poppy_crop",
            () -> new FlowerCropBlock("poppy_seeds", Blocks.POPPY, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> BLUE_ORCHID_CROP = BLOCKS.register("blue_orchid_crop",
            () -> new FlowerCropBlock("blue_orchid_seeds", Blocks.BLUE_ORCHID, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> ALLIUM_CROP = BLOCKS.register("allium_crop",
            () -> new FlowerCropBlock("allium_seeds", Blocks.ALLIUM, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> AZURE_BLUET_CROP = BLOCKS.register("azure_bluet_crop",
            () -> new FlowerCropBlock("azure_bluet_seeds", Blocks.AZURE_BLUET, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> RED_TULIP_CROP = BLOCKS.register("red_tulip_crop",
            () -> new FlowerCropBlock("red_tulip_seeds", Blocks.RED_TULIP, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> ORANGE_TULIP_CROP = BLOCKS.register("orange_tulip_crop",
            () -> new FlowerCropBlock("orange_tulip_seeds", Blocks.ORANGE_TULIP, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> WHITE_TULIP_CROP = BLOCKS.register("white_tulip_crop",
            () -> new FlowerCropBlock("white_tulip_seeds", Blocks.WHITE_TULIP, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> PINK_TULIP_CROP = BLOCKS.register("pink_tulip_crop",
            () -> new FlowerCropBlock("pink_tulip_seeds", Blocks.PINK_TULIP, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> OXEYE_DAISY_CROP = BLOCKS.register("oxeye_daisy_crop",
            () -> new FlowerCropBlock("oxeye_daisy_seeds", Blocks.OXEYE_DAISY, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> CORNFLOWER_CROP = BLOCKS.register("cornflower_crop",
            () -> new FlowerCropBlock("cornflower_seeds", Blocks.CORNFLOWER, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> LILY_OF_THE_VALLEY_CROP = BLOCKS.register("lily_of_the_valley_crop",
            () -> new FlowerCropBlock("lily_of_the_valley_seeds", Blocks.LILY_OF_THE_VALLEY, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));

    /**
     * Crop Blocks
     */
    // Cassava
    public static final RegistryObject<Block> CASSAVA_CROP = BLOCKS.register("cassava_crop",
            () -> new CassavaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    // Coffee
    public static final RegistryObject<Block> COFFEE_CROP_BOTTOM = BLOCKS.register("coffee_crop_bottom",
            () -> new CropTreeBottomBlock("coffee_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> COFFEE_CROP_TOP = BLOCKS.register("coffee_crop_top",
            () -> new CropTreeTopBlock(COFFEE_CROP_BOTTOM.get(), "item.minecafe.coffee_cherries", 7, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Apple
    public static final RegistryObject<Block> APPLE_CROP_BOTTOM = BLOCKS.register("apple_crop_bottom",
            () -> new CropTreeBottomBlock("apple_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> APPLE_CROP_TOP = BLOCKS.register("apple_crop_top",
            () -> new CropTreeTopBlock(APPLE_CROP_BOTTOM.get(), Items.APPLE, 5, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));

    /**
     * Crafting Blocks
     */
    public static final RegistryObject<Block> WAFFLE_IRON = BLOCKS.register("waffle_iron",
            () -> new WaffleIronBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> COFFEE_MACHINE = BLOCKS.register("coffee_machine",
            () -> new CoffeeMachineBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> ESPRESSO_MACHINE = BLOCKS.register("espresso_machine",
            () -> new EspressoMachineBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));

    /**
     * Display Blocks
     */
    public static final RegistryObject<Block> DISPLAY_CASE_CURVED = BLOCKS.register("display_case_curved",
            () -> new DisplayCaseBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> CAKE_STAND = BLOCKS.register("cake_stand",
            () -> new CakeStandBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> OAK_WALL_SHELF = BLOCKS.register("oak_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.6f).dynamicShape().noOcclusion()));
//    public static final RegistryObject<Block> BIRCH_WALL_SHELF = BLOCKS.register("birch_wall_shelf",
//            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.6f).dynamicShape().noOcclusion()));
public static final RegistryObject<Block> VASE = BLOCKS.register("vase",
        () -> new VaseBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));

    /**
     * Fluids
     */
    public static final RegistryObject<LiquidBlock> COFFEE_FLUID_BLOCK = BLOCKS.register("coffee_fluid_block",
            () -> new LiquidBlock(ModFluids.SOURCE_COFFEE_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));

    /**
     * Setup
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItemsInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    /**
     * Registering the event bus
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
