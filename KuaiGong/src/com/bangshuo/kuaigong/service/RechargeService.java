package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.rechargeMapper;
import com.bangshuo.kuaigong.po.recharge;

public class RechargeService {
@Autowired
rechargeMapper rechargemapper;
//查询充值记录
public List<recharge> select(int id){
List<recharge>	list=rechargemapper.select(id);
 return list;
}
//查询充值记录分页
public List<recharge> selectPage(int id,int page,int pageSize){
List<recharge>	list=rechargemapper.selectpage(page, pageSize, id);
return list;
}

//充值
public int selectSum(int id){
int list=rechargemapper.selectSum(id);
return list;
}


/*李奎写的代码*/
public List<recharge> selectRechargeByTime(String starttime,String endtime) {
	List<recharge> list = rechargemapper.selectRechargeByTime(starttime, endtime);
	return list;
}

}
