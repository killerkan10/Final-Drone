
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

   
class Drone{ 

    static void finalPosition() throws IOException 
    { 
        String st;
        String right = "R";
        String left = "L";
        
        String plus = "+";
        String minus = "-";
        
        int bearing = 1;
        int bearingHolder = 1;
        int longitude = 0;
        int latitude =0;
        
         Map<String, Integer> Direction = new HashMap<>();    
                          
            Direction.put("N", 1);
            Direction.put("E", 2);
            Direction.put("S", 3);
            Direction.put("W", 4);
        
        //reading in input file
        File file = new File("C:\\Users\\adam.evans\\Documents\\NetBeansProjects\\Drone\\src\\problem-basic-input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        //looping through input file and applying to string st
        while ((st = br.readLine()) != null){
        
        //splitting string into array
        String[] splitArray = st.split("");
        
        for (int i = 0; i <= splitArray.length - 1; i++) { 
            
            //setting direction of drone 1 being north 4 being west
            if(bearing == 0){
                bearing = 4;
                bearingHolder = bearing;
            }else if(bearing == 5){
                bearing = 1;
                bearingHolder = bearing;
            } 
             
            // arraylist to check if array posisiton i is in hashmap
            if( Arrays.asList("N","E","S","W").contains(splitArray[i]) ){
                
            //set baring to cardinal direction 
            bearingHolder = bearing;
            bearing = Direction.get(splitArray[i]);
            }

            //allows drone to turn right or left 90 degrees  by adding or minus 1 to bearing
            if (splitArray[i].equals(right)){
                bearing = bearingHolder;          
                bearing++; 
                bearingHolder = bearing;      
            }else if(splitArray[i].equals(left)){
                bearing = bearingHolder;           
                bearing--;
                bearingHolder = bearing;          
            
                  
            //allows drone to move fowards or backwards depending on the drones facing direction
            }else if(splitArray[i].equals(plus) && bearing == 1 || splitArray[i].equals(minus) && bearing == 3){
                longitude++; 
                
            } else if(splitArray[i].equals(plus) && bearing == 2  || splitArray[i].equals(minus) && bearing == 4){
                latitude++; 

            } 
            else if(splitArray[i].equals(plus) && bearing == 3 || splitArray[i].equals(minus) && bearing == 1){
                longitude--; 
                
            } else if(splitArray[i].equals(plus) && bearing == 4 || splitArray[i].equals(minus) && bearing == 2){
                latitude--;             
            }        
                                                   
        }
        System.out.printf("The final coordinates are (%s,%s)\n",latitude,longitude);
          
       }
    }
  

    public static void main(String[] args) throws IOException 
    { 

        finalPosition(); 
        
        
    } 
} 
