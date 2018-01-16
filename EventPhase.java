package final_Project;

public class EventPhase {
	private Choice [] EpChoices; 
	private int numChoices;
	private String phaseText; 
	boolean proceed = false; 
	
	public EventPhase (Choice [] choices){
		numChoices = choices.length; 
		EpChoices = new Choice[numChoices];
		
		for (int i = 0; i < numChoices; i++){
			EpChoices[i] = choices[i]; 
		}
	}
	
	public void playPhase(){
		System.out.println(phaseText);
		for (int i = 0; i < numChoices; i++){
			System.out.println(i + ": " + EpChoices[i].getChoiceText()); 
		}
		System.out.println();
	}
		
	public void appendText(int choiceNum){
		phaseText = EpChoices[choiceNum].getChangeToStory() + phaseText; 
	}
	
	public int getNumChoices(){
		return EpChoices.length; 
	}
	
	public String getPhaseText(){
		return phaseText;
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
