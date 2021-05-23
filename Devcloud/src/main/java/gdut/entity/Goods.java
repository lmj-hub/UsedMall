package gdut.entity;

public class Goods {
    public int goods_id;
    public String goods_name;
    public double goods_price;
    public int goods_num;
    public String goods_imgurl;
    public String goods_desp;
    public String goods_type;
    public String goods_cdate;

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public String getGoods_imgurl() {
        return goods_imgurl;
    }

    public void setGoods_imgurl(String goods_imgurl) {
        this.goods_imgurl = goods_imgurl;
    }

    public String getGoods_desp() {
        return goods_desp;
    }

    public void setGoods_desp(String goods_desp) {
        this.goods_desp = goods_desp;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getGoods_cdate() {
        return goods_cdate;
    }

    public void setGoods_cdate(String goods_cdate) {
        this.goods_cdate = goods_cdate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price=" + goods_price +
                ", goods_num=" + goods_num +
                ", goods_imgurl='" + goods_imgurl + '\'' +
                ", goods_desp='" + goods_desp + '\'' +
                ", goods_type='" + goods_type + '\'' +
                ", goods_cdate='" + goods_cdate + '\'' +
                '}';
    }
}
