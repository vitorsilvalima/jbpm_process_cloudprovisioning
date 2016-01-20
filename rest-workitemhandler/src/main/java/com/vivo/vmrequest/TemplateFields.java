package com.vivo.vmrequest;

/**
 * Created by vlima on 1/19/16.
 */
public class TemplateFields {
    private String guid;

    public TemplateFields(){
    }

    public TemplateFields(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
