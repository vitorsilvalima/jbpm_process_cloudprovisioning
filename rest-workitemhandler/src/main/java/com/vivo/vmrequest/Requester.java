package com.vivo.vmrequest;

/**
 * Created by vlima on 1/19/16.
 */
public class Requester {
    private String user_name;
    private String owner_first_name;
    private String owner_last_name;
    private String owner_email;
    private boolean auto_approve;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getOwner_first_name() {
        return owner_first_name;
    }

    public void setOwner_first_name(String owner_first_name) {
        this.owner_first_name = owner_first_name;
    }

    public String getOwner_last_name() {
        return owner_last_name;
    }

    public void setOwner_last_name(String owner_last_name) {
        this.owner_last_name = owner_last_name;
    }

    public String getOwner_email() {
        return owner_email;
    }

    public void setOwner_email(String owner_email) {
        this.owner_email = owner_email;
    }

    public boolean isAuto_approve() {
        return auto_approve;
    }

    public void setAuto_approve(boolean auto_approve) {
        this.auto_approve = auto_approve;
    }
}
