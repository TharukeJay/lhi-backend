package com.tharuke.lhi.repository.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Part extends PersistObject{

    private String partNumber;
    private String partName;
    private String qty;
    private String partCategory;

}
