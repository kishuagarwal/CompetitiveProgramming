import java.util.Scanner;

public class CompilerTesting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int INSIDE_MAIN = 0;
		int INSIDE_USER_DEFINED_FUNCTION = 1;
		int INSIDE_LOOP_MAIN = 2;
		int INSIDE_PROGRAM = 3;
		int INSIDE_LOOP_USER_FUNCTION = 4;
		int PROGRAM_CLOSED = 5;
		int UNDEFINED = 6;
		int currentState;
		boolean containsErrors;
		boolean mainFunctionOccured;

		int statementsCount;
		int nestedLoopCount;
		in.nextLine();
		for (int i = 0; i < t; i++) {
			String program = in.nextLine();
			currentState = UNDEFINED;
			containsErrors = false;
			statementsCount = 0;
			nestedLoopCount = 0;
			mainFunctionOccured = false;
			for (int j = 0; j < program.length(); j++) {
				switch (program.charAt(j)) {
 
				case '<':
					if (!mainFunctionOccured && currentState == INSIDE_PROGRAM) {
						mainFunctionOccured = true;
						currentState = INSIDE_MAIN;
						nestedLoopCount = 0;
					} else {
						containsErrors = true;
					}
					break;
				case '>':
					if (currentState == INSIDE_MAIN) {
						currentState = INSIDE_PROGRAM;
					
					} else {
						containsErrors = true;
					}
					break;
				case '{':
					if (currentState == INSIDE_MAIN
							|| currentState == INSIDE_USER_DEFINED_FUNCTION
							|| currentState == INSIDE_LOOP_MAIN
							|| currentState == INSIDE_LOOP_USER_FUNCTION) {
						if (currentState == INSIDE_MAIN)
							currentState = INSIDE_LOOP_MAIN;
						else if (currentState == INSIDE_USER_DEFINED_FUNCTION)
							currentState = INSIDE_LOOP_USER_FUNCTION;
						nestedLoopCount++;

					}
					else if(currentState == UNDEFINED)
						{
							currentState = INSIDE_PROGRAM;
						}else
						containsErrors = true;
					break;

				case '}':
					if (currentState == INSIDE_LOOP_MAIN) {
						nestedLoopCount--;
						if (nestedLoopCount == 0)
							currentState = INSIDE_MAIN;
					} else if (currentState == INSIDE_LOOP_USER_FUNCTION) {
						nestedLoopCount--;
						if (nestedLoopCount == 0)
							currentState = INSIDE_USER_DEFINED_FUNCTION;
					} else if (currentState == INSIDE_PROGRAM) {
						currentState = PROGRAM_CLOSED;
					} else
						containsErrors = true;
					break;

				case '(':
					if (currentState == INSIDE_PROGRAM) {
						currentState = INSIDE_USER_DEFINED_FUNCTION;
						statementsCount = 0;
						nestedLoopCount = 0;
					} else {
						containsErrors = true;
					}
					break;
				case ')':
					if (currentState == INSIDE_USER_DEFINED_FUNCTION) {
						currentState = INSIDE_PROGRAM;
						statementsCount = 0;
					} else
						containsErrors = true;
					break;
				case 'P':
					if(currentState == PROGRAM_CLOSED)
						containsErrors = true;
					
					if (currentState == INSIDE_USER_DEFINED_FUNCTION
							|| currentState == INSIDE_LOOP_USER_FUNCTION)
							
						statementsCount++;
					break;

				}
				if (containsErrors)
					break;
				if (statementsCount > 100) {
					containsErrors = true;
					break;
				}
				
			}
			if (containsErrors || currentState != PROGRAM_CLOSED
					|| !mainFunctionOccured)
				System.out.println("Compilation Errors");
			else
				System.out.println("No Compilation Errors");
		}
		in.close();

	}
}
