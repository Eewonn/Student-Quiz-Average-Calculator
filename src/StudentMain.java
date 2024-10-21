import javax.swing.*;

public class StudentMain {
    public static void main(String[] args) {
        //Laboratory 4 - Classes and Objects

        JOptionPane.showMessageDialog(null, "This is a program to calculate the average of the student's scores", "Quiz Average Calculator", JOptionPane.INFORMATION_MESSAGE);

        Student juan = new Student("Juan", "Dela Cruz", "John", 30);
        Student pedro = new Student("Pedro", "Penduko", "Peter", 25);
    
        juan.displayAllInformation();
        pedro.displayAllInformation();
        
        Student student = new Student();
        do{
            Student newStudent = student.askForStudentInfo();
            newStudent.displayAllInformation();
        }while(student.askForAnotherStudentInfo()); //Continue asking for another student info if user press yes otherwise end program
    }
}                                   