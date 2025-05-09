package nl.birdswithlegs.cursed_iron;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CursedIronMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(CursedIronMod.MODID);
    public static final String MODID = "cursed-iron";

    public static final ArmorMaterial CURSED_IRON_ARMOR_MATERIAL = new CursedIronArmorMaterial();
    public static final ToolMaterial CURSED_IRON_TOOL_MATERIAL = new CursedIronToolMaterial();

    public static final Item CURSED_IRON_INGOT = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_ingot"), new Item(new Item.Settings()));
    public static final Item CURSED_IRON_NUGGET = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_nugget"), new Item(new Item.Settings()));

    public static final Block CURSED_IRON_BLOCK = Registry.register(Registries.BLOCK, new Identifier(MODID, "cursed_iron_block"), new Block(AbstractBlock.Settings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));    
    public static final Item CURSED_IRON_BLOCK_ITEM = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_block_item"), new BlockItem(CURSED_IRON_BLOCK, new Item.Settings()));

    public static final Item CURSED_IRON_SWORD = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_sword"), new SwordItem(CURSED_IRON_TOOL_MATERIAL, 3, -2.4f, new Item.Settings()));
    public static final Item CURSED_IRON_SHOVEL = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_shovel"), new ShovelItem(CURSED_IRON_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings()));
    public static final Item CURSED_IRON_PICKAXE = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_pickaxe"), new PickaxeItem(CURSED_IRON_TOOL_MATERIAL, 1, -2.8f, new Item.Settings()));
    public static final Item CURSED_IRON_AXE = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_axe"), new AxeItem(CURSED_IRON_TOOL_MATERIAL, 6.0f, -3.1f, new Item.Settings()));
    public static final Item CURSED_IRON_HOE = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_hoe"), new HoeItem(CURSED_IRON_TOOL_MATERIAL, -2, -1.0f, new Item.Settings()));
    
    public static final Item CURSED_IRON_HELMET = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_helmet"), new ArmorItem(CURSED_IRON_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item CURSED_IRON_CHESTPLATE = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_chestplate"), new ArmorItem(CURSED_IRON_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item CURSED_IRON_LEGGINGS = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_leggings"), new ArmorItem(CURSED_IRON_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item CURSED_IRON_BOOTS = Registry.register(Registries.ITEM, new Identifier(MODID, "cursed_iron_boots"), new ArmorItem(CURSED_IRON_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()));

    // public static final Potion GOLEM_SOUL = Registry.register(Registries.POTION, new Identifier(MODID, "golem_soul"), new Potion(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 3), new StatusEffectInstance(StatusEffects.STRENGTH, 400, 1)));
    // public static final Potion LONG_GOLEM_SOUL = Registry.register(Registries.POTION, new Identifier(MODID, "long_golem_soul"), new Potion(new StatusEffectInstance(StatusEffects.SLOWNESS, 800, 3), new StatusEffectInstance(StatusEffects.STRENGTH, 800, 1)));
    // public static final Potion STRONG_GOLEM_SOUL = Registry.register(Registries.POTION, new Identifier(MODID, "strong_golem_soul"), new Potion(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 5), new StatusEffectInstance(StatusEffects.STRENGTH, 400, 2)));

	public void onInitialize() {
		ItemGroupEvents.modifyEntriesEvent((ItemGroups.BUILDING_BLOCKS)).register(content -> {
            content.addAfter(Items.IRON_BLOCK, CURSED_IRON_BLOCK_ITEM);
        });

        ItemGroupEvents.modifyEntriesEvent((ItemGroups.TOOLS)).register(content -> {
            content.addAfter(Items.IRON_HOE, CURSED_IRON_SHOVEL);
            content.addAfter(CURSED_IRON_SHOVEL, CURSED_IRON_PICKAXE);
            content.addAfter(CURSED_IRON_PICKAXE, CURSED_IRON_AXE);
            content.addAfter(CURSED_IRON_AXE, CURSED_IRON_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent((ItemGroups.COMBAT)).register(content -> {
            content.addAfter(Items.IRON_SWORD, CURSED_IRON_SWORD);
            content.addAfter(Items.IRON_AXE, CURSED_IRON_AXE);
            content.addAfter(Items.IRON_BOOTS, CURSED_IRON_HELMET);
            content.addAfter(CURSED_IRON_HELMET, CURSED_IRON_CHESTPLATE);
            content.addAfter(CURSED_IRON_CHESTPLATE, CURSED_IRON_LEGGINGS);
            content.addAfter(CURSED_IRON_LEGGINGS, CURSED_IRON_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent((ItemGroups.INGREDIENTS)).register(content -> {
            content.addAfter(Items.IRON_INGOT, CURSED_IRON_INGOT);
            content.addAfter(Items.IRON_NUGGET, CURSED_IRON_NUGGET);
        });
	}
}