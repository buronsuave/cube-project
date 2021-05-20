package math.objects;

/**
 * @author: David Alejandro Lopez Torres. 17300155. 8D1
 * @version: 1.0
 */

public class Matrix 
{
    // Params
    private int rows;
    
    private int cols;
    
    private double[][] values;

    // Constructors
    public Matrix(int rows, int cols) 
    {
        values = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
        clear();
    }
    
    public Matrix(double[][] values) 
    {
        setValues(values);
    }

    // Getters and Setters
    public int getRows() 
    {
        return rows;
    }
    
    public double[][] getValues() 
    {
        return values;
    }
    
    public int getCols() 
    {
        return cols;
    }

    public void setValues(double[][] values) 
    {
        this.values = values;
        rows = values.length;
        if (rows == 0) 
        {
            cols = 0;
        } else 
        {
            cols = values[0].length;
        }
    }

    public double getValue(int row, int col)
    {
        return getValues()[row][col];
    }

    /**
     * Init a matrix with just 0
     */
    public void clear() 
    {
        for (int i = 0; i < rows; i++) 
        {          
            values[i] = new double[cols];
            for (int j = 0; j < cols; j++) 
            {
                values[i][j] = 0;
            }
        }
    }

    @Override
    public String toString() 
    {
        String outString = "";
        for (int i = 0; i < rows; i++) 
        {
            outString += "[";
            for (int j = 0; j < cols; j++) 
            {
                outString += values[i][j];
                if (j < cols-1) 
                {
                    outString += ", ";
                }
            }
            outString += "]";
            if (i < rows-1) 
            {
                outString += "\n";
            }
        }
        return outString;
    }
}
