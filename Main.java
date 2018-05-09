import java.util.Random;

public class Main extends Frame{
/**
 * @author Damian Mietus
 * 	Completed May 9 2018
 *  Reddit Daily Programmer 
 *  Challenge #340 [Intermediate] Walk in a Minefield
 */
	static String usIn = new String();
	

@SuppressWarnings("static-access")
public static void main(String[] args) {
		
	Frame frame = new Frame();
	frame.getFrame().setVisible(true);
	int runVal = 0;
	int getInput = 0;
	int result = 0;
	int simulation = 1;
	char[][] array = new char[13][13];
	
		
    while (simulation == 1) {
    	result = 0;
        runVal = frame.runFunc;
        getInput = frame.inpFunc;
        System.out.print("");//Text display has buffering problems
	    if (runVal == 1) {
            array = generateMap();
            getInput = 0;
            while (getInput == 0) {
                System.out.print("");
                getInput = frame.inpFunc;
            	if (frame.inpFunc == 1) {
            	    getInput = 1;
            	    frame.inpFunc = 0;           	    
            	}
            }
            usIn = frame.inputField.getText();
            usIn = usIn.toUpperCase();
            result = checkUserInput(array, usIn, frame);           
            frame.resultMsg(result);
            

		    frame.runFunc = 0;		
	    }
	    runVal = 0;
    }
        
		    
		    
	}
	
	public static char[][] generateMap() {
		
		char[][] array = new char[13][13];
		char[][] tempArr = new char[13][13];

		int numbOfMines = slider.getValue();
		String printStr ="";
		boolean passable = false;
		
		while (passable == false) {
			 for  (int i = 0; i < 13; i++) {
				    for (int j = 0; j < 13; j++) {
				        if (i == 0 || j == 0) {
				            array[i][j] = '+';
				            tempArr[i][j] = '+';
				        } else if (i == 12 || j == 12) {
				        	array[i][j] = '+';
				        } else {
			            	array[i][j] = '0';
			            }   	
				    }		    	
				}
				
			array[11][0] = 'M';
			array[1][12] = '0';
		
			array = generateMines(array, numbOfMines);
			

			for (int i=0; i<array.length; i++) {
				for(int j=0; j<array[i].length; j++) {
					tempArr[i][j] = array[i][j];	
				}				
			}

					
			
			passable = mazeSolver(tempArr);
		}
		
        printStr = arrayToString(array);		    
		    
		    field.setText(printStr);
		    return array;
		
	}
	
	public static char[][] generateMines(char[][] arr, int n) {
	
		Random rand = new Random();
		Random rand2 = new Random();
		int i = 0;
		int j = 0;
		int key = 0;
		
		for (int k = 0; k < n; k++) {
			
			while (key == 0) {
				i = rand.nextInt(11) + 1;
				j = rand2.nextInt(11) + 1;
				
				if (i == 11 && j == 1) {
				    key = 0;
				} else if (i == 1 && j == 11) {
				    key = 0;
				} else if (arr[i][j] == '0') {
					arr[i][j] = '*';
					key = 1;	
			    }
					
				
			}
			key = 0;
			
		    	
		}
	    return arr;
	}
	
	
    public static boolean mazeSolver(char[][] arr) {

    	
		
	    int counter = 0;
	    Random rand = new Random();
	    int move = 0;
	    int i = 11;
	    int j = 1;

	    while (counter < 35) {
	    	
	    	if (arr[1][11] == 'M') {
	    		return true;
	    	}
	    	if (arr[1][11] == '*' || arr[1][10] == '*') {
	    		return false;
	    	}
 
    		
    		if (arr[i-1][j] == '0'  && arr[i][j+1] == '0') {
    		    move =  rand.nextInt(2);
    			if (move == 0) {
    			    arr[i][j] = 'V';
    			    i--;
    			    arr[i][j] = 'M';
    			} else {
    			    arr[i][j] = 'V';
    			    j++;
    			    arr[i][j] = 'M';	
    			}
    			
    		} else if (arr[i-1][j] == '0') {
			    arr[i][j] = 'V';
			    i--;
			    arr[i][j] = 'M';	
    		} else if (arr[i][j+1] == '0') {
			    arr[i][j] = 'V';
			    j++;
			    arr[i][j] = 'M';
    		}
    		
    		else if (arr[i+1][j] == '0' && arr[i][j-1] == '0') {
    			move =  rand.nextInt(2);
    			if (move == 0) {
    			    arr[i][j] = 'V';
    			    i++;
    			    arr[i][j] = 'M';
    			} else {
    			    arr[i][j] = 'V';
    			    j--;
    			    arr[i][j] = 'M';	
    			}	
    		} else if (arr[i+1][j] == '0') {
			    arr[i][j] = 'V';
			    i++;
			    arr[i][j] = 'M';	
    		} else if (arr[i][j-1] == '0') {
			    arr[i][j] = 'V';
			    j--;
			    arr[i][j] = 'M';
    		}
    		counter++;
    		
       		if (arr[i-1][j] != '0') {
    		    if (arr[i][j+1] != '0') {
    		    	if (arr[i+1][j] != '0') {
    		    		if (arr[i][j-1] != '0') {
    		    		    return false;
    		    		}   		    		
    		    	}
    		    }
    		}
       		       		
	    }	    
	    return false;
	}
	
