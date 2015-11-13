package SecondLesson.HomeWork.TigerArmor;

public class Tank {
    protected int speed = 10;
    private int x;
    private int y;
    private Direction direction;
    private ActionField actionField;
    private BattleField battleField;

    public Tank(ActionField actionField, BattleField battleField) {
        this(0, 512, Direction.UP, actionField, battleField);
    }

    public Tank(int x, int y, Direction direction, ActionField actionField,
                BattleField battleField) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.actionField = actionField;
        this.battleField = battleField;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public ActionField getActionField() {
        return actionField;
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void turn(Direction direction) throws Exception {
        this.direction = direction;
        actionField.processTurn(this);
    }

    public void move() throws Exception {
        actionField.processMove(this);
    }


    public void fire() throws Exception {
        Bullet bullet = new Bullet(x + 25, y + 25, direction);
        actionField.processFire(bullet);
    }


    public void moveToQuadrant(int v, int h) throws Exception {
        String coordinates = actionField.getQuadrant(v, h);
        int separator = coordinates.indexOf("_");
        int x = Integer.parseInt(coordinates.substring(0, separator));
        int y = Integer.parseInt(coordinates.substring(separator + 1));

        if (this.y < x && x >= actionField.getMinimumFieldSize() && x <= actionField.getMaximumFieldSize()) {
            turn(Direction.DOWN);
            while (this.y != x) {
                move();
            }
        }

        if (this.y > x && x >= actionField.getMinimumFieldSize() && x <= actionField.getMaximumFieldSize()) {
            turn(Direction.UP);
            while (this.y != x) {
                move();
            }
        }

        if (this.x < y && y >= actionField.getMinimumFieldSize() && y <= actionField.getMaximumFieldSize()) {
            turn(Direction.RIGHT);
            while (this.x != y) {
                move();
            }
        }

        if (this.x > y && y >= actionField.getMinimumFieldSize() && y <= actionField.getMaximumFieldSize()) {
            turn(Direction.LEFT);
            while (this.x != y) {
                move();
            }
        }
    }

    public int random() {
        int rand = 0;
        int[] array = {1, 2, 3, 4};
        long time = System.currentTimeMillis();
        String str = Long.toString(time);
        char lostSimbol = str.charAt(str.length() - 1);
        int lost = Integer.parseInt(String.valueOf(lostSimbol));
        if (lost >= 6 && lost <= 7) {
            rand = array[0];
        }
        if (lost >= 3 && lost <= 5) {
            rand = array[1];
        }
        if (lost >= 0 && lost <= 2) {
            rand = array[2];
        }
        if (lost >= 8 && lost <= 9) {
            rand = array[3];
        }
        return rand;
    }

    void clean() throws Exception {
        String str = actionField.getQuadrantXY(getX(), getY());
        int tankV = Integer.valueOf(str.substring(0, 1));
        int tankH = Integer.valueOf(str.substring(2, str.length()));

        if (battleField.scanQuadrant(tankH, tankV) == "B") {
            System.out.println("Initial data are false!");
            System.out.println("GAME OVER!!!");
            return;
        } else {
            for (int i = tankV + 1; i >= 1; i--) {
                actionField.fireUp();
                actionField.fireRight();
                actionField.fireDown();
                actionField.fireLeft();
                moveToQuadrant(i, tankH + 1);
                tankV--;
            }
            for (int i = tankH + 1; i >= 1; i--) {
                actionField.fireUp();
                actionField.fireRight();
                actionField.fireDown();
                actionField.fireLeft();
                moveToQuadrant(tankV + 1, i);
            }
            for (int i = 1; i <= battleField.getBattleField().length; i++) {
                actionField.fireUp();
                actionField.fireRight();
                actionField.fireDown();
                actionField.fireLeft();
                moveToQuadrant(i, 1);
            }
        }
        // fire
        actionField.fireUp();
        actionField.fireRight();
        actionField.fireDown();
        actionField.fireLeft();
        System.out.println("GAME OVER!!!");
    }

    public void destroy() {

        x = -100;
        y = -100;
    }
}
