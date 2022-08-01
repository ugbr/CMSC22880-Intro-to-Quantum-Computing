public class TestQubits
{
    public static int TesttoBraKetSingle(SingleQubit input, String expected) {
        String i = input.toBraKet();
        if (i.equals(expected)) {
                System.out.println("TesttoBraKetSingle: Test PASSED!");
                return 1;
            } else {
                System.out.println("TesttoBraKetSingle: Test FAILED!");
                System.out.println("actual values: " + i);
                System.out.println("expected values: " + expected);
                return 1;
            }
    }

    public static int TestapplyNotGateSingle(SingleQubit input, float[] expected) {
        input.applyNotGate();
        if (input.getValues().equals(expected)) {
            System.out.println("TestapplyNotGateSingle: Test PASSED!");
            return 1;
        } else {
            System.out.println("TestapplyNotGateSingle: Test FAILED!");
            System.out.println("actual values: " + input.getValues().toString());
            System.out.println("expected values: " + expected.toString());
            return 1;
        }
    }

    public static int TestapplyNotGateSingle(SingleQubit input, int qb, float[] expected) {
        input.applyNotGate(qb);
        if (input.getValues().equals(expected)) {
            System.out.println("TestapplyNotGateSingle: Test PASSED!");
            return 1;
        } else {
            System.out.println("TestapplyNotGateSingle: Test FAILED!");
            System.out.println("actual values: " + input.getValues().toString());
            System.out.println("expected values: " + expected.toString());
            return 1;
        }
    }

    public static int TestapplyHGateSingle(SingleQubit input, float[] expected) {
        input.applyHGate();
        if (input.getValues().equals(expected)) {
            System.out.println("TestapplyHGateSingle: Test PASSED!");
            return 1;
        } else {
            System.out.println("TestapplyHGateSingle: Test FAILED!");
            System.out.println("actual values: " + input.getValues().toString());
            System.out.println("expected values: " + expected.toString());
            return 1;
        }
    }    

    public static int TestapplyHGateSingle(SingleQubit input, int qb, float[] expected) {
        input.applyHGate(qb);
        if (input.getValues().equals(expected)) {
            System.out.println("TestapplyHGateSingle: Test PASSED!");
            return 1;
        } else {
            System.out.println("TestapplyHGateSingle: Test FAILED!");
            System.out.println("actual values: " + input.getValues().toString());
            System.out.println("expected values: " + expected.toString());
            return 1;
        }
    }  

    public static int TesttoBraKetDouble(DoubleQubit input, String expected) {
        String i = input.toBraKet();
        if (i == expected) {
                System.out.println("TesttoBraKetDouble: Test PASSED!");
                return 1;
            } else {
                System.out.println("TesttoBraKetDouble: Test FAILED!");
                System.out.println("actual values: " + i);
                System.out.println("expected values: " + expected);
                return 1;
            }
    }

    public static int TestapplyNotGateDouble(DoubleQubit input, float[] expected) {
        input.applyNotGate();
        if (input.getValues().equals(expected)) {
            System.out.println("TestapplyNotGateDouble: Test PASSED!");
            return 1;
        } else {
            System.out.println("TestapplyNotGateDouble: Test FAILED!");
            System.out.println("actual values: " + input.getValues().toString());
            System.out.println("expected values: " + expected.toString());
            return 1;
        }
    }

    public static int TestapplyNotGateDouble(DoubleQubit input, int qb, float[] expected) {
        input.applyNotGate(qb);
        if (input.getValues().equals(expected)) {
            System.out.println("TestapplyNotGateDouble: Test PASSED!");
            return 1;
        } else {
            System.out.println("TestapplyNotGateDouble: Test FAILED!");
            System.out.println("actual values: " + input.getValues().toString());
            System.out.println("expected values: " + expected.toString());
            return 1;
        }
    }

    public static int TestapplyHGateDouble(DoubleQubit input, float[] expected) {
        input.applyHGate();
        if (input.getValues().equals(expected)) {
            System.out.println("TestapplyHGateDouble: Test PASSED!");
            return 1;
        } else {
            System.out.println("TestapplyHGateDouble: Test FAILED!");
            System.out.println("actual values: " + input.getValues().toString());
            System.out.println("expected values: " + expected.toString());
            return 1;
        }
    } 

    public static int TestapplyHGateDouble(DoubleQubit input, int qb, float[] expected) {
        input.applyHGate(qb);
        if (input.getValues().equals(expected)) {
            System.out.println("TestapplyHGateDouble: Test PASSED!");
            return 1;
        } else {
            System.out.println("TestapplyHGateDouble: Test FAILED!");
            System.out.println("actual values: " + input.getValues().toString());
            System.out.println("expected values: " + expected.toString());
            return 1;
        }
    }  

    public static int TestapplySwapGateDouble(DoubleQubit input, int qb1, int qb2, float[] expected) {
        input.applySwapGate(qb1, qb2);
        if (input.getValues().equals(expected)) {
            System.out.println("TestapplySwapGateDouble: Test PASSED!");
            return 1;
        } else {
            System.out.println("TestapplySwapGateDouble: Test FAILED!");
            System.out.println("actual values: " + input.getValues().toString());
            System.out.println("expected values: " + expected.toString());
            return 1;
        }
    }  
	public static void main(String[] args)
	{
		SingleQubit input = new SingleQubit();
        TesttoBraKetSingle(input, "1|0> + 0|1>");
        input.setValue(0.25f, 1);
        TesttoBraKetSingle(input, "1|0> + 0.5|1>");
        float[] expected = {0.25f, 1};
        TestapplyNotGateSingle(input, expected);

	}
}