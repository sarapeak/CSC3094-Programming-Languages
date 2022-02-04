import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interpreter
{
   private String program = "";
   private HashMap<String, String> map = new HashMap<>();
   private ArrayList<String[]> arrayL = new ArrayList<>();
   private String[] arrayS;
   private String var1 = "";
   private String var2 = "";
   private String var3 = "";
   private Panel panel;
   private IImage image;
   int checker = 0;
   
   public Interpreter()   //Constructor   -In Panel does not take in anything-
   { }
   
   public void load(String filename)   //-Takes in a string (file)-
   {
      //Going to try and get the file, if the file does not exists it will tell the user
      try
      {
         //Scans contents of a file
         Scanner scan = new Scanner(new File(filename));
         //Loops through the file until nothing is left
         while(scan.hasNext())
         {
            program = scan.next();   //Takes in the label
            //A switch statement for each of the possible functions
            switch (program)
            {
               //Sets the color of a pixel
               case "setpixel":
                  arrayS = new String[4];   //Creates a new array
                  arrayS[0] = program;      //Adds the name to the program string
                  //Scans the appropriate amount for the command
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();   //Adds to the array
                  }
                  arrayL.add(arrayS);   //The array is added to the arraylist
                  //Same sequence above for the rest of the commands below
                  break;
               //Gets a pixel color
               case "getpixel":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //Get current time
               case "time":
                  arrayS = new String[2];
                  arrayS[0] = program;
                  for(int i = 1; i < 2; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //An integer
               case "int":
                  arrayS = new String[2];
                  arrayS[0] = program;
                  for(int i = 1; i < 2; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
                //A boolean
               case "bool":
                  arrayS = new String[2];
                  arrayS[0] = program;
                  for(int i = 1; i < 2; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //A plus sign to add
               case "+":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //A minus sign to subtract
               case "-":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //A multiply sign to multiply
               case "*":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //A divide sign to divide
               case "/":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //A modulus sign to modulify
               case "%":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //Used to see if things are equal to each other
               case "==":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //Sees if something is greater than another thing
               case ">":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //Sees if something is greater than or equal to another thing
               case ">=":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //For both booleans and ints Ampersand = and (if both true = true, if one false = false, if both false = false)
               case "&":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
                //For both booleans and ints Line = or (only false if both are false)
               case "|":
                  arrayS = new String[4];
                  arrayS[0] = program;
                  for(int i = 1; i < 4; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //Set something to something
               case "=":
                  arrayS = new String[3];
                  arrayS[0] = program;
                  for(int i = 1; i < 3; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //Moves to label
               case "jump":
                  arrayS = new String[2];
                  arrayS[0] = program;
                  for(int i = 1; i < 2; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //Defines where label is located
               case "label":
                  arrayS = new String[2];
                  arrayS[0] = program;
                  for(int i = 1; i < 2; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  map.put(arrayS[1], Integer.toString(checker));   //Adds the label and its position to the map
                  arrayL.add(arrayS);
                  break;
               //Jumps if condition is true
               case "jumpif":
                  arrayS = new String[3];
                  arrayS[0] = program;
                  for(int i = 1; i < 3; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
               //Outputs stuff to debug program
               case "print":
                  arrayS = new String[2];
                  arrayS[0] = program;
                  for(int i = 1; i < 2; i++)
                  {
                     arrayS[i] = scan.next();
                  }
                  arrayL.add(arrayS);
                  break;
            }
            program = "";//Resets program
            checker++;   //Adds one to checker
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
   }
   
   public String printProgram()   //-Does not take anything-
   {
      //Loops through the arraylist
      for(int a = 0; a < arrayL.size(); a++)
      {
         arrayS = arrayL.get(a);   //Sets the array to the arry in the arraylist
         //Loops through the array
         for(int b = 0; b < arrayS.length; b++)
         {
            System.out.print(arrayS[b]+" ");  //Prints out the items in the array
         }
         System.out.println();
      }
      return program;
   }
   
   public void run()   //-Does not take in anything-
   {
      int resultInt = 0;
      boolean resultBool = false;
      //Loops through the arraylist
      for(int z = 0; z < arrayL.size(); z++)
      {
         arrayS = arrayL.get(z);   //Sets the array from the array in the arraylist
         //Cases for the different actions
         switch(arrayS[0])
         {
            case "setpixel":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               
               image = panel.getImage();
               
               //If the map has all of the variables
               if(map.containsKey(var1) && map.containsKey(var2) && map.containsKey(var3))
               {
                  //Sets the color on the image
                  image.setColor(Integer.parseInt(map.get(var1)), Integer.parseInt(map.get(var2)), Integer.parseInt(map.get(var3)));
               }
               //If the map has only two of the variables (var1 and var2)
               else if(map.containsKey(var1) && map.containsKey(var2))
               {
                  image.setColor(Integer.parseInt(map.get(var1)), Integer.parseInt(map.get(var2)), Integer.parseInt(var3));
               }
               //If the map has two of the variables (var1 and var3)
               else if(map.containsKey(var1) && map.containsKey(var3))
               {
                  image.setColor(Integer.parseInt(map.get(var1)), Integer.parseInt(var2), Integer.parseInt(map.get(var3)));
               }
               //If the map has two of the variables (var2 and var3)
               else if(map.containsKey(var2) && map.containsKey(var3))
               {
                  image.setColor(Integer.parseInt(var1), Integer.parseInt(map.get(var2)), Integer.parseInt(map.get(var3)));
               }
               //If the map only contains var1
               else if(map.containsKey(var1))
               {
                  image.setColor(Integer.parseInt(map.get(var1)), Integer.parseInt(var2), Integer.parseInt(var3));
               }
               //If the map only contains var2
               else if(map.containsKey(var2))
               {
                  image.setColor(Integer.parseInt(var1), Integer.parseInt(map.get(var2)), Integer.parseInt(var3));
               }
               //If the map only contains var3
               else if(map.containsKey(var3))
               {
                  image.setColor(Integer.parseInt(var1), Integer.parseInt(var2), Integer.parseInt(map.get(var3)));
               }
               //If the map does not contain any of the variables
               else
               {
                  image.setColor(Integer.parseInt(var1), Integer.parseInt(var2), Integer.parseInt(var3));
               }
               break;
            case "getpixel":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               
               int getC = 0;
               image = panel.getImage();
               
               //If the map contains both of the variables (var2 and var3)
               if(map.containsKey(var2) && map.containsKey(var3))
               {
                  getC = image.getColor(Integer.parseInt(map.get(var2)), Integer.parseInt(map.get(var3)));
               }
               //If the map contains only var2
               else if(map.containsKey(var2))
               {
                  getC = image.getColor(Integer.parseInt(map.get(var2)), Integer.parseInt(var3));
               }
               //If the map contains only var3
               else if(map.containsKey(var3))
               {
                  getC = image.getColor(Integer.parseInt(var2), Integer.parseInt(map.get(var3)));
               }   
               //If the map does not contain any of the variables              
               else
               {
                  getC = image.getColor(Integer.parseInt(var2), Integer.parseInt(var3));
               }
               //If the map does contain the key
               if(map.containsKey(var1))
               {
                  map.replace(var1, Integer.toString(getC));   //Replaces it
               }
               //If the map does not contain the key
               else
               {
                  map.put(var1, Integer.toString(getC));   //Puts it in the map
               }
               break;
            case "time":
               //Gets the time in milliseconds and typecasts it to an int
                  //Found here: https://stackoverflow.com/questions/8244340/current-milliseconds-from-long-to-int
               int tInMil = (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
               if(map.containsKey(arrayS[1]))
               {
                  map.replace(arrayS[1], Integer.toString(tInMil));
               }
               else
               {
                  map.put(arrayS[1], Integer.toString(tInMil));   //Puts the time into the map
               }
               break;
            case "int":
               if(map.containsKey(arrayS[1]))
               {
                  map.replace(arrayS[1], "0");
               }
               else
               {
                  map.put(arrayS[1], "0");   //Puts the variable int the map and sets the value to 0
               }
               break;
            case "bool":
               if(map.containsKey(arrayS[1]))
               {
                  map.replace(arrayS[1], "false");
               }
               else
               {
                  map.put(arrayS[1], "false");   //Puts the variable in the map and sets the value to false
               }
               break;
            case "+":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               //If the map contains the key integer in both positions 2 and 3
                  //Use those key values and add them together
               if(map.containsKey(var2) && map.containsKey(var3))
               {
                  resultInt = Integer.parseInt(map.get(var2)) + Integer.parseInt(map.get(var3));
               }
               //If the map contains the key integer at position 2
                  //Use the value of the key and add it to the third position
               else if(map.containsKey(var2))
               {
                  resultInt = Integer.parseInt(map.get(var2)) + Integer.parseInt(var3);
               }
               //If the map contains the key integer at position 3
                  //Use the value of the key and add it to the second position
               else if(map.containsKey(var3))
               {
                  resultInt = Integer.parseInt(var2) + Integer.parseInt(map.get(var3));
               }                 
               //If the map does not have those keys
                  //Hope that they are integers and add them
               else
               {
                  resultInt = Integer.parseInt(var2) + Integer.parseInt(var3);
               }
               //If the end result is a key in the map
                  //Replace the value with the new result
               if(map.containsKey(var1))
               {
                  map.replace(var1, Integer.toString(resultInt));
               }
               //If the end result is not a key value in the map
                  //Create a new key and store the new result
               else
               {
                  map.put(var1, Integer.toString(resultInt));
               }
               break;
            case "-":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               
               //When the map contains both of the variables
               if(map.containsKey(var2) && map.containsKey(var3))
               {
                  resultInt = Integer.parseInt(map.get(var2)) - Integer.parseInt(map.get(var3));
               }
               //When the map contains one variable (var2)
               else if(map.containsKey(var2))
               {
                  resultInt = Integer.parseInt(map.get(var2)) - Integer.parseInt(var3);
               }
               //When the map contains one variable (var3)
               else if(map.containsKey(var3))
               {
                  resultInt = Integer.parseInt(var2) - Integer.parseInt(map.get(var3));
               }
               //When the map contains none of the variables
               else
               {
                  resultInt = Integer.parseInt(var2) - Integer.parseInt(var3);
               }
               //If the map has the variable
               if(map.containsKey(var1))
               {
                  map.replace(var1, Integer.toString(resultInt));   //Replaces it
               }
               //If the map does not have the variable
               else
               {
                  map.put(var1, Integer.toString(resultInt));   //Adds it to the map
               }
               break;
            case "*":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               
               //When the map contains both of the variables
               if(map.containsKey(var2) && map.containsKey(var3))
               {
                  resultInt = Integer.parseInt(map.get(var2)) * Integer.parseInt(map.get(var3));
               }
               //When the map contains one variable (var2)
               else if(map.containsKey(var2))
               {
                  resultInt = Integer.parseInt(map.get(var2)) * Integer.parseInt(var3);
               }
               //When the map contains one variable (var3)
               else if(map.containsKey(var3))
               {
                  resultInt = Integer.parseInt(var2) * Integer.parseInt(map.get(var3));
               }
               //When the map does not contain any of the variables
               else
               {
                  resultInt = Integer.parseInt(var2) * Integer.parseInt(var3);
               }
               //If the map has the variable
               if(map.containsKey(var1))
               {
                  map.replace(var1, Integer.toString(resultInt));   //Replaces the value
               }
               //If the map does not have the variable
               else
               {
                  map.put(var1, Integer.toString(resultInt));   //Adds to the map
               }
               break;
            case "/":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               //If the map contains both the variables
               if(map.containsKey(var2) && map.containsKey(var3))
               {
                  resultInt = Integer.parseInt(map.get(var2)) / Integer.parseInt(map.get(var3));
               }
               //When the map contains only one variable
               else if(map.containsKey(var2))
               {
                  resultInt = Integer.parseInt(map.get(var2)) / Integer.parseInt(var3);
               }
               //When the map contains only one variable
               else if(map.containsKey(var3))
               {
                  resultInt = Integer.parseInt(var2) / Integer.parseInt(map.get(var3));
               }
               //When the map does not contain any of the variables
               else
               {
                  resultInt = Integer.parseInt(var2) / Integer.parseInt(var3);
               }
               //If the map has the variable, it will replace it, otherwise, it will add it
               if(map.containsKey(var1))
               {
                  map.replace(var1, Integer.toString(resultInt));
               }
               else
               {
                  map.put(var1, Integer.toString(resultInt));
               }
               break;
            case "%":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               //When the map contains both the variables
               if(map.containsKey(var2) && map.containsKey(var3))
               {
                  resultInt = Integer.parseInt(map.get(var2)) % Integer.parseInt(map.get(var3));
               }
               //When the map contains only one variable
               else if(map.containsKey(var2))
               {
                  resultInt = Integer.parseInt(map.get(var2)) % Integer.parseInt(var3);
               }
               //When the map contains only one variable
               else if(map.containsKey(var3))
               {
                  resultInt = Integer.parseInt(var2) % Integer.parseInt(map.get(var3));
               } 
               //When the map contains none of the variables                
               else
               {
                  resultInt = Integer.parseInt(var2) % Integer.parseInt(var3);
               }
               //If the map has the variable, it will replace it, otherwise, it will add it
               if(map.containsKey(var1))
               {
                  map.replace(var1, Integer.toString(resultInt));
               }
               else
               {
                  map.put(var1, Integer.toString(resultInt));
               }
               break;
            case "==":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               //If the variables are booleans
               if((map.containsKey(var2) && (map.get(var2).equals("true") || map.get(var2).equals("false"))) || (map.containsKey(var3) && (map.get(var3).equals("true") || map.get(var3).equals("false"))))
               {
                  //When the map contains both the variables
                  if(map.containsKey(var2) && map.containsKey(var3))
                  {
                     resultBool = Boolean.parseBoolean(map.get(var2)) == Boolean.parseBoolean(map.get(var3));
                  }
                  //When the map contains one variable
                  else if(map.containsKey(var2))
                  {
                     resultBool = Boolean.parseBoolean(map.get(var2)) == Boolean.parseBoolean(var3);
                  }
                  //When the map contains one variable
                  else if(map.containsKey(var3))
                  {
                     resultBool = Boolean.parseBoolean(var2) == Boolean.parseBoolean(map.get(var3));
                  } 
                  //When the map does not have any of the variables                
                  else
                  {
                     resultBool = Boolean.parseBoolean(var2) == Boolean.parseBoolean(var3);
                  }
                  map.replace(var1, Boolean.toString(resultBool));
               }
               //If the variables are integers
               else
               {
                  //When the map contains both the variables
                  if(map.containsKey(var2) && map.containsKey(var3))
                  {
                     resultBool = Integer.parseInt(map.get(var2)) == Integer.parseInt(map.get(var3));
                  }
                  //When the map contains one variable
                  else if(map.containsKey(var2))
                  {
                     resultBool = Integer.parseInt(map.get(var2)) == Integer.parseInt(var3);
                  }
                  //When the map contains one variable
                  else if(map.containsKey(var3))
                  {
                     resultBool = Integer.parseInt(var2) == Integer.parseInt(map.get(var3));
                  } 
                  //When the map does not have any of the variables                
                  else
                  {
                     resultBool = Integer.parseInt(var2) == Integer.parseInt(var3);
                  }
                  map.replace(var1, Boolean.toString(resultBool));
               }
               break;
            case ">":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               //If the map contains both of the variables
               if(map.containsKey(var2) && map.containsKey(var3))
               {
                  resultBool = Integer.parseInt(map.get(var2)) > Integer.parseInt(map.get(var3));
               }
               //When the map has one of the variables (var2)
               else if(map.containsKey(var2))
               {
                  resultBool = Integer.parseInt(map.get(var2)) > Integer.parseInt(var3);
               }
               //When the map has one of the variables (var3)
               else if(map.containsKey(var3))
               {
                  resultBool = Integer.parseInt(var2) > Integer.parseInt(map.get(var3));
               } 
               //When the map has none of the variables                
               else
               {
                  resultBool = Integer.parseInt(var2) > Integer.parseInt(var3);
               }
               //If the map has the variable, it will replace it, otherwise, it will add it
               if(map.containsKey(var1))
               {
                  map.replace(var1, Boolean.toString(resultBool));
               }
               else
               {
                  map.put(var1, Boolean.toString(resultBool));
               }
               break;
            case ">=":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               //When the map has both of the variables
               if(map.containsKey(var2) && map.containsKey(var3))
               {
                  resultBool = Integer.parseInt(map.get(var2)) >= Integer.parseInt(map.get(var3));
               }
               //When the map has one variable (var2)
               else if(map.containsKey(var2))
               {
                  resultBool = Integer.parseInt(map.get(var2)) >= Integer.parseInt(var3);
               }
               //When the map has one variable (var3)
               else if(map.containsKey(var3))
               {
                  resultBool = Integer.parseInt(var2) >= Integer.parseInt(map.get(var3));
               }  
               //When the map has none of the variables               
               else
               {
                  resultBool = Integer.parseInt(var2) >= Integer.parseInt(var3);
               }
               //If the map has the variable, it will replace it, otherwise, it will add it
               if(map.containsKey(var1))
               {
                  map.replace(var1, Boolean.toString(resultBool));
               }
               else
               {
                  map.put(var1, Boolean.toString(resultBool));   //Replaces the variable with the new value
               }
               break;
            case "&":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               //Checks to see if the map has the variables and if they are booleans
               if((map.containsKey(var2) && (map.get(var2).equals("true") || map.get(var2).equals("false"))) || (map.containsKey(var3) && (map.get(var3).equals("true") || map.get(var3).equals("false"))))
               {
                  //When the map has both of the variables
                  if(map.containsKey(var2) && map.containsKey(var3))
                  {
                     resultBool = Boolean.parseBoolean(map.get(var2)) & Boolean.parseBoolean(map.get(var3));
                  }
                  //When the map has only one of the variables (var2)
                  else if(map.containsKey(var2))
                  {
                     resultBool = Boolean.parseBoolean(map.get(var2)) & Boolean.parseBoolean(var3);
                  }
                  //When the map has one of the variables (var3)
                  else if(map.containsKey(var3))
                  {
                     resultBool = Boolean.parseBoolean(var2) & Boolean.parseBoolean(map.get(var3));
                  } 
                  //When the map has none of the variables                
                  else
                  {
                     resultBool = Boolean.parseBoolean(var2) & Boolean.parseBoolean(var3);
                  }
                  map.replace(var1, Boolean.toString(resultBool));   //Replaces the variables with the new value
               }
               //If the variables are integers
               else
               {
                  //When the map contains both of the variables
                  if(map.containsKey(var2) && map.containsKey(var3))
                  {
                     resultInt = Integer.parseInt(map.get(var2)) & Integer.parseInt(map.get(var3));
                  }
                  //When the map contains one variable (var2)
                  else if(map.containsKey(var2))
                  {
                     resultInt = Integer.parseInt(map.get(var2)) & Integer.parseInt(var3);
                  }
                  //When the map contains one variable (var3)
                  else if(map.containsKey(var3))
                  {
                     resultInt = Integer.parseInt(var2) & Integer.parseInt(map.get(var3));
                  } 
                  //WHen the map contains none of the variables                
                  else
                  {
                     resultInt = Integer.parseInt(var2) & Integer.parseInt(var3);
                  }
                  map.replace(var1, Integer.toString(resultInt));   //Replaces it with the new value
               }
               break;
            case "|":
               var1 = arrayS[1];
               var2 = arrayS[2];
               var3 = arrayS[3];
               //If the map contains the variables and they are booleans
               if((map.containsKey(var2) && (map.get(var2).equals("true") || map.get(var2).equals("false"))) || (map.containsKey(var3) && (map.get(var3).equals("true") || map.get(var3).equals("false"))))
               {
                  //When the map has both variables
                  if(map.containsKey(var2) && map.containsKey(var3))
                  {
                     resultBool = Boolean.parseBoolean(map.get(var2)) | Boolean.parseBoolean(map.get(var3));
                  }
                  //When the map has one variable (var2)
                  else if(map.containsKey(var2))
                  {
                     resultBool = Boolean.parseBoolean(map.get(var2)) | Boolean.parseBoolean(var3);
                  }
                  //When the map has one variable (var3)
                  else if(map.containsKey(var3))
                  {
                     resultBool = Boolean.parseBoolean(var2) | Boolean.parseBoolean(map.get(var3));
                  }  
                  //When the map has none of the variables            
                  else
                  {
                     resultBool = Boolean.parseBoolean(var2) | Boolean.parseBoolean(var3);
                  }
                  map.replace(var1, Boolean.toString(resultBool));   //Replaces the value
               }
               //If the variables are integers
               else
               {
                  //When the map has both variables
                  if(map.containsKey(var2) && map.containsKey(var3))
                  {
                     resultInt = Integer.parseInt(map.get(var2)) | Integer.parseInt(map.get(var3));
                  }
                  //When the map has one variable (var2)
                  else if(map.containsKey(var2))
                  {
                     resultInt = Integer.parseInt(map.get(var2)) | Integer.parseInt(var3);
                  }
                  //When the map has one variable (var3)
                  else if(map.containsKey(var3))
                  {
                     resultInt = Integer.parseInt(var2) | Integer.parseInt(map.get(var3));
                  }  
                  //When the map has none of the variables               
                  else
                  {
                     resultInt = Integer.parseInt(var2) | Integer.parseInt(var3);
                  }
                  map.replace(var1, Integer.toString(resultInt));   //Replaces the value
               }
               break;
            case "=":
               String var1 = arrayS[1];   //Gets the name of the variable
               String var2 = arrayS[2];
               //If the map has it already, it will replace the value
               if(map.containsKey(var1) && map.containsKey(var2))
               {
                  map.replace(var1, map.get(var2));
               }
               //If it only contains var1, it will replace the value
               else if(map.containsKey(var1))
               {
                  map.replace(var1, var2);
               }
               //If it does not, it will add it to the map
               else
               {
                  map.put(var1, var2);
               }
               break;
            case "jump":
               var1 = arrayS[1];
               //If the map contains the label name it will go back to the label
               if(map.containsKey(var1))
               {
                  z = Integer.parseInt(map.get(var1));
               }
               break;
            case "label":
               //Gets taken care of in the load
               break;
            case "jumpif":
               var1 = arrayS[1];
               var2 = arrayS[2];
               //If the condition passed in is true
               if(Boolean.parseBoolean(map.get(var1)) == true)
               {
                  z = Integer.parseInt(map.get(var2));
               }
               break;
            case "print":
               System.out.println(map.get(arrayS[1]));   //Prints out the value
               break;
         }
      }
   }
}
