package eu.seatter.ppecdb.Model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name="vAPILastTemp")
@Immutable
public class VAPILastTemp implements Serializable {
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

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
