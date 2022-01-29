package programmercat.lifestealnotverygoodedition;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack rerollItem;

    public static void init() {
        createRerollItem();
    }

    private static void createRerollItem() {

        //item
        ItemStack item = new ItemStack(Material.RED_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Reroll Hearts");
        List<String> lore = new ArrayList<>();

        lore.add("randomizes hearts when used");

        meta.setLore(lore);

        meta.addEnchant(Enchantment.LURE, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        //recipe

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("rerollitem"), item);
        recipe.shape("ABA",
                "BAB",
                "ABA");
        recipe.setIngredient('A', Material.IRON_BLOCK);
        recipe.setIngredient('B', Material.DIAMOND);

        Bukkit.getServer().addRecipe(recipe);

        rerollItem = item;
    }

}
