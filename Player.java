   import java.util.*;

    public class Player
   {
   	//Fields
      Scanner input = new Scanner(System.in);
      private Stats stats;
      private Type type;
      private String gender;
      private String name;
      private boolean sufficientSleep;
      private Course[] schedule;
      private Study allocatedStudy;
      private int month;
   
   	//Constructor
       public Player(Stats stats, Type type, String gender, String name, boolean sufficientSleep, Course[] schedule, int month)
      {
         this.stats=stats;
         this.type=type;
         this.gender=gender;
         this.name=name;
         this.sufficientSleep=sufficientSleep;
         this.schedule=schedule;
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
         System.out.println("How would you like to spend your time after school from 3pm? (12 hours)");
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
               System.out.println("How much time do you want to spend studyin?");
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
            stats.happiness+=(int)sleep/3;
         else
            stats.happiness-=1;
      }
   	//Gets time for study and converts it into stats
       public void study(double time)
      {
      
      }
      //Gets time for social and converts it into stats
       public void social(double time)
      {
         if(time>3)
         {
            stats.socialChrisma+=time/2;
            stats.happiness+=time/3;
         }
      }
   }