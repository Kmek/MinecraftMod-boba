package com.kmek.minecafe.block.entity;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.ModBlocksInit;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MineCafeMod.MODID);

    public static final RegistryObject<BlockEntityType<WaffleIronBlockEntity>> WAFFLE_IRON =
            BLOCK_ENTITIES.register("waffle_iron", () ->
                    BlockEntityType.Builder.of(WaffleIronBlockEntity::new,
                            ModBlocksInit.WAFFLE_IRON.get()).build(null));

    public static final RegistryObject<BlockEntityType<DisplayCaseBlockEntity>> DISPLAY_CASE =
            BLOCK_ENTITIES.register("display_case", () ->
                    BlockEntityType.Builder.of(DisplayCaseBlockEntity::new,
                            ModBlocksInit.DISPLAY_CASE_CURVED.get()).build(null));

    public static final RegistryObject<BlockEntityType<CakeStandBlockEntity>> CAKE_STAND =
            BLOCK_ENTITIES.register("cake_stand", () ->
                    BlockEntityType.Builder.of(CakeStandBlockEntity::new,
                            ModBlocksInit.CAKE_STAND.get()).build(null));

    public static final RegistryObject<BlockEntityType<WallShelfBlockEntity>> WALL_SHELF =
            BLOCK_ENTITIES.register("wall_shelf_oak", () ->
                    BlockEntityType.Builder.of(WallShelfBlockEntity::new,
                            ModBlocksInit.OAK_WALL_SHELF.get()).build(null));

//    public static final RegistryObject<BlockEntityType<WallShelfBlockEntity>> WALL_SHELF_BIRCH =
//            BLOCK_ENTITIES.register("wall_shelf_birch", () ->
//                    BlockEntityType.Builder.of(WallShelfBlockEntity::new,
//                            ModBlocksInit.BIRCH_WALL_SHELF.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
