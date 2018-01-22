public class Predetermined extends Event{
	private int month; 
	//Contructor
	public Predetermined(String id, int statType, int statReq, int changeType, int changeAmount, int month, EventPhase[] phases){
		super(id, statType, statReq, changeType, changeAmount, phases);	
		this.month = month; 
	}
	//accessor
	public int getMonthReq(){
		return month; 
	}
}
