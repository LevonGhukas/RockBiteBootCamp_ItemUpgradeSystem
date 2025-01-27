🎮 Item Upgrade System
Welcome to the Item Upgrade System! This Java-based project simulates an inventory system for a game where items can be created, stored, and upgraded based on rarity. The system uses object-oriented programming principles and provides functionality for managing, upgrading, and saving items in a clean and efficient way.

🌟 Features
Item Management: Create, add, and organize items in an inventory grouped by rarity.
Upgrade Mechanics: Combine items of the same type and rarity to upgrade them to higher rarities.
Random Item Generation: Generate items with rarities based on weighted probabilities.
Inventory Persistence: Save the inventory to a file and reload it anytime.
User-Friendly Output: Displays inventory in a clear and structured way with meaningful messages.

🛠️ How It Works
Item Classes
Each item has a name, rarity, and (if Epic) an upgrade count.
Rarity progresses in the following order: COMMON → GREAT → RARE → EPIC → LEGENDARY.
Epic items have incremental upgrades (Epic 1, Epic 2) before reaching Legendary.
Inventory System
Items are grouped by rarity and type using efficient data structures.
Inventory can:
Add and remove items.
Perform upgrades by combining required items.
Save and load its state from a file (inventory.txt).
Upgrade Rules
Items require two additional items of the same type and rarity for an upgrade.
Epic-to-Legendary upgrades require three Epic 2 items of the same type.

🚀 Getting Started
Prerequisites
Install Java Development Kit (JDK) (version 8 or higher).
Running the Program
1.Clone the repository or download the source files.
2.Open a terminal in the directory containing the files.
3.Compile the program: javac Main.java
4.Run the program: java Main

📋 Example Usage
Here's an example of what you can expect when running the program:
🎲 Generating random items...
🎲 Generated item: Iron Sword (COMMON)
🎲 Generated item: Iron Shield (GREAT)
🎲 Generated item: Iron Helmet (RARE)

=== Inventory ===
COMMON:
  Iron Sword (x1): [Iron Sword (COMMON)]
GREAT:
  Iron Shield (x1): [Iron Shield (GREAT)]
RARE:
  Iron Helmet (x1): [Iron Helmet (RARE)]
=================

✅ Inventory successfully saved to file: inventory.txt
🔄 Reloading inventory from file...
✅ Inventory successfully loaded from file: inventory.txt

=== Inventory ===
COMMON:
  Iron Sword (x1): [Iron Sword (COMMON)]
GREAT:
  Iron Shield (x1): [Iron Shield (GREAT)]
RARE:
  Iron Helmet (x1): [Iron Helmet (RARE)]
=================

🔧 Attempting to upgrade items...
⚠️ Not enough COMMON items to upgrade Iron Sword. Required: 3, Available: 1.
⚠️ Not enough RARE items to upgrade Iron Shield. Required: 3, Available: 1.

=== Inventory ===
COMMON:
  Iron Sword (x1): [Iron Sword (COMMON)]
GREAT:
  Iron Shield (x1): [Iron Shield (GREAT)]
RARE:
  Iron Helmet (x1): [Iron Helmet (RARE)]
=================

📂 File Structure
.
├── Main.java          # Entry point for the program
├── Inventory.java     # Manages inventory operations
├── Item.java          # Represents a game item
├── Rarity.java        # Enum for item rarities
└── inventory.txt      # Saved inventory state

Design Choices
Object-Oriented Design: The system is modular, with clear separation of concerns for items, inventory, and program logic.
User-Friendly Interface: Console output is structured, clean, and easy to follow.
Efficiency: Data structures like HashMap and ArrayList ensure fast and reliable operations.

 Assumptions
Items removed during upgrades are permanently deleted.
Random item rarities follow weighted probabilities:
COMMON: 50%
GREAT: 25%
RARE: 15%
EPIC: 8%
LEGENDARY: 2%

🔧 Future Enhancements
Add a graphical user interface (GUI) for better user experience.
Support more complex upgrade mechanics (e.g., adding materials for upgrades).
Extend inventory persistence to include JSON or database storage.

📝 License 
This project is open-source and free to use. Feel free to copy this directly into your GitHub repository! Let me know if you need any further adjustments.

