
/**
 * The program allows user to input the assignment name and 30 student Marks.
 * It shows the highest and lowest marks from the student marks.
 * It also calculates the mean and deviation.
 * 
 * @author (Mohammad Ashique Ali)
 * @version (06/09/2023)
 */
import java.util.Scanner;
 
public class studentAssignmentMarks
{
    // instance variables
    private int[] studentAssignmentMarks;
    private String studentAssignmentName;

    /**
     * Constructor for objects of class studentAssignmentMarks
     */
    public studentAssignmentMarks()
    {
        // initialise instance variables with array for 30
        studentAssignmentMarks = new int[5];
    }
    
    /**
     * Prompt for user to enter assignment name
     */
    public void getAssignmentName(){
        Scanner inputAssignmentName = new Scanner(System.in);
        System.out.print( "Enter Assignment Name : " );
        studentAssignmentName = inputAssignmentName.nextLine();
        
    }
    
    /**
     * Prompt for user to enter student marks
     * invalid input data is not accepted.
     */
    public void getStudentMarks(){
        Scanner inputStudentMarks = new Scanner(System.in);
        System.out.print(studentAssignmentMarks.length);
        
        int counter = 1;
        for (int i=0; i < studentAssignmentMarks.length; i++ ){
            // setting a flag to get error result
            boolean inputError = false;
            while( !inputError ){
                System.out.print( "Enter marks for student number " + counter + " : " );
                int studentMark = inputStudentMarks.nextInt();
                if( studentMark > 0 && studentMark <= 30 ){
                    counter++;
                    studentAssignmentMarks[i] = studentMark;
                    inputError = true;
                }else{
                    System.out.print( "Marks should be between 0 to 30. Please try again." );
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
     * Default method to run the whole program by having
     * a instance of the class itself and calling all the method one by one.
     */
    public static void main(String[] args) {
        studentAssignmentMarks marks = new studentAssignmentMarks();

        marks.getAssignmentName();
        marks.getStudentMarks();
        marks.showAssignmentNameAndStudentMarks();
    }
}
