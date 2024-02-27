package com.example.items.tools;

import com.example.items.CustomToolMaterials;
import net.minecraft.item.AxeItem;

public class CustomAxeItem extends AxeItem {
    public CustomAxeItem(CustomToolMaterials material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
