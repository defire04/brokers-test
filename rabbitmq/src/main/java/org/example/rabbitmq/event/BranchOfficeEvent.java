package org.example.testrabbitmq.connection;

import lombok.Data;

import java.io.Serializable;

@Data
public class BranchOfficeEvent implements Serializable {
    private String serviceName;
    private String entityName;
    private String action;
    private String payload;


}