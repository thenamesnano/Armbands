package com.nanosplace.armbands.init.items;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

public class ModArmbandItem extends DyeableArmorItem implements IItemColor {
    private static final String NBT_COLOR = "ArmbandColor";
    public ModArmbandItem() {
        super(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, new Item.Properties()
                .stacksTo(1)
                .tab(ItemGroup.TAB_COMBAT)
                .rarity(Rarity.COMMON));
    }

    public ModArmbandItem(Properties properties) {
        super(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, properties);
    }

    public static int getArmbandColor(ItemStack stack) {
        return stack.getOrCreateTag().getInt(NBT_COLOR);
    }

    public static void setArmbandColor(ItemStack stack, int color) {
        stack.getOrCreateTag().putInt(NBT_COLOR, color);
    }

    public int getColor(ItemStack stack, int tintIndex) {
        if (tintIndex == 0) {
            return getArmbandColor(stack);
        }
        return 0xFFFFFF;
    }

}
