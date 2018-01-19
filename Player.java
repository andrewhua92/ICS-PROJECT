import java.util.*;

public class Player {
	// Fields
   Scanner input = new Scanner(System.in);
   private int grade;
   Stats stats;
   private Type type;
   private String gender;
   private String name;
   private boolean sufficientSleep;
   private final int COURSES = 4;
   Course[] schedule = new Course[COURSES];
   Study allocatedStudy;
   private int month;

	// Constructor
   public Player(Stats stats, Type type, String gender, String name, boolean sufficientSleep, int month) {
      this.stats = stats;
      this.type = type;
      this.gender = gender;
      this.name = name;
      this.sufficientSleep = sufficientSleep;
      this.schedule = schedule;
      this.month = month;
   }

	// Accessors
   public Stats getStats() {
      return stats;
   }

   public Type getType() {
      return type;
   }

   public String getGender() {
      return gender;
   }

   public String getName() {
      return name;
   }

   public boolean getSufficientSleep() {
      return sufficientSleep;
   }

   public Course[] getSchedule() {
      return schedule;
   }

   public Study getAllocatedStudy() {
      return allocatedStudy;
   }

   public int getMonth() {
      return month;
   }

   public int getGrade() {
      return grade;
   }

	// Mutators
   public void setStats(Stats stats) {
      this.stats = stats;
   }

