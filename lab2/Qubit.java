import java.util.Random;
import java.text.DecimalFormat;

public class Qubit{
	private float value; // value between -1 and 1 (inclusive)
    private int phase; // either -1 or 1. -1 for negative, 1 for positive

	/* Default Constructor
	 * Constructor without input arguments
	 * Initialize value to 0, positive phase
	 */
	public Qubit() 
    {
		value = 0;
        phase = 1;
	}

	/* Constructor with input arguments
	 * Initialize value to inputted value
	 */
	public Qubit(float v)
	{
        if (0 <= v && v <= 1) 
        {
            this.value = v;
            this.phase = 1;
        } else if (-1 <= v && v < 0) 
        {
            this.value = -v;
            this.phase = -1;
        } else 
        {
            System.out.println("Qubit: value input must be " +
                "within range [-1, 1]");
        }
	}

	/* Constructor with input arguments
	 * allow other ways of specifying the starting value
	 * initialize: "White" is false, "Black" is true
	 */
	public Qubit(String v)
	{
		if (v.equals("white"))
		{
			this.value = 0;
            this.phase = 1;
		} else if (v.equals("black"))
		{
			this.value = 1;
            this.phase = 1;
		} else
        {
            System.out.println("Qubit: input string must either be \"black\"" + 
                "or \"white\"");
        }
	}


	/* These are standard "setters" and "getters" except that we
	 * are supporting two types for the setter. Fill these in.
	 */
	public void setValue(float v)
	{
        if (0 <= v && v <= 1) 
        {
            this.value = v;
            this.phase = 1;
        } else if (-1 <= v) 
        {
            this.value = -v;
            this.phase = -1;
        } else 
        {
            System.out.println("setValue: input float must be" + 
                "within range [-1, 1]");
        }  
	}

	public void setValue(String v)
	{  
		if (v.equals("white"))
		{
			this.value = 0;
            this.phase = 1;
		} else if (v.equals("black"))
		{
			this.value = 1;
            this.phase = 1;
		} else 
        {
            System.out.println("setValue: input string must either be \"black\"" + 
                "or \"white\"");
        }
	}

	public float getValue()
	{  
		return this.value * this.phase;
	}

    public void setPhase(int phase)
    {
        if (phase == 1 || phase == -1)
        {
            this.phase = phase;
        } else
        {
            System.out.println("setPhase: input int must be either 1 or -1");
        }
    }

    public int getPhase()
    {
        return this.phase;
    }

	/* not
	 * Perform a not gate on the qubit
	 * In week 1, this is only required to flip between 0 and 1
	 * Implement this without a conditional - figure out a 
	 * mathematical calculation that will work for either 0 or 1
     * For now, we will assume that not does not affect the phase
	 */
	public void not()
	{
		this.value = 1 - this.value;
	}

    /* hgate
	 * Perform a hgate operation on the qubit
     * Supports the inputs: 0 with positive phase, 1 with positive phase
	 */
    public void hgate()
    {
        if ((this.phase == 1) && (this.value == 0
            || this.value == 1))
        {
            this.phase = this.value == 0 ? 1 : -1;
            this.value = (float) 0.5;
        }
        else
        {
            System.out.println("hgate: supports the inputs: " + 
                "0 with positive phase, 1 with positive phase");
        }
    }

    /* swap
	 * Perform a swap operation between this qubit and q2
     * Swaps the value and phase of this qubit with
     * q2's value and phase
	 */
    public void swap(Qubit q2)
    {
        float tempValue = q2.getValue();
        int tempPhase = q2.getPhase();

        q2.setValue(this.value);
        q2.setPhase(this.phase);

        this.value = tempValue;
        this.phase = tempPhase;
    }

    /* cnot
	 * Perform a cnot operation on this qubit (target) and q2 (control)
     * Supports the inputs 0 and 1, positive phase
	 */
    public void cnot(Qubit q2)
    {
        if ((this.phase == 1 && (this.value == 0
            || this.value == 1)) &&
            (q2.getPhase() == 1 && (q2.getValue() == 0
            || q2.getValue() == 1)))
        {
            if (this.value == 1)
                q2.setValue(1 - q2.getValue());
        } else
        {
            System.out.println("cnot: supports the inputs: " + 
                "0 and 1 inputs, positive phase");
        }
    }

    /* measureValue
	 * Measure the value of the given superposition based on probability
     * Sets the current value to the new value and returns the new value
     * Always sets the phase to positive (1)
	 */
    public int measureValue()
    {
        if (this.value == 0 || this.value == 1)
            return (int) this.value;
        
        Random rndm = new Random();
        int res = rndm.nextFloat() > this.value ? 0 : 1;
        this.phase = 1;
        return res;
    }

    /* toBraKet
	 * Returns a string that prints out the value in bra-ket notation
     * The form of the string is either 0.##|0> + 0.##|1> or 0.##|0> - 0.##|1>
     * depending on the phase of the qubit. If the rightmost digit in a 
     * number is 0, it is omitted. Therefore, if value = 1, phase = 1
     *  the string will be 0|0> + 1|1>.
	 */
    public String toBraKet()
    {
        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        float probWhite = (float) Math.sqrt(1 - this.value);
        float probBlack = (float) Math.sqrt(this.value);
        String formatWhite = decimalFormat.format(probWhite);
        String formatBlack = decimalFormat.format(probBlack);
        
        if (this.phase == -1)
            return formatWhite + "|0> - " + formatBlack + "|1>";
        else
            return formatWhite + "|0> + " + formatBlack + "|1>";
    }

	/* These are methods we implement so that we can use Qubit with
	 * standard operations - like System.out.println and comparison 
	 * These are critical for grading, so don't change them!!!
	 */
	public String toString()
	{
	       // we put the "" before value to make it a String.	
		return "" + value;
    } 

	public static int compare (Object obj1, Object obj2)
	{
		// first cast to Qubits - we assume we're comparing Qubits
		Qubit q1 = (Qubit) obj1;
		Qubit q2 = (Qubit) obj2;

		// if they are equal within a certain precision
		// because they are floats, we must put in a fudge factor
		if (((q1.getValue() - q2.getValue()) < 0.01) &&
		    ((q2.getValue() - q1.getValue()) < 0.01) ) 
		{
			// obj1 == obj2
			return 0;
		}
		else if (q1.getValue() > q2.getValue())
		{
			// obj1 > obj2
			return 1;
		}
		else // if (q1.getValue() < q2.getValue())
		{
			// obj1 < obj2
			return -1;
		}
		   
	}

} // end of class


