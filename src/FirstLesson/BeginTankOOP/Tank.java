package FirstLesson.BeginTankOOP;
public class Tank {
    int tankDirection = 0;
    int tankX = 512;
    int tankY = 512;
    static int cellSize = 64;
    int step = 1;
    int moveUp = 1;
    int moveDown = 2;
    int moveLeft = 3;
    int moveRight = 4;
    int beginX = 1;
    int beginY = 1;
    int minimumCoordinate = 0;
    int maximumCoordinate = 9;
    int minimumFieldSize = 0;
    int maximumFieldSize = 512;
    int speed = 10;
    int tankH = tankX / cellSize;
    int tankV = tankY / cellSize;

    void fire() throws Exception {
        Bullet bullet = new Bullet();
        BattleField battleField = new BattleField();
        bullet.bulletX = tankX + 25;
        bullet.bulletY = tankY + 25;
        while ((bullet.bulletX > -15 && bullet.bulletX < battleField.BF_WIDTH)
                && (bullet.bulletY > -15 && bullet.bulletY < battleField.BF_HEIGHT)) {
            if (tankDirection == moveUp) {
                bullet.bulletY -= step;
            } else if (tankDirection == moveDown) {
                bullet.bulletY += step;
            } else if (tankDirection == moveLeft) {
                bullet.bulletX -= step;
            } else {
                bullet.bulletX += step;
            }
            bullet.repaintFire();
            bullet.deleteBullet();
        }
    }

    public void turn(int direction) {
        tankDirection = direction;
    }

    public void move(int direction) throws Exception {
        ActionField actionField = new ActionField();
        actionField.illegaleMove(direction);
        turn(direction);
        for (int i = 0; i < cellSize; i++) {
            actionField.illegaleMove(direction);
            actionField.moveUp(direction);
            actionField.moveDown(direction);
            actionField.moveLeft(direction);
            actionField.moveRight(direction);
            actionField.repaintMove();
        }
    }
}
