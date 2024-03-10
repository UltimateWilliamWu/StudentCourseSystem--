package Pojo;

public class Schedule {
    int id;
    String sclass,day,time,cid,idclassroom,smester;

    public Schedule(int id, String sclass, String day, String time, String cid, String idclasssroom,String smester) {
        this.id=id;
        this.sclass = sclass;
        this.day = day;
        this.time = time;
        this.cid = cid;
        this.idclassroom = idclasssroom;
        this.smester=smester;
    }

    public String getIdclassroom() {
        return idclassroom;
    }

    public void setIdclassroom(String idclassroom) {
        this.idclassroom = idclassroom;
    }

    public String getSmester() {
        return smester;
    }

    public void setSmester(String smester) {
        this.smester = smester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getIdclasssroom() {
        return idclassroom;
    }

    public void setIdclasssroom(String idclasssroom) {
        this.idclassroom = idclasssroom;
    }
}
