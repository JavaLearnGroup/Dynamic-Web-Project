package com.nf.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.nf.entity.LoveInHeart;
//import com.nf.util.MyPage;
public class LoveInHeartDaoImpl extends BaseDao implements LoveInHeartDao {
    /**
    @Override  //查询
    public List<LoveInHeart> getAll(MyPage myPage) {
        // 操作数据库，需要一个连接Connection
        Connection connection = getConnection();
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        List<LoveInHeart> loveInHeartList = new ArrayList();

        String sql_data = "select * from loveinheart order by lid desc ";
        String sql_recodeCount = "select count(1) as mycount from loveinheart";

        sql_data += "limit ";
        sql_data += (myPage.getCurrentPage()-1)*myPage.getPerPageSize();
        sql_data += ",";
        sql_data += myPage.getPerPageSize();

        System.out.println("分页的SQL:"+sql_data);

        try {

            prepareStatement = connection.prepareStatement(sql_data);
            resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                LoveInHeart l = new LoveInHeart();
                l.setId(resultSet.getInt("id"));
                l.setName(resultSet.getString("name"));
                l.setSex(resultSet.getString("sex"));
                l.setTime(resultSet.getDate("time"));
                l.setMoney(resultSet.getInt("money"));
                loveInHeartList.add(l);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        try {
            prepareStatement = connection.prepareStatement(sql_recodeCount);
            resultSet = prepareStatement.executeQuery();
            resultSet.next();
            myPage.setRecodeCount( resultSet.getInt("mycount") );
        } catch (SQLException e) {

            e.printStackTrace();
        }


        closeAll(connection, prepareStatement, resultSet);

        // System.out.println(connection);
        return loveInHeartList;
    }
*/
    @Override   //添加
    public boolean add(LoveInHeart love) {
        // 操作数据库，需要一个连接Connection
        Connection connection = getConnection();
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection
                    .prepareStatement("insert into LoveInHeart(lname,lsex,ltime,lmoney) values (?,?,?,?)");
            prepareStatement.setString(1, love.getName());
            prepareStatement.setString(2, love.getSex());
            prepareStatement.setDate(3, love.getTime());
            prepareStatement.setFloat(4, love.getMoney());
            prepareStatement.executeUpdate();

            closeAll(connection, prepareStatement, null);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override    //删除
    public boolean delete(int id) {
        // 操作数据库，需要一个连接Connection
        Connection connection = getConnection();
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection
                    .prepareStatement("delete from LoveInHeart where lid=?");
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();

            closeAll(connection, prepareStatement, null);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
