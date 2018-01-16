   import java.io.*;  
	
    public class Type{
      private Stats[] stats;
      private String[] names;
      private int[] id;
       public Stats[] getStats(){
         return stats;
      }	
       public void setStats(Stats[] stats1){
         stats=stats1;
      }
       public String[] getNames(){
         return names;
      }
       public void setNames(String[] names1){
         names=names1;
      }
       public int[] getId(){
         return id;
      }
       public void setId(int[] ids){
         id=ids;
      }
       public Type(){
      
         try{
            BufferedReader in=new BufferedReader(new FileReader("Type.txt"));
            stats=new Stats[Integer.parseInt(in.readLine())];
            names=new String[stats.length];
            id=new int[stats.length];
            //Reads in the names Id and Stats from a text file.
            for(int i=0;i<stats.length;i++){
               names[i]=in.readLine();
               id[i]=Integer.parseInt(in.readLine());
               stats[i]=new Stats(Integer.parseInt(in.readLine()),Integer.parseInt(in.readLine()),Integer.parseInt(in.readLine()),Integer.parseInt(in.readLine()),Integer.parseInt(in.readLine()),(int)(Math.random()*10)+1,Integer.parseInt(in.readLine()),Integer.parseInt(in.readLine()));
            }
            in.close();
         }
             catch(IOException iox){
               System.out.println("Error in reading file.");  
            }
            
      }
      
   	public Stats choose(int identity) {
   	return stats[identity];
   	}
   	}
