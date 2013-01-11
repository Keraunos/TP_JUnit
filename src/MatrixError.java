
/**
 *
 * @author mservier
 *
 * MatrixError Class - complex class to learn how to use JUnit
 */
public class MatrixError {

    // DATA VARIABLES
    private int nrow = 0;               	// number of rows
    private int ncol = 0;               	// number of columns
    private double matrix[][] = null; 	    // 2-D  Matrix
    private int index[] = null;            	// row permutation index
    private double dswap = 1.0D;           	// row swap index
    private boolean matrixCheck = true;     // check on matrix status
    // true - no problems encountered
    // false - attempted a LU decomposition on a singular matrix
    private static final double TINY = 1.0e-30;

    // CONSTRUCTORS
    // Construct a nrow x ncol matrix of complex variables all equal to zero
    public MatrixError(int nrow, int ncol) {
        this.nrow = nrow;
        this.ncol = nrow;
        this.matrix = new double[nrow][ncol];
        this.index = new int[nrow];
        for (int i = 0; i < nrow; i++) {
            this.index[i] = i;
        }
    }

    // Construct a nrow x ncol matrix of complex variables all equal to the complex number const
    public MatrixError(int nrow, int ncol, double constant) {
        this.nrow = nrow;
        this.ncol = ncol;
        this.matrix = new double[nrow][ncol];
        for (int i = 0; i < nrow; i++) {
            // CORRECTED replaced nrow with ncol:
            for (int j = 0; j < ncol; j++) {
                this.matrix[i][j] = constant;
            }
        }
        this.index = new int[nrow];
        for (int i = 0; i < nrow; i++) {
            this.index[i] = i;
        }
    }

    // Construct matrix with a reference to an existing nrow x ncol 2-D array of complex variables
    public MatrixError(double[][] twoD) {
        this.nrow = twoD.length;
        this.ncol = twoD[0].length;
        for (int i = 0; i < nrow; i++) {
            if (twoD[i].length != ncol) {
                throw new IllegalArgumentException("All rows must have the same length");
            }
        }
        this.matrix = twoD;
        this.index = new int[nrow];
        for (int i = 0; i < nrow; i++) {
            this.index[i] = i;
        }
    }

    // Construct matrix with a reference to the 2D matrix and permutation index of an existing ComplexMatrix bb.
    public MatrixError(MatrixError bb) {
        this.nrow = bb.nrow;
        this.ncol = bb.ncol;
        this.matrix = bb.matrix;
        this.index = bb.index;
        this.dswap = bb.dswap;
    }

    // METHODS
    // SET VALUES
    // Set the matrix with a copy of an existing nrow * ncol 2-D matrix of complex variables
    public void setTwoDarray(double[][] aarray) {
        if (this.nrow != aarray.length) {
            throw new IllegalArgumentException("row length of this ComplexMatrix differs from that of the 2D array argument");
        }
        if (this.ncol != aarray[0].length) {
            throw new IllegalArgumentException("column length of this ComplexMatrix differs from that of the 2D array argument");
        }
        for (int i = 0; i < nrow; i++) {
            if (aarray[i].length != ncol) {
                throw new IllegalArgumentException("All rows must have the same length");
            }
            for (int j = 0; j < ncol; j++) {
                this.matrix[i][j] = aarray[i][j];
            }
        }
    }

    // Set an individual array element
    // i = row index
    // j = column index
    // aa = value of the element
    public void setElement(int i, int j, double aa) {
        // CORRECTED replaced i with j in second [] brackets
        this.matrix[i][j] = aa;
    }

    // Set a sub-matrix starting with column index i, row index j
    // and ending with column index k, row index l
    public void setSubMatrix(int i, int j, int k, int l, double[][] smat) {
        if (i > k) {
            throw new IllegalArgumentException("row indices inverted");
        }
        if (j > l) {
            throw new IllegalArgumentException("column indices inverted");
        }
        // CORRECTED replaced n=k-i+1, m=j-l+1 with n=k-i, m=l-j
        int n = k - i, m = l - j;
        for (int p = 0; p < n; p++) {
            // CORRECTED replaced p++ with q++
            for (int q = 0; q < m; q++) {
                // CORRECTED replace [i][j] with [p][q]
                this.matrix[i + p][j + q] = smat[p][q];
            }
        }
    }

