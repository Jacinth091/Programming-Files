package Entity;

public abstract class Object {

    protected int xPos, yPos;
    protected int velocity;
    protected int dirX, dirY;



    public abstract void checkOutOfBounds();

    public abstract void getCoordinates();





}
