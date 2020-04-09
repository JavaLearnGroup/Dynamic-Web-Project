package com.nf.dao;
import java.util.List;
import com.nf.entity.LoveInHeart;
//import com.nf.util.MyPage;
public interface LoveInHeartDao {

    //public List<LoveInHeart> getAll(MyPage myPage);
    public boolean add(LoveInHeart love);
    public boolean delete(int id);

}
