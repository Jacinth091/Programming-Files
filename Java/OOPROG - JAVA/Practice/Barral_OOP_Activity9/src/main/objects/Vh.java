package main.objects;


public abstract class Vh {
    private String vhName;
    private String vhType;




    public Vh(String vhName, String vhType) {
        this.vhName = vhName;
        this.vhType = vhType;

    }

    public String getVhName() {
        return vhName;
    }

    public String getVhType() {
        return vhType;
    }

}
