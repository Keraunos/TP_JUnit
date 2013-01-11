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
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                assertEquals(amatrix.getElement(i, j), result.getElement(i, j), 1.0e-7);
            }
        }
    }

    /**
     * Test of setElement method, of class MatrixError.
     */
    @Test
    public void testSetElement() {
        System.out.println("setElement");
        int i = 0;
        int j = 0;
        double aa = 0.0;
        MatrixError instance = null;
        instance.setElement(i, j, aa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubMatrix method, of class MatrixError.
     */
    @Test
    public void testSetSubMatrix_5args() {
        System.out.println("setSubMatrix");
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        double[][] smat = null;
        MatrixError instance = null;
        instance.setSubMatrix(i, j, k, l, smat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubMatrix method, of class MatrixError.
     */
    @Test
    public void testSetSubMatrix_3args() {
        System.out.println("setSubMatrix");
        int[] row = null;
        int[] col = null;
        double[][] smat = null;
        MatrixError instance = null;
        instance.setSubMatrix(row, col, smat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrixCheck method, of class MatrixError.
     */
    @Test
    public void testGetMatrixCheck() {
        System.out.println("getMatrixCheck");
        MatrixError instance = null;
        boolean expResult = false;
        boolean result = instance.getMatrixCheck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of identityMatrix method, of class MatrixError.
     */
    @Test
    public void testIdentityMatrix() {
        System.out.println("identityMatrix");
        int nrow = 0;
        MatrixError expResult = null;
        MatrixError result = MatrixError.identityMatrix(nrow);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scalarMatrix method, of class MatrixError.
     */
    @Test
    public void testScalarMatrix() {
        System.out.println("scalarMatrix");
        int nrow = 0;
        double diagconst = 0.0;
        MatrixError expResult = null;
        MatrixError result = MatrixError.scalarMatrix(nrow, diagconst);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diagonalMatrix method, of class MatrixError.
     */
    @Test
    public void testDiagonalMatrix() {
        System.out.println("diagonalMatrix");
        int nrow = 0;
        double[] diag = null;
        MatrixError expResult = null;
        MatrixError result = MatrixError.diagonalMatrix(nrow, diag);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNrow method, of class MatrixError.
     */
    @Test
    public void testGetNrow() {
        System.out.println("getNrow");
        MatrixError instance = null;
        int expResult = 0;
        int result = instance.getNrow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNcol method, of class MatrixError.
     */
    @Test
    public void testGetNcol() {
        System.out.println("getNcol");
        MatrixError instance = null;
        int expResult = 0;
        int result = instance.getNcol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArrayReference method, of class MatrixError.
     */
    @Test
    public void testGetArrayReference() {
        System.out.println("getArrayReference");
        MatrixError instance = null;
        double[][] expResult = null;
        double[][] result = instance.getArrayReference();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArrayPointer method, of class MatrixError.
     */
    @Test
    public void testGetArrayPointer() {
        System.out.println("getArrayPointer");
        MatrixError instance = null;
        double[][] expResult = null;
        double[][] result = instance.getArrayPointer();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArrayCopy method, of class MatrixError.
     */
    @Test
    public void testGetArrayCopy() {
        System.out.println("getArrayCopy");
        MatrixError instance = null;
        double[][] expResult = null;
        double[][] result = instance.getArrayCopy();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElement method, of class MatrixError.
     */
    @Test
    public void testGetElement() {
        System.out.println("getElement");
        int i = 0;
        int j = 0;
        MatrixError instance = null;
        double expResult = 0.0;
        double result = instance.getElement(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementCopy method, of class MatrixError.
     */
    @Test
    public void testGetElementCopy() {
        System.out.println("getElementCopy");
        int i = 0;
        int j = 0;
        MatrixError instance = null;
        double expResult = 0.0;
        double result = instance.getElementCopy(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementPointer method, of class MatrixError.
     */
    @Test
    public void testGetElementPointer() {
        System.out.println("getElementPointer");
        int i = 0;
        int j = 0;
        MatrixError instance = null;
        double expResult = 0.0;
        double result = instance.getElementPointer(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

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
