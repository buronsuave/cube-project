package math.operations;

import math.objects.Matrix;

/**
 * @author: David Alejandro Lopez Torres
 * @version: 1.0
 */

public class MatrixOperations
{
    /**
     * Add to matrixes an return the result (A[i,j] + B[i,j]). 
     * They must have the same dimensions
     * @param A - first matrix
     * @param B - second matrix
     * @return resultant matrix 
     */
    public static Matrix addMatrix(Matrix A, Matrix B)
    {
        Matrix C = new Matrix(A.getRows(), A.getCols());

        for (int i = 0; i < A.getRows(); i++)
        {
            for (int j = 0; j < A.getCols(); j++)
            {
                C.getValues()[i][j] = A.getValues()[i][j] + B.getValues()[i][j];
            }
        }
        return C;
    }

    /**
     * Substract matrixes and return the result (A[i,j] - B[i,j]). 
     * They must have the same dimensions
     * @param A - first matrix (positive)
     * @param B - second matrix (negative)
     * @return resultant matrix
     */
    public static Matrix subbMatrix(Matrix A, Matrix B) 
    {
        Matrix C = new Matrix(A.getRows(), A.getCols());

        for (int i = 0; i < A.getRows(); i++)
        {
            for (int j = 0; j < A.getCols(); j++)
            {
                C.getValues()[i][j] = A.getValues()[i][j] - B.getValues()[i][j];
            }
        }
        return C;
    }

    /**
     * Make cross matrix product and return the result. 
     * (C[i,j] = Dot product between A[i] vector and B[j] transpose vector). 
     * A cols and B rows must be equals. 
     * @param A - first matrix
     * @param B - secons matrix
     * @return resultant matrix
     */
    public static Matrix crossMatrix(Matrix A, Matrix B) 
    {
        Matrix C = new Matrix(A.getRows(), B.getCols());

        for (int i = 0; i < A.getRows(); i++)
        {
            for (int j = 0; j < B.getCols(); j++)
            {
                for (int k = 0; k < A.getCols(); k++)
                {
                    C.getValues()[i][j] += A.getValues()[i][k] * B.getValues()[k][j];
                }
            }
        }

        return C;
    }

    /**
     * Make transpossed matrix and return it as a new matrix. 
     * (B[i][j] = A[j][i])
     * @param A - matrix to transpose
     * @return transpossed matrix
     */
    public static Matrix transMatrix(Matrix A) 
    {
        Matrix B = new Matrix(A.getCols(), A.getRows());

        for (int i = 0; i < A.getRows(); i++) 
        {
            for (int j = 0; j < A.getCols(); j++) 
            {
                B.getValues()[j][i] = A.getValues()[i][j];
            }
        }
        return B;
    }
}
