package network.trials.app.server.db.model;

import java.util.List;
import java.util.Objects;

public class ObservationType {
    private String                 id;
    private String                 group;
    private String                 name;
    private String                 shortName;
    private String                 unit;
    private String                 shortUnit;
    private String                 displayFormat;
    private String                 normalRangeSelector;
    private List<ObservationRange> normalRanges;

    public ObservationType() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getShortUnit() {
        return shortUnit;
    }

    public void setShortUnit(String shortUnit) {
        this.shortUnit = shortUnit;
    }

    public String getDisplayFormat() {
        return displayFormat;
    }

    public void setDisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat;
    }

    public String getNormalRangeSelector() {
        return normalRangeSelector;
    }

    public void setNormalRangeSelector(String normalRangeSelector) {
        this.normalRangeSelector = normalRangeSelector;
    }

    public List<ObservationRange> getNormalRanges() {
        return normalRanges;
    }

    public void setNormalRanges(List<ObservationRange> normalRanges) {
        this.normalRanges = normalRanges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObservationType that = (ObservationType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(group, that.group) &&
                Objects.equals(name, that.name) &&
                Objects.equals(shortName, that.shortName) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(shortUnit, that.shortUnit) &&
                Objects.equals(displayFormat, that.displayFormat) &&
                Objects.equals(normalRangeSelector, that.normalRangeSelector) &&
                Objects.equals(normalRanges, that.normalRanges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, name, shortName, unit, shortUnit, displayFormat, normalRangeSelector, normalRanges);
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", unit='" + unit + '\'' +
                ", shortUnit='" + shortUnit + '\'' +
                ", displayFormat='" + displayFormat + '\'' +
                ", normalRangeSelector='" + normalRangeSelector + '\'' +
                ", normalRanges=" + normalRanges +
                '}';
    }
}
