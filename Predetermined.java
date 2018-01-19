package final_Project;

public class Predetermined extends Event{
	public Predetermined(String id, int statType, int statReq, int changeType, int changeAmount, int month, EventPhase[] phases){
		super(id, statType, statReq, changeType, changeAmount, phases);	
		this.month = month; 
	}
}
