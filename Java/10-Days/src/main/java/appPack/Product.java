package appPack;

public class Product {

    private int pid;
    private int cid;
    private String title;
    private String detail;
    private int price;
    private String catTitle;

    public Product(int pid, int cid, String title, String detail, int price, String catTitle) {
        this.pid = pid;
        this.cid = cid;
        this.title = title;
        this.detail = detail;
        this.price = price;
        this.catTitle = catTitle;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", cid=" + cid +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", catTitle='" + catTitle + '\'' +
                '}';
    }
}
