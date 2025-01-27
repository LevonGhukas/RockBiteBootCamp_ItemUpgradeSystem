
import java.util.*;
import java.util.Random;
import java.io.*;

public class Inventory {
    private Map<Rarity, Map<String, List<Item>>> itemsByRarity;

    public Inventory() {
        itemsByRarity = new HashMap<>();
        for (Rarity rarity : Rarity.values()) {
            itemsByRarity.put(rarity, new HashMap<>());
        }
    }

    // Add an item to the inventory
    public void addItem(Item item) {
        itemsByRarity.get(item.getRarity())
                .computeIfAbsent(item.getName(), k -> new ArrayList<>())
                .add(item);
    }

    // Create a new item
    public void createItem(String name, Rarity rarity) {
        addItem(new Item(name, rarity));
        System.out.println("Created new item: " + name + " (" + rarity + ")");
    }

    // Upgrade an item
    public void upgradeItem(String name, Rarity rarity) {
        Map<String, List<Item>> itemsOfRarity = itemsByRarity.get(rarity);
        if (itemsOfRarity == null || !itemsOfRarity.containsKey(name)) {
            System.out.println("⚠️ No items of type " + name + " with rarity " + rarity + " found.");
            return;
        }

        List<Item> itemList = itemsOfRarity.get(name);
        if (itemList == null || itemList.size() < 1) {
            System.out.println("⚠️ No items available for upgrade: " + name + " (" + rarity + ")");
            return;
        }

        int requiredItems = determineRequiredItems(rarity, itemList.get(0).getUpgradeCount());

        if (itemList.size() < requiredItems) {
            System.out.printf("⚠️ Not enough %s items to upgrade %s. Required: %d, Available: %d.%n",
                    rarity, name, requiredItems, itemList.size());
            return;
        }

        // Perform the upgrade
        Item baseItem = itemList.remove(0);
        for (int i = 1; i < requiredItems; i++) {
            itemList.remove(0);
        }

        baseItem.upgradeToNextRarity();
        addItem(baseItem);

        System.out.println("✨ Successfully upgraded " + name + " to: " + baseItem);
    }


    // Display inventory grouped by rarity
    public void displayInventory() {
        System.out.println("\n=== Inventory ===");
        for (Rarity rarity : Rarity.values()) {
            Map<String, List<Item>> itemsOfRarity = itemsByRarity.get(rarity);
            if (itemsOfRarity != null && !itemsOfRarity.isEmpty()) {
                System.out.println(rarity + ":");
                for (Map.Entry<String, List<Item>> entry : itemsOfRarity.entrySet()) {
                    String itemName = entry.getKey();
                    List<Item> itemList = entry.getValue();
                    System.out.printf("  %s (x%d): %s%n", itemName, itemList.size(), itemList);
                }
            }
        }
        System.out.println("=================");
    }

    // Determine required items for upgrades
    private int determineRequiredItems(Rarity rarity, int upgradeCount) {
        switch (rarity) {
            case COMMON:
            case GREAT:
            case RARE:
                return 3; // Base + 2 additional items
            case EPIC:
                if (upgradeCount == 2) {
                    return 3; // Epic 2 to Legendary requires 3 Epic 2 items
                } else {
                    return 2; // Incremental Epic upgrades
                }
            default:
                return 0;
        }
    }

    public void generateRandomItem(String name) {
        Random random = new Random();
        int randValue = random.nextInt(100);
        Rarity rarity;

        if (randValue < 50) {
            rarity = Rarity.COMMON;
        } else if (randValue < 75) {
            rarity = Rarity.GREAT;
        } else if (randValue < 90) {
            rarity = Rarity.RARE;
        } else if (randValue < 98) {
            rarity = Rarity.EPIC;
        } else {
            rarity = Rarity.LEGENDARY;
        }

        Item newItem = new Item(name, rarity);
        addItem(newItem);
        System.out.println("🎲 Generated item: " + newItem + " [Rarity: " + rarity + "]");
    }


    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Rarity rarity : Rarity.values()) {
                Map<String, List<Item>> itemsOfRarity = itemsByRarity.get(rarity);
                for (Map.Entry<String, List<Item>> entry : itemsOfRarity.entrySet()) {
                    for (Item item : entry.getValue()) {
                        writer.write(item.getName() + "," + item.getRarity() + "," + item.getUpgradeCount());
                        writer.newLine();
                    }
                }
            }
            System.out.println("✅ Inventory successfully saved to file: " + filename);
        } catch (IOException e) {
            System.err.println("❌ Error saving inventory: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    Rarity rarity = Rarity.valueOf(parts[1]);
                    int upgradeCount = Integer.parseInt(parts[2]);

                    Item item = new Item(name, rarity);
                    while (item.getUpgradeCount() < upgradeCount) {
                        item.incrementUpgradeCount();
                    }
                    addItem(item);
                }
            }
            System.out.println("✅ Inventory successfully loaded from file: " + filename);
        } catch (IOException e) {
            System.err.println("❌ Error loading inventory: " + e.getMessage());
        }
    }





}
