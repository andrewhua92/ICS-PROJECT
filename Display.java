import java.util.*;
import java.io.*;

public class Display {
   Scanner sc = new Scanner(System.in);
   private Player character;
   private EventRunner events;
   final int COURSES = 4;
   private int month = 0;
   private int num;
   private String gend;
   private String name;
   private String input;
   private Type type = new Type();

//accessor and mutator for months
   public int getMonth(){
      return month; 
   }

   public void addMonth(){
      month = month+1;
   }
//calls all methods
   public void startGame() {
   
      System.out.println("Welcome to AYJ Simulator!");
      this.characterCreation();
   //gives exposition and tips for playing game
      System.out.println("You will be playing through various situations, selecting courses at the beginning of every year.");
      System.out.println("Every month, you will select how much sleep, entertainment, and studying you will do.");
      System.out.println("You will also have a chance of encountering random events that can affect your stats.");
      System.out.println("The stats and what they affect are the following:");
      System.out.println("Logical Intelligence: How you think about things systematically, scientficially, and mathematically.\n Affects your ability in STEM related courses / events\n");
      System.out.println("Spatial Intelligence: How you think about your artistic expression and ability to transfer your visions into a medium.\n Affects your ability to perform in the visual arts.\n");
      System.out.println("Linguistic Intelligence: How you are able to be understand linguistic syntax and a measure of your literacy.\n Affects your ability to perform in language and humanities courses.\n");
      System.out.println("Expression Charisma: How you are able to control how you express yourself, with compelling vigor and confidence.\n Affects your ability to perform in expressionism and music courses.\n");
      System.out.println("Social Charisma: How you are able to control how you express yourself, with compelling vigor and confidence.\n Affects your ability to perform in socially related courses.\n");
      System.out.println("Strength: How you are able to show off your athleticism and brawn.\n Affects your ability to perform in physical activity courses.\n");
      System.out.println("Spend your time wisely!");
      System.out.println("");
   //affects course selection and possible events
   //creates player object where all of the information of the player is stored
      character = new Player (type.choose(num), type, gend, name, true, month);
   //events folder is loaded
      events = new EventRunner(character, "Events.txt" , "Endings.txt" );
   //character's grade is set to 9
      character.setGrade(9); 
   //asks users to pick their courses
      System.out.println("Time to choose your courses!");
      this.chooseCourses();
   //counts time for 40 months
      while(month<40)
      {
         int counter = this.getMonth();
      //course selection after every term
         if(counter%4 == 0 && counter!= 0){
            System.out.println("Exams are coming up! The semester is almost over. Finally.");
            System.out.println("");
         }
         if(counter == 5) {
            System.out.println("First term already gone in a flash! Here's to seven more!");
            this.chooseCourses();
         }
         if (counter == 15) {
            System.out.println("You're getting the hang of this, almost at the halfway mark!");
            this.chooseCourses();
         }
         if (counter == 25) {
            System.out.println("You're pretty much an expert at this point, finish strong!");
            this.chooseCourses();
         }
         if(counter == 35) {
            System.out.println("Last semester! Make it count - the end is near.");
            this.chooseCourses();
         }
      //graduates to next grade, new events and classes to take
         if(counter == 10) {
            character.setGrade(10);
            System.out.println("First year already gone by! Welcome to your sophmore year.");
            this.chooseCourses();
         }
         if(counter == 20) {
            character.setGrade(11);
            System.out.println("Already Grade 11! Enjoy it while you can, the world is still your oyster.");
            this.chooseCourses();
         }
         if(counter == 30){
            character.setGrade(12);
            System.out.println("Final year! Just ten short months before you enter the real world.");
            this.chooseCourses();
         }
            //player chooses how to allocate time
         System.out.println("Another month, another round of decisions. Pick how you would like to allocate your time this month.");
         character.spendTime();
      //initializes event per month
         events.rollEvent(counter);
      //increases month value after all course work and events are completed
         for(int i = 0 ; i< COURSES ; i++) {
            character.doTest(i, month);
         }
      
      //summarizes what happened the last month
         if(counter>-1) {
            int happiness = character.stats.getHappiness();
         //Different response depending on their happiness level
            if(happiness>8) {
               System.out.println("Your happiness is through the roof! Here are the rest of yours stats.");
            }
            else if (happiness>4) {
               System.out.println("Life is fine, but it could also be better! Here are the results of last month.");
            }
            else {
               System.out.println("You've done enough, but at what cost? You've been depressed all month. Here are your stats.");
            }
         //prints out all stats for player to see that month
            System.out.println("");
            System.out.println(character.stats);
            System.out.println("");
            for (int i = 0; i< COURSES ; i++)
            {
               System.out.printf("Marks this month for %s is : %.2f%% \n", character.schedule[i].list[((counter)%5)].getName(), character.schedule[i].list[((counter)%5)].getMark());
               System.out.printf("Mark for the %s course overall: %.2f%% \n\n",character.schedule[i].getSubject(), character.schedule[i].getCurrMark());
            }
            System.out.println("");
         }
         this.addMonth();
      //Gives the player a pause
         System.out.println("The end of another month... (Press enter to continue)");
         sc.nextLine();
         input = sc.nextLine();
         System.out.println("");
      }
   //initialize ending after all 40 months have passed
      this.startEnding();
   }

//called from start game, sets gender and character type
   public void characterCreation()
   {
      String input;
      String flush;
      boolean valid = false;
   //Sets name and gender
      do{
         try
         {
            System.out.println("What is your name?");
            System.out.print("Name: ");
            name = sc.nextLine();
            for (int i = 0; i < name.length() && !valid; i++)
            {
               if (name.charAt(i) != ' ')
               {
                  valid = true;
               }
            }
            if (!valid)
            {
               System.out.print("Invalid input. Try again. ");
            }
         }
         catch (InputMismatchException imx)
         {
            System.out.print("Invalid input. Try again. ");
         }
      }
      while(!valid);
      
      System.out.println("");
      
      valid = false;
   
      do{
         try
         {
            System.out.println("What is your gender?");
            System.out.print("Gender: ");
            gend = sc.nextLine();
            for (int i = 0; i < gend.length() && !valid; i++)
            {
               if (gend.charAt(i) != ' ')
               {
                  valid = true;
               }
            }
            if (!valid)
            {
               System.out.print("Invalid input. Try again. ");
            }
         }
         catch (InputMismatchException imx)
         {
            System.out.print("Invalid input. Try again. ");
         }
      }
      while(!valid);
      
      System.out.println("");
   
   //selects Character type
      System.out.println("What character class do you want to be? Input a number for each result.");
      System.out.println("Charmer: 1");
      System.out.println("Artist: 2");
      System.out.println("Jock: 3");
      System.out.println("Unspecialized: 4");
      System.out.println("Nerd: 5");
   
      do
      {
         try
         {  
            System.out.print("Character Class #: ");
            num = sc.nextInt();
            if (!(num>=1 && num <=5))
            {
               System.out.println("Incorrect input. Try again. What character class do you want to be? Input a number for each result.");
            }
         }
         catch (NumberFormatException nfx)
         {
            System.out.println("Incorrect input. Try again. What character class do you want to be? Input a number for each result.");
            flush = sc.next();
         }
         catch (InputMismatchException imx)
         {
            System.out.println("Incorrect input. Try again. What character class do you want to be? Input a number for each result.");
            flush = sc.next();
         }
      }
      while(!(num >= 1 && num <=5));
      
      System.out.println("");
      
      System.out.println("You have chosen : " + (type.getNames()[num-1]));
      
      System.out.println("");
   }

   public void chooseCourses(){
      character.courseSelection();
   }
//initialized once sufficient time has passed

//TODO: Finish ending
   public void startEnding(){
      events.rollEnding();
      
      System.out.println("The End. Thanks for playing the AYJ Simulator!");
   }
}
