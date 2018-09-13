package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.EmployeeUserOnlineInfo;
import com.bangshuo.kuaigong.po.OnlineDetailInfo;
import com.bangshuo.kuaigong.po.OnlineInformation;

public interface OnlineInformationMapper {
	
	OnlineInformation selectNum(@Param("name")String name,@Param("status")String status,@Param("starttime")String starttime,@Param("endtime")String endtime);
	
	//查时间总数
	List<OnlineInformation> timeCount(@Param("status")String status,@Param("name")String name,@Param("starttime")String starttime,@Param("endtime")String endtime);
			
	
    int deleteByPrimaryKey(Integer id);

    int insert(OnlineInformation record);

    int insertSelective(OnlineInformation record);
    
    List<OnlineInformation>selectByPrimaryKey(OnlineInformation onlineInformation);
    

    List<OnlineInformation> selectById(int id);
    
    int updateByPrimaryKeySelective(OnlineInformation record);

    int updateByPrimaryKey(OnlineInformation onlineInformation);
       
    List<OnlineInformation> selectAll(@Param("username") String username);
      
    List<OnlineInformation> selectByPage(@Param("username") String username,@Param("page") int page,@Param("pageSize") int pageSize);

	List<OnlineInformation> selectByStartimeOrEndtimePage(@Param("page") int page,@Param("pageSize")int pageSize,@Param("name") String name);
   //ģ���ѯ��ҳ
	List<OnlineInformation> selectByStartimeOrEndtime(@Param("name") String name);
	
	List<OnlineInformation> selectByStartimeOrEndtime2(@Param("name") String name);

	List<OnlineInformation> selectByStartimeOrEndtime1(String query);

	List<OnlineInformation> queryInfomation1(@Param("name") String name);

	List<OnlineInformation> queryInfomation1PaGe(@Param("page") int page,@Param("pageSize") int pageSize,@Param("name") String name);

	//���״̬��ѯ
		List<OnlineInformation>selectstatus(@Param("status")String status, @Param("name") String name, @Param("starttime") String starttime,  @Param("endtime") String endtime);
		//���״̬��ѯ��ҳ
		List<OnlineInformation>selectstatusPage(@Param("page")int page,@Param("pageSize")int pageSize,@Param("status")String status,@Param("name") String name,@Param("starttime") String starttime,  @Param("endtime") String endtime);
		
		List<OnlineInformation> selectstatusPage1(@Param("page")int page,@Param("pageSize")int pageSize,@Param("status")String status);

		List<OnlineInformation> selectstatus1(String status);
		List<OnlineInformation> selectstatusPage2(@Param("page")int page,@Param("pageSize")int pageSize,@Param("status")String status);

		List<OnlineInformation> selectstatus2(String status);

		List<OnlineInformation> queryInfomation8(@Param("status") String status,@Param("name")String name);

		List<OnlineInformation> queryInfomation8PaGe(@Param("page")int page,@Param("pageSize")int pageSize,@Param("status") String status,@Param("name")String name);

		List<OnlineInformation> queryDate77(@Param("starttime") String starttime, @Param("endtime") String endtime, @Param("id") int id);
		List<OnlineInformation> queryDatePaGe77(@Param("starttime") String starttime, @Param("endtime") String endtime, @Param("id") int id
				,@Param("page") int page,@Param("pageSize") int pageSize);

		List<OnlineInformation> queryInfomationByTime(@Param("starttime") String starttime, @Param("endtime") String endtime, @Param("status") String status);

		List<OnlineInformation> queryInfomationByTimePage(@Param("starttime") String starttime, @Param("endtime") String endtime, @Param("status") String status,@Param("page") int page, @Param("pageSize") int pageSize);

		List<OnlineInformation> queryInfomation886(@Param("status") String status,@Param("name") String name,
				@Param("starttime") String starttime, @Param("endtime") String endtime);

		List<OnlineInformation> queryInfomation886PaGe(@Param("status") String status,@Param("name") String name,
				@Param("starttime") String starttime, @Param("endtime") String endtime,@Param("page")int page,@Param("pageSize")int pageSize);

		/*李奎写的代码*/
		List<OnlineInformation> selectOnlineInformationByTime(@Param("yesterday") String yesterday,
				@Param("now") String now,@Param("name") String name,@Param("btu") String btu);
		
		List<EmployeeUserOnlineInfo> queryTotalOnlineInfoPage(@Param("name") String name);
		
		List<EmployeeUserOnlineInfo> queryTotalOnlineInfo(@Param("name") String name,@Param("sort") String sort,@Param("page") int page,@Param("pageSize") int pageSize);

		List<EmployeeUserOnlineInfo> queryYearOnlineInfoPage(@Param("name") String name);
		
		List<EmployeeUserOnlineInfo> queryYearOnlineInfo(@Param("name") String name,@Param("sort") String sort,@Param("page") int page,@Param("pageSize") int pageSize);

		List<EmployeeUserOnlineInfo> queryMonthOnlineInfoPage(@Param("name") String name);
		
		List<EmployeeUserOnlineInfo> queryMonthOnlineInfo(@Param("name") String name,@Param("sort") String sort,@Param("page") int page,@Param("pageSize") int pageSize);

		List<EmployeeUserOnlineInfo> queryWeekOnlineInfoPage(@Param("name") String name);
		
		List<EmployeeUserOnlineInfo> queryWeekOnlineInfo(@Param("name") String name,@Param("sort") String sort,@Param("page") int page,@Param("pageSize") int pageSize);

		List<EmployeeUserOnlineInfo> queryYesterdayOnlineInfoPage(@Param("name") String name);
		
		List<EmployeeUserOnlineInfo> queryYesterdayOnlineInfo(@Param("name") String name,@Param("sort") String sort,@Param("page") int page,@Param("pageSize") int pageSize);

		List<EmployeeUserOnlineInfo> queryTodayOnlineInfoPage(@Param("name") String name);
		
		List<EmployeeUserOnlineInfo> queryTodayOnlineInfo(@Param("name") String name,@Param("sort") String sort,@Param("page") int page,@Param("pageSize") int pageSize);

		List<EmployeeUserOnlineInfo> queryTimeSlotOnlineInfo(@Param("start") String start,@Param("end") String end,@Param("name") String name,@Param("sort") String sort,@Param("page") int page,@Param("pageSize") int pageSize);

		OnlineDetailInfo queryTotalOnlineDetailInfo(int eeid);
		
		List<OnlineInformation> queryNearlyAWeekOnlineDetailInfo(int eeid); 
		
		List<OnlineInformation> queryNearlyAWeekWorkDetailInfo(int eeid); 
		
	//=============KW===============
		
		int updateOnlineStatusByEeid(int eeid);

		List<OnlineInformation> selectOnlineInformationByTimeInfo(@Param("yesterday")
				String yesterday, @Param("now")String now,@Param("name") String name,@Param("btu") String btu, @Param("page")int page,@Param("pageSize") int pageSize);

		List<OnlineInformation> selectstatusSort(@Param("status") String status,@Param("name") String name,@Param("starttime")  String starttime,@Param("endtime") String endtime);

		List<OnlineInformation> selectstatusPageInfo(@Param("page") int page,@Param("pageSize") int pageSize,@Param("status") String status,@Param("name") String name,@Param("starttime") String starttime,@Param("endtime") String endtime);

		OnlineInformation updateOnline(@Param("eeid") int eeid,@Param("online") String online);

		OnlineInformation updateOnlineInfomation(int id);


}