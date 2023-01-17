package com.kmek.minecafe.block;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.item.ModItemsInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
     * Crop Blocks
     */
    public static final RegistryObject<Block> CASSAVA_CROP = BLOCKS.register("cassava_crop",
            () -> new CassavaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    /**
     * Crafting Blocks
     */
    public static final RegistryObject<Block> WAFFLE_IRON = BLOCKS.register("waffle_iron",
            () -> new WaffleIronBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
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
    public static final RegistryObject<Block> BIRCH_WALL_SHELF = BLOCKS.register("birch_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.6f).dynamicShape().noOcclusion()));

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
