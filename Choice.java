package final_Project;

public class Choice {
	private int id;
	private String choiceText; //the text that actually makes up the choice
	private String changeToStory; //the text that is added to the phase text of the next phase if you make a certain decision
	
	public Choice (int id, String text, String changeToStory){
		id = this.id;
		choiceText = text;  
		this.changeToStory = changeToStory; 
	} 
	
	public String getChangeToStory(){
		return changeToStory; 
	}
	
	public String getChoiceText(){
		return choiceText; 
	}
	
	public String toString(){
		return choiceText; 
	}
}
