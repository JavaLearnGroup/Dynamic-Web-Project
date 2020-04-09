package com.nf.service;
import java.util.List;

import com.nf.dao.LoveInHeartDao;
import com.nf.dao.LoveInHeartDaoImpl;
import com.nf.entity.LoveInHeart;
//import com.nf.entity.MyData;
//import com.nf.util.MyPage;
public class LoveInHeartServiceImpl implements LoveInHeartService {

    private LoveInHeartDao loveDao = new LoveInHeartDaoImpl();

    public MyData getAll(int currentPage) {
        MyData md=null;
        /**
        MyPage myPage = new MyPage();
        myPage.setCurrentPage(currentPage);
        //myPage.setRecodeCount( 0  );//让Dao层来计算
        myPage.setPerPageSize( 10 );//设置每页10条
        List<LoveInHeart> loveList = loveDao.getAll( myPage  );
        MyData myData = new MyData();
        myData.setLoveInHeartList(loveList);
        myData.setMyPage(myPage);
        return myData;
         */
        return md;
    }

    @Override
    public boolean add(LoveInHeart love) {
        return loveDao.add(love);

    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return loveDao.delete(id);
    }
}
