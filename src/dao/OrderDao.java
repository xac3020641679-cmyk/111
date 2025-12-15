package dao;

import domain.Foodtj;
import domain.Order;
import domain.Orderitem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface OrderDao {
    List<Order> findallorder();

    void delorder(String ordernumber);

    Orderitem huixianorder(String id);

    void updateorderitemnumber(String id, String number);


    List<Orderitem> updateorderitem(String ordernumber);

    void updateordertotalmoney(int totalmoney, String ordernumber);

    void delorderitem(String id);

    List<Orderitem> findtodayorder();

    List<Order> findtodayordertotal();



//    统计指定时间的订单
List<Orderitem> findrangetime(Timestamp starttime, Timestamp endtime);



//找到订单中出现过的菜名
List<Orderitem> findordernameweiyi2(Timestamp starttime, Timestamp endtime);

    List<Orderitem> findteshu(String menuname,String money,Timestamp starttime, Timestamp endtime);

    void delitemorder(String ordernumber);

    List<Order> finduserorder(Timestamp starttimein, Timestamp orderlistTime, String username);

    List<Orderitem> findmyordertj(String ordernumber);

    List<Orderitem> distinctorder(Timestamp todaystart, Timestamp todayend);

    List<Orderitem> distinctjrzkdd(Timestamp todaystart, Timestamp todayend);

    List<Orderitem> finddistinctjrzkdd(int menunumber, String menuname, String money, Timestamp todaystart, Timestamp todayend);

    List<Orderitem> finddistinct(int menunumber, String menuname, Timestamp todaystart, Timestamp todayend);

    List<Orderitem> findpcytodayorder(Timestamp todaystart, Timestamp todayend);
}
