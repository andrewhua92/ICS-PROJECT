import java.io.*;
import java.util.*;

public class Course
{
	// Variables
   private double currentMark = 100;
   private int courseMissed = 0;
   //private int courseLength;
   protected static int gradeLevel;
   private String subject;
   Evaluations[] list;
   private int numEval; 
   private double PASS = 50;
   private final int NUM_STATS = 6;
      
   private String boostStat;
 
   String[] selection = new String[NUM_STATS];
   String[] fileSelect ={"logicalIntelligenceCourses.txt","spatialIntelligenceCourses.txt","linguisticIntelligenceCourses.txt","expressionCharsimaCourses.txt","socialCharismaCourses.txt","strengthCourses.txt"};
   String[][] choices;
   
	// Constructors
   public Course (int grdLvl)
   {
      gradeLevel = grdLvl;
      try
      {
         BufferedReader in = new BufferedReader (new FileReader("statsList.txt"));
         for (int i =0; i < 6; i++)
         {
            selection[i] = in.readLine();
         }
         in.close();
      }
      catch(IOException iox)
      {
         System.out.println("Error in reading file.");
      }
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
   
   /*
   public int getCourseLength()
   {
      return courseLength;
   } 
   
   public void setCourseLength(int length)
   {
      courseLength = length;
   } */
   
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
   
   // Process to allow user to pick course
   public void chooseCourse()
   {
      int choose = 0;
      int course = 0;
      String[][] choices = new String[2][];
      Scanner sc = new Scanner(System.in);
      
      // Asks user to pick a class first based on stat
      System.out.println("Please enter the number for the specific types of class for a stat:");
      for (int i = 0; i < NUM_STATS; i++)
      {
         System.out.println((i+1)+" " +selection[i]);
      }
      do
      {
         try
         {
            choose=sc.nextInt();
         }
         catch(InputMismatchException imx)
         {
            System.out.println("Wrong input. Try again");
         }
         catch(NumberFormatException nfe)
         {
            System.out.println("Wrong input. Try again");
         }
      }while(!(choose >= 1 && choose <= 6));
      
      // Calls the method to allow this specific object to have a stat identity
      boostStatSelect(choose);
      
      // Based on user-selected stat, will read in courses for that specific stat
      try
      {
         BufferedReader in = new BufferedReader(new FileReader(selection[choose]));
         int jr = Integer.parseInt(in.readLine());
         for (int i = 0; i <jr; i++)
         {
            choices[0][i] = in.readLine();
         }
         int sr = Integer.parseInt(in.readLine());
         for (int i = 0; i < sr; i++)
         {
            choices[1][i] = in.readLine();
         }
      }
      catch(IOException iox)
      {
         System.out.println("Error in reading file.");
      }
      
      // Asks user to select which course they would like to pick
      System.out.println("Please enter a number for the specific course accordingly:");
   
      if (gradeLevel == 9 || gradeLevel == 10)
      {
         for (int i = 0; i < choices[0].length;i++)
         {
            System.out.println((i+1)+ " " + choices[0][i]);
         }
      }
      else
      {
         for (int i =0 ; i < choices[1].length;i++)
         {
            System.out.println((i+1)+" " + choices[1][i]);
         }
      }
       do
      {
         try
         {
            course=sc.nextInt();
         }
         catch(InputMismatchException imx)
         {
            System.out.println("Wrong input. Try again");
         }
         catch(NumberFormatException nfe)
         {
            System.out.println("Wrong input. Try again");
         }
      }while(!(course >= 1 && course <= 6));
      
      // Assigns this course object a name
      if (gradeLevel == 9 || gradeLevel == 10)
      {
         subject=choices[0][course];
      }   
      else
      {
         subject=choices[1][course];
      }
      
   }
   
   // Identifies this course with a specific stat 
   private void boostStatSelect (int num)
   {
      switch(num)
      {
         case 1:
            boostStat = "logicalIntelligence";
            break;
         case 2:
            boostStat = "spatialIntelligence";
            break;
         case 3:
            boostStat = "linguisticIntelligence";
            break;
         case 4:
            boostStat = "expressionCharisma";
            break;
         case 5:
            boostStat = "socialCharisma";
            break;
         case 6:
            boostStat = "strength";
            break;
      }
   }
}
