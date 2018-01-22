public class EventPhase {
   private Choice [] EpChoices; 
   private int numChoices;
   private String phaseText; 
   private String baseText;
   boolean proceed = false; 
	
   public EventPhase (String phaseText, Choice [] choices){
      this.phaseText = phaseText;
      numChoices = choices.length; 
      EpChoices = new Choice[numChoices];
      for (int i = 0; i < numChoices; i++){
         EpChoices[i] = choices[i]; 
      }
      baseText = phaseText;
   }
	
   public void playPhase(){
      System.out.println(phaseText);
      for (int i = 0; i < numChoices; i++){
         System.out.println(i + ": " + EpChoices[i].getChoiceText()); 
      }
      System.out.println();
   }
		
   /*public void appendText(int choiceNum){
      phaseText = EpChoices[choiceNum].getChangeToStory() + phaseText; 
   }*/
	
   public int getNumChoices(){
      return EpChoices.length; 
   }
	
   public void appendText(String text){
      phaseText = text + phaseText; 
   }
	
   public String getPhaseText(){
      return phaseText;
   }
	
   public String getChoiceChangeToStory(int choiceNum){
      return EpChoices[choiceNum].getChangeToStory();
   }
	
   public void setChangeToStory(int choiceNum, String s){
      EpChoices[choiceNum].setChangeToStory(s);
   }
   
   public String getBaseText(){
      return baseText; 
   }
	
   public void resetPhaseText(){ //added
      phaseText = baseText; 
   }
   
   public String toString(){
      String s = "";
      for (int i = 0; i < numChoices; i++){
         s += i + ": " + EpChoices[i].toString() + "\n"; 
      } 
      s+= "\n";
      return s; 
   }
}