   public void setType(Type type) {
      this.type = type;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setSufficientSleep(boolean sufficientSleep) {
      this.sufficientSleep = sufficientSleep;
   }

   public void setSchedule(Course[] schedule) {
      this.schedule = schedule;
   }

   public void setAllocatedStudy(Study allocatedStudy) {
      this.allocatedStudy = allocatedStudy;
   }

   public void setMonth(int month) {
      this.month = month;
   }

   public void setGrade(int grade) {
      this.grade = grade;
   }

	// Checks if the time they inputed is greater than time avaliable or if it is a valid amount of time
   public boolean timeChecker(double time, double timeLeft) {
      if ((timeLeft - time) >= 0 && time >=0 )
         return true;
      else
         return false;
   }

	// Prompts the user to input time for socializing, studying and sleeping. Also
	// calls social, study and sleep method to
	// add points into stats.
   public void spendTime() {
      String word;
      String flush;
      double time = 0;
      double socialTime;
      double studyTime;
      double timeLeft = 12.0;
		boolean reset = true;
      while (reset) {
         System.out.println("How would you like to spend your time after school from 3pm? (12 hours)");
      // makes sure under time limit
         do{
            try {
               System.out.println("How much time do you want to spend socializing/having fun?");
               time = input.nextDouble();
               if (!timeChecker(time,timeLeft))
               {
                  System.out.print("Invalid time. Try again. ");
               }
            } catch (NumberFormatException nfx) {
               System.out.println("Bad input, please try again. ");
               flush = input.next();
               time = -1;
            }
            catch (InputMismatchException imx)
            {
               System.out.println("Bad input, please try again.");
               flush = input.next();
               time = -1;
            }
         }
            while(!timeChecker(time,timeLeft));
         
      // subtract time used for social
         socialTime = time;
         timeLeft -= time;
      
         do {
            try {
               System.out.println("How much time do you want to spend studying? Hours left: " + timeLeft + " Hours.");
               time = input.nextDouble();
               if (!timeChecker(time,timeLeft))
               {
                  System.out.print("Invalid time. Try again. ");
               }
            } catch (NumberFormatException nfx) {
               System.out.println("Bad input, please try again. ");
               flush = input.next();
               time = -1;
            }
            catch (InputMismatchException imx)
            {
               System.out.println("Bad input, please try again.");
               flush = input.next();
               time = -1;
            }
         }
            while (!timeChecker(time, timeLeft));
         timeLeft-=time;
            
         double hours[] = new double [schedule.length];
         for (int i =0 ; i<schedule.length;i++)
         {
            do
            {
               System.out.println("How much time do you want to spend with each course? Hours left to study: " + time + " Hours.");
               System.out.print(schedule[i].getSubject() + ": ");
               try{
                  hours[i] = input.nextDouble();
                  if (!timeChecker(hours[i],time))
                  {
                     System.out.print("Invalid time. Try again. ");
                  }
               }
               catch (NumberFormatException nfx)
               {
                  System.out.println("Bad input, please try again. ");
                  flush = input.next();
                  hours[i] = -1;
               }
               catch (InputMismatchException imx)
               {
                  System.out.println("Bad input, please try again .");
                  flush = input.next();
                  hours[i] = -1;
               }
            }
            while (!timeChecker(hours[i], time));
            time-=hours[i];
         }
      
      // subtract time used for study
      
         System.out.println("You are given 6 hours of sleep, plus " + timeLeft + " hours left over.");
         System.out.println("");
      
         boolean correct= false;
         int choose;
         while (!correct) 
         {
            System.out.println("Would you like to save these settings? (1 for yes, 2 for no)");
            try{
               choose = input.nextInt();
               if (choose == 1) {
                  System.out.println("Your choices have been saved.");
                  System.out.println("");
                  social(socialTime);
                  study(hours);
                  sleep(timeLeft);
                  reset = false;
                  correct = true;
               }else if (choose == 2) {
                  System.out.println("Your choices have been reset.");
                  System.out.println("");
                  correct = true;
                  time = 0;
                  timeLeft = 12;
                  hours = null;
                  socialTime = 0;
						
               }
               else
               {
                  System.out.println("Incorrect input. Try again.");
               }
            }
            catch(NumberFormatException nfx)
            {
               System.out.println("Incorrect input. Try again. ");
               flush = input.next();
               choose = -1;
            }
            catch(InputMismatchException imx)
            {
               System.out.println("Incorrect input. Try again. ");
               flush = input.next();
               choose = -1;
            }
         }
      }
   }
   

	// Gets time for sleep and converts it into stats
   public void sleep(double sleep) {
      if (sleep > 2)
      {
         stats.setHappiness(stats.getHappiness() + (int) sleep / 3);
      }
      else
      {	
         stats.setHappiness(stats.getHappiness() - 1);
      }
   }

	// Gets time for study and converts it into stats
   public void study(double[] time) {
      for (int i = 0; i < schedule.length; i++) {
         allocatedStudy = new Study(time[i]);
         allocatedStudy.effectiveCalculator(allocatedStudy.getHoursStudy(), allocatedStudy.getEffectiveHours(), true,
            	1);
      
         String statType = schedule[i].getBoostStat();
      
         switch (statType) {
            case "linguisticIntelligence":
               stats.setLinguisticIntelligence(
                  (int) (stats.getLinguisticIntelligence() + allocatedStudy.getEffectiveHours()));
               break;
            case "spatialIntelligence":
               stats.setSpatialIntelligence(
                  (int) (stats.getSpatialIntelligence() + allocatedStudy.getEffectiveHours()));
               break;
            case "logicalIntelligence":
               stats.setLogicalIntelligence(
                  (int) (stats.getLogicalIntelligence() + allocatedStudy.getEffectiveHours()));
               break;
            case "expressionCharisma":
               stats.setExpressionCharisma((int) (stats.getExpressionCharisma() + allocatedStudy.getEffectiveHours()));
               break;
            case "socialCharisma":
               stats.setSocialCharisma((int) (stats.getSocialCharisma() + allocatedStudy.getEffectiveHours()));
               break;
            case "strength":
               stats.setStrength((int) (stats.getStrength() + allocatedStudy.getEffectiveHours()));
               break;
            default:
               System.out.println("Error");
         }
      }
   }

	// Gets time for social and converts it into stats
   public void social(double time) {
      if (time > 3) {
         stats.setSocialCharisma((int) (stats.getSocialCharisma() + time / 2));
         stats.setHappiness((int) (stats.getHappiness() + time / 3));
      }
   }

	// Performs a test based on which course is chosen
   public void doTest(int courseNum, int month) {
      schedule[courseNum].createEval(this, (month%5));
      schedule[courseNum].list[(month%5)].calculateMark();
   }
   
   // Method that initializes the courses and selects the courses
   public void courseSelection()
   {
      for (int i = 0; i < COURSES; i++)
      {
         schedule[i] = new Course(grade);
         schedule[i].chooseCourse();
         for(int j = 0; j < i; j++)
         {
            if (schedule[i].getSubject().equals(schedule[j].getSubject()))
            {
               System.out.println("You already have selected this course. Try again.");
               schedule[i] = null;
               i--;
            }
         }
         System.out.println("You have chosen : " + schedule[i].getSubject());
         System.out.println("");
      }
   }
}
