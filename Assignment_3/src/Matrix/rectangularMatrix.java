package Matrix;

import java.util.ArrayList;

import static Matrix.matrixManager.matrixArrayList;

public class rectangularMatrix extends matrix {
    rectangularMatrix(ArrayList<ArrayList<Integer>> matrixElements, int id){
        super(matrixElements,id);
    }
    @Override
    public void printDeterminants(){
        System.out.println("Determinant doesn't exist for rectangular matrices");
    }
    @Override
    public void addTranspose(){
        System.out.println("We cannot add two matrices of different dimensions");
    }
    @Override
    public void printMatrixInverse() {
        System.out.println("The inverse does not exists for rectangular matrices");
    }
}
