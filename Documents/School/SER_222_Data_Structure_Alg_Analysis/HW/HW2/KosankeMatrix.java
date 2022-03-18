/**
 * An implementation of the Matrix ADT. Provides four basic operations over an
 * immutable type.
 *
 * Completion time: 4 hours
 *
 * @author Steven Kosanke
 * @version 1/14/2022
 */
public class KosankeMatrix implements Matrix {
private final int rowMax;
private final int colMax;
private int[][] values;

    public MyMatrix(int[][] matrix) {
        this.rowMax = matrix.length;
        if (this.rowMax == 0)
            this.colMax = 0;
        else
            this.colMax = matrix[0].length;

        this.values = new int[rowMax][colMax];
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
            values[i][j] = matrix[i][j];
            }
        }
    }


    @Override
    public int getElement(int y, int x) {
       return this.values[y][x];}

    /**
     * Returns the number of rows in the matrix.
     * @return rows
     */
    @Override
    public int getRows() {
        return this.rowMax;
    }

    /**
     * Returns the number of columns in the matrix.
     * @return columns
     */
    @Override
    public int getColumns(){
        return this.colMax;
    }
    /**
     * Returns this matrix scaled by a factor. That is, computes kA where k is a
     * constant and A is a matrix (this object).
     *
     * @param scalar scalar
     * @return matrix
     */
    @Override
    public Matrix scale(int scalar){
        int[][] A = new int[this.rowMax][this.colMax];
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
            A[i][j] = scalar * this.values[i][j];
            }
        }
        Matrix B = new MyMatrix(A);
        return B;

    }


    /**
     * Returns this matrix added with another matrix. That is, computes A+B
     * where A and B are matrices (this object, and another respectively).
     * @param other addend
     * @return matrix
     * @throws RuntimeException if matrices do not have matching dimensions.
     */
    @Override
    public Matrix plus(Matrix other) {
        if (this.rowMax != other.getRows() || this.colMax != other.getColumns()) {
            throw new RuntimeException();
        }

        int[][] A = new int[this.rowMax][this.colMax];
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
            A[i][j] =  other.getElement(i,j) + this.values[i][j];
            }
        }
        //return a as a matrix from this new array
        Matrix B = new MyMatrix(A);
        return B;
    }

    /**
     * Returns this matrix subtracted by another matrix. That is, computes A-B
     * where A and B are matrices (this object, and another respectively).
     * @param other subtrahend
     * @return matrix
     * @throws RuntimeException if matrices do not have matching dimensions.
     */
    @Override
    public Matrix minus(Matrix other) {
        if (this.rowMax != other.getRows() || this.colMax != other.getColumns()) {
            throw new RuntimeException();
        }

        int[][] A = new int[this.rowMax][this.colMax];
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
            A[i][j] = this.values[i][j] - other.getElement(i,j);
            }
        }
        //return a as a matrix from this new array
        Matrix B = new MyMatrix(A);
        return B;
    }

    /**
     * Returns this matrix multiplied by another matrix. That is, computes AB
     * where A and B are matrices (this object, and another respectively).
     * @param other multiplicand
     * @return matrix
     * @throws RuntimeException if matrices do not have matching dimensions.
     */
    @Override
    public Matrix multiply(Matrix other){
        if (this.rowMax != other.getRows() || this.colMax != other.getColumns()) {
            throw new RuntimeException();
        }

        int[][] A = new int[this.rowMax][this.colMax];
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
            A[i][j] = this.values[i][j] * other.getElement(i,j);
            }
        }
        //return a as a matrix from this new array
        Matrix B = new MyMatrix(A);
        return B;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {return true;}
        if (other == null) {return false;}
        if (other.getClass() != this.getClass()) {return false;}
        MyMatrix m = (MyMatrix) other;
        if (m.getColumns() != this.getColumns() ||
                m.getRows() != this.getRows() ) {
            return false;
        }
         for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (m.getElement(i, j) != this.getElement(i,j)) {
                    return false;
                }
            }
         }
         return true;
    }
    /**
     * Returns a string representation of this matrix. A new line character will
     * separate each row, while a space will separate each column.
     * @return string representation
     */
    @Override
    public String toString(){
        String finalString = "";

        for (int i = 0; i < this.rowMax; i++) {
            for (int j = 0; j < this.colMax; j++) {
            finalString = finalString + String.valueOf(this.values[i][j]) + " ";
            }
            finalString = finalString + "\n";
        }
        return finalString;
    }

    public static void main(String[] args) {

        int[][] data1 = new int[0][0];
        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] data4 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};

        Matrix m1 = new MyMatrix(data1);
        Matrix m2 = new MyMatrix(data2);
        Matrix m3 = new MyMatrix(data3);
        Matrix m4 = new MyMatrix(data4);

        System.out.println("m1 --> Rows: " + m1.getRows() + " Columns: " + m1.getColumns());
        System.out.println("m2 --> Rows: " + m2.getRows() + " Columns: " + m2.getColumns());
        System.out.println("m3 --> Rows: " + m3.getRows() + " Columns: " + m3.getColumns());

        //check for reference issues
        System.out.println("m2 -->\n" + m2);
        data2[1][1] = 101;
        System.out.println("m2 -->\n" + m2);

        //test equals
        System.out.println("m2==null: " + m2.equals(null));             //false
        System.out.println("m3==\"MATRIX\": " + m2.equals("MATRIX"));   //false
        System.out.println("m2==m1: " + m2.equals(m1));                 //false
        System.out.println("m2==m2: " + m2.equals(m2));                 //true
        System.out.println("m2==m3: " + m2.equals(m3));                 //false
        System.out.println("m3==m4: " + m3.equals(m4));                 //true

        //test operations (valid)
        System.out.println("2 * m2:\n" + m2.scale(2));
        System.out.println("m2 + m3:\n" + m2.plus(m3));
        System.out.println("m2 - m3:\n" + m2.minus(m3));

    }
}