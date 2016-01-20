package com.vivo.vmrequest;

/**
 * Created by vlima on 1/19/16.
 */
public class Request {
    private double version;
    private TemplateFields template_fields;
    private VMFields vm_fields;
    private Requester requester;

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public TemplateFields getTemplate_fields() {
        return template_fields;
    }

    public void setTemplate_fields(TemplateFields template_fields) {
        this.template_fields = template_fields;
    }

    public VMFields getVm_fields() {
        return vm_fields;
    }

    public void setVm_fields(VMFields vm_fields) {
        this.vm_fields = vm_fields;
    }

    public Requester getRequester() {
        return requester;
    }

    public void setRequester(Requester requester) {
        this.requester = requester;
    }
}
