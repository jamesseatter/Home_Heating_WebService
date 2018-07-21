package eu.seatter.ppecdb.Model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name="vAPITemperatureLast365Days") //this tells hibernate to make a table out of this class
@Immutable
public class VAPITemperatureLast365Days {
    @OrderBy("sysid ASC")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sysid;

    private Timestamp date;

    private float temperature;

    public Long getSysid() {
        return sysid;
    }

    public Timestamp getDate() {
        return date;
    }

    public float getTemperature() {
        return temperature;
    }

}
