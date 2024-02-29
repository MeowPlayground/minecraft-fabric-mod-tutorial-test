package com.example.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterEnchantments {
    public static final String MODID = "tutorial";
    public static final Enchantment FROST = new FrostEnchantment();

    public static void register() {
        Registry.register(Registries.ENCHANTMENT, new Identifier(MODID, "frost"), FROST);
    }
}
