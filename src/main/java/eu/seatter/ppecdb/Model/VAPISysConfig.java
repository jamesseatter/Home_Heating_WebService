package eu.seatter.ppecdb.Model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="vAPISysConfig")
@Immutable
public class VAPISysConfig implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sysId;

    private String name;

    private Integer value;

    private String description;

    public Long getSysId() {
        return sysId;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
