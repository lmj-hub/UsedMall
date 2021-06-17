package gdut.entity;

import java.util.List;

public class PageBean<T> {
    private int pc;//当前页面的页码数   由jsp传来
    private int ps;//当前页面的数据条数   自己定义
    private int all;//数据库总的数据条数
    private String url;//页面的路径
    private List<T> beanlist;


    public int getTp(){
        int tp = all/ps;
        return all%ps == 0 ? tp :tp+1;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<T> getBeanlist() {
        return beanlist;
    }

    public void setBeanlist(List<T> beanlist) {
        this.beanlist = beanlist;
    }
}

