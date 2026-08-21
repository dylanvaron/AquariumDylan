public class ClownFish extends SeaCreature {
    
    private String normalSymbol;
    private String smileSymbol;
    private int maxCount;
    private int count;

    public ClownFish(String name, int position, int speed, int direction, String normalSymbol, String smileSymbol, int maxCount) {
        super(name, position, speed, direction);
        this.normalSymbol = normalSymbol;
        this.smileSymbol = smileSymbol;
        this.maxCount = maxCount;
        count = maxCount;

    }

    @Override
    public void move(int tankWidth) {
        if(count > 0) {
            position += speed * direction;
            keepInsideTank(tankWidth);
            count--;
        }
        else {
            count = maxCount;
        }
    }

    @Override
    public String getSymbol() {
        String symbol = count > 0 ? normalSymbol : smileSymbol;
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }

    private String reverseSymbol(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
