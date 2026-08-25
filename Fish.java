public class Fish extends SeaCreature {

    private String symbol;

    public Fish(String name, int position, int speed, int direction, String symbol) {
        super(name, position, speed, direction, 10);
        this.symbol = symbol;
    }

    @Override
    public void move(int tankWidth) {
        position += speed * direction;
        keepInsideTank(tankWidth);
        currentHunger -= 2;
    }

    @Override
    public String getSymbol() {
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }

    @Override
    public void feed(int foodAmt) {
        currentHunger = Math.min(currentHunger + foodAmt, maxHunger);
    }

    private String reverseSymbol(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
