import java.util.*; 
abstract class Event{
   private String id;
   private boolean occured = false; 
   EventPhase[] ePhases; 
   private int eStatType; // each stat assignned a number from 1-9
   private int eStatReq; // minimum num of the stat that needs to be met
   private int eChangeType; 
   private int eChangeAmount; 
   private int month = -1; 
	
   public Event(String id, int statType, int statReq, int changeType, int changeAmount, EventPhase[] phases){
      // for simplicity sake only one stat req per event
      this.id = id; 
      eStatType = statType; 
      eStatReq = statReq; 
      eChangeType = changeType; 
      eChangeAmount = changeAmount; 
      ePhases = new EventPhase [phases.length];
      for (int i = 0; i < phases.length; i++){
         ePhases[i] = phases[i]; 
      }
   } 
   
   public int getStatType(){
      return eStatType; 
   }
   
   public boolean getOccured(){
      return occured; 
   }
   
   public void setOccured(boolean b){
      occured = b; 
   }
   
   public int getStatReq(){
      return eStatReq; 
   }
   
   public int getChangeType(){
      return eChangeType; 
   }
   
   public int getChangeAmount(){
      return eChangeAmount;
   }
	
	public int getMonthReq(){
		return month; 
	}
	
	public void setMonth(int i){
		month = i;
	}
	
	public int getEventValue(){
		if (this instanceof Routine){
			return 2; 
		} else if (this instanceof Random){
			return 3; 
		} else if (this instanceof Predetermined){
			return 1; 
		}
		return 0; 
	}
	
   public void play(){
      Scanner sc = new Scanner(System.in); 
      int playerChoice;
		boolean valid = false;
      String flush; 
      for (int i = 0; i < ePhases.length; i++){
         System.out.println("Event: " + id);
         ePhases[i].playPhase();
			if (i != ePhases.length-1)
			{
         do
         {
            try{
               playerChoice = sc.nextInt();
					valid = makeDecision(playerChoice,i);
               if (!valid || playerChoice <0)
               {
                  System.out.println("Incorrect input. Try again.");
               }
            }
            catch (NumberFormatException nfx)
            {
               System.out.println("Incorrect input. Try again.");
               flush = sc.next();
               playerChoice = -1;
            }
            catch (InputMismatchException imx)
            {
               System.out.println("Incorrect input. Try again.");
               flush = sc.next();
               playerChoice = -1;
            }
         }
         while (!valid || playerChoice <0 );
      }
		}
   }
   
   private boolean makeDecision(int choiceMade, int phaseNum){
      if (choiceMade >= 0 && choiceMade <= ePhases[phaseNum].getNumChoices()){
    	 ePhases[phaseNum].appendText(ePhases[phaseNum].getChoiceChangeToStory(choiceMade));
         ePhases[phaseNum].setChangeToStory(choiceMade, null);
         return true;
      } 
      else if (choiceMade == 0){
         return true;
      } 
      else {
         return false;
      }
   }
   
}
