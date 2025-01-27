public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Generate random items
        System.out.println("🎲 Generating random items...");
        inventory.generateRandomItem("Iron Sword");
        inventory.generateRandomItem("Iron Shield");
        inventory.generateRandomItem("Iron Helmet");

        // Display inventory
        inventory.displayInventory();

        // Save inventory to a file
        inventory.saveToFile("inventory.txt");

        // Clear and reload inventory
        System.out.println("\n🔄 Reloading inventory from file...");
        inventory = new Inventory();
        inventory.loadFromFile("inventory.txt");

        // Display inventory again
        inventory.displayInventory();

        // Attempt an upgrade
        System.out.println("\n🔧 Attempting to upgrade items...");
        inventory.upgradeItem("Iron Sword", Rarity.COMMON);
        inventory.upgradeItem("Iron Shield", Rarity.RARE);

        // Display inventory after upgrades
        inventory.displayInventory();
    }
}
