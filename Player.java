import java.util.*;

    public class Player
   {
   	//Fields
      Scanner input = new Scanner(System.in);
      private int grade;
      Stats stats;
      private Type type;
      private String gender;
      private String name;
      private boolean sufficientSleep;
      Study allocatedStudy;
      private int month;
      private final int COURSES = 4;
      Course[] schedule = new Course[COURSES];
   
   	//Constructor
       public Player(Stats stats, Type type, String gender, String name, boolean sufficientSleep, int month)
      {
         this.stats=stats;
         this.type=type;
         this.gender=gender;
         this.name=name;
         this.sufficientSleep=sufficientSleep;
         this.month=month;
      }
   	
   	//Accessors
       public Stats getStats()
      {
         return stats;           
      }
       public Type getType()
      {
         return type;
      }
       public String getGender()
      {
         return gender;
      }
       public String getName()
      {
         return name;
      }
       public boolean getSufficientSleep()
      {
         return sufficientSleep;
      }
       public Course[] getSchedule()
      {
         return schedule;
      }
       public Study getAllocatedStudy()
      {
         return allocatedStudy;
      }
       public int getMonth()
      {
         return month;
      }
       public int getGrade()
      {
         return grade;
      }
   	//Mutators
       public void setStats(Stats stats)
      {
         this.stats=stats;
      }
       public void setType(Type type)
      {
         this.type=type;
      }
       public void setGender(String gender)
      {
         this.gender=gender;
      }
       public void setName(String name)
      {
         this.name=name;
      }
       public void setSufficientSleep(boolean sufficientSleep)
      {
         this.sufficientSleep=sufficientSleep;
      }
       public void setSchedule(Course[] schedule)
      {
         this.schedule=schedule;
      }
       public void setAllocatedStudy(Study allocatedStudy)
      {
         this.allocatedStudy=allocatedStudy;
      }
       public void setMonth(int month)
      {
         this.month=month;
      }
       public void setGrade(int grade)
      {
         this.grade=grade;
      }
   	
   	//Checks if the time they inputed is greater than time avaliable
       public boolean timeChecker(double time, double timeLeft)
      {
         if(timeLeft-time>0)
            return true;
         else
            return false;
      }
   	
   	//Prompts the user to input time for sociallizing, studying and sleeping. Also calls social, study and sleep method to
   	//add points into stats.
       public void spendTime()
      {
         double time;
         double timeLeft=12.0;
         boolean badTime;
         System.out.println("How would you like to spend your time after school from 3pm? (12 hours) ");
         System.out.println("How much time do you want to spend socializing/having fun?");
         time=input.nextDouble();
         try
         {
            while(!timeChecker(time,timeLeft))
            {
               System.out.println("How much time do you want to spend socializing/having fun?");
               time=input.nextDouble();
            }
            social(time);
            timeLeft-=time;
            System.out.println("How much time do you want to spend studying?");
            time=input.nextDouble();
            while(!timeChecker(time,timeLeft))
            {
               System.out.println("How much time do you want to spend studying?");
               time=input.nextDouble();
            }
            study(time);
            timeLeft-=time;
            System.out.println("You sleep at 3am, how many additional hours do you want to sleep?");
            time=input.nextDouble();
            while(!timeChecker(time,timeLeft))
            {
               System.out.println("You sleep at 3am, how many additional hours do you want to sleep?");
               time=input.nextDouble();
            }
            sleep(time);
            timeLeft-=time;
         }
             catch(InputMismatchException ime)
            {
               System.out.println("Please input a number.");
            }
      }
   
   	//Gets time for sleep and converts it into stats
       public void sleep(double time)
      {
         if (time>3)
            stats.setHappiness(stats.getHappiness() +(int)time/3);
         else 
            stats.setHappiness(stats.getHappiness() - 1);
      }
   	//Gets time for study and converts it into stats
       public void study(double time)
      {
			double hours;
      	double timeLeft=time;
         for(int i=0; i<schedule.length; i++)
         {
            System.out.println("How much time do you want to spend with each course?");
            System.out.println(schedule[i].getSubject()+": ");
         	hours=input.nextDouble();
				 while(!timeChecker(hours,timeLeft))
            {
               System.out.println("Re-enter a number for "+schedule[i].getSubject());
               hours=input.nextDouble();
            }
				timeLeft-=hours;
				allocatedStudy=new Study(hours);
				allocatedStudy.effectiveCalculator(allocatedStudy.getHoursStudy(),allocatedStudy.getEffectiveHours(), true, 1);
				
				String statType = schedule[i].getBoostStat();
				
				switch(statType)
				{
					case"linguisticIntelligence":
               stats.setLinguisticIntelligence((int)(stats.getLinguisticIntelligence()+allocatedStudy.getEffectiveHours()));
               break;
               case"spatialIntelligence":
					stats.setSpatialIntelligence((int)(stats.getSpatialIntelligence()+allocatedStudy.getEffectiveHours()));
               break;
               case"logicalIntelligence":
               stats.setLogicalIntelligence((int)(stats.getLogicalIntelligence()+allocatedStudy.getEffectiveHours()));
               break;
               case"expressionCharisma":
               stats.setExpressionCharisma((int)(stats.getExpressionCharisma()+allocatedStudy.getEffectiveHours()));
               break;
               case"socialCharisma":
               stats.setSocialCharisma((int)(stats.getSocialCharisma()+allocatedStudy.getEffectiveHours()));
               break;
               case"strength":
               stats.setStrength((int)(stats.getStrength()+allocatedStudy.getEffectiveHours()));
               break;
               default: System.out.println("Error");
				}
         }
      }  
      //Gets time for social and converts it into stats
       public void social(double time)
      {
         if(time>3)
         {
            stats.setSocialCharisma((int)(stats.getSocialCharisma()+time/2));
            stats.setHappiness((int)(stats.getHappiness()+time/3));
         }
      }
		
      // Method used to simulate a 'test' based on stats of player at current month
		public void doTest(int courseNum)
		{
			schedule[courseNum].list[schedule[courseNum].createEval(this)].calculateMark();
		}
      
      // Method that initializes the courses and selects the courses
      public void courseSelection()
      {
         for (int i = 0; i < COURSES; i++)
         {
            schedule[i] = new Course(grade);
            schedule[i].chooseCourse();
         }
      }
   }
