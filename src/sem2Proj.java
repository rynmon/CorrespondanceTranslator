package sem2ProjectFINAL;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sem2Proj {
 
	final static int MAX = 100;
    static Scanner input = new Scanner(System.in);
    
        public static void main(String[] args){
                // TODO Auto-generated method stub
                Scanner input = new Scanner(System.in);
                int menuOption;
                String[] acronyms = new String[MAX];
                String[] translation = new String[MAX];
                String position = " ";
                String finalOutput = " ";
                String userInput = " ";
      
          System.out.println("Welcome to my correspondance translator!");
          System.out.println();        		
          System.out.println("Please login:");    
          System.out.println("1. General User.\n2. Admin.");
          menuOption=input.nextInt();
        	  

                int adminMenuOption = 0;
				if (menuOption==1)
                {
                        int genUserMenuOption = 0;
                      
                       
                        System.out.println();
                                System.out.println("You have been logged in a general user."
                                +"\n\n----------------------------MENU----------------------------"
                                +"\n1. Input the piece of correspondance you would to translate."
                                +"\n2. Input a file name to a piece of correspondance."
                                +"\n3. View correspondance translation statistics."
                                +"\n------------------------------------------------------------");
                                genUserMenuOption=input.nextInt();
                               
                                if (genUserMenuOption==1)
                                                {
                                                        getUserCorrespondance(position, finalOutput, acronyms, translation, userInput);
                                                }
                               
                                        else if (genUserMenuOption==2)
                                                {
                                        			getUserCorrFile(userInput, finalOutput, acronyms, translation);
                                                }
                               
                                        else if (genUserMenuOption==3)
                                                {
                                        				
                                                }
                               
                                
                                else
                                {
                                        System.out.println("Error, please enter a correct menu option.");
                                }
                               
                                
                
                }
                
                else if (menuOption==2)
                {
                        int adminMenuOption1 = 0;
                   
                       
                       
                        System.out.println();
                                System.out.println("You have been logged in as as an administrator."
                                +"\n\n-------------------------ADMIN MENU-------------------------"
                                +"\n1. View all acronyms."
                                +"\n2. Add an acronym."
                                +"\n3. Edit an existing acronym."
                                +"\n4. Delete an existing acronym."
                                +"\n5. View correspondance translation statistics."
                                +"\n------------------------------------------------------------");
                                adminMenuOption1=input.nextInt();
                               
                               
                                if (adminMenuOption1==1)
                                {
                                        
                                }
               
                                        else if (adminMenuOption1==2)
                                                {
                                                        
                                                }
                               
                                        else if (adminMenuOption1==3)
                                                {
                                        	System.out.println("Enter the acronym you would like to edit:?");
                                            
                                            String acronymToEdit=input.nextLine();
                                            int positionToEdit=-1;
                                            for (int counter=0;counter<MAX;counter++)
                                            {
                                                    if (acronymToEdit.equalsIgnoreCase(acronyms[counter]))
                                                    {
                                                            positionToEdit=counter;
                                                    }
                                            }
                                            System.out.println("The current acronym is as follows: " + acronyms[positionToEdit]
                                            + "." + "What would you like to change it to?");
                                            String newAcronymName=input.next();
                                           
                                            System.out.println("That acronyms' current translation is " + translation[positionToEdit]
                                            		+ "." + "What would you like to change the translation to?");
                                            String newTranslation=input.nextLine();
                                           
                                            acronyms[positionToEdit]=newAcronymName;
                                            translation[positionToEdit]=newTranslation;   
                                                }
                                               
                                        else if (adminMenuOption1==4)
                                                {
                                        	System.out.println("Please enter the acronym you'd like to delete:");
                                            
                                            String acranymToBeDeleted=input.nextLine();
                                            int indexToDelete=-1;
                                            for (int counter=0;counter<MAX;counter++)
                                            {
                                                    if (acranymToBeDeleted.equalsIgnoreCase(acronyms[counter]))
                                                    {
                                                    	indexToDelete=counter;
                                                    }
                                            }
                                            acronyms[indexToDelete]="empty";
                                            translation[indexToDelete]="empty";
                                            }     
                                        	
                                                }
                                               
                                        else if (adminMenuOption==5)
                                                {
                                        	
                                                }
           
                }
                
        private static void getUserCorrFile(String userInput,
				String finalOutput, String[] acronyms, String[] translation) {
			// TODO Auto-generated method stub
			
		}

		public static void getAcro(String[] acronyms, String[] translation, int[] stats) throws IOException {
            File file = new File("acroLib.txt");
            Scanner inputFile = new Scanner(file);
            int counter = 1;
            int counter1 = 0;
           
            while(counter1 < MAX)
            {
                    if(counter == 1)
                    {
                            acronyms[counter1] = inputFile.nextLine();
                            counter++;
                    }
                    if(counter == 2)
                    {
                            translation[counter1] = inputFile.nextLine();
                            counter++;
                    }
                    if(counter == 3)
                    {
                            stats[counter1] = inputFile.nextInt();
                            inputFile.nextLine();
                            counter = 1;
                            counter1++;    
                    }
            }
            inputFile.close();
            }

        public static String getFile(String fileName) throws IOException {
            System.out.println("------------------------------------------------------------"
                            + "\n\nPlease enter the name of the correnpondance file: "
                            + "\n------------------------------------------------------------");
            fileName = input.nextLine();
            File file = new File(fileName);
            Scanner inputFile = new Scanner(file);
            String line = " ";
            while (inputFile.hasNext()) {
                    line = inputFile.nextLine();
            }

            inputFile.close();
           
            return line;
    }

        public static int findAccro(String userInput, String[] acronyms) {
            int index = 0;
            int foundIndex = -1;

            while (index < MAX) {
                    if (userInput.equalsIgnoreCase(acronyms[index])) {
                    	foundIndex = index;
                    }
                    index++;
            }

            return foundIndex;
            }

        public static String translationOfAccro(String line, String[] acronyms,
                    String[] acromeaning, String userInput) {
            String translationOfAccro = " ";
            StringTokenizer st = new StringTokenizer(line, " ");
            while (st.hasMoreTokens()) {
            	userInput = st.nextToken();
                    int pos = findAccro(userInput, acronyms);

                    if (pos == -1) {
                    	translationOfAccro = translationOfAccro + userInput + " ";
                    } else {
                    	translationOfAccro = translationOfAccro + acromeaning[pos] + " ";
                    }

            }

            return translationOfAccro;
    }

        public static void getUserCorrespondance(String line, String finalOutput,
                    String[] acronyms, String[] translation, String userInput) {
            System.out.println("Please enter the piece of correspondance you'd like to translate:");
            
            line = input.nextLine();
            
            finalOutput = translationOfAccro(line, acronyms, translation, userInput);
            System.out.println(finalOutput);
            }
    }