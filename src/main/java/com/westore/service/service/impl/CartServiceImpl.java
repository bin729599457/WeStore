package com.westore.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.CartDAO;
import com.westore.dao.CommonDAO;
import com.westore.model.T_B_Cart;
import com.westore.service.CartService;
import com.westore.service.RedisService;
import com.westore.utils.CommonUtils;
import com.westore.utils.CustomUUID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("cartService")
public class CartServiceImpl implements CartService {

    @Resource
    private RedisService redisService;

    @Resource
    private CartDAO cartDAO;

    @Resource
    private CommonDAO commonDAO;

    public PageInfo<T_B_Cart> findUserCart(String trd_session, String pageNum, String pageSize) {
        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return null;
        }
        else {
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            PageInfo<T_B_Cart> p_list = new PageInfo<T_B_Cart>(cartDAO.findUserCart(openid));
            return p_list;
        }
    }


    public int insertUserCart(String trd_session, T_B_Cart cart) {
        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return 0;
        }
        else {
            cart.setUser_id(openid);
            T_B_Cart cartDB = cartDAO.ifExist(openid,cart.getGoods().getId());
            int num =0;
            if(cartDB == null){
                cart.setId(CustomUUID.getFlowIdWorkerInstance().generate());
                commonDAO.add(CommonUtils.add(cart));
                num = cart.getNum();
            }else {
                cartDAO.updateUserCart(openid,cart.getGoods().getId(),cart.getNum());
                num = cartDB.getNum() + cart.getNum();
            }
            return num;
        }
    }


    public String deleteUserCart(String trd_session, T_B_Cart cart) {
        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return null;
        }
        else {
            String sql = CommonUtils.delete(cart);
            commonDAO.delete(sql);
            return "success";
        }
    }

    public int getTotal(String trd_session) {
        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return 0;
        }
        else {
            int result = cartDAO.getTotal(openid);
            return result;
        }
    }
}
