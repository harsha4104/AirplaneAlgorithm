import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

public class AirplaneAlgorithm {

    public static List<SeatPosition> aisleSeats = new ArrayList<>();
    public static List<SeatPosition> middleSeats = new ArrayList<>();
    public static List<SeatPosition> windowSeats = new ArrayList<>();
    private static int maxRowSize = 0;
    private static int maxColumnSize = 0;
    private static List<int[][]> seats;

    public static void main(String[] args){

        List<List<Integer>> matrix = new ArrayList<>();
        Scanner myinput = new Scanner(System.in);

        System.out.print("Enter the number of matrix :");
        int noOfMatrix = myinput.nextInt();

        for(int i=0;i<noOfMatrix;i++){
            System.out.print("Enter the "+(i+1)+"  Matrix dimension :");
            int n = myinput.nextInt();
            int m = myinput.nextInt();

            List<Integer> values = new ArrayList<>();
            values.add(n);
            values.add(m);
            matrix.add(values);
        }

        System.out.println("Enter the number of Passenger :");
        int counter = myinput.nextInt();

        seats = getTheSeats(matrix);
        printSeats();
        System.out.println();

        int passenger = 1;
        for(int i=0;i<aisleSeats.size() && passenger <= counter;i++){
            seats.get(aisleSeats.get(i).getMatrixNumber())[aisleSeats.get(i).getRow()][aisleSeats.get(i).getColumn()] = passenger;
            passenger++;
        }

        for(int i=0;i<windowSeats.size() && passenger <= counter;i++){
            seats.get(windowSeats.get(i).getMatrixNumber())[windowSeats.get(i).getRow()][windowSeats.get(i).getColumn()] = passenger;
            passenger++;
        }

        for(int i=0;i<middleSeats.size() && passenger <= counter;i++){
            seats.get(middleSeats.get(i).getMatrixNumber())[middleSeats.get(i).getRow()][middleSeats.get(i).getColumn()] = passenger;
            passenger++;
        }

        printSeats();

    }

    public static List<int[][]> getTheSeats(List<List<Integer>> matrix){

        for(int i =0;i<matrix.size();i++) {
             maxRowSize = Math.max(maxRowSize, matrix.get(i).get(0));
             maxColumnSize = Math.max(maxColumnSize, matrix.get(i).get(1));
        }

        List<int[][]> seats = new ArrayList<>();
        for(int i=0;i<matrix.size();i++){
            int row = matrix.get(i).get(0);
            int column = matrix.get(i).get(1);
            int[][] seatsInMatrix = new int[row][column];

            for(int l=0;l<matrix.get(i).get(0); l++) {
                Arrays.fill(seatsInMatrix[l], -1);
            }
            seats.add(seatsInMatrix);
        }


        for(int i=0;i<seats.size();i++){

            for(int j=0;j<seats.get(i).length;j++){
                seats.get(i)[j][0] = 0;
                seats.get(i)[j][seats.get(i)[0].length-1] = 0;
            }
        }

        for(int i=0;i<seats.get(0).length;i++){
            seats.get(0)[i][0] = -2;
        }

        int lastMatrixNumber = seats.size()-1;
        int lastMatrixlastColumn = seats.get(lastMatrixNumber)[0].length-1;
        for(int i=0;i<seats.get(lastMatrixNumber).length;i++){
            seats.get(lastMatrixNumber)[i][lastMatrixlastColumn] =-2;
        }

        for(int i=0;i<maxRowSize;i++) {
                for(int k=0;k<seats.size();k++){

                    for(int j = 0; j<maxColumnSize;j++){

                        if(i>=seats.get(k).length){
                            continue;
                        }
                        if(j>= seats.get(k)[0].length){
                            continue;
                        }

                        if(seats.get(k)[i][j] == 0) {
                            SeatPosition seatPosition = new SeatPosition(k, i, j);
                            aisleSeats.add(seatPosition);

                        }

                        if(seats.get(k)[i][j] == -1) {
                            SeatPosition seatPosition = new SeatPosition(k, i, j);
                            middleSeats.add(seatPosition);

                        }

                        if(seats.get(k)[i][j] == -2) {
                            SeatPosition seatPosition = new SeatPosition(k, i, j);
                            windowSeats.add(seatPosition);
                        }
                    }
                }

        }



        for(int i=0;i<matrix.size();i++) {
            for (int j = 0; j < matrix.get(i).get(0); j++) {
                for (int k = 0; k < matrix.get(i).get(1); k++) {
                    seats.get(i)[j][k] = 0;
                }
            }
        }

        return seats;
    }

    public static void printSeats(){
        for(int i=0;i<maxRowSize;i++) {
            for(int k=0;k<seats.size();k++){

                for(int j = 0; j<maxColumnSize;j++){

                    if(i>=seats.get(k).length){
                        System.out.print("  ");
                        continue;
                    }
                    if(j>= seats.get(k)[0].length){
                        System.out.print("  ");
                        continue;
                    }

                    System.out.print(seats.get(k)[i][j]+" ");

                }
                System.out.print("   ");
            }
            System.out.println();

        }

    }
}
