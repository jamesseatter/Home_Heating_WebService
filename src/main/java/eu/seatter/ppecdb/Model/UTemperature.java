package eu.seatter.ppecdb.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by james on 26/06/2018.
 */
@Entity(name="uTemperature")
@NamedStoredProcedureQuery(name = "insert.Temperature", procedureName = "insert_temperature", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "tempC", type = Float.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "alertstatus", type = String.class) })
@NamedStoredProcedureQuery(name = "dev.insert.Temperature", procedureName = "dev_insert_temperature", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "tempC", type = Float.class) })

public class UTemperature {
    @OrderBy("sysid ASC")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sysid;

    private Timestamp date;

    private float temperature_base;

    private float temperature;

    private String uTemperaturecol;

    public Long getSysid() {
        return sysid;
    }

    public void setSysid(Long sysid) {
        this.sysid = sysid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public float getTemperature_base() {
        return temperature_base;
    }

    public void setTemperature_base(float base_temperature) {
        this.temperature_base = base_temperature;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getuTemperaturecol() {
        return uTemperaturecol;
    }

    public void setuTemperaturecol(String uTemperaturecol) {
        this.uTemperaturecol = uTemperaturecol;
    }
}
