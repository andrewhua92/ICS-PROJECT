import java.util.*;

public class Display {
	Scanner sc = new Scanner(System.in);
	String input;
	private Player character;
	private eventRunner events;
	final int COURSES = 4;
	int month = 0;
	//initialize constructor
	public Display (Player chara, eventRunner events) {
		character = chara;
		this.events = events;
	}
	
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
		System.out.println("Spend your time wisely!");
		//affects course selection and possible events
		character.setGrade(9);
		this.chooseCourses();
		//counts time for 40 months
		while(this.getMonth()<=40)
		{
			int counter = this.getMonth();
			//course selection after every term
			if(counter == 6) {
				System.out.println("First term already gone in a flash! Here's to seven more!");
				this.chooseCourses();
			}
			if (counter == 16) {
				System.out.println("You're getting the hang of this, almost at the halfway mark!");
				this.chooseCourses();
			}
			if (counter == 26) {
				System.out.println("You're pretty much an expert at this point, finish strong!");
				this.chooseCourses();
			}
			if(counter == 36) {
				System.out.println("Last semester! Make it count, the end is near.");
				this.chooseCourses();
			}
			//graduates to next grade, new events and classes to take
			if(counter == 11) {
				character.setGrade(10);
				System.out.println("First year already gone by! Welcome to your sophmore year.");
				this.chooseCourses();
			}
			if(counter == 21) {
				character.setGrade(11);
				System.out.println("Already Grade 11! Enjoy it while you can, the world is still your oyster.");
				this.chooseCourses();
			}
			if(counter == 31){
				character.setGrade(12);
				System.out.println("Final year! Just ten short months before you enter the real world.");
				this.chooseCourses();
			}
			//summarizes what happened the last month
			if(counter>1) {
				happiness = character.getHappiness();
				//Different response depending on their happiness level
				if(happiness>8) {
					System.out.println("You're happiness is through the roof! Here are the rest of yours stats.");
				}else if (happiness>4) {
					System.out.println("Life is fine, but it could also be better! Here are the results of last month.");
				}
				else {
					System.out.println("You've done enough, but at what cost? You've been depressed all month. Here are your stats.")
				}
				//prints out all stats for player to see that month
				System.out.print(character.stats);
				for (int i = 0; i< COURSES ; i++)
				{
					System.out.printf("Marks this month for %s: %f%n", character.schedule[i].getSubject(), character.schedule[i].getMark());
					System.out.printf("Mark for course overall:%f%n", character.schedule[i].getTotalMark());
				}
			}
			//player chooses how to allocate time
			System.out.print("Another month, another round of decisions. Pick how you would like to allocate your time this month.");
			character.spendTime();
			//initializes event per month
			events.rollEvent(counter);
			//increases month value after all course work and events are completed
			for(int i = 0 ; i<4 ; i++) {
				character.doTest(i);
			}
			this.addMonth();
			//Gives the player a pause
			System.out.println("The end of another month... (Press enter to continue)");
			input=sc.nextLine();
		}
		//initialize ending after all 40 months have passed
		this.startEnding();
	}
	
	//called from start game, sets gender and character type
	public void characterCreation()
	{
		String input;
		boolean valid = false;
		//Sets name and gender
		System.out.println("What is your name?");
		input = sc.nextLine();
		character.setName(input);
		System.out.print("What is your gender?");
		input=sc.nextLine();
		character.setGender(input);
		
		//selects Character type
		while (!valid) {
			System.out.println("What character class do you want to be? Input a number for each result.");
			System.out.println("Charmer: 1");
			System.out.println("Artist: 2");
			System.out.println("Jock: 3");
			System.out.println("Unspecialized: 4");
			System.out.println("Nerd: 5");
			input = sc.nextLine();
					 
			switch (input) {
			case 1:
				character.Type(Charmer);
				valid = true;
				break;
			case 2:
				character.Type(Artist);
				valid = true;
				break;
			case 3:
				character.Type(Jock);
				valid = true;
				break;
			case 4:
				character.Type(Unspecialized);
				valid = true;
				break;
			case 5:
				character.Type(Nerd);
				valid = true;
			default:
				System.out.print("Invalid input, please try again");
			}
		}
		
	}
	
	public void chooseCourses(){
		for (int i = 0 ; i <4 ; i++) {
			character.schedule[i].chooseCourse();
		}
	}
	//initialized once sufficient time has passed
	
	//TODO: Finish ending
	public void startEnding(){
		
	}
	
}
