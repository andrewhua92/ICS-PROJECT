    public class Study{
      private double hourStudy;
      private Course[] schedule;
      private double effectiveHours;
      private final static double MAXHOURS=2;
      
   	//Constructor
       public Study(double hourStudied ,Course[] sched,double effective){
         hourStudy=hoursStudied;
         schedule=sched;
         effectiveHours=effective;
      }
       public double getHoursStudy(){
         return hourStudy;
      }
       public void setHoursStudy(double hourStudied){
         hourStudy=hourStudied;
      }
       public Course[] getSchedule(){
         return schedule;
      }
       public void setSchedule(Course[] newSched){
         schedule=newSched;
      }
       public double getEffectiveHours(){
         return effectiveHours;
      }
       public void setEffectiveHours(double effective){
         effectiveHours=effective;
      }
       public void resetInfo(){
         effectiveHours=0;
      }
      
   	//recursive method to calculate effective hours
       public void effectiveCalculator(double hour,double effectiveness,boolean firstTime,double hourDecrease){
      //Adds in the max hours at 100% efficiency
         if(firstTime==true){    
            if (hourStudy<=MAXHOURS){
               effectiveHour+=hour;
            }
            else{
               effectiveHours+=MAXHOURS;
               effectiveCalculator(hour-MAXHOURS,effectiveness*0.9,false,hourDecrease);
            }
         }
         //Recursion part of code that decreases effectiveness and adds effective hours
         else if(hour>0){
            effectiveHours+=hourDecrease*effectiveness;
            effectiveCalculator(hour-hourDecrease,effectiveness*0.9,false,hourDecrease+2);
          
         }
      }
   }
