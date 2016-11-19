    public enum GeneType {
        FIRE, WATER, GRASS;

        public static GeneType getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }
    }
