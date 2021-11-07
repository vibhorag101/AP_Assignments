package Matrix;

import java.util.ArrayList;

public class identityMatrix extends diagonalMatrix{
    identityMatrix(ArrayList<ArrayList<Integer>> matrixElements, int id){
        super(matrixElements,id);
    }
    @Override
    public void printDeterminants(){
        System.out.println("Determinant is "+1);
    }
    @Override
    public void printMatrixInverse(){
        System.out.println("Inverse is the identity matrix itself");
        displayMatrix();
    }
    @Override
    public void multiplyMatrix(matrix m){
        if(getColumn()==m.getRow()&&getRow()==m.getColumn()){
            m.displayMatrix();
        }
        else{
            System.out.println("The matrix cannot be multiplied");
        }
    }
}
