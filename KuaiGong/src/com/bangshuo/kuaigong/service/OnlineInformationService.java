package com.bangshuo.kuaigong.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.OnlineInformationMapper;
import com.bangshuo.kuaigong.po.EmployeeUserOnlineInfo;
import com.bangshuo.kuaigong.po.OnlineDetailInfo;
import com.bangshuo.kuaigong.po.OnlineInformation;

public class OnlineInformationService {
	
	@Autowired
	OnlineInformationMapper onlineInformationMapper;
	
public OnlineInformation selectNum(String name,String status,String starttime,String endtime){
		
	OnlineInformation list = onlineInformationMapper.selectNum(name, status, starttime, endtime);
	
	return list;
	}

 public 	List<OnlineInformation> timeCount (String name,String status,String starttime,String endtime){
	 
		List<OnlineInformation> list = onlineInformationMapper.timeCount(status, name, starttime, endtime);
	 
	 return list;
 }

	public List<OnlineInformation> queryDate77(String starttime, String endtime, int id) {
		List<OnlineInformation> list=onlineInformationMapper.queryDate77(starttime,endtime,id);
		return list;
	}
	public List<OnlineInformation> queryDatePaGe77(String starttime, String endtime,
			int page, int pageSize, int id) {
		List<OnlineInformation> list=onlineInformationMapper.queryDatePaGe77(starttime,endtime,id,page,pageSize);
		return list;
	}
	
	public List<OnlineInformation> selectById(int id){
		
	List<OnlineInformation> list=onlineInformationMapper.selectById(id);
	return list;
	}
//public List<OnlineInformation> selectPage1(){
//		
//		List<OnlineInformation> list=onlineInformationMapper.selectAll();
//	
//		return list;
//	
//	}
	 
