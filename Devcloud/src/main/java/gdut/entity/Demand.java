package gdut.entity;

import java.sql.Date;

public class Demand {
    public int re_id;
    public String re_msg;
    public Date re_date;
    public int user_id;

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public String getRe_msg() {
        return re_msg;
    }

    public void setRe_msg(String re_msg) {
        this.re_msg = re_msg;
    }

    public Date getRe_date() {
        return re_date;
    }

    public void setRe_date(Date re_date) {
        this.re_date = re_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
