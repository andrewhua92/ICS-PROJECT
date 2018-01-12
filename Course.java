    public class Course
   {
		// Variables
      private double currentMark = 100;
      private int courseMissed = 0;
      private int courseLength;
      protected static int gradeLevel;
      private String subject;
      Evaluations[] list;
      private int numEval; 
      private double PASS = 50;
		
		private String boostStat;
   
		// Constructors
       public Course (int crsLeg,int grdLvl,String name, String stat)
      {
         courseLength = crsLeg;
         gradeLevel = grdLvl;
         subject = name;
			boostStat = stat;
      }
   
		// Accesors and mutators
       public double getCurrMark()
      {
         return currentMark;
      }
   
       public void setCurrMark(double mark)
      {
         currentMark = mark;
      }
   
       public int getCourseMissed()
      {
         return courseMissed;
      }
   
       public void setCourseMissed(int num)
      {
         courseMissed = num;
      }
       public int getCourseLength()
      {
         return courseLength;
      }
   
       public void setCourseLength(int length)
      {
         courseLength = length;
      }
       public int getGradeLevel()
      {
         return gradeLevel;
      }
   
       public void setGradeLevel(int grade)
      {
         gradeLevel = grade;
      }
   
       public String getSubject()
      {
         return subject;
      }
   
       public void setSubject(String sbj)
      {
         subject = sbj;
      }
   
       public int getNumEval()
      {
         return numEval;
      }
   
       public void setNumEval(int num)
      {
         numEval = num;
      }
		
		public String getBoostStat()
		{
			return boostStat;
		}
		
		public void setBoostStat(String stat)
		{
			boostStat = stat;
		}
   
		// Methiod to check if this player is passing course
       public boolean pass ()
      {
         if (currentMark >= PASS)
         {
            return true;
         }	
         return false;
      }
   
   
   
   }