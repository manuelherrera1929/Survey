package survey;

import javax.swing.JOptionPane;

/**
 *
 * @author manuelherrera
 */
public class surveyClass {
    //static class variable and instance variable
    int respondentID;
    String surveyTitle;
    //Array variables
    int surveyMatrix[][] = new int [10][10];
    String questionArray[] = new String [10];
    
    //takes question ID and stores it in question array
    void provideQ(int qID){
    questionArray[qID]=JOptionPane.showInputDialog("Please input question{"+qID+"}");
    }
    
    //stores number provided by user and stores it in surveymatrix
    void respondentLog(int qID, int rID, int res){
    surveyMatrix[qID][rID]= res;  
    }
    
    //displays the survey matrix
    void matrixDisplay(int nQ, int nR){
        
            System.out.println("*******Survey Title"+ surveyTitle+" *******");
     
     for(int qID =0; qID< nQ; qID++){
            
            for(int rID=0; rID < nR; rID++){
            
            System.out.print(surveyMatrix[qID][rID]+"   ");
            }
            System.out.println();
    }
    
     
    }

   
    
    void promptQ(int qID){ 
     System.out.println("Q("+qID+")"+questionArray[qID]);
  }
    
    void promptQ(int qID, int rID){
     System.out.println("Respondent ID= "+rID);   
     System.out.println("Q("+qID+")"+questionArray[qID]);
  }
  //Display question results
    void displayQStats(int qID, int nR){
    
        System.out.println();
        
        System.out.print("Q("+qID+"):  ");
    
        for(int rID =0; rID<nR;rID++){
        
        System.out.print(surveyMatrix[qID][rID]+"   ");
        
    }
        
        System.out.println();
        
    } 
    
    
    int topRatedQ(int nQ, int nR){
    
        int topIndex=-1;
        int questionR;
        int topResult=-0;
        
        for(int qID=0; qID < nQ; qID ++){
           questionR=0; 
            
         for(int rID =0; rID < nR; rID++){
             
             questionR=  questionR+ surveyMatrix[qID] [rID];
      
           }
    
           if(questionR > topResult){
              topResult =  questionR;
              topIndex = qID;
           }
         
           }
        
        return topIndex;   
      
    }
    
    
    int lowRatedQ(int nQ, int nR){
    
        int lowIndex=-1;
        int questionR;
        int lowResult=51;
        
        for(int qID=0; qID < nQ; qID ++){
           questionR=0; 
            
         for(int rID =0; rID < nR; rID++){
             
             questionR=  questionR+ surveyMatrix[qID] [rID];
      
           }
    
           if(questionR < lowResult){
              lowResult =  questionR;
              lowIndex = qID;
           }
         
           }
        
        return lowIndex;   
      
    }
    
    
    
        

//constructor, resets the static respondentID to zero 
    surveyClass(){
        
    this("survey Title");
    }               
        
        
    
  surveyClass(String titleofSurvey){    
  surveyTitle= titleofSurvey; 
  respondentID=0;
  
  } 
   
  //constructor, sets survey value to default value
    int promptID(){
            
        respondentID++;
    
       return respondentID;
     }

  
  
}
