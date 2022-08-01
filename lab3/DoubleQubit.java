import java.text.DecimalFormat;

public class DoubleQubit extends ParentQubit {

    // DoubleQubit
    // Constructor: initialize to |00>
    public DoubleQubit() {
        super(2);
        setValue(1, 0);
    }

    // mergeQubits
    // merge the current DoubleQubit with pq
    // returns null
    ParentQubit mergeQubits(ParentQubit pq) {
        return null;
    }

    // toBraKet
    // converts the combination probabilities to BraKet notation
    // and returns the resulting String
    public String toBraKet() {
        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        int phase1 = this.getValue(1) < 0 ? -1 : 1;
        int phase2 = this.getValue(2) < 0 ? -1 : 1;
        int phase3 = this.getValue(3) < 0 ? -1 : 1;
        
        // assumes that v[0] and v[2] are always non-negative
        String formatWW = decimalFormat.format(
            (float) Math.sqrt(this.getValue(0))
        );
        String formatWB = decimalFormat.format(
            (float) Math.sqrt(Math.abs(this.getValue(1)))
        );
        String formatBW = decimalFormat.format(
            (float) Math.sqrt(Math.abs(this.getValue(2)))
        );
        String formatBB = decimalFormat.format(
            (float) Math.sqrt(Math.abs(this.getValue(3)))
        );

        return formatWW + "|00> " + (phase1 == -1 ? "- " : "+ ") +
            formatWB + "|01> " + (phase2 == -1 ? "- " : "+ ") +
            formatBW + "|10> " + (phase3 == -1 ? "- " : "+ ") +
            formatBB + "|11>";
    }

    // applyNotGate
    // apply a not gate to all the qubits in the set and
    // modifies the combinations accordingly
    public void applyNotGate() {
        float[] vals = {getValue(3), getValue(2), getValue(1), getValue(0)};
        setValues(vals);
    }

    // applyNotGate
    // apply a not gate to the qb-th qubit in the set
    // modifies the combinations accordingly
    public void applyNotGate(int qb) {
        if (qb == 0) {
            float[] vals = {getValue(2), getValue(3), getValue(0), getValue(1)};
            setValues(vals);
        } else if (qb == 1) {
            float[] vals = {getValue(1), getValue(0), getValue(3), getValue(2)};
            setValues(vals);
        } else {
            return;
        }
    }

    // applyHGate
    // apply an H gate to each qubit
    // modifies the combinations accordingly
    public void applyHGate() {
        float[] probabilityMagnitude = getMagnitudes();
        float temp0 = 0.5f * (probabilityMagnitude[0] + probabilityMagnitude[1] +
            probabilityMagnitude[2] + probabilityMagnitude[3]);
        float temp1 = 0.5f * (probabilityMagnitude[0] - probabilityMagnitude[1] +
            probabilityMagnitude[2] - probabilityMagnitude[3]);
        float temp2 = 0.5f * (probabilityMagnitude[0] + probabilityMagnitude[1] -
            probabilityMagnitude[2] - probabilityMagnitude[3]);
        float temp3 = 0.5f * (probabilityMagnitude[0] - probabilityMagnitude[1] -
            probabilityMagnitude[2] + probabilityMagnitude[3]);
        float[] combs = {
            sign(temp0) * temp0 * temp0,
            sign(temp1) * temp1 * temp1,
            sign(temp2) * temp2 * temp2,
            sign(temp3) * temp3 * temp3
        };
        setValues(combs);
    }

    // applyHgate
    // apply an H gate to the qb-th qubit in the set
    // modifies the combinations accordingly
    public void applyHGate(int qb) {
        float[] probabilityMagnitude = getMagnitudes();
        float temp0, temp1, temp2, temp3;
        if (qb == 0) {
            temp0 = (float) Math.sqrt(0.5) * (probabilityMagnitude[0] + probabilityMagnitude[2]);
            temp1 = (float) Math.sqrt(0.5) * (probabilityMagnitude[1] + probabilityMagnitude[3]);
            temp2 = (float) Math.sqrt(0.5) * (probabilityMagnitude[0] - probabilityMagnitude[2]);
            temp3 = (float) Math.sqrt(0.5) * (probabilityMagnitude[1] - probabilityMagnitude[3]);
        } else if (qb == 1) {
            temp0 = (float) Math.sqrt(0.5) * (probabilityMagnitude[0] + probabilityMagnitude[1]);
            temp1 = (float) Math.sqrt(0.5) * (probabilityMagnitude[0] - probabilityMagnitude[1]);
            temp2 = (float) Math.sqrt(0.5) * (probabilityMagnitude[2] + probabilityMagnitude[3]);
            temp3 = (float) Math.sqrt(0.5) * (probabilityMagnitude[2] - probabilityMagnitude[3]);
        } else {
            return;
        }
        float[] combs = {
            sign(temp0) * temp0 * temp0,
            sign(temp1) * temp1 * temp1,
            sign(temp2) * temp2 * temp2,
            sign(temp3) * temp3 * temp3
        };
        setValues(combs);
    }

    // applySwapGate
    // apply a swap gate to the qubit1-th and qubit2-th qubits
    // modifies the combinations accordingly
    public void applySwapGate(int qubit1, int qubit2) {
        if (qubit1 == 0 && qubit2 == 1) {
            float temp1 = getValue(1);
            setValue(getValue(2), 1);
            setValue(temp1, 2);
        }
    }
}