package Pojo;

public class TeacherSeeStudents {
    int sid,cid;
    float ggrades,tgrades,fgrades;
    String cname,sclass,sdept,Sname;

    public TeacherSeeStudents() {

    }

    public TeacherSeeStudents(int sid, int cid, float ggrades, float tgrades, float fgrades, String cname, String sclass, String sdept, String sname) {
        this.sid = sid;
        this.cid = cid;
        this.ggrades = ggrades;
        this.tgrades = tgrades;
        this.fgrades = fgrades;
        this.cname = cname;
        this.sclass = sclass;
        this.sdept = sdept;
        this.Sname = sname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public float getGgrades() {
        return ggrades;
    }

    public void setGgrades(float ggrades) {
        this.ggrades = ggrades;
    }

    public float getTgrades() {
        return tgrades;
    }

    public void setTgrades(float tgrades) {
        this.tgrades = tgrades;
    }

    public float getFgrades() {
        return fgrades;
    }

    public void setFgrades(float fgrades) {
        this.fgrades = fgrades;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        this.Sname = sname;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }
}
