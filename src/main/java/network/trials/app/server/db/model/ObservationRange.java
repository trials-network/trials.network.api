package network.trials.app.server.db.model;

import java.util.Objects;

public class ObservationRange {
    private ValueRange partition;
    private ValueRange range;


    public ValueRange getPartition() {
        return partition;
    }

    public void setPartition(ValueRange partition) {
        this.partition = partition;
    }

    public ValueRange getRange() {
        return range;
    }

    public void setRange(ValueRange range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObservationRange that = (ObservationRange) o;
        return Objects.equals(partition, that.partition) &&
                Objects.equals(range, that.range);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partition, range);
    }

    @Override
    public String toString() {
        return "ObservationRange{" +
                "partition=" + partition +
                ", range=" + range +
                '}';
    }
}
