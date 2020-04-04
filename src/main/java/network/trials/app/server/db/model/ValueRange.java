package network.trials.app.server.db.model;

import java.util.Objects;

public class ValueRange {
    private float min;
    private float max;

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueRange that = (ValueRange) o;
        return Float.compare(that.min, min) == 0 &&
                Float.compare(that.max, max) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public String toString() {
        return "ValueRange{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
