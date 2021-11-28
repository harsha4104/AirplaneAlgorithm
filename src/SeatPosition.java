public class SeatPosition {




    private int matrixNumber;
    private int row;
    private int column;

    public SeatPosition(int matrixNumber, int row, int column) {
        this.matrixNumber = matrixNumber;
        this.row = row;
        this.column = column;
    }

    public int getMatrixNumber() {
        return matrixNumber;
    }

    public void setMatrixNumber(int matrixNumber) {
        this.matrixNumber = matrixNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}
