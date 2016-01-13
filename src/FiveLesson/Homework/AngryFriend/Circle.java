package FiveLesson.Homework.AngryFriend;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle extends Ellipse2D {

    private double x;
    private double y;
    private double wight;
    private double height;

    public Circle() {

    }

    public double getWight() {
        return wight;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWight(double wight) {
        this.wight = wight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Circle(double x, double y, double wight, double height) {
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.height = height;

    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return wight;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double x, double y, double wight, double height) {
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.height = height;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}
