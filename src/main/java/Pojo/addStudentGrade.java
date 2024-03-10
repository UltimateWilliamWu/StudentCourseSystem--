package Pojo;

public class addStudentGrade {
    int Sid,Tid,Cid;
    float Ggrades,Fgrades,Tgrades;

    public addStudentGrade(int sid, int tid, int cid, float ggrades, float fgrades, float tgrades) {
        Sid = sid;
        Tid = tid;
        Cid = cid;
        Ggrades = ggrades;
        Fgrades = fgrades;
        Tgrades = tgrades;
    }

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int tid) {
        Tid = tid;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public float getGgrades() {
        return Ggrades;
    }

    public void setGgrades(float ggrades) {
        Ggrades = ggrades;
    }

    public float getFgrades() {
        return Fgrades;
    }

    public void setFgrades(float fgrades) {
        Fgrades = fgrades;
    }

    public float getTgrades() {
        return Tgrades;
    }

    public void setTgrades(float tgrades) {
        Tgrades = tgrades;
    }
}
