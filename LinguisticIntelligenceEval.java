public class LinguisticIntelligenceEval extends Evaluations
{
	public LinguisticIntelligenceEval(String name, Player plyr)
	{
		super(name,plyr);
	}
	
	public double calculateMark()
	{
		double mark = 0;
		int grdLvl = Course.gradeLevel;
		int control = super.user.stats.getLinguisticIntelligence();
		if (grdLvl <= 10)
		{
			if (control < 7)
			{
				mark = 50;
			}
			else 
			{
				mark = 70;
			}
			mark = mark + (control - 7) * 2.5;
		}
		else if (grdLvl >= 11)
		{
			if (control < 11)
			{
				mark = 60;
			} 
			else
			{
				mark = 85;
			}	
			mark = mark + (control - 11) * 2.5;
		}
		mark = super.teacherBoost(super.user.stats.getSocialCharisma(),mark);
		mark = super.luckBoost(super.user.stats.getLuck(), mark);
		return mark;
	}
}	