package com.vivo.vmrequest;

/**
 * Created by vlima on 1/19/16.
 */
public class VMFields {
    private int number_of_cpus;
    private String vm_name;
    private String vm_memory;
    private String vlan;

    public int getNumber_of_cpus() {
        return number_of_cpus;
    }

    public void setNumber_of_cpus(int number_of_cpus) {
        this.number_of_cpus = number_of_cpus;
    }

    public String getVm_name() {
        return vm_name;
    }

    public void setVm_name(String vm_name) {
        this.vm_name = vm_name;
    }

    public String getVm_memory() {
        return vm_memory;
    }

    public void setVm_memory(String vm_memory) {
        this.vm_memory = vm_memory;
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }
}
