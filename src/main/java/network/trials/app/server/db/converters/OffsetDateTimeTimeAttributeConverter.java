package network.trials.app.server.db.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Converter(autoApply = true)
public class OffsetDateTimeTimeAttributeConverter implements AttributeConverter<OffsetDateTime, Timestamp> {
     
    @Override
    public Timestamp convertToDatabaseColumn(OffsetDateTime locDateTime) {
        return locDateTime == null ? null : Timestamp.valueOf(locDateTime.atZoneSameInstant(ZoneId.of("Etc/Utc")).toLocalDateTime());
    }
 
    @Override
    public OffsetDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return sqlTimestamp == null ? null : OffsetDateTime.from(sqlTimestamp.toLocalDateTime());
    }
}