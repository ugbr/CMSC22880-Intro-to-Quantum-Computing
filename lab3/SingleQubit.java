import java.text.DecimalFormat;

public class SingleQubit extends ParentQubit {

    // SingleQubit
    // Constructor: initialize bit to |0>
    public SingleQubit() {
        super(1);
        setValue(1, 0);
    }
    
    // mergeQubits
    // merge the current DoubleQubit with pq
    // returns a DoubleQubit when merged with a SingleQubit
    ParentQubit mergeQubits(ParentQubit pq) {
        if (pq.getNumQubits() != 1) {
            return null;
        } else {
            DoubleQubit dqubit = new DoubleQubit();
            float[] v = {(this.getValue(0) * pq.getValue(0)), 
                (this.getValue(0) * pq.getValue(1)),
                (this.getValue(1) * pq.getValue(0)),
                (this.getValue(1) * pq.getValue(1)) };
            dqubit.setValues(v);
            return dqubit;
        }
    }

    // toBraKet
    // converts the combination probabilities to BraKet notation
    // and returns the resulting String
    public String toBraKet() {
        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        // assumes that v[0] is always non-negative
        String formatWhite = decimalFormat.format(
            (float) Math.sqrt(this.getValue(0))
        );
        String formatBlack = decimalFormat.format(
            (float) Math.sqrt(Math.abs(this.getValue(1)))
        );

        int phase = this.getValue(1) < 0 ? -1 : 1;

        return formatWhite + "|0> " + (phase == -1 ? "- ": "+ ") + 
            formatBlack + "|1>";
    }
    
    // applyNotGate
    // apply a not gate to all the qubits in the set and
    // modifies the combinations 
    public void applyNotGate() {
        float temp0 = getValue(0);
        setValue(getValue(1), 0);
        setValue(temp0, 1);
    }
    
    // applyNotGate
    // apply a not gate to the qb-th qubit in the set
    // works only if qb = 0
    // modifies the combinations
    public void applyNotGate(int qb) {
        if (qb == 0)
            applyNotGate();
    }
    
    // applyHGate
    // apply an H gate to the qubit
    // modifies the combinations accordingly
    public void applyHGate() {
        float[] magnitudes = getMagnitudes();
        float temp0 = (float) Math.sqrt(0.5) * (magnitudes[0] + magnitudes[1]);
        float temp1 = (float) Math.sqrt(0.5) * (magnitudes[0] - magnitudes[1]);
        
        float[] combs = {
            sign(temp0) * temp0 * temp0,
            sign(temp1) * temp1 * temp1,
        };
        setValues(combs);
    }
    
    // applyHGate
    // apply an H gate to the qb-th qubit in the set
    // only works if qb = 0
    // modifies the combinations accordingly
    public void applyHGate(int qb) {
        if (qb == 0)
            applyHGate();
    }
    
    // applySwapGate
    // apply a swap gate to the qubit1-th and qubit2-th qubits
    // modifies the combinations accordingly
    // does nothing in this context
    public void applySwapGate(int qubit1, int qubit2) {
        return;
    }
    
}