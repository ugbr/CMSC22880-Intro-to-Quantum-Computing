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

	/* TestsetPhase
	 * receives user input for testing one call of setPhase
	 * on a Qubit
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 5, "int"}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int TestsetPhase(Qubit start, Qubit expected, 
						String[] args)
	{
		// make sure the degrees input is there
		if (args.length < 4)	
		{
			System.out.println("Too few arguments for "+
				"TestsetPhase: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

		// perform the operation
		start.setPhase(Integer.parseInt(args[3]));
        
		// check the result and report
		if (start.getPhase() == expected.getPhase())
		{
			System.out.println("Qubit not(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit setPhase(): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
	}

	/* TestgetPhase
	 * receives user input for testing one call of getPhase
	 * on a Qubit
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 6, "int"}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int TestgetPhase(Qubit start, Qubit expected, 
						String[] args)
	{
		// make sure the degrees input is there
		if (args.length < 4)	
		{
			System.out.println("Too few arguments for "+
				"TestgetPhase: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

		// perform the operation
        int phase = start.getPhase();
        
		// check the result and report
		if (phase== Integer.parseInt(args[3]))
		{
			System.out.println("Qubit getPhase(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit getPhase(): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
	}

	/* Testhgate
	 * receives user input for testing one call of hgate
	 * on a Qubit
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 7}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int Testhgate(Qubit start, Qubit expected, 
						String[] args)
	{
		// make sure the degrees input is there
		if (args.length < 3)	
		{
			System.out.println("Too few arguments for "+
				"Testhgate: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

		// perform the operation
        start.hgate();
        
		// check the result and report
		if (start.getValue() == expected.getValue() &&
            start.getPhase() == expected.getPhase())
		{
			System.out.println("Qubit hgate(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit hgate(): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
	}

	/* Testswap
	 * receives user input for testing one call of swap
	 * on a Qubit
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 8, "float", "float"}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int Testswap(Qubit start, Qubit expected, 
						String[] args)
	{
		// make sure the degrees input is there
		if (args.length < 5)	
		{
			System.out.println("Too few arguments for "+
				"Testswap: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}
        
        Qubit start1 = new Qubit();
		Qubit expected1 = new Qubit();
        start1.setValue( Float.parseFloat(args[3]));
		expected1.setValue( Float.parseFloat(args[4]));   
        
        // perform the operation
        start.swap(start1);
        
		// check the result and report
		if (start.getValue() == expected.getValue() &&
            start.getPhase() == expected.getPhase() &&
            start1.getValue() == expected1.getValue() &&
            start1.getPhase() == expected1.getPhase())
		{
			System.out.println("Qubit swap(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit swap(): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
	}

	/* Testcnot
	 * receives user input for testing one call of cnot
	 * on a Qubit
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 9, "float", "float"}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int Testcnot(Qubit start, Qubit expected, 
						String[] args)
	{
		// make sure the degrees input is there
		if (args.length < 5)	
		{
			System.out.println("Too few arguments for "+
				"Testcnot: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

        Qubit start1 = new Qubit();
		Qubit expected1 = new Qubit();
        start1.setValue( Float.parseFloat(args[3]));
		expected1.setValue( Float.parseFloat(args[4]));   
		
        // perform the operation
        start.cnot(start1);

		// check the result and report
		if (start.getValue() == expected.getValue() &&
            start.getPhase() == expected.getPhase() &&
            start1.getValue() == expected1.getValue() &&
            start1.getPhase() == expected1.getPhase())
		{
			System.out.println("Qubit cnot(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit cnot(): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
	}

	/* TestmeasureValue
	 * receives user input for testing multiplec calls of measure
	 * on a Qubit
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 10}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int TestmeasureValue(Qubit start, Qubit expected, 
						String[] args)
	{
		// make sure the degrees input is there
		if (args.length < 3)	
		{
			System.out.println("Too few arguments for "+
				"Testmeasure: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		} 
		
        // perform many trials on measure
        int trials = 10000000;
        int numberOfBlacks = 0; 
        for (int i = 0; i < trials; i++) 
        {
            numberOfBlacks += start.measureValue() == 1 ? 1 : 0;
        }

        Qubit average = new Qubit((float) numberOfBlacks / (float) trials);

		// check the result and report
		if (Qubit.compare(average, expected) == 0)
		{
			System.out.println("Qubit measureValue(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit measureValue(): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
	}

	/* TesttoBraKet
	 * receives user input for testing one call of toBraKet
	 * on a Qubit
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float", "float", 11}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int TesttoBraKet(Qubit start, Qubit expected, 
						String[] args)
	{
		// make sure the degrees input is there
		if (args.length < 3)	
		{
			System.out.println("Too few arguments for "+
				"TesttoBraKet: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		} 
		
        // perform operation
        System.out.println(start.toBraKet());

		// check the result and report
		if (Qubit.compare(start, expected) == 0)
		{
			System.out.println("Qubit toBraKet(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit toBraKet(): FAIL!");
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
            case (5):
                // test setPhase
                TestsetPhase(testQubit, expectedQubit, args);
                break;
            case (6):
                // test getPhase
                TestgetPhase(testQubit, expectedQubit, args);
                break;
            case (7):
                // test hgate
                Testhgate(testQubit, expectedQubit, args);
                break;
            case (8):
                // test swap
                Testswap(testQubit, expectedQubit, args);
                break;
            case (9):
                // test cnot
                Testcnot(testQubit, expectedQubit, args);
                break;
            case (10):
                // test measureValue
                TestmeasureValue(testQubit, expectedQubit, args);
                break;
            case (11):
                //test toBraKet
                TesttoBraKet(testQubit, expectedQubit, args);
                break;
			default:
				System.out.println("Test "+testNumber+" not supported");
		}
	}
}

