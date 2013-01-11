/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gaetan
 */
public class MatrixErrorTest {
    
    public MatrixErrorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setTwoDarray method, of class MatrixError.
     */
    @Test
    public void testSetTwoDarray() {
        System.out.println("--> setTwoDarray");
        
        int nrow = 4, ncol = 5;
        double val1 = 3.4D, val2 = 2.1D;
        
        MatrixError amatrix = new MatrixError(nrow, ncol, val1);
        MatrixError result = new MatrixError(nrow, ncol, val2);
        double[][] aarray = new double[nrow][ncol];
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                aarray[i][j] = val2;
            }
        }
        
        amatrix.setTwoDarray(aarray);
        
        assertEquals(amatrix.getNcol(), result.getNcol());
        assertEquals(amatrix.getNrow(), result.getNrow());
        for (int i = 0; i < nrow; i++)
            for (int j = 0; j < ncol; j++)
                assertEquals(result.getElement(i, j), amatrix.getElement(i, j), 1.0e-7);
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testSetTwoDarray_wrongRow() {
        System.out.println("--> setTwoDarray with wrong nrow");
        
        int nrow = 4, ncol = 5;
        double val1 = 3.4D;
        
        MatrixError amatrix = new MatrixError(nrow, ncol, val1);
        double[][] aarray = new double[nrow+1][ncol];
        
        amatrix.setTwoDarray(aarray);
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testSetTwoDarray_wrongCol() {
        System.out.println("--> setTwoDarray with wrong ncol");
        
        int nrow = 4, ncol = 5;
        double val1 = 3.4D;
        
        MatrixError amatrix = new MatrixError(nrow, ncol, val1);
        double[][] aarray = new double[nrow][ncol+1];
        
        amatrix.setTwoDarray(aarray);
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testSetTwoDarray_wrongRowLength() {
        System.out.println("--> setTwoDarray with different row lengths");
        
        int nrow = 4, ncol = 5;
        double val1 = 3.4D;
        
        MatrixError amatrix = new MatrixError(nrow, ncol, val1);
        double[][] aarray = new double[nrow][ncol];
        aarray[0] = new double[ncol+1];
        amatrix.setTwoDarray(aarray);
    }
    
    
    /**
     * Test of setSubMatrix method, of class MatrixError.
     */
    @Test
    public void testSetSubMatrix_5args() {
        System.out.println("--> setSubMatrix - 5 args");
        
        int i = 2,          j = 1;
        int k = 4,          l = 3;
        int nrow = k+1,   ncol = l+1;
        
        MatrixError matrix = new MatrixError(nrow, ncol, -1.0D);
        
        double[][] smat = new double[k-i][l-j];
        for (int r = 0; r < k-i; r++)
            for (int c = 0; c < l-j; c++)
                smat[r][c] = 10*r+c;
        
        matrix.setSubMatrix(i, j, k, l, smat);
        
        for (int r = 0; r < k-i; r++)
            for (int c = 0; c < l-j; c++) {
                assertEquals(smat[r][c], matrix.getElement(i+r, j+c), 1.0e-7);
            }
        
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testSetSubMatrix_5args_wrongRowIndices() {
        System.out.println("--> setSubMatrix - 5 args with wrong row indices");
        
        int i = 2,          j = 1;
        int k = 1,          l = 3;
        int nrow = k+1,   ncol = l+1;
        
        double[][] smat = new double[i-k][l-j];
        MatrixError matrix = new MatrixError(nrow, ncol, -1.0);
        
        matrix.setSubMatrix(i, j, k, l, smat);
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testSetSubMatrix_5args_wrongColIndices() {
        System.out.println("--> setSubMatrix - 5 args with wrong col indices");
        
        int i = 2,          j = 3;
        int k = 4,          l = 1;
        int nrow = k+1,   ncol = l+1;
        
        double[][] smat = new double[k-i][j-l];
        MatrixError matrix = new MatrixError(nrow, ncol, -1.0);
        
        matrix.setSubMatrix(i, j, k, l, smat);
    }
    

    /**
     * Test of setSubMatrix method, of class MatrixError.
     */
    @Test
    public void testSetSubMatrix_3args() {
        System.out.println("--> setSubMatrix - 3 args");
        
        int rowLength = 2, colLength = 3;
        int nrow = 2*rowLength+1, ncol = 2*colLength+1;
        
        MatrixError matrix = new MatrixError(nrow, ncol, 0);
        
        int[] row = new int[rowLength];
        for (int i = 0; i < rowLength; i++)
            row[i] = 2*i;
        
        int[] col = new int[colLength];
        for (int j = 0; j < colLength; j++)
            col[j] = 2*j;
        
        double[][] smat = new double[rowLength][colLength];
        for (int i = 0; i < rowLength; i++)
            for (int j = 0; j < colLength; j++)
                smat[i][j] = 10*i+j;
        
        matrix.setSubMatrix(row, col, smat);
        
        for (int i = 0; i < rowLength; i++)
            for (int j = 0; j < colLength; j++)
                assertEquals(smat[i][j], matrix.getElement(row[i], col[j]), 1.0e-7);
    }
    
    
    /**
     * Test of identityMatrix method, of class MatrixError.
     */
    @Test
    public void testIdentityMatrix() {
        System.out.println("--> identityMatrix");
        
        int nrow = 4;
        
        MatrixError expResult = new MatrixError(nrow, nrow, 0);
        for (int i = 0; i < nrow; i++)
            expResult.setElement(i, i, 1);
        
        MatrixError result = MatrixError.identityMatrix(nrow);
        
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < nrow; j++) {
                assertEquals(expResult.getElement(i, j), result.getElement(i, j), 1.0e-7);
            }
        }
        
    }
    
    
    /**
     * Test of scalarMatrix method, of class MatrixError.
     */
    @Test
    public void testScalarMatrix() {
        System.out.println("--> scalarMatrix");
        
        int nrow = 4;
        double diagconst = 6.3;
        
        MatrixError expResult = new MatrixError(nrow, nrow, 0);
        for (int i = 0; i < nrow; i++)
            expResult.setElement(i, i, diagconst);
        
        MatrixError result = MatrixError.scalarMatrix(nrow, diagconst);
        
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < nrow; j++) {
                assertEquals(expResult.getElement(i, j), result.getElement(i, j), 1.0e-7);
            }
        }
        
    }
    
    
    /**
     * Test of diagonalMatrix method, of class MatrixError.
     */
    @Test
    public void testDiagonalMatrix() {
        System.out.println("--> diagonalMatrix");
        
        int nrow = 4;
        double[] diag = new double[nrow];
        for (int i = 0; i < nrow; i++)
            diag[i] = i+1;
        
        MatrixError expResult = new MatrixError(nrow, nrow, 0);
        for (int i = 0; i < nrow; i++)
            expResult.setElement(i, i, diag[i]);
        
        MatrixError result = MatrixError.diagonalMatrix(nrow, diag);
        
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < nrow; j++) {
                assertEquals(expResult.getElement(i, j), result.getElement(i, j), 1.0e-7);
            }
        }
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testDiagonalMatrix_wrongDiagLength() {
        System.out.println("--> diagonalMatrix with wrong diag length");
        
        int nrow = 4;
        double[] diag = new double[nrow + 1]; // add 1 to nrow /!\
        for (int i = 0; i < nrow; i++)
            diag[i] = i+1;
        
        MatrixError expResult = new MatrixError(nrow, nrow, 0);
        for (int i = 0; i < nrow; i++)
            expResult.setElement(i, i, diag[i]);
        
        MatrixError result = MatrixError.diagonalMatrix(nrow, diag);
    }
    
    
    /**
     * Test of getArrayCopy method, of class MatrixError.
     */
    @Test
    public void testGetArrayCopy() {
        System.out.println("--> getArrayCopy");
        
        MatrixError instance = new MatrixError(2, 2, 0);
        instance.setElement(0, 0, 2.0);
        instance.setElement(0, 1, -4.0);
        instance.setElement(1, 0, 3.3);
        instance.setElement(1, 1, 0.6);
        
        double[][] expResult = new double[2][2];
        expResult[0][0] = 2.0;
        expResult[0][1] = -4.0;
        expResult[1][0] = 3.3;
        expResult[1][1] = 0.6;
        
        double[][] result = instance.getArrayCopy();
        
        assertEquals(expResult[0][0], result[0][0], 1.0e-7);
        assertEquals(expResult[1][0], result[1][0], 1.0e-7);
        assertEquals(expResult[0][1], result[0][1], 1.0e-7);
        assertEquals(expResult[1][1], result[1][1], 1.0e-7);
    }
    
    
    
    
    
    
    /**************************************************************************/
    /********                **************************************************/
    /******** END OF MY WORK **************************************************/
    /********                **************************************************/
    /**************************************************************************/
    
    
    
    
    /**
     * Test of getSubMatrix method, of class MatrixError.
     */
    @Test
    public void testGetSubMatrix_4args() {
        System.out.println("getSubMatrix");
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.getSubMatrix(i, j, k, l);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubMatrix method, of class MatrixError.
     */
    @Test
    public void testGetSubMatrix_intArr_intArr() {
        System.out.println("getSubMatrix");
        int[] row = null;
        int[] col = null;
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.getSubMatrix(row, col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndexReference method, of class MatrixError.
     */
    @Test
    public void testGetIndexReference() {
        System.out.println("getIndexReference");
        MatrixError instance = null;
        int[] expResult = null;
        int[] result = instance.getIndexReference();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndexPointer method, of class MatrixError.
     */
    @Test
    public void testGetIndexPointer() {
        System.out.println("getIndexPointer");
        MatrixError instance = null;
        int[] expResult = null;
        int[] result = instance.getIndexPointer();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndexCopy method, of class MatrixError.
     */
    @Test
    public void testGetIndexCopy() {
        System.out.println("getIndexCopy");
        MatrixError instance = null;
        int[] expResult = null;
        int[] result = instance.getIndexCopy();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSwap method, of class MatrixError.
     */
    @Test
    public void testGetSwap() {
        System.out.println("getSwap");
        MatrixError instance = null;
        double expResult = 0.0;
        double result = instance.getSwap();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copy method, of class MatrixError.
     */
    @Test
    public void testCopy_MatrixError() {
        System.out.println("copy");
        MatrixError a = null;
        MatrixError expResult = null;
        MatrixError result = MatrixError.copy(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copy method, of class MatrixError.
     */
    @Test
    public void testCopy_0args() {
        System.out.println("copy");
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.copy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class MatrixError.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        MatrixError instance = null;
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class MatrixError.
     */
    @Test
    public void testPlus_MatrixError() {
        System.out.println("plus");
        MatrixError bmat = null;
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.plus(bmat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class MatrixError.
     */
    @Test
    public void testPlus_MatrixError_MatrixError() {
        System.out.println("plus");
        MatrixError amat = null;
        MatrixError bmat = null;
        MatrixError expResult = null;
        MatrixError result = MatrixError.plus(amat, bmat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plusEquals method, of class MatrixError.
     */
    @Test
    public void testPlusEquals() {
        System.out.println("plusEquals");
        MatrixError bmat = null;
        MatrixError instance = null;
        instance.plusEquals(bmat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minus method, of class MatrixError.
     */
    @Test
    public void testMinus_MatrixError() {
        System.out.println("minus");
        MatrixError bmat = null;
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.minus(bmat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minus method, of class MatrixError.
     */
    @Test
    public void testMinus_MatrixError_MatrixError() {
        System.out.println("minus");
        MatrixError amat = null;
        MatrixError bmat = null;
        MatrixError expResult = null;
        MatrixError result = MatrixError.minus(amat, bmat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minusEquals method, of class MatrixError.
     */
    @Test
    public void testMinusEquals() {
        System.out.println("minusEquals");
        MatrixError bmat = null;
        MatrixError instance = null;
        instance.minusEquals(bmat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class MatrixError.
     */
    @Test
    public void testTimes_MatrixError() {
        System.out.println("times");
        MatrixError bmat = null;
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.times(bmat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class MatrixError.
     */
    @Test
    public void testTimes_double() {
        System.out.println("times");
        double constant = 0.0;
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.times(constant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class MatrixError.
     */
    @Test
    public void testTimes_MatrixError_MatrixError() {
        System.out.println("times");
        MatrixError amat = null;
        MatrixError bmat = null;
        MatrixError expResult = null;
        MatrixError result = MatrixError.times(amat, bmat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class MatrixError.
     */
    @Test
    public void testTimes_MatrixError_double() {
        System.out.println("times");
        MatrixError amat = null;
        double constant = 0.0;
        MatrixError expResult = null;
        MatrixError result = MatrixError.times(amat, constant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timesEquals method, of class MatrixError.
     */
    @Test
    public void testTimesEquals_MatrixError() {
        System.out.println("timesEquals");
        MatrixError bmat = null;
        MatrixError instance = null;
        instance.timesEquals(bmat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timesEquals method, of class MatrixError.
     */
    @Test
    public void testTimesEquals_double() {
        System.out.println("timesEquals");
        double constant = 0.0;
        MatrixError instance = null;
        instance.timesEquals(constant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inverse method, of class MatrixError.
     */
    @Test
    public void testInverse_0args() {
        System.out.println("inverse");
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.inverse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inverse method, of class MatrixError.
     */
    @Test
    public void testInverse_MatrixError() {
        System.out.println("inverse");
        MatrixError amat = null;
        MatrixError expResult = null;
        MatrixError result = MatrixError.inverse(amat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transpose method, of class MatrixError.
     */
    @Test
    public void testTranspose_0args() {
        System.out.println("transpose");
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.transpose();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transpose method, of class MatrixError.
     */
    @Test
    public void testTranspose_MatrixError() {
        System.out.println("transpose");
        MatrixError amat = null;
        MatrixError expResult = null;
        MatrixError result = MatrixError.transpose(amat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of opposite method, of class MatrixError.
     */
    @Test
    public void testOpposite_0args() {
        System.out.println("opposite");
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.opposite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of opposite method, of class MatrixError.
     */
    @Test
    public void testOpposite_MatrixError() {
        System.out.println("opposite");
        MatrixError amat = null;
        MatrixError expResult = null;
        MatrixError result = MatrixError.opposite(amat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trace method, of class MatrixError.
     */
    @Test
    public void testTrace_0args() {
        System.out.println("trace");
        MatrixError instance = null;
        double expResult = 0.0;
        double result = instance.trace();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trace method, of class MatrixError.
     */
    @Test
    public void testTrace_MatrixError() {
        System.out.println("trace");
        MatrixError amat = null;
        double expResult = 0.0;
        double result = MatrixError.trace(amat);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of determinant method, of class MatrixError.
     */
    @Test
    public void testDeterminant_0args() {
        System.out.println("determinant");
        MatrixError instance = null;
        double expResult = 0.0;
        double result = instance.determinant();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of determinant method, of class MatrixError.
     */
    @Test
    public void testDeterminant_MatrixError() {
        System.out.println("determinant");
        MatrixError amat = null;
        double expResult = 0.0;
        double result = MatrixError.determinant(amat);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logDeterminant method, of class MatrixError.
     */
    @Test
    public void testLogDeterminant_0args() {
        System.out.println("logDeterminant");
        MatrixError instance = null;
        double expResult = 0.0;
        double result = instance.logDeterminant();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logDeterminant method, of class MatrixError.
     */
    @Test
    public void testLogDeterminant_MatrixError() {
        System.out.println("logDeterminant");
        MatrixError amat = null;
        double expResult = 0.0;
        double result = MatrixError.logDeterminant(amat);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of frobeniusNorm method, of class MatrixError.
     */
    @Test
    public void testFrobeniusNorm() {
        System.out.println("frobeniusNorm");
        MatrixError instance = null;
        double expResult = 0.0;
        double result = instance.frobeniusNorm();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of oneNorm method, of class MatrixError.
     */
    @Test
    public void testOneNorm() {
        System.out.println("oneNorm");
        MatrixError instance = null;
        double expResult = 0.0;
        double result = instance.oneNorm();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infinityNorm method, of class MatrixError.
     */
    @Test
    public void testInfinityNorm() {
        System.out.println("infinityNorm");
        MatrixError instance = null;
        double expResult = 0.0;
        double result = instance.infinityNorm();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of luDecomp method, of class MatrixError.
     */
    @Test
    public void testLuDecomp() {
        System.out.println("luDecomp");
        MatrixError instance = null;
        MatrixError expResult = null;
        MatrixError result = instance.luDecomp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of luBackSub method, of class MatrixError.
     */
    @Test
    public void testLuBackSub() {
        System.out.println("luBackSub");
        double[] bvec = null;
        MatrixError instance = null;
        double[] expResult = null;
        double[] result = instance.luBackSub(bvec);
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solveLinearSet method, of class MatrixError.
     */
    @Test
    public void testSolveLinearSet() {
        System.out.println("solveLinearSet");
        double[] bvec = null;
        MatrixError instance = null;
        double[] expResult = null;
        double[] result = instance.solveLinearSet(bvec);
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
