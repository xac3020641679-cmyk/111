package domain;

public class Recipe {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenunumber() {
        return menunumber;
    }

    public void setMenunumber(int menunumber) {
        this.menunumber = menunumber;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenupicture() {
        return menupicture;
    }

    public void setMenupicture(String menupicture) {
        this.menupicture = menupicture;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", menunumber=" + menunumber +
                ", menuname='" + menuname + '\'' +
                ", menupicture='" + menupicture + '\'' +
                ", kind='" + kind + '\'' +
                ", unit='" + unit + '\'' +
                ", money='" + money + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    private int id;
    private int menunumber;
    private String menuname;
    private String menupicture;
    private String kind;
    private String unit;
    private String money;
    private String remarks;
}
