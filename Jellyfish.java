public class Jellyfish extends SeaCreature {

    private String openSymbol;
    private String closedSymbol;
    private boolean charging;

    public Jellyfish(String name, int position, int speed, int direction, String openSymbol, String closedSymbol) {
        super(name, position, speed, direction);
        this.openSymbol = openSymbol;
        this.closedSymbol = closedSymbol;
        charging = false;
    }

    @Override
    public void move(int tankWidth) {
        if(charging) {
            position += speed * direction;
            keepInsideTank(tankWidth);
            charging = false;
        }
        else {
            charging = true;
        }
    }

    @Override
    public String getSymbol() {
        String symbol = charging ? openSymbol : closedSymbol;
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }

    private String reverseSymbol(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
