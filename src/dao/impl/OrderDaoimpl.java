package dao.impl;

import dao.OrderDao;
import domain.Caidanlist;
import domain.Foodtj;
import domain.Order;
import domain.Orderitem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoimpl implements OrderDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Order> findallorder() {
        String sql = "select * from orderfrom ";
        List<Order> order = template.query(sql,new BeanPropertyRowMapper<Order>(Order.class));
        return order;
    }

    @Override
    public void delorder(String ordernumber) {
        String sql = "delete from orderfrom where ordernumber = ?";

        template.update(sql,ordernumber);
    }

    @Override
    public void delitemorder(String ordernumber) {
        String sql = "delete from orderitem where ordernumber = ?";

        template.update(sql,ordernumber);
    }

//    查找我的个人月度统计


    @Override
    public List<Order> finduserorder(Timestamp starttimein, Timestamp orderlistTime, String username) {
        String sql = "select * from orderfrom where  date> ? and date < ? and username = ? ";
        List<Order> orderitems = template.query(sql,new BeanPropertyRowMapper<Order>(Order.class),starttimein,orderlistTime,username);
        return orderitems;
    }

    @Override
    public List<Orderitem> findmyordertj(String ordernumber) {
        String sql = "select * from orderitem where  ordernumber = ? ";
        List<Orderitem> orderitems = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),ordernumber);
        return orderitems;
    }

    @Override
    public List<Orderitem> distinctorder(Timestamp todaystart, Timestamp todayend) {
        String sql = "  select DISTINCT menunumber,menuname from orderitem where  date> ? and date < ? ";
        List<Orderitem> orders = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),todaystart,todayend);
        return orders;
    }
    @Override
    public List<Orderitem> finddistinct(int menunumber, String menuname, Timestamp todaystart, Timestamp todayend) {
            String sql = "select * from orderitem where menunumber = ? and menuname = ? and date> ? and date < ?";
    List<Orderitem> orderitems = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),menunumber,menuname,todaystart,todayend);
        return orderitems;
    }

    @Override
    public List<Orderitem> findpcytodayorder(Timestamp todaystart, Timestamp todayend) {
        String sql = "select * from orderitem where date> ? and date < ?";
        List<Orderitem> orderitems = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),todaystart,todayend);
        return orderitems;
    }


    @Override
    public List<Orderitem> distinctjrzkdd(Timestamp todaystart, Timestamp todayend) {
        String sql = "  select DISTINCT menunumber,menuname,money from orderitem where  date> ? and date < ? ";
        List<Orderitem> orders = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),todaystart,todayend);
        return orders;
    }

    @Override
    public List<Orderitem> finddistinctjrzkdd(int menunumber, String menuname, String money, Timestamp todaystart, Timestamp todayend) {

    String sql = "select * from orderitem where menunumber = ? and menuname = ? and money = ? and date> ? and date < ? ";
    List<Orderitem> orderitems = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),menunumber,menuname,money,todaystart,todayend);
        return orderitems;
    }




    @Override
    public Orderitem huixianorder(String id) {
        String sql = "select * from orderitem where id = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),id);
    }

    @Override
    public void updateorderitemnumber(String id, String number) {
        String sql = "update orderitem set number = ? where id = ?";

        template.update(sql,Integer.parseInt(number),id);
    }

    @Override
    public List<Orderitem> updateorderitem(String ordernumber) {
        String sql = "select * from orderitem where ordernumber = ?";
        List<Orderitem> orderitems = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),ordernumber);
        return orderitems;
    }

    @Override
    public void updateordertotalmoney(int totalmoney, String ordernumber) {
        String sql = "update orderfrom set totalmoney = ? where ordernumber = ?";

        template.update(sql,totalmoney,ordernumber);
    }

    @Override
    public void delorderitem(String id) {
        String sql = "delete from orderitem where id = ?";

        template.update(sql,Integer.parseInt(id));
    }

    @Override
    public List<Orderitem> findtodayorder() {
        String sql = "select * from orderitem ";
        List<Orderitem> orderitems = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class));
        return orderitems;
    }

    @Override
    public List<Order> findtodayordertotal() {
        String sql = "select * from orderfrom ";
        List<Order> orders = template.query(sql,new BeanPropertyRowMapper<Order>(Order.class));
        return orders;
    }

    @Override
    public List<Orderitem> findrangetime(Timestamp starttime, Timestamp endtime) {
        String sql = "select * from orderitem where  date> ? and date < ? ";
        List<Orderitem> orderitems = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),starttime,endtime);
        return orderitems;
    }

    @Override
    public List<Orderitem> findordernameweiyi2(Timestamp starttime, Timestamp endtime) {
        String sql = "  select DISTINCT menuname,money from orderitem where  date> ? and date < ? ";
        List<Orderitem> orders = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),starttime,endtime);
        return orders;
    }

    @Override
    public List<Orderitem> findteshu(String menuname,String money,Timestamp starttime, Timestamp endtime) {
        String sql = "select * from orderitem where ( menuname = ? and money = ?)and (date> ? and date < ?)";
        List<Orderitem> orderitems = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),menuname,money,starttime,endtime);
        return orderitems;
    }




}