    @SuppressWarnings("static-access")
	public static int checkUserInput(char[][] arr, String str, Frame frame) {
        
    	boolean engine = false;
    	int i = 11;
    	int j = 0;
    	int firstKey = 0;
    	int lastKey = 0;
    	String arrayToPrint = new String();
    	for (int c = 0; c < str.length(); c++) {
    		
    		if (i == 11 && j == 0) {
    			firstKey = 0;
    		} else {
    			firstKey = 1;
    		}
    		
    		if (i == 1 && j == 12) {
    			lastKey = 0;
    		} else {
    			lastKey = 1;
    		}    		
    		
    		if (str.charAt(c) == 'I') {
    			engine = true;
    		} else if (str.charAt(c) == '-') {
    			engine = false;
    		}
    		
    		if (arr[1][12] == 'M' && engine == false) {
    			arrayToPrint = arrayToString(arr);
    			frame.field.setText(arrayToPrint);
    			return 1;
    		}
    		
    		if (engine == true) {
    			
    			if (str.charAt(c) == 'N') {
    				
    				if(arr[i-1][j] == '0' || arr[i-1][j] == '.' ) {    					
        			    arr[i][j] = '.';
        			    i--;
        			    arr[i][j] = 'M';
    				} else if (arr[i-1][j] == '*') {
        			    arr[i][j] = '.';
        			    i--;
        			    arr[i][j] = 'X';
            			arrayToPrint = arrayToString(arr);
            			frame.field.setText(arrayToPrint);
        			    return -1;
    			    } 
    				
    			} else if (str.charAt(c) == 'E' && lastKey != 0) {
    				
    				if(arr[i][j+1] == '0' || arr[i][j+1] == '.') {
    			        arr[i][j] = '.';
    			        j++;
    			        arr[i][j] = 'M';
    			    } else if (arr[i][j+1] == '*') {
    			        arr[i][j] = '.';
    			        j++;
    			        arr[i][j] = 'X';
    	    			arrayToPrint = arrayToString(arr);
    	    			frame.field.setText(arrayToPrint);
    			        return -1;    				
    			    }
    				
    			} else if (str.charAt(c) == 'S') {
    				
                    if (arr[i+1][j] == '0' || arr[i+1][j] == '.') { 
   			            arr[i][j] = '.';
   			            i++;
   			            arr[i][j] = 'M';
   			        } else if (arr[i+1][j] == '*') {
   			            arr[i][j] = '.';
   			            i++;
   			            arr[i][j] = 'X';
   	    			    arrayToPrint = arrayToString(arr);
   	    			    frame.field.setText(arrayToPrint);
   			            return -1;    				
   			        }
                    
    			} else if (str.charAt(c) == 'W' && firstKey != 0) {
    				
                    if (arr[i][j-1] == '0' || arr[i][j-1] == '.') {
     			        arr[i][j] = '.';
     			        j--;
     			        arr[i][j] = 'M';
     			    } else if (arr[i][j-1] == '*') {
     			        arr[i][j] = '.';
     			        j--;
     			        arr[i][j] = 'X';
     	    			arrayToPrint = arrayToString(arr);
     	    			frame.field.setText(arrayToPrint);
     			        return -1;    				
     			    }
                       
    			}
    				    		
    		}
    		
    	}
    		  
		arrayToPrint = arrayToString(arr);
		frame.field.setText(arrayToPrint);
    	return -1;
    }

    public static String arrayToString(char[][] arr) {
        String str = "";
    	
		for  (int i = 0; i < 13; i++) {
	        for (int j = 0; j < 13; j++) {
		        str = str + arr[i][j];
		    }
		        str = str + "\n";
		}	
        
    	return str;
    }

}





