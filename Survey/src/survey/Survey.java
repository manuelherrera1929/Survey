package survey;

import javax.swing.JOptionPane;

/**
 *
 * @author manuelherrera
 */
public class Survey {

   
    public static void main(String[] args) {
        int qID, respID;
        int nQ, nR;
        int res;
        String temp;
        
        surveyClass Quiz;
        Quiz = new surveyClass("Survey");
        
        nQ =Integer.parseInt(JOptionPane.showInputDialog("How many questions does the survey have?"));
        
        for(qID =0; qID< nQ; qID++){
            
            Quiz.provideQ(qID);
    }
        
    nR =Integer.parseInt(JOptionPane.showInputDialog("How many respondents do you have?"));

    
    for(int r=0; r<nR ; r++){
        
       respID= Quiz.promptID()-1;
       System.out.println("******* Respondent ID:" + respID+" *******");
       
       for(qID=0; qID < nQ; qID++){
       Quiz.promptQ(qID, respID);
       res=0;
       while(res < 1 || res > 5){
        
           temp= JOptionPane.showInputDialog("Please enter an answer (1-5)");
           
          if(temp.matches("\\d+"))  res= Integer.parseInt(temp);
       }
       Quiz.respondentLog(qID, qID, res);
       }
       
    }
    
    Quiz.matrixDisplay(nQ, nR);
           
           
    int topRatedQ, lowRatedQ;
    
    topRatedQ= Quiz.topRatedQ(nQ, nR);
    lowRatedQ= Quiz.lowRatedQ(nQ, nR);
    
    System.out.println("Top rated Question: ");
    Quiz.promptQ(topRatedQ);
    
    System.out.println("low rated Question: ");
    Quiz.promptQ(lowRatedQ);
    
    
    System.out.println("Please add question's ID to prompt results ");
    qID = Integer.parseInt(JOptionPane.showInputDialog("Question's ID to prompt results"));
    Quiz.displayQStats(qID, nR);
    
  }
    
}
