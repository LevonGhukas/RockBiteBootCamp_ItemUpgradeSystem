public class Item {
    private String name;
    private Rarity rarity;
    private int upgradeCount;

    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void incrementUpgradeCount() {
        upgradeCount++;
    }

    public void upgradeToNextRarity() {
        if (rarity == Rarity.EPIC && upgradeCount == 2) {
            rarity = Rarity.LEGENDARY;
            upgradeCount = 0;
        } else if (rarity == Rarity.EPIC) {
            incrementUpgradeCount();
        } else {
            Rarity nextRarity = rarity.next();
            if (nextRarity != null) {
                rarity = nextRarity;
            }
        }
    }

    @Override
    public String toString() {
        return name + " (" + rarity + (rarity == Rarity.EPIC ? " " + upgradeCount : "") + ")";
    }
}
