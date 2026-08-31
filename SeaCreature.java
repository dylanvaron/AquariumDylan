public abstract class SeaCreature {

    protected String name;
    protected int position;
    protected int speed;
    protected int direction;
    protected int maxHunger;
    protected int currentHunger;

    public SeaCreature(String name, int position, int speed, int direction, int maxHunger) throws InvalidCreatureException {
        if(name != null && position >= 0 && speed >= 0 && (direction == -1 || direction == 1) && maxHunger >= 1) {
            this.name = name;
            this.position = position;
            this.speed = speed;
            this.direction = direction;
            this.maxHunger = maxHunger;
            currentHunger = maxHunger;
        }
        else {
            throw new InvalidCreatureException("Invalid value in creature construction");
        }
    }

    // Each subclass decides how it moves.
    public abstract void move(int tankWidth);

    // Each subclass decides how it looks in the terminal.
    public abstract String getSymbol();

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public String getHungerStats() {
        return "(" + currentHunger + "/" + maxHunger + ")";
    }

    public int getCurrentHunger() {
        return currentHunger;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void turnAround() {
        direction *= -1;
    }

    protected void keepInsideTank(int tankWidth) {
        int maxPosition = Math.max(0, tankWidth - getSymbol().length());

        if (position > maxPosition) {
            position = maxPosition;
            direction = -1;
        }

        if (position < 0) {
            position = 0;
            direction = 1;
        }
    }

    public String getDirectionWord() {
        return direction >= 0 ? "right" : "left";
    }

    // Each subclass gets to determine the frequency of hunger checks and the amount decremented each turn
    public abstract void feed(int foodAmt);

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " | name=" + name
                + " | position=" + position
                + " | speed=" + speed
                + " | direction=" + getDirectionWord();
    }
}
