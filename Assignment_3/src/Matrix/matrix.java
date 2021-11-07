package Matrix;

import java.util.ArrayList;

public class matrix {
    private final int row;
    private final int column;
    private ArrayList<String> matrixLabels;
    private String matrixStoreType;
    private final int id;
    private final ArrayList<ArrayList<Integer>> matrixElements;

    matrix(ArrayList<ArrayList<Integer>> matrixElements, int id) {
        this.matrixElements = matrixElements;
        this.row = matrixElements.size();
        this.column = matrixElements.get(0).size();
        this.id = id;
    }

    public void displayMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrixElements.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void displayMatrixByList(ArrayList<ArrayList<Integer>> matrixElements) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrixElements.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<String> getMatrixLabels() {
        return matrixLabels;
    }

    public void setMatrixLabels(ArrayList<String> matrixLabels) {
        this.matrixLabels = matrixLabels;
    }

    public int getId() {
        return id;
    }

    public ArrayList<ArrayList<Integer>> getMatrixElements() {
        return matrixElements;
    }

    // matrix operations with single operand.

    public int getDeterminants() {
        if (row == 1) {
            return (matrixElements.get(0).get(0));
        } else if (row == 2) {
            int temp1 = matrixElements.get(0).get(0) * matrixElements.get(1).get(1);
            int temp2 = matrixElements.get(0).get(1) * matrixElements.get(1).get(0);
            return (temp1 - temp2);
        } else {
            int temp00 = matrixElements.get(0).get(0);
            int temp01 = matrixElements.get(0).get(1);
            int temp02 = matrixElements.get(0).get(2);
            int temp10 = matrixElements.get(1).get(0);
            int temp11 = matrixElements.get(1).get(1);
            int temp12 = matrixElements.get(1).get(2);
            int temp20 = matrixElements.get(2).get(0);
            int temp21 = matrixElements.get(2).get(1);
            int temp22 = matrixElements.get(2).get(2);
            int det = temp00 * (temp11 * temp22 - temp12 * temp21) - temp01 * (temp10 * temp22 - temp12 * temp20) + temp02 * (temp10 * temp21 - temp11 * temp20);
            System.out.println("the determinant of the matrix is " + det);
            return (det);
        }
    }

    public void printDeterminants() {
        if (row == 1) {
            System.out.println("The determinant is " + matrixElements.get(0).get(0));
        } else if (row == 2) {
            int temp1 = matrixElements.get(0).get(0) * matrixElements.get(1).get(1);
            int temp2 = matrixElements.get(0).get(1) * matrixElements.get(1).get(0);
            System.out.println("The determinant is " + (temp1 - temp2));

        } else {
            int temp00 = matrixElements.get(0).get(0);
            int temp01 = matrixElements.get(0).get(1);
            int temp02 = matrixElements.get(0).get(2);
            int temp10 = matrixElements.get(1).get(0);
            int temp11 = matrixElements.get(1).get(1);
            int temp12 = matrixElements.get(1).get(2);
            int temp20 = matrixElements.get(2).get(0);
            int temp21 = matrixElements.get(2).get(1);
            int temp22 = matrixElements.get(2).get(2);
            int det = temp00 * (temp11 * temp22 - temp12 * temp21) - temp01 * (temp10 * temp22 - temp12 * temp20)
                    + temp02 * (temp10 * temp21 - temp11 * temp20);
            System.out.println("the determinant of the matrix is " + det);
        }
    }

    public void getRowMean() {
        for (int i = 0; i < row; i++) {
            int mean = 0;
            for (int j = 0; j < column; j++) {
                mean += matrixElements.get(i).get(j);
            }
            mean = mean / row;
            System.out.println("The mean of row " + i + " is " + mean);
        }
    }

    public void getColumnMean() {
        for (int i = 0; i < column; i++) {
            int mean = 0;
            for (int j = 0; j < row; j++) {
                mean += matrixElements.get(i).get(j);
            }
            mean = mean / column;
            System.out.println("The mean of column " + i + " is " + mean);
        }
    }

    public void getMean() {
        int mean = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mean = mean + matrixElements.get(i).get(j);
            }
        }
        mean = mean / (row * column);
        System.out.println("The mean of all the elements is " + mean);
    }

    public ArrayList<ArrayList<Integer>> transpose() {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < column; i++) {
            al.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                al.get(i).add(0);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                al.get(j).set(i, matrixElements.get(i).get(j));
            }
        }
        displayMatrixByList(al);
        return al;
    }

    public void addTranspose() {
        ArrayList<ArrayList<Integer>> al = transpose();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                al.get(i).set(j, al.get(i).get(j) + matrixElements.get(i).get(j));
            }
        }
        displayMatrixByList(al);
    }

    public void singletonScalar(matrix m, int flag) {
        ArrayList<ArrayList<Integer>> s = m.getMatrixElements();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>(matrixElements);
        int scalar = s.get(0).get(0);
        if (flag == 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    al.get(i).set(j, al.get(i).get(j) * 2);
                }
            }
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    al.get(i).set(j, al.get(i).get(j) / 2);
                }
            }
        }
        displayMatrixByList(al);
    }

    //operations with two arguments
    public void matrixOperate(matrix m, int flag) {
        ArrayList<ArrayList<Integer>> secondMat = m.getMatrixElements();
        ArrayList<ArrayList<Integer>> firstMat = new ArrayList<>(matrixElements);
        if (flag == 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    firstMat.get(i).set(i, firstMat.get(i).get(j) + secondMat.get(i).get(j));
                }
            }
        } else if (flag == 1) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    firstMat.get(i).set(i, firstMat.get(i).get(j) - secondMat.get(i).get(j));
                }
            }
        } else if (flag == 2) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    firstMat.get(i).set(i, firstMat.get(i).get(j) * secondMat.get(i).get(j));
                }
            }
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    firstMat.get(i).set(i, firstMat.get(i).get(j) / secondMat.get(i).get(j));
                }
            }
        }
        displayMatrixByList(firstMat);
    }

    public ArrayList<ArrayList<Integer>> getAdjoint() {
        ArrayList<ArrayList<Integer>> adjoint = new ArrayList<>(matrixElements);
        if (row == 3 && column == 3) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    int cofactor1 = matrixElements.get((i + 1) % 3).get((j + 1) % 3) * matrixElements.get((i + 2) % 3).get((j + 2) % 3);
                    int cofactor2 = matrixElements.get((j + 1) % 3).get((i + 2) % 3) * matrixElements.get((i + 2) % 3).get((j + 1) % 3);
                    adjoint.get(i).set(j, cofactor1 - cofactor2);
                }
            }
        } else if (row == 2 && column == 2) {
            adjoint.get(0).set(0, matrixElements.get(1).get(1));
            adjoint.get(0).set(1, -1 * matrixElements.get(0).get(1));
            adjoint.get(1).set(0, -1 * matrixElements.get(1).get(0));
            adjoint.get(1).set(1, matrixElements.get(0).get(0));
        }
        return adjoint;
    }

    public void printMatrixInverse() {
        if (getDeterminants() == 0) {
            System.out.println("The matrix is not invertible");
        } else {
            ArrayList<ArrayList<Float>> inverse = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                inverse.add(new ArrayList<Float>());
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    inverse.get(i).add((float) 0);
                }
            }
            ArrayList<ArrayList<Integer>> adjoint = getAdjoint();
            float determinant = getDeterminants();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    inverse.get(i).set(j, adjoint.get(i).get(j) / determinant);
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(inverse.get(i).get(j) + " ");
                }
                System.out.println();
            }

        }
    }

    public ArrayList<ArrayList<Float>> getMatrixInverse() {
        ArrayList<ArrayList<Float>> inverse = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            inverse.add(new ArrayList<Float>());
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                inverse.get(i).add((float) 0);
            }
        }
        ArrayList<ArrayList<Integer>> adjoint = getAdjoint();
        float determinant = getDeterminants();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                inverse.get(i).set(j, adjoint.get(i).get(j) / determinant);
            }
        }
        return inverse;
    }


}