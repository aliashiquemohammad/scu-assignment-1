
/**
 * The program allows user to input the assignment name and 30 student Marks.
 * It shows the highest and lowest marks from the student marks.
 * It also calculates the mean and deviation.
 * 
 * @author (Mohammad Ashique Ali)
 * @version (10/09/2023)
 */
import java.util.Scanner;
 
public class studentAssignmentMarks
{
    // instance variables
    private int[] studentAssignmentMarks;
    private String studentAssignmentName;
    private double meanOfStudentMarks;

    /**
     * Constructor for objects of class studentAssignmentMarks
     */
    public studentAssignmentMarks()
    {
        // initialise instance variables with array for 30
        studentAssignmentMarks = new int[5];
        meanOfStudentMarks = 0.0;
    }
    
    /**
     * Prompt for user to enter assignment name
     */
    public void getAssignmentName(){
        Scanner inputAssignmentName = new Scanner(System.in);
        System.out.println( "Enter Assignment Name : " );
        studentAssignmentName = inputAssignmentName.nextLine();
        
    }
    
    /**
     * Prompt for user to enter student marks
     * invalid input data is not accepted.
     */
    public void getStudentMarks(){
        Scanner inputStudentMarks = new Scanner(System.in);
        
        int counter = 1;
        for (int i=0; i < studentAssignmentMarks.length; i++ ){
            // setting a flag to get error result
            boolean inputError = false;
            while( !inputError ){
                System.out.print( "Enter marks for student number " + counter + " : " );
                int studentMark = inputStudentMarks.nextInt();
                if( studentMark > 0 && studentMark <= studentAssignmentMarks.length ){
                    counter++;
                    studentAssignmentMarks[i] = studentMark;
                    inputError = true;
                }else{
                    System.out.println( "Marks should be between 0 to 30. Please try again." );
                }
            }
        }
    }
    
    /**
     * 
     */
    public void showAssignmentNameAndStudentMarks(){
        System.out.println("Assignment Name : " + studentAssignmentName);
        System.out.println("All Student Marks");
        int counter = 1;
        for (int i = 0; i < studentAssignmentMarks.length; i++) {
            counter++;
            System.out.println("Mark of student " +  counter  + " : " + studentAssignmentMarks[i]);
        }
    }
    
    /**
     * Calculating Mean from the student Marks
     */
    public void calculateMeanFromStudentMarks() {
        int totalSumOfAssignmentMarks = 0;
        for (int i = 0; i < studentAssignmentMarks.length; i++) {
            totalSumOfAssignmentMarks += studentAssignmentMarks[i];
        }
        meanOfStudentMarks = (double) totalSumOfAssignmentMarks / studentAssignmentMarks.length;
        System.out.println( "The mean is: " + meanOfStudentMarks );

    }
    
    /**
     * Calculating standard deviation from the student marks without
     * any pre defined function
     */
    public void calculateStandardDeviationFromStudentMarks(){
        double totalSumOfSquares = 0;
        double standardDeviationOfStudentMarks;
        
        for (int i = 0; i < studentAssignmentMarks.length; i++) {
            double powerBaseNumber =  studentAssignmentMarks[i] - meanOfStudentMarks;
            int powerNumber = 2;
            double sumOfPower = 1;
            
            while( powerNumber != 0 ){
                sumOfPower *= powerBaseNumber;
                powerNumber--;
            }
            
            totalSumOfSquares += sumOfPower;
        }
        double numberToGetSquareRootOf =  totalSumOfSquares / studentAssignmentMarks.length;
        
        //temporary variable manuplate data
        double flagVariable;  
        double squareRootOfMarks = numberToGetSquareRootOf / 2;  
        do{  
            flagVariable = squareRootOfMarks;  
            squareRootOfMarks = ( flagVariable + ( numberToGetSquareRootOf / flagVariable ) ) / 2;  
        }
        while( ( flagVariable - squareRootOfMarks ) != 0 );
          
        standardDeviationOfStudentMarks = squareRootOfMarks;
    

        System.out.println("The Standard Deviation: " + standardDeviationOfStudentMarks);
    }
    /**
     * Default method to run the whole program by having
     * a instance of the class itself and calling all the method one by one.
     */
    public static void main(String[] args) {
        studentAssignmentMarks marks = new studentAssignmentMarks();

        marks.getAssignmentName();
        marks.getStudentMarks();
        marks.showAssignmentNameAndStudentMarks();
        marks.calculateMeanFromStudentMarks();
        marks.calculateStandardDeviationFromStudentMarks();
    }
}
