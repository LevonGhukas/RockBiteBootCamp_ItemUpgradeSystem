public enum Rarity {
    COMMON, GREAT, RARE, EPIC, LEGENDARY;

    public Rarity next() {
        if (this.ordinal() < Rarity.values().length - 1) {
            return Rarity.values()[this.ordinal() + 1];
        }
        return null;
    }
}
