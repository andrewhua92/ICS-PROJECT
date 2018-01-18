import java.util.*; 
abstract class Event{
	private String id;
	private boolean occured = false; 
	private EventPhase [] ePhases; 
	private int eStatType; // each stat assignned a number from 1-9
	private int eStatReq; // minimum num of the stat that needs to be met
	private int eChangeType; 
	private int eChangeAmount; 
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
	
	public void play(){
		Scanner sc = new Scanner(System.in); 
		int playerChoice; 
		for (int i = 0; i < ePhases.length; i++){
			System.out.println(ePhases[i]);
			playerChoice = sc.nextInt(); 
			while (!(makeDecision(playerChoice, i))){
				System.out.println("Invalid decision. Please enter a valid decision number.");
				playerChoice = sc.nextInt();
			}
			makeDecision(playerChoice, i);
		}
	}
	
	private boolean makeDecision(int choiceMade, int phaseNum){
		if (choiceMade >= 1 && choiceMade <= ePhases[phaseNum].getNumChoices()){
			 ePhases[phaseNum + 1].appendText(ePhases[phaseNum].getChoiceChangeToStory(choiceMade));
			 return true;
		} else if (choiceMade == 0){
			return true;
		} else {
			return false;
		}
	}
}

