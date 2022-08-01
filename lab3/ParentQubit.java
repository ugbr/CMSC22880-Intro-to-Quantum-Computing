
public abstract class ParentQubit {
    private int num;
    private float[] combs;

    // ParentQubit
    // Constructor: initialize all bits to |0>
    public ParentQubit(int numqubits) {
        num = numqubits;
        combs = new float[(int) Math.pow(2, numqubits)];
        combs[0] = 1;
    }

    // setValue
    // sets the value in i-th value of combinations to v, the probability
    // Values are negative if the phase should be negative.
    public void setValue(float v, int i) {
        if (i < 0 || i > (combs.length - 1)) {
            System.out.println("Input i must be within range [0, (2^numqubits)-1]!");
        }
        combs[i] = v;
    }

    // setValues
    // Sets the values to those v
    // The value in v[i] is the probability of measuring that combination.
    // Values are negative if the phase should be negative.
    public void setValues(float[] v) {
        for (int i = 0; i < v.length; i++) {
            combs[i] = v[i];
        }
    }

    // getValue
    // returns the value at i-th index of combinations
    public float getValue(int i) {
        return combs[i];
    }

    // getValues
    // returns all the values in the combinations
    public float[] getValues() {
        return combs;
    }
    
    // setPhase
    // sets the phase of i-th value to p
    public void setPhase(int p, int i) {
        if (combs[i] != 0)
            combs[i] *= p;
    }

    // setPhases
    // sets the phases of values to the values in p
    public void setPhases(int[] p) {
        for (int i = 0; i < p.length; i++) {
            if (combs[i] != 0) 
                combs[i] *= p[i];
        }
    }

    // getPhase
    // returns the phase of the i-th combination
    public int getPhase(int i) {
        if (combs[i] == 0)
            return 1;
        else if (combs[i] < 0)
            return -1;
        else
            return 1;
    }

    // getNumQubits
    // this returns the number of qubits this object represents
    public int getNumQubits() {
        return num;
    } 

    // sign
    // helper function: returns the sign of a float 
    public float sign(float x) {
        return (x < 0) ? -1.0f : 1.0f;
    }

    // getMagnitudes
    // helper function: returns the magnitudes array based on the combinations
    public float[] getMagnitudes() {
        float[] probabilityMagnitude = new float[(int) Math.pow(2, num)];
        for (int i = 0; i < combs.length; i++) {
            float v = getValue(i);
            probabilityMagnitude[i] = sign(v) * (float) Math.sqrt(Math.abs(v));
        }
        return probabilityMagnitude;
    }

    // mergeQubits
    // not implemented in ParentQubit
    // merges two sets of qubits and returns a new set of qubits with
    // all the possible combinations
    abstract ParentQubit mergeQubits(ParentQubit pq);

    // toBraKet
    // not implemented in ParentQubit
    // converts the combination probabilities to BraKet notation
    abstract String toBraKet();

    // applyNotGate
    // not implemented
    // apply a not gate to all the qubits in the set and
    // modifies the combinations accordingly
    abstract void applyNotGate();

    // applyNotGate
    // not implemented
    // apply a not gate to the qb-th qubit in the set
    // modifies the combinations accordingly
    abstract void applyNotGate(int qb);

    // applyHGate
    // apply an H gate to each qubit
    // modifies the combinations accordingly
    abstract void applyHGate();

    // applyHgate
    // apply an H gate to the qb-th qubit in the set
    // modifies the combinations accordingly
    abstract void applyHGate(int qb);

    // applySwapGate
    // apply a swap gate to the qubit1-th and qubit2-th qubits
    // modifies the combinations accordingly
    abstract void applySwapGate(int qubit1, int qubit2);
}