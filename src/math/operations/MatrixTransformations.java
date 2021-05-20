package math.operations;

import math.objects.Matrix;

public class MatrixTransformations 
{
    public static final Matrix IDENTITY = new Matrix(
        new double[][]
        {
            {1, 0, 0, 0}, 
            {0, 1, 0, 0}, 
            {0, 0, 1, 0}, 
            {0, 0, 0, 1}
        }
    );

    public static Matrix getMoveXMatrix(double x)
    {
        return new Matrix(
            new double[][]
            {
                {1, 0, 0, x}, 
                {0, 1, 0, 0}, 
                {0, 0, 1, 0}, 
                {0, 0, 0, 1}
            }
        );   
    }

    public static Matrix getMoveYMatrix(double y)
    {
        return new Matrix(
            new double[][]
            {
                {1, 0, 0, 0}, 
                {0, 1, 0, y}, 
                {0, 0, 1, 0}, 
                {0, 0, 0, 1}
            }
        );
    }

    public static Matrix getMoveZMatrix(double z)
    {
        return new Matrix(
            new double[][]
            {
                {1, 0, 0, 0}, 
                {0, 1, 0, 0}, 
                {0, 0, 1, z}, 
                {0, 0, 0, 1}
            }
        );
    }

    public static Matrix getRotateXMatrix(double x)
    {
        return new Matrix(
            new double[][]
            {
                {1, 0, 0, 0}, 
                {0, Math.cos(x), -Math.sin(x), 0}, 
                {0, Math.sin(x), Math.cos(x), 0}, 
                {0, 0, 0, 1}
            }
        ); 
    }

    public static Matrix getRotateYMatrix(double y)
    {
        return new Matrix(
            new double[][]
            {
                {Math.cos(y), 0, -Math.sin(y), 0}, 
                {0, 1, 0, 0}, 
                {Math.sin(y), 0, Math.cos(y), 0}, 
                {0, 0, 0, 1}
            }
        );
    }

    public static Matrix getRotateZMatrix(double z)
    {
        return new Matrix(
            new double[][]
            {
                {Math.cos(z), -Math.sin(z), 0, 0},
                {Math.sin(z), Math.cos(z), 0, 0}, 
                {0, 0, 1, 0}, 
                {0, 0, 0, 1}
            }
        );
    }

    public static Matrix getScaleMatrix(double r)
    {
        return new Matrix(
            new double[][]
            {
                {r, 0, 0, 0}, 
                {0, r, 0, 0}, 
                {0, 0, r, 0}, 
                {0, 0, 0, 1}
            }
        );
    }

    public static Matrix getPositionMatrix(double x, double y, double z)
    {
        return new Matrix(
            new double[][]
            {
                {1, 0, 0, x}, 
                {0, 1, 0, y}, 
                {0, 0, 1, z}, 
                {0, 0, 0, 1}
            }
        );
    }
}