	public  List<OnlineInformation> selectByPage1(String username, int page,int pageSize){
	
		List<OnlineInformation> list=onlineInformationMapper.selectByPage(username,page, pageSize);
		return list;
	
	}
	
	
	
	
	
	
	
	

public List<OnlineInformation> queryAll(String username){
				List<OnlineInformation> list=onlineInformationMapper.selectAll(username);
				return list;
			}

			
public int insertSelective(OnlineInformation onlineInformation){
				
				int list = onlineInformationMapper.insertSelective(onlineInformation);
				
			   return list;
			
            }
            
public int insert(OnlineInformation onlineInformation){
				
				int list = onlineInformationMapper.insert(onlineInformation);
				
				return list;
			}
			
public int updateByPrimaryKey(OnlineInformation onlineInformation){
				
				int list =onlineInformationMapper.updateByPrimaryKey(onlineInformation);
				
				return list;
			}
			
public int updateByPrimaryKeySelective(OnlineInformation onlineInformation){
				
				int list =onlineInformationMapper.updateByPrimaryKeySelective(onlineInformation);
				
				return list;
			}
			
public int  deleteByPrimaryKey(int id){
				
				int list =onlineInformationMapper.deleteByPrimaryKey(id);
				
				return list ;
			}
//��ģ���ѯ��ҳ
public List<OnlineInformation> selectByStartimeOrEndtime2(String name){
	 
	List<OnlineInformation> list = onlineInformationMapper.selectByStartimeOrEndtime(name);
	
	return list;
	
}
//ģ���ѯ��ҳ
public List<OnlineInformation> selectByStartimeOrEndtime1(String query){
  	 
	List<OnlineInformation> list = onlineInformationMapper.selectByStartimeOrEndtime(query);
	
	return list;
	
}
public List<OnlineInformation> selectByStartimeOrEndtimePage(int page,
		int pageSize, String name) {
	
	List<OnlineInformation> list = onlineInformationMapper.selectByStartimeOrEndtimePage(page,pageSize,name);
return list;
}
public List<OnlineInformation> queryInfomation1(String query) {
	List<OnlineInformation> list = onlineInformationMapper. queryInfomation1(query);
	
	return list;
}
public List<OnlineInformation> queryInfomation1PaGe(int page, int pageSize,String name) {
	List<OnlineInformation> list = onlineInformationMapper.queryInfomation1PaGe(page,pageSize,name);
	return list;
}
public  List<OnlineInformation> selectstatus(String status, String name, String starttime, String endtime){
	
	List<OnlineInformation> list=onlineInformationMapper.selectstatus(status,name,starttime,endtime);
	
	return list;
}

public  List<OnlineInformation> selectstatusPage(int page,int pageSize,String status, String name, String starttime, String endtime){
	
	List<OnlineInformation> list=onlineInformationMapper.selectstatusPage(page, pageSize, status,name,starttime,endtime);

	return list;
}
public List<OnlineInformation> selectstatusPage1(int page, int pageSize,
		String status) {
	List<OnlineInformation> list=onlineInformationMapper.selectstatusPage1(page, pageSize, status);
	return list;
}
public List<OnlineInformation> selectstatus1(String status) {
List<OnlineInformation> list=onlineInformationMapper.selectstatus1(status);
	
	return list;
}
public List<OnlineInformation> selectstatusPage2(int page, int pageSize,
		String status) {
	List<OnlineInformation> list=onlineInformationMapper.selectstatusPage1(page, pageSize, status);
	return list;
}
public List<OnlineInformation> selectstatus2(String status) {
List<OnlineInformation> list=onlineInformationMapper.selectstatus1(status);
	
	return list;
}
public List<OnlineInformation> queryInfomation8(String id, String query) {
	List<OnlineInformation> list=onlineInformationMapper.queryInfomation8(id,query);
	return list;
}
public List<OnlineInformation> queryInfomation8PaGe(int page, int pageSize,
		String id, String query) {
	List<OnlineInformation> list=onlineInformationMapper.queryInfomation8PaGe(page,pageSize,id,query);
	return list;
}
public List<OnlineInformation> queryInfomationByTime(String starttime,
		String endtime, String btu) {
	List<OnlineInformation> list=onlineInformationMapper.queryInfomationByTime(starttime,endtime,btu);
	return list;
}
public List<OnlineInformation> queryInfomationByTimePage(String starttime,
		String endtime, String btu, int page, int pageSize) {
	List<OnlineInformation> list=onlineInformationMapper.queryInfomationByTimePage(starttime,endtime,btu, page,pageSize);
	return list;
}
public List<OnlineInformation> queryInfomation886(String query, String id,
		String starttime, String endtime) {
	List<OnlineInformation> list=onlineInformationMapper.queryInfomation886(query,id,starttime,endtime);
	return list;
}
public List<OnlineInformation> queryInfomation886PaGe(
		String query, String id, String starttime, String endtime,int page, int pageSize) {
	List<OnlineInformation> list=onlineInformationMapper.queryInfomation886PaGe(query,id,starttime,endtime,page,pageSize);
	return list;
}


/*李奎写的代码*/
public List<OnlineInformation> selectOnlineInformationByTime(String starttime, String endtime, String name, String btu) {
	List<OnlineInformation> list = onlineInformationMapper
			.selectOnlineInformationByTime(starttime, endtime,name,btu);
	return list;
}
	
//===================kw=========================
	/*
	 * Total
	 */
	public List<EmployeeUserOnlineInfo> queryTotalOnlineInfoPage(@Param("name") String name){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryTotalOnlineInfoPage(name);
		return list;
	}

