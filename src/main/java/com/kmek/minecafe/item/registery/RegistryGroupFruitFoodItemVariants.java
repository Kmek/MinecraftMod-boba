package com.kmek.minecafe.item.registery;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistryGroupFruitFoodItemVariants {
    private final String nameSuffix;
    private final DeferredRegister<Item> ITEMS;
    protected List<Fruits> values = Arrays.asList(Fruits.values());
    protected final Map<Fruits, Item> group = new HashMap<>();

    public RegistryGroupFruitFoodItemVariants(String nameSuffix, DeferredRegister<Item> items) {
        this.ITEMS = items;
        this.nameSuffix = nameSuffix;
    }

    public RegistryGroupFruitFoodItemVariants skip(Fruits toSkip) {
        this.values = values.stream().filter(val -> val != toSkip).toList();
        return this;
    }

    public RegistryGroupFruitFoodItemVariants override(Fruits toOverride, Item toSet) {
        skip(toOverride);
        group.put(toOverride, toSet);
        return this;
    }

    public Map<Fruits, Item> build() {
        values.forEach(this::buildItem);
        return group;
    }

    protected void buildItem(Fruits val) {
        Item toAdd = new Item(new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(3).saturationMod(1f).build()));
        group.put(val, toAdd);
        ITEMS.register(val.toString().toLowerCase()  + "_" + nameSuffix, () -> toAdd);
    }
}