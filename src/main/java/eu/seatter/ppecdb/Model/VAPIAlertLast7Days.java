package eu.seatter.ppecdb.Model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name="vAPIAlertLast7Days")
@Immutable
public class VAPIAlertLast7Days implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Timestamp date;

    private float temperature;

    private int cleared;

    public Timestamp getDate() {
        return date;
    }

    public float getTemperature() {
        return temperature;
    }

    public int getCleared() {
        return cleared;
    }
}