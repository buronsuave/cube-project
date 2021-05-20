package models;

public class Cube 
{
    private double length;
    private double angleX;
    private double angleY;
    private double angleZ;
    private double x;
    private double y;
    private double z;

    public Cube()
    {
        setLength(50);
        setAngleX(0);
        setAngleY(0);
        setAngleZ(0);
        setX(400);
        setY(300);
        setZ(0);
    }

    public double getZ() 
    {
        return z;
    }

    public void setZ(double z) 
    {
        this.z = z;
    }

    public double getY() 
    {
        return y;
    }

    public void setY(double y) 
    {
        this.y = y;
    }

    public double getX() 
    {
        return x;
    }

    public void setX(double x) 
    {
        this.x = x;
    }

    public double getAngleZ() 
    {
        return angleZ;
    }

    public void setAngleZ(double angleZ) 
    {
        this.angleZ = angleZ;
    }

    public double getAngleY() 
    {
        return angleY;
    }

    public void setAngleY(double angleY) 
    {
        this.angleY = angleY;
    }

    public double getAngleX() 
    {
        return angleX;
    }

    public void setAngleX(double angleX) 
    {
        this.angleX = angleX;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }
}
