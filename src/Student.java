import javax.swing.*;

public class Student {
    //Initialization
    public String firstName, lastName;
    public int age;
    private String nickName;
    private int[] quizzes = new int[5];

    //Constructor w/ no parameters
    public Student(){
        firstName = "";
        lastName = "";
        age = 0;
    }

    //Constructor w/ parameters
    public Student(String firstName, String lastName, String nickName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
    }

    //Accessor(nickName)
    public String getNickName(){
        return nickName;
    }

    //Mutator(nickName)
    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    //Accessor(quizzes)
    //public int[] getQuizzes(){
      //  return quizzes;
    //}

    //Mutator(quizzes)
    //public void setQuizzes(int[] quizzes){
    //    this.quizzes = quizzes;
    //}

    //Display Firstname, Lastname, Nickname and Age using JOptionPane
    public void displayStudentNameAge(){
        String message = "Firstname: " + firstName +
                         "\n Lastname: " + lastName +
                          "\n Nickname: " + nickName +
                          "\n Age: " + age ;

        JOptionPane.showMessageDialog(null, message, "Student Information", JOptionPane.INFORMATION_MESSAGE);
    }

    //Compute for grade based on the quizzes
    private void computeGrade(){

        //Ask for input on quiz scores
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();        

        Object[] fields = {
            "Quiz 1: ", field1,
            "Quiz 2: ", field2,
            "Quiz 3: ", field3,
            "Quiz 4: ", field4,
            "Quiz 5: ", field5
        };

        //OK or Cancel option for the input of scores
        int result = JOptionPane.showConfirmDialog(null, fields, "Enter Quiz Scores of " + firstName + " " + lastName , JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            quizzes = new int[5];
    
            // Retrieve scores from text fields and compute average
            double total = 0;
            int countValidScores = 0;

            for (int i = 0; i < quizzes.length; i++) {
                boolean validInput = false;
                
                
                while(!validInput){
                    String input = ((JTextField) fields[2 * i + 1]).getText().trim();
                    //Check if input is empty
                    if (input.isEmpty()) {
                        input = JOptionPane.showInputDialog(null, "Quiz Score " + (i + 1) + " is empty. Please enter a score:", "Input Error", JOptionPane.ERROR_MESSAGE);
                        
                        //Check if user inputted a score properly
                        if (input == null) {
                            JOptionPane.showMessageDialog(null, "Quiz Score " + (i + 1) + " was not entered. Setting it to 0.");
                            quizzes[i] = 0;
                            validInput = true;
                        } else {
                            ((JTextField) fields[2 * i + 1]).setText(input.trim()); 
                        }
                        continue;
                    }else{
                        try{
                            input = ((JTextField) fields[2 * i + 1]).getText().trim();

                            
                            
                            quizzes[i] = Integer.parseInt(input);

                            total+=quizzes[i];
                            countValidScores++;
                            validInput = true;

                        }catch(NumberFormatException e){
                            input = JOptionPane.showInputDialog(null, "Invalid input for quiz score " + (i + 1) + ". Please enter a valid number:", "Input Error", JOptionPane.ERROR_MESSAGE);                        
                            ((JTextField) fields[2 * i + 1]).setText(input);
                        }
                    }
                }
            }   
            double avg = countValidScores > 0 ? total / countValidScores:0; 

        //Score Display
        String message = "Quiz 1: " + quizzes[0] +
                         "\nQuiz 2: " + quizzes[1] +
                         "\nQuiz 3: " + quizzes[2] +
                         "\nQuiz 4: " + quizzes[3] +
                         "\nQuiz 5: " + quizzes[4] +
                         "\nAverage: " + avg;

        JOptionPane.showMessageDialog(null, message, "Quiz Scores of " + firstName + " " + lastName, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Display all information with respect to displayStudentNameAge and computeGrade
    public void displayAllInformation(){
        displayStudentNameAge();
        computeGrade(); 
    }

    //Ask for student input
    public Student askForStudentInfo() {
        JTextField field1 = new JTextField("");
        JTextField field2 = new JTextField("");
        JTextField field3 = new JTextField("");
        JTextField field4 = new JTextField("");       

        Object[] fields = {
            "First Name: ", field1,
            "Last Name: ", field2,
            "Nickname: ", field3,
            "Age: ", field4
        };

        int result = JOptionPane.showConfirmDialog(null, fields, "Student Information", JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.OK_OPTION){

            //firstName Validation
            firstName = field1.getText().trim();
            while (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "First Name cannot be empty. Please enter a valid first name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                firstName = JOptionPane.showInputDialog(null, "Please enter a valid First Name:");
                if (firstName == null) return null; 
                field1.setText(firstName);
            }

            //lastName Validation
            lastName = field2.getText().trim();
            while (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Last Name cannot be empty. Please enter a valid last name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                lastName = JOptionPane.showInputDialog(null, "Please enter a valid Last Name:");
                if (lastName == null) return null; 
                field2.setText(lastName);
            }

            nickName = field3.getText().trim();
            while (nickName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nickname cannot be empty. Please enter a valid nickname.", "Input Error", JOptionPane.ERROR_MESSAGE);
                nickName = JOptionPane.showInputDialog(null, "Please enter a valid Nickname:");
                if (nickName == null) return null; 
                field3.setText(nickName);
            }

        boolean validInput = false;    
        
        while(!validInput){
            try{
                this.age = Integer.parseInt(field4.getText().trim());
                validInput = true;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid input for age. Please enter a valid value.", "Input Error", JOptionPane.ERROR_MESSAGE);
                
                String newAgeInput = JOptionPane.showInputDialog(null, "Please enter a valid age:", "Input Error", JOptionPane.ERROR_MESSAGE);

                //New field text for age
                if (newAgeInput != null) {
                    field4.setText(newAgeInput.trim());
                } else {
                    age = 0; 
                    validInput = true;
                }
            }
        }
            return new Student(firstName, lastName, nickName, age);
        }
        return null;
    }

    public boolean askForAnotherStudentInfo(){
        int result = JOptionPane.showConfirmDialog(null, "Do you want to enter another student info?", "Add Another Information?", JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }
}   