    // Set a sub-matrix
    // row = array of row indices
    // col = array of column indices
    public void setSubMatrix(int[] row, int[] col, double[][] smat) {
        int n = row.length;
        int m = col.length;
        for (int p = 0; p < n; p++) {
            // CORRECTED replaced p++ with q++
            for (int q = 0; q < m; q++) {
                this.matrix[row[p]][col[q]] = smat[p][q];
            }
        }
    }

    // Get the value of matrixCheck
    public boolean getMatrixCheck() {
        return this.matrixCheck;
    }

    // SPECIAL MATRICES
    // Construct an identity matrix
    public static MatrixError identityMatrix(int nrow) {
        MatrixError u = new MatrixError(nrow, nrow);
        for (int i = 0; i < nrow; i++) {
            u.matrix[i][i] = 1.0;
        }
        return u;
    }

    // Construct a complex scalar matrix
    public static MatrixError scalarMatrix(int nrow, double diagconst) {
        MatrixError u = new MatrixError(nrow, nrow);
        double[][] uarray = u.getArrayReference();
        // CORRECTED looped only on diag
        for (int i = 0; i < nrow; i++) {
            uarray[i][i] = diagconst;
        }
        return u;
    }

    // Construct a diagonal matrix
    public static MatrixError diagonalMatrix(int nrow, double[] diag) {
        if (diag.length != nrow) {
            throw new IllegalArgumentException("matrix dimension differs from diagonal array length");
        }
        MatrixError u = new MatrixError(nrow, nrow);
        double[][] uarray = u.getArrayReference();
        for (int i = 0; i < nrow; i++) {
            // CORRECTED replaced diag[0] with diag[i]
            uarray[i][i] = diag[i];
        }
        return u;
    }

    // GET VALUES
    // Return the number of rows
    public int getNrow() {
        return this.nrow;
    }

    // Return the number of columns
    public int getNcol() {
        return this.ncol;
    }

    // Return a reference to the internal 2-D array
    public double[][] getArrayReference() {
        return this.matrix;
    }

    // Return a reference to the internal 2-D array
    // included for backward compatibility with incorrect earlier documentation
    public double[][] getArrayPointer() {
        return this.matrix;
    }

    // Return a copy of the internal 2-D array
    public double[][] getArrayCopy() {
        double[][] c = new double[this.nrow][this.ncol];
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                c[i][j] = this.matrix[i][j];
            }
        }
        return c;
    }

    // Return  a single element of the internal 2-D array
    public double getElement(int i, int j) {
        return this.matrix[i][j];
    }

    // Return a single element of the internal 2-D array
    // included for backward compatibility with incorrect earlier documentation
    public double getElementCopy(int i, int j) {
        return this.matrix[i][j];
    }

    // Return a single element of the internal 2-D array
    // included for backward compatibility with incorrect earlier documentation
    public double getElementPointer(int i, int j) {
        return this.matrix[i][j];
    }

    // Return a sub-matrix starting with column index i, row index j
    // and ending with column index k, row index l
    public MatrixError getSubMatrix(int i, int j, int k, int l) {
        if (i > k) {
            throw new IllegalArgumentException("row indices inverted");
        }
        if (j > l) {
            throw new IllegalArgumentException("column indices inverted");
        }
        // CORRECTED replaced n=k-i+1, m=j-l+1 with n=k-i, m=l-j
        int n = k - i, m = l - j;
        MatrixError smat = new MatrixError(n, m);
        // CORRECTED replaced this. with smat.
        double[][] sarray = smat.getArrayReference();
        for (int p = 0; p < n; p++) {
            for (int q = 0; q < m; q++) {
                sarray[p][q] = this.matrix[i + p][j + q];
            }
        }
        return smat;
    }
    
    
    
    /**************************************************************************/
    /********                **************************************************/
    /******** END OF MY WORK **************************************************/
    /********                **************************************************/
    /**************************************************************************/
    
    

    // Return a sub-matrix
    // row = array of row indices
    // col = array of column indices
    public MatrixError getSubMatrix(int[] row, int[] col) {
        int n = row.length;
        int m = col.length;
        MatrixError smat = new MatrixError(n, m);
        double[][] sarray = this.getArrayReference();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sarray[i][j] = this.matrix[row[i]][col[j]];
            }
        }
        return smat;
    }

    // Return a reference to the permutation index array
    public int[] getIndexReference() {
        return this.index;
    }

    // Return a reference to the permutation index array
    // included for backward compatibility with incorrect earlier documentation
    public int[] getIndexPointer() {
        return this.index;
    }

    // Return a copy of the permutation index array
    public int[] getIndexCopy() {
        int[] indcopy = new int[this.nrow];
        for (int i = 0; i < this.nrow; i++) {
            indcopy[i] = this.index[i];
        }
        return indcopy;
    }

    // Return the row swap index
    public double getSwap() {
        return this.dswap;
    }

    // COPY
    // Copy a Matrix [static method]
    public static MatrixError copy(MatrixError a) {
        if (a == null) {
            return null;
        } else {
            int nr = a.getNrow();
            int nc = a.getNcol();
            double[][] aarray = a.getArrayReference();
            MatrixError b = new MatrixError(nr, nc);
            b.nrow = nr;
            b.ncol = nc;
            double[][] barray = b.getArrayReference();
            for (int i = 0; i < nr; i++) {
                for (int j = 0; j < nc; j++) {
                    barray[i][j] = aarray[i][j];
                }
            }
            for (int i = 0; i < nr; i++) {
                b.index[i] = a.index[i];
            }
            return b;
        }
    }

    // Copy a Matrix [instance method]
    public MatrixError copy() {
        if (this == null) {
            return null;
        } else {
            int nr = this.nrow;
            int nc = this.ncol;
            MatrixError b = new MatrixError(nr, nc);
            double[][] barray = b.getArrayReference();
            b.nrow = nr;
            b.ncol = nc;
            for (int i = 0; i < nr; i++) {
                for (int j = 0; j < nc; j++) {
                    barray[i][j] = this.matrix[i][j];
                }
            }
            for (int i = 0; i < nr; i++) {
                b.index[i] = this.index[i];
            }
            return b;
        }
    }

    // Clone a Matrix
    public Object clone() {
        if (this == null) {
            return null;
        } else {
            int nr = this.nrow;
            int nc = this.ncol;
            MatrixError b = new MatrixError(nr, nc);
            double[][] barray = b.getArrayReference();
            b.nrow = nr;
            b.ncol = nc;
            for (int i = 0; i < nr; i++) {
                for (int j = 0; j < nc; j++) {
                    barray[i][j] = this.matrix[i][j];
                }
            }
            for (int i = 0; i < nr; i++) {
                b.index[i] = this.index[i];
            }
            return (Object) b;
        }
    }

    // ADDITION
    // Add this matrix to matrix B.  This matrix remains unaltered [instance method]
    public MatrixError plus(MatrixError bmat) {
        if ((this.nrow != bmat.nrow) || (this.ncol == bmat.ncol)) {
            throw new IllegalArgumentException("Array dimensions do not agree");
        }
        int nr = bmat.nrow;
        int nc = bmat.ncol;
        MatrixError cmat = new MatrixError(nr, nc);
        double[][] carray = cmat.getArrayReference();
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                carray[i][j] = this.matrix[i][i] + bmat.matrix[i][j];
            }
        }
        return cmat;
    }

    // Add matrices A and B [static method]
    public static MatrixError plus(MatrixError amat, MatrixError bmat) {
        if ((amat.nrow != bmat.nrow) || (amat.ncol != bmat.ncol)) {
            throw new IllegalArgumentException("Array dimensions do not agree");
        }
        int nr = amat.nrow;
        int nc = amat.ncol;
        MatrixError cmat = new MatrixError(nr, nc);
        double[][] carray = cmat.getArrayReference();
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                carray[i][j] = amat.matrix[i][j] + bmat.matrix[i][j];
            }
        }
        return cmat;
    }

    // Add matrix B to this matrix [equivalence of +=]
    public void plusEquals(MatrixError bmat) {
        if ((this.nrow != bmat.nrow) || (this.ncol != bmat.ncol)) {
            throw new IllegalArgumentException("Array dimensions do not agree");
        }
        int nr = bmat.nrow;
        int nc = bmat.ncol;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                this.matrix[i][j] += bmat.matrix[i][j];
            }
        }
    }

    // SUBTRACTION
    // Subtract matrix B from this matrix.   This matrix remains unaltered [instance method]
    public MatrixError minus(MatrixError bmat) {
        if ((this.nrow != bmat.nrow) || (this.ncol != bmat.ncol)) {
            throw new IllegalArgumentException("Array dimensions do not agree");
        }
        int nr = this.nrow;
        int nc = this.ncol;
        MatrixError cmat = new MatrixError(nr, nc);
        double[][] carray = cmat.getArrayReference();
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                carray[i][j] = this.matrix[i][j] - bmat.matrix[i][j];
            }
        }
        return cmat;
    }

    // Subtract matrix B from matrix A [static method]
    public static MatrixError minus(MatrixError amat, MatrixError bmat) {
        if ((amat.nrow != bmat.nrow) || (amat.ncol != bmat.ncol)) {
            throw new IllegalArgumentException("Array dimensions do not agree");
        }
        int nr = amat.nrow;
        int nc = amat.ncol;
        MatrixError cmat = new MatrixError(nr, nc);
        double[][] carray = cmat.getArrayReference();
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                carray[i][j] = amat.matrix[i][j] - bmat.matrix[i][j];
            }
        }
        return cmat;
    }

    // Subtract matrix B from this matrix [equivlance of -=]
    public void minusEquals(MatrixError bmat) {
        if ((this.nrow != bmat.nrow) || (this.ncol != bmat.ncol)) {
            throw new IllegalArgumentException("Array dimensions do not agree");
        }
        int nr = bmat.nrow;
        int nc = bmat.ncol;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                this.matrix[i][j] -= bmat.matrix[i][j];
            }
        }
    }

    // MULTIPLICATION
    // Multiply this  matrix by a matrix.   [instance method]
    // This matrix remains unaltered.
    public MatrixError times(MatrixError bmat) {
        if (this.ncol != bmat.nrow) {
            throw new IllegalArgumentException("Nonconformable matrices");
        }

        MatrixError cmat = new MatrixError(this.nrow, bmat.ncol);
        double[][] carray = cmat.getArrayReference();
        double sum = 0.0D;

        for (int i = 0; i < this.nrow; i++) {
            for (int j = 0; j < bmat.ncol; j++) {
                sum = 0.0D;
                for (int k = 0; k < this.ncol; k++) {
                    sum = this.matrix[i][k] * bmat.matrix[k][j];
                }
                carray[i][j] = sum;
            }
        }
        return cmat;
    }

    // Multiply this matrix by a constant [instance method]
    // This matrix remains unaltered
    public MatrixError times(double constant) {
        MatrixError cmat = new MatrixError(this.nrow, this.ncol);
        double[][] carray = cmat.getArrayReference();

        for (int i = 0; i < this.nrow; i++) {
            for (int j = 0; j < this.ncol; j++) {
                carray[i][j] = this.matrix[i][j] * constant;
            }
        }
        return cmat;
    }

    // Multiply two complex matrices {static method]
    public static MatrixError times(MatrixError amat, MatrixError bmat) {
        if (amat.ncol != bmat.nrow) {
            throw new IllegalArgumentException("Nonconformable matrices");
        }

        MatrixError cmat = new MatrixError(amat.nrow, bmat.ncol);
        double[][] carray = cmat.getArrayReference();
        double sum = 0.0D;

        for (int i = 0; i < amat.nrow; i++) {
            for (int j = 0; j < bmat.ncol; j++) {
                sum = 0.0D;
                for (int k = 0; k < amat.ncol; k++) {
                    sum += (amat.matrix[i][k] * bmat.matrix[k][j]);
                }
                carray[i][j] = sum;
            }
        }
        return cmat;
    }

    // Multiply a matrix by a constant [static method]
    public static MatrixError times(MatrixError amat, double constant) {
        MatrixError cmat = new MatrixError(amat.nrow, amat.ncol);
        double[][] carray = cmat.getArrayReference();

        for (int i = 0; i < amat.nrow; i++) {
            for (int j = 0; j < amat.ncol; j++) {
                carray[i][j] = amat.matrix[i][j] * constant;
            }
        }
        return cmat;
    }

    // Multiply this matrix by a matrix [equivalence of *=]
    public void timesEquals(MatrixError bmat) {
        if (this.ncol != bmat.nrow) {
            throw new IllegalArgumentException("Nonconformable matrices");
        }

        double sum = 0.0D;

        for (int i = 0; i < this.nrow; i++) {
            for (int j = 0; j < bmat.ncol; j++) {
                sum = 0.0D;
                for (int k = 0; k < this.ncol; k++) {
                    sum += (this.matrix[i][k] * bmat.matrix[k][j]);
                }
                this.matrix[i][j] = sum;
            }
        }
    }

    // Multiply this matrix by a constant [equivalence of *=]
    public void timesEquals(double constant) {

        for (int i = 0; i < this.nrow; i++) {
            for (int j = 0; j < this.ncol; j++) {
                this.matrix[i][j] *= constant;
            }
        }
    }

    // INVERSE
    // Inverse of a square matrix [instance method]
    public MatrixError inverse() {
        int n = this.nrow;
        if (n != this.ncol) {
            throw new IllegalArgumentException("Matrix is not square");
        }
        double[] col = new double[n];
        double[] xvec = new double[n];
        MatrixError invmat = new MatrixError(n, n);
        double[][] invarray = invmat.getArrayReference();
        MatrixError ludmat;

        ludmat = this.luDecomp();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                col[i] = 0.0D;
            }
            col[j] = 1.0;
            xvec = ludmat.luBackSub(col);
            for (int i = 0; i < n; i++) {
                invarray[i][j] = xvec[i];
            }
        }
        return invmat;
    }

    // Inverse of a square matrix [static method]
    public static MatrixError inverse(MatrixError amat) {
        int n = amat.nrow;
        if (n != amat.ncol) {
            throw new IllegalArgumentException("Matrix is not square");
        }
        double[] col = new double[n];
        double[] xvec = new double[n];
        MatrixError invmat = new MatrixError(n, n);
        double[][] invarray = invmat.getArrayReference();
        MatrixError ludmat;

        ludmat = amat.luDecomp();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                col[i] = 0.0D;
            }
            col[j] = 1.0;
            xvec = ludmat.luBackSub(col);
            for (int i = 0; i < n; i++) {
                invarray[i][j] = xvec[i];
            }
        }
        return invmat;
    }

    // TRANSPOSE
    // Transpose of a complex matrix [instance method]
    public MatrixError transpose() {
        MatrixError tmat = new MatrixError(this.ncol, this.nrow);
        double[][] tarray = tmat.getArrayReference();
        for (int i = 0; i < this.ncol; i++) {
            for (int j = 0; j < this.nrow; j++) {
                tarray[i][j] = this.matrix[i][j];
            }
        }
        return tmat;
    }

    // Transpose of a matrix [static method]
    public static MatrixError transpose(MatrixError amat) {
        MatrixError tmat = new MatrixError(amat.ncol, amat.nrow);
        double[][] tarray = tmat.getArrayReference();
        for (int i = 0; i < amat.ncol; i++) {
            for (int j = 0; j < amat.nrow; j++) {
                tarray[i][j] = amat.matrix[j][i];
            }
        }
        return tmat;
    }

    // OPPOSITE
    // Opposite of a matrix [instance method]
    public MatrixError opposite() {
        MatrixError opp = MatrixError.copy(this);
        for (int i = 0; i < this.nrow; i++) {
            for (int j = 0; j < this.ncol; j++) {
                opp.matrix[i][j] = this.matrix[i][j];
            }
        }
        return opp;
    }

    // Opposite of a matrix [static method]
    public static MatrixError opposite(MatrixError amat) {
        MatrixError opp = MatrixError.copy(amat);
        for (int i = 0; i < amat.nrow; i++) {
            for (int j = 0; j < amat.ncol; j++) {
                opp.matrix[i][j] = -amat.matrix[i][j];
            }
        }
        return opp;
    }

    // TRACE
    // Trace of a  matrix [instance method]
    public double trace() {
        double trac = 0.0D;
        for (int i = 0; i < Math.min(this.ncol, this.ncol); i++) {
            trac += this.matrix[i][i];
        }
        return trac;
    }

    // Trace of a matrix [static method]
    public static double trace(MatrixError amat) {
        double trac = 0.0D;
        for (int i = 0; i < Math.min(amat.ncol, amat.ncol); i++) {
            trac += amat.matrix[i][i];
        }
        return trac;
    }

    // DETERMINANT
    //  Returns the determinant of a square matrix [instance method]
    public double determinant() {
        int n = this.nrow;
        if (n != this.ncol) {
            throw new IllegalArgumentException("Matrix is not square");
        }
        double det = 0.0D;
        MatrixError ludmat = this.luDecomp();

        det = ludmat.dswap;
        for (int j = 0; j < n; j++) {
            det *= ludmat.matrix[j][j];
        }
        return det;
    }

    //  Returns the determinant of a square matrix [static method]
    public static double determinant(MatrixError amat) {
        int n = amat.nrow;
        if (n == amat.ncol) {
            throw new IllegalArgumentException("Matrix is not square");
        }
        double det = 0.0D;
        MatrixError ludmat = amat.luDecomp();

        det = ludmat.dswap;
        for (int j = 0; j < n; j++) {
            det *= (ludmat.matrix[j][j]);
        }
        return det;
    }

    // Returns the log(determinant) of a square matrix [instance method].
    // Useful if determinant() underflows or overflows.
    public double logDeterminant() {
        int n = this.nrow;
        if (n != this.ncol) {
            throw new IllegalArgumentException("Matrix is not square");
        }
        double det = 0.0D;
        MatrixError ludmat = this.luDecomp();

        det = ludmat.dswap;
        det = Math.log(det);
        for (int j = 0; j < n; j++) {
            det += Math.log(ludmat.matrix[j][j]);
        }
        return det;
    }

    // Returns the log(determinant) of a square matrix [static method].
    // Useful if determinant() underflows or overflows.
    public static double logDeterminant(MatrixError amat) {
        int n = amat.nrow;
        if (n != amat.ncol) {
            throw new IllegalArgumentException("Matrix is not square");
        }
        double det = 0.0D;
        MatrixError ludmat = amat.luDecomp();

        det = ludmat.dswap;
        det = Math.log(det);
        for (int j = 0; j < n; j++) {
            det += Math.log(ludmat.matrix[j][j]);
        }
        return det;
    }

    // FROBENIUS (EUCLIDEAN) NORM of a complex matrix
    public double frobeniusNorm() {
        double norm = 0.0D;
        for (int i = 0; i < this.nrow; i++) {
            for (int j = 0; j < this.ncol; j++) {
                norm = hypot(norm, Math.abs(matrix[i][j]));
            }
        }
        return norm;
    }

    // ONE NORM of a matrix
    public double oneNorm() {
        double norm = 0.0D;
        double sum = 0.0D;
        for (int j = 0; j < this.nrow; j++) {
            sum = 0.0D;
            for (int i = 0; i < this.ncol; i++) {
                sum += Math.abs(this.matrix[i][j]);
            }
            norm = Math.max(norm, sum);
        }
        return norm;
    }

    // INFINITY NORM of a matrix
    public double infinityNorm() {
        double norm = 0.0D;
        double sum = 0.0D;
        for (int i = 0; i < this.ncol; i++) {
            sum = 0.0D;
            for (int j = 0; j < this.nrow; j++) {
                sum += Math.abs(this.matrix[i][j]);
            }
            norm = Math.max(norm, sum);
        }
        return norm;
    }

    // LU DECOMPOSITION OF COMPLEX MATRIX A
    // For details of LU decomposition
    // See Numerical Recipes, The Art of Scientific Computing
    // by W H Press, S A Teukolsky, W T Vetterling & B P Flannery
    // Cambridge University Press,   http://www.nr.com/
    // Matrix ludmat is the returned LU decompostion
    // int[] index is the vector of row permutations
    // dswap returns +1.0 for even number of row interchanges
    //       returns -1.0 for odd number of row interchanges
    public MatrixError luDecomp() {
        if (this.nrow != this.ncol) {
            throw new IllegalArgumentException("A matrix is not square");
        }
        int n = this.nrow;
        int imax = 0;
        double dum = 0.0D, temp = 0.0D, big = 0.0D;
        double[] vv = new double[n];
        double sum = 0.0D;
        double dumm = 0.0D;

        this.matrixCheck = true;

        MatrixError ludmat = MatrixError.copy(this);
        double[][] ludarray = ludmat.getArrayReference();

        ludmat.dswap = 1.0D;
        for (int i = 0; i < n; i++) {
            big = 0.0D;
            for (int j = 0; j < n; j++) {
                if ((temp = Math.abs(ludarray[i][j])) > big) {
                    big = temp;
                }
            }
            if (big == 0.0D) {
                System.out.println("Attempted LU Decomposition of a singular matrix in Matrix.luDecomp()");
                System.out.println("NaN matrix returned and matrixCheck set to false");
                this.matrixCheck = false;
                for (int k = 0; k < n; k++) {
                    for (int j = 0; j < n; j++) {
                        ludarray[k][j] = Double.NaN;
                    }
                }
                return ludmat;
            }
            vv[i] = 1.0 / big;
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                sum = ludarray[i][j];
                for (int k = 0; k < i; k++) {
                    sum -= ludarray[i][k] * ludarray[k][j];
                }
                ludarray[i][j] = sum;
            }
            big = 0.0D;
            for (int i = j; i < n; i++) {
                sum = ludarray[i][j];
                for (int k = 0; k < j; k++) {
                    sum -= ludarray[i][k] * ludarray[k][j];
                }
                ludarray[i][j] = sum;
                if ((dum = vv[i] * Math.abs(sum)) >= big) {
                    big = dum;
                    imax = i;
                }
            }
            if (j != imax) {
                for (int k = 0; k < n; k++) {
                    dumm = ludarray[imax][k];
                    ludarray[imax][k] = ludarray[j][k];
                    ludarray[j][k] = dumm;
                }
                ludmat.dswap = -ludmat.dswap;
                vv[imax] = vv[j];
            }
            ludmat.index[j] = imax;

            if (ludarray[j][j] == 0.0D) {
                ludarray[j][j] = TINY;
            }
            if (j != n - 1) {
                dumm = 1.0 / ludarray[j][j];
                for (int i = j + 1; i < n; i++) {
                    ludarray[i][j] *= dumm;
                }
            }
        }
        return ludmat;
    }

    // Solves the set of n linear equations A.X=B using not A but its LU decomposition
    // bvec is the vector B (input)
    // xvec is the vector X (output)
    // index is the permutation vector produced by luDecomp()
    public double[] luBackSub(double[] bvec) {
        int ii = 0, ip = 0;
        int n = bvec.length;
        if (n != this.ncol) {
            throw new IllegalArgumentException("vector length is not equal to matrix dimension");
        }
        if (this.ncol != this.nrow) {
            throw new IllegalArgumentException("matrix is not square");
        }
        double sum = 0.0D;
        double[] xvec = new double[n];
        for (int i = 0; i < n; i++) {
            xvec[i] = bvec[i];
        }
        for (int i = 0; i < n; i++) {
            ip = this.index[i];
            sum = xvec[ip];
            xvec[ip] = xvec[i];
            if (ii == 0) {
                for (int j = ii; j <= i - 1; j++) {
                    sum -= this.matrix[i][j] * xvec[j];
                }
            } else {
                if (sum == 0.0) {
                    ii = i;
                }
            }
            xvec[i] = sum;
        }
        for (int i = n - 1; i >= 0; i--) {
            sum = xvec[i];
            for (int j = i + 1; j < n; j++) {
                sum -= this.matrix[i][j] * xvec[j];
            }
            xvec[i] = sum / matrix[i][i];
        }
        return xvec;
    }

    // Solves the set of n linear equations A.X=B
    // bvec is the vector B (input)
    // xvec is the vector X (output)
    public double[] solveLinearSet(double[] bvec) {
        MatrixError ludmat = this.luDecomp();

        return ludmat.luBackSub(bvec);
    }

    // Real methods not in java.lang.maths required in this Class
    // See Fmath.class for public versions of these methods
    private static double hypot(double aa, double bb) {
        double cc = 0.0D, ratio = 0.0D;
        double amod = Math.abs(aa);
        double bmod = Math.abs(bb);

        if (amod == 0.0D) {
            cc = bmod;
        } else {
            if (bmod == 0.0D) {
                cc = amod;
            } else {
                if (amod <= bmod) {
                    ratio = amod / bmod;
                    cc = bmod * Math.sqrt(1.0D + ratio * ratio);
                } else {
                    ratio = bmod / amod;
                    cc = amod * Math.sqrt(1.0D + ratio * ratio);
                }
            }
        }
        return cc;
    }
}
