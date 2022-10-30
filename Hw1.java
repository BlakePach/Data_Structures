package HW1;

public class Hw1 {
    static int day = 1; //position of date, reset at beginning of displayMonth
    public static void displayMonth(int numDays, int startCol){
        /*Display a monthly calendar based on number of days and the day of the week
        it starts on.*/

        System.out.println("SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");

        day = startCol;
        int currentDay = 1;

        for (int i = 1; i <= numDays; i++){
            if(startCol!= 1){
                while(startCol != 1){
                    System.out.print(" \t");
                    startCol--;
                }
            }//end if statement

            if (day % 7 == 1){
                System.out.println();
            }

            System.out.print(currentDay+" \t");
            day++;
            currentDay++;


        }//end loop
        System.out.println();

    }//end displayMonth
    public static void drawHollowSquareWithSymbol(char symbol, int size){
        /* Draws a square outline while leaving the middle blank it applicable.*/

        int line = size;
        for(int j = 0; j < size; j++) {
            if (line == size || line == 1) {
                for (int i = 0; i < size; i++) {
                    System.out.print(symbol + "\t");
                }
                System.out.println();
                line--;
            } else {
                System.out.print(symbol );
                for (int i = 1; i < size; i++) {
                    System.out.print("\t");
                }
                System.out.print(symbol);
                System.out.println();
                line--;
            }
        }//end loop

    }//end drawSquare
    public static void main(String[] args) {
        displayMonth(31,1);
        displayMonth(28,4);
        drawHollowSquareWithSymbol('*',4);
        drawHollowSquareWithSymbol('$',5);
        drawHollowSquareWithSymbol('+',2);

    }
}
