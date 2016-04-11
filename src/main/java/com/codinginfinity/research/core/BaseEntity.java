package com.codinginfinity.research.core;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by andrew on 2016/04/11.
 */
@Entity
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 4580452341113808605L;

    @Id
    private long id;

    public long getId() {
        return id;
    }


}
