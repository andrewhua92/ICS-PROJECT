abstract class Evaluations
{
	private String name;
	private int minCharisma;
	private double mark;
	
	Player user;
	
	// constructor
	public Evaluations(String eval, Player plyr)
	{
		name = eval;
		user = plyr;
		minCharisma = calcCharis();
	}
	
	// accesors and mutators
	public String getName()
	{
		return name;
	}
	
	public void setName(String nm)
	{
		name = nm;
	}
	
	public int getMinCharisma()
	{
		return minCharisma;
	}
	
	public void setMinCharisma(int charis)
	{
		minCharisma = charis;
	}
	
	public double getMark()
	{
		return mark;
	}
	
	public void setMark(double mrk)
	{
		mark = mrk;
	}
	
	// calculate independent minimum charisma
	private int calcCharis()
	{
		int charis;
		charis =(int)( Math.random() * 4 + 3);
		return charis;
	}
	
	// calculates the boost for a teacher
	public double teacherBoost(int playerCharis, double mark)
	{
		if (playerCharis > minCharisma)
		{
			mark = mark + (Math.random()*3);
		}
		else
		{
			mark = mark - (Math.random()*2);
		}
		return mark;
	}
	
	// calculates the boost for current luck
	public double luckBoost(int playerLuck, double mark)
	{
		boolean check = false;
		int luck = playerLuck;
		int choose = (int) Math.random()*10;
		if (luck > choose)
		{
			mark = mark + (Math.random()*3);
		}
		return mark;
	}
	
	// calculates independent mark
	abstract double calculateMark();
}