package com.nf.service;
import java.util.List;
import com.nf.entity.LoveInHeart;
//import com.nf.entity.MyData;
public interface LoveInHeartService {
 //   public MyData getAll(int currentPage);
    public boolean add(LoveInHeart love);
    public boolean delete(int id);
}