	public List<EmployeeUserOnlineInfo> queryTotalOnlineInfo(@Param("name") String name, @Param("sort") String sort,@Param("page") int page, @Param("pageSize") int pageSize) {
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryTotalOnlineInfo(name,sort,page,pageSize);
		return list;
	}
	/*
	 * Year
	 */
	public List<EmployeeUserOnlineInfo> queryYearOnlineInfoPage(@Param("name") String name){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryYearOnlineInfoPage(name);
		return list;
	}
	public List<EmployeeUserOnlineInfo> queryYearOnlineInfo(
			@Param("name") String name,@Param("sort") String sort,
			@Param("page") int page,@Param("pageSize") int pageSize){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryYearOnlineInfo(name,sort,page,pageSize);
		return list;
	}
	/*
	 * Month
	 */
	public List<EmployeeUserOnlineInfo> queryMonthOnlineInfoPage(@Param("name") String name){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryMonthOnlineInfoPage(name);
		return list;
	}
	public List<EmployeeUserOnlineInfo> queryMonthOnlineInfo(
			@Param("name") String name,@Param("sort") String sort,
			@Param("page") int page,@Param("pageSize") int pageSize){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryMonthOnlineInfo(name,sort,page,pageSize);
		return list;
	}
	/*
	 * Week
	 */
	public List<EmployeeUserOnlineInfo> queryWeekOnlineInfoPage(@Param("name") String name){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryWeekOnlineInfoPage(name);
		return list;
	}
	public List<EmployeeUserOnlineInfo> queryWeekOnlineInfo(
			@Param("name") String name,@Param("sort") String sort,
			@Param("page") int page,@Param("pageSize") int pageSize){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryWeekOnlineInfo(name,sort,page,pageSize);
		return list;
	}
	/*
	 * Yesterday
	 */
	public List<EmployeeUserOnlineInfo> queryYesterdayOnlineInfoPage(@Param("name") String name){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryYesterdayOnlineInfoPage(name);
		return list;
	}
	public List<EmployeeUserOnlineInfo> queryYesterdayOnlineInfo(
			@Param("name") String name,@Param("sort") String sort,
			@Param("page") int page,@Param("pageSize") int pageSize){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryYesterdayOnlineInfo(name,sort,page,pageSize);
		return list;
	}
	/*
	 * Today
	 */
	public List<EmployeeUserOnlineInfo> queryTodayOnlineInfoPage(@Param("name") String name){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryTodayOnlineInfoPage(name);
		return list;
	}
	public List<EmployeeUserOnlineInfo> queryTodayOnlineInfo(
			@Param("name") String name,@Param("sort") String sort,
			@Param("page") int page,@Param("pageSize") int pageSize){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryTodayOnlineInfo(name,sort,page,pageSize);
		return list;
	}
	
	public List<EmployeeUserOnlineInfo> queryTimeSlotOnlineInfo(
			@Param("start") String start, @Param("end") String end,
			@Param("name") String name, @Param("sort") String sort,
			@Param("page") int page, @Param("pageSize") int pageSize){
		List<EmployeeUserOnlineInfo> list = onlineInformationMapper.queryTimeSlotOnlineInfo(start,end,name,sort,page,pageSize);
		return list;
	}
	
	public OnlineDetailInfo queryTotalOnlineDetailInfo(int eeid){
		OnlineDetailInfo result = onlineInformationMapper.queryTotalOnlineDetailInfo(eeid);
		return result;
	}
	
	public List<OnlineInformation> queryNearlyAWeekOnlineDetailInfo(int eeid){
		List<OnlineInformation> list = onlineInformationMapper.queryNearlyAWeekOnlineDetailInfo(eeid);
		return list;
	}
	public List<OnlineInformation> queryNearlyAWeekWorkDetailInfo(int eeid){
		List<OnlineInformation> list = onlineInformationMapper.queryNearlyAWeekWorkDetailInfo(eeid);
		return list;
	}
	//===================kw=========================
	//===================kw=========================

		public int updateOnlineStatusByEeid(int eeid){
			int result = onlineInformationMapper.updateOnlineStatusByEeid(eeid);
			return result;
		}

		public List<OnlineInformation> selectOnlineInformationByTimeInfo(
				String yesterday, String now, String name,String btu,int page, int pageSize) {
			List<OnlineInformation> list = onlineInformationMapper.selectOnlineInformationByTimeInfo(yesterday,now,name,btu,page,pageSize);
			return list;
		}

		public List<OnlineInformation> selectstatusSort(String btu,String name, String starttime, String endtime) {
			List<OnlineInformation> list = onlineInformationMapper.selectstatusSort(btu,name,starttime,endtime);
			return list;
		}

		public List<OnlineInformation> selectstatusPageInfo(int page,int pageSize, String btu, String name, String starttime,String endtime) {
			List<OnlineInformation> list = onlineInformationMapper.selectstatusPageInfo(page,pageSize,btu,name,starttime,endtime);
			return list;
		}

		public OnlineInformation updateOnline(int id, String online) {
		OnlineInformation updateOnline=onlineInformationMapper.updateOnline(id,online);
			return updateOnline;
		}

		public OnlineInformation updateOnlineInfomation(int id) {
			OnlineInformation updateOnline=onlineInformationMapper.updateOnlineInfomation(id);
			return updateOnline;
		}

}