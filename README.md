# 🎮 **Item Upgrade System**

## 📝 **Description**  
The **Item Upgrade System** is a Java-based project that simulates a game inventory system. Players can create, store, and upgrade items based on rarity. Designed with object-oriented programming principles, the system provides functionality for managing, upgrading, and saving items efficiently.  

---

## 🌟 **Features**

- **Item Management:** Create, add, and organize items grouped by rarity in an inventory.
- **Upgrade Mechanics:** Combine items of the same type and rarity to upgrade them to higher rarities.
- **Random Item Generation:** Generate items with rarities based on weighted probabilities.
- **Inventory Persistence:** Save the inventory to a file and reload it at any time.
- **User-Friendly Output:** Displays the inventory in a clear, structured format with meaningful messages.

---

## 🚀 **How It Works**

### **Item Classes**
Each item has:
1. **Name:** A unique identifier for the item.
2. **Rarity:** Determines its level (COMMON → GREAT → RARE → EPIC → LEGENDARY).
3. **Upgrade Count:** Used for incremental upgrades of Epic items (e.g., Epic → Epic 1 → Epic 2).

### **Inventory System**
Items are grouped by rarity and type using efficient data structures.  
The inventory system can:
- Add and remove items.
- Perform upgrades by combining required items.
- Save and load its state from a file (`inventory.txt`).

### **Upgrade Rules**
1. Two additional items of the same type and rarity are required for a basic upgrade.  
2. Epic-to-Legendary upgrades require three Epic 2 items of the same type.

---

## 🛠️ **Getting Started**

### **Prerequisites**
- **Java Development Kit (JDK):** Version 8 or higher.

### **Running the Program**
1. Clone the repository or download the source files.
2. Open a terminal in the directory containing the files.
3. Compile the program using:
   ```bash
   javac Main.java
   ```
4. Run the program:
   ```bash
   java Main
   ```

---

## 📂 **File Structure**

```plaintext
.
├── Main.java          # Entry point for the program
├── Inventory.java     # Manages inventory operations
├── Item.java          # Represents a game item
├── Rarity.java        # Enum for item rarities
└── inventory.txt      # Saved inventory state
```

---

## 🎯 **Design Choices**

1. **Object-Oriented Design:**  
   The system is modular, with clear separation of concerns for items, inventory, and program logic.  

2. **User-Friendly Interface:**  
   Console output is structured, clean, and easy to follow.  

3. **Efficiency:**  
   Data structures like `HashMap` and `ArrayList` ensure fast and reliable operations.  

---

## 📊 **Assumptions**

- Items used in upgrades are permanently removed from the inventory.
- Weighted probabilities for random item rarities are as follows:  
  - **COMMON:** 50%  
  - **GREAT:** 25%  
  - **RARE:** 15%  
  - **EPIC:** 8%  
  - **LEGENDARY:** 2%  

---

## 🔧 **Future Enhancements**

- **Graphical User Interface (GUI):** To improve the user experience.
- **Advanced Upgrade Mechanics:** Adding materials or special requirements for upgrades.
- **Database Integration:** Extend inventory persistence using JSON or database storage.

---

## 📝 **License**

This project is open-source and free to use. Feel free to contribute, share, or modify as needed!
