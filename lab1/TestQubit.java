public class TestQubit
{
	/* TestsetValue
	 * receives user input for testing one call of setValue
	 * on a Qubit with a float input
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float"}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int TestsetValueFloat(Qubit start, Qubit expected, 
						String[] args)
	{
		float val;
		// make sure the degrees input is there
		if (args.length < 4)	
		{
			System.out.println("Too few arguments for "+
				"TestsetValueFloat: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

		// read the command-line argument
		val = Float.parseFloat(args[3]);
		// perform the operation
		start.setValue(val);

		// check the result and report
		if (Qubit.compare(start, expected) == 0)
		{
			System.out.println("Qubit setValue("+val+
						"): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit setValue("+val+
				"): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
	}

	/* TestStringConstructor
	 * receives user input for testing the String 
	 * constructor for Qubit
	 * of Qubit with a String input
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 0, "String"}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int TestStringConstructor(Qubit start, Qubit expected, 
						String[] args)
	{
		String val;
		// make sure the degrees input is there
		if (args.length < 4)	
		{
			System.out.println("Too few arguments for "+
				"TestStringConstructor: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

		// read the command-line argument
		val = args[3];
		
		// create new Qubit using String constructor
		Qubit test = new Qubit(val);

		// check the result and report
		if (Qubit.compare(test, expected) == 0)
		{
			System.out.println("Qubit(\""+val+
						"\"): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit(\""+val+
				"\"): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+test);
			return 0;
		}
	}

	/* TestsetValueString
	 * receives user input for testing one call of setValue
	 * on a Qubit with a String input
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 2, "String"}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int TestsetValueString(Qubit start, Qubit expected, 
						String[] args)
	{
		String val;
		// make sure the degrees input is there
		if (args.length < 4)	
		{
			System.out.println("Too few arguments for "+
				"TestsetValueString: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

		// read the command-line argument
		val = args[3];
		// perform the operation
		start.setValue(val);

		// check the result and report
		if (Qubit.compare(start, expected) == 0)
		{
			System.out.println("Qubit setValue(\""+val+
						"\"): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit setValue(\""+val+
				"\"): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
	}
	
	/* TestgetValue
	 * receives user input for testing one call of getValue
	 * on a Qubit
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 3, "float"}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int TestgetValue(Qubit start, Qubit expected, 
						String[] args)
	{
		float val, expectedVal;
		// make sure the degrees input is there
		if (args.length < 4)	
		{
			System.out.println("Too few arguments for "+
				"TestgetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}
		// read command-line input
		expectedVal = Float.parseFloat(args[3]);

		// perform the operation
		val = start.getValue();

		// check the result and report
		if (val == expectedVal)
		{
			System.out.println("Qubit getValue(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit getValue(): FAIL!");
			System.out.println("Expected: "+expectedVal);
			System.out.println("Actual: "+val);
			return 0;
		}
	}

	/* Testnot
	 * receives user input for testing one call of not
	 * on a Qubit
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 4}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int Testnot(Qubit start, Qubit expected, 
						String[] args)
	{
		// make sure the degrees input is there
		if (args.length < 3)	
		{
			System.out.println("Too few arguments for "+
				"Testnot: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

		// perform the operation
		start.not();

		// check the result and report
		if (Qubit.compare(start, expected) == 0)
		{
			System.out.println("Qubit not(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit getValue(): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
	}
	public static void main(String[] args)
	{
		int testNumber = 2;
		Qubit testQubit = new Qubit();
		Qubit expectedQubit = new Qubit();
		// make sure there are enough arguments
		if (args.length < 3)	
		{
			System.out.println("Too few arguments: "+args.length);
			System.out.println("Usage: TestQubit.exe start_state "
				+"expected_end_state testNumber inputs " 
				+"expected_ret_val");
			System.exit(0);
		}

		// get the starting state, ending state, and test number
		testQubit.setValue( Float.parseFloat(args[0]));
		expectedQubit.setValue( Float.parseFloat(args[1]));
		testNumber = Integer.parseInt(args[2]);

		// use the testnumber to choose a test function
		switch (testNumber)
		{
			case (0):
				// test String constructor
				TestStringConstructor(testQubit, expectedQubit, args);
				break;
			case (1):
				// test setValue with float input
				TestsetValueFloat(testQubit, expectedQubit, args);
				break;
			case (2):
				// test setValue with String input
				TestsetValueString(testQubit, expectedQubit, args);
				break;
			case (3):
				// test getValue
				TestgetValue(testQubit, expectedQubit, args);
				break;
			case (4):
				// test not
				Testnot(testQubit, expectedQubit, args);
				break;
			default:
				System.out.println("Test "+testNumber+" not supported");
		}
	}
}

