import java.util.*;

public class HighSchoolGrades{
    static Scanner gIN = new Scanner(System.in);
    static int gClassSize;
    static double[] gGrades = new double[100];

    //method that allows the user to add or change the grades of any element in gGrades up to user initiated class size
    public static void addModifyGrade(){
        int chosenStudent;
        do {
            System.out.print("Enter the index (" + 0 + " to " + (gGrades.length - 1) + ") : ");
            chosenStudent = gIN.nextInt();

            while ((chosenStudent < 0)||(chosenStudent > (gGrades.length -1))){ //limits going below or above valid options
                System.out.println("Value out of range, please, try again");
                System.out.print("Enter the index (" + 0 + " to " + (gGrades.length - 1) + ") : ");
                chosenStudent = gIN.nextInt();
            }

            System.out.println("The current value of the grade in index " + chosenStudent + " is : " + gGrades[chosenStudent]);
            System.out.print("Enter the grade you want to assign (0.00 - 100.00) : ");
            gGrades[chosenStudent] = gIN.nextDouble();

            while ((gGrades[chosenStudent]<0.00)||(gGrades[chosenStudent]>100.00)){ //limits going below or above valid options
                System.out.println("Value out of range, please, try again");
                System.out.print("Enter the grade you want to assign (0.00 - 100.00) : ");
                gGrades[chosenStudent] = gIN.nextDouble();
            }
        }
        while ((chosenStudent > (gGrades.length -1))||(gGrades[chosenStudent]<0.00)||(gGrades[chosenStudent]>100.00));

    }

    //gets the two choices that the user wants to perform a swap on then calls the swap method
    public static void swapGrades(){
        int idxFrom, idxTo;
        do {
            System.out.print("Enter the index (" + 0 + " to " + (gGrades.length - 1) + ") : ");
            idxFrom = gIN.nextInt();

            while ((idxFrom < 0) || (idxFrom > (gGrades.length-1))) {
                System.out.println("Value out of range, please, try again");
                System.out.print("Enter the index (" + 0 + " to " + (gGrades.length - 1) + ") : ");
                idxFrom = gIN.nextInt();
            }

            System.out.print("Enter the index (" + 0 + " to " + (gGrades.length - 1) + ") that is not " + idxFrom + " : ");
            idxTo = gIN.nextInt();

            while ((idxTo < 0) || (idxTo > (gGrades.length - 1))||(idxTo==idxFrom)) {
                System.out.println("Value out of range, please, try again");
                System.out.print("Enter the index (" + 0 + " to " + (gGrades.length - 1) + ") that is not " + idxFrom + " : ");
                idxTo = gIN.nextInt();
            }
        }while ((idxTo > (gGrades.length - 1))||(idxFrom > (gGrades.length-1)));
        swapValues(idxFrom, idxTo);
    }

    //swap the from and to values passed to the method and return them...
    public static void swapValues(int f, int t){
    double temp = gGrades[f];
    gGrades[f] = gGrades[t];
    gGrades[t] = temp;
    }

    //prints out the list of grades one by one based on the acceptable used indexes
    public static void listGrades(){
        System.out.println("LIST OF GRADES");
        for (int i = 0; i < gGrades.length; i++) {
            System.out.printf("Grade["+ i +"]"+" : " + "%.2f%n", gGrades[i]);
        }
    }

    //prints letter grade and the tallied count of elements with scores in that specific letter grade
    public static void report(){
        System.out.println("GRADES REPORT");
        char [] grades = {'A', 'B', 'C', 'D', 'F'};
        for (int i = 0; i < grades.length; i++) {
            getGradesLetter(grades[i]);
        }

    }

    public static void getGradesLetter(char letter){
        int aCount = 0, bCount = 0, cCount = 0, dCount = 0, fCount = 0;

        for (int i = 0; i < gGrades.length; i++) {
            if (gGrades[i] <= 100 && gGrades [i] >= 90){
                aCount = aCount+1;
            }
            if (gGrades[i] < 90 && gGrades [i] >= 80){
                bCount = bCount+1;
            }
            if (gGrades[i] < 80 && gGrades [i] >= 70){
                cCount = cCount+1;
            }
            if (gGrades[i] < 70 && gGrades [i] >= 60){
                dCount = dCount+1;
            }
            if (gGrades[i] < 60){
                fCount = fCount+1;
            }
        }
        if (letter == 'A'){
        System.out.println(letter + " : " + aCount);
        }
        if (letter == 'B'){
        System.out.println(letter + " : " + bCount);
        }
        if (letter == 'C'){
        System.out.println(letter + " : " + cCount);
        }
        if (letter == 'D'){
        System.out.println(letter + " : " + dCount);
        }
        if (letter == 'F'){
        System.out.println(letter + " : " + fCount);
        }
    }

    public static void main(String[] args){

        System.out.println("UTSA - Fall 2020 - CS1083 - Section 004 - Project 2 - written by DWIGHTABRAHAMS");
        System.out.println();

        do {
            System.out.print("Please, enter the class size: ");
            gClassSize = gIN.nextInt();
            gGrades = new double[gClassSize];

            if ((gClassSize < 0) || (gClassSize > 100)){
                System.out.println("Value out of range, please, try again");
            }
        }
        while ((gClassSize < 0) || (gClassSize > 100));

        //prints out menu options, stays in loop until user enters appropriate exit or continuation choice
        int userChoice;
        do {
            System.out.println();
            System.out.println("MAIN MENU");
            System.out.println("0 - Exit, 1 - Add/Modify Grade, 2 - Swap Grades, 3 - List, 4 - Report");
            System.out.print("Select an option: ");
            userChoice = gIN.nextInt();

            //if user enters a value greater than menu choice then prompt appears
            if ((userChoice > 4)||(userChoice < 0)){
                System.out.println("Value out of range, please, try again");
            }
            else if (userChoice == 1){
                addModifyGrade();
            }
            else if (userChoice == 2){
                swapGrades();
            }
            else if (userChoice == 3){
                listGrades();
            }
            else if (userChoice == 4){
                report();
            }
        }
        while (userChoice != 0);

        if (userChoice == 0){
            System.out.println("Thank you for using the grades program! Bye!");
        }
    }
}