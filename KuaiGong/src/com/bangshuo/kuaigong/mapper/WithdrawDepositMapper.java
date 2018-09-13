package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.bangshuo.kuaigong.po.WithdrawDeposit;

public interface WithdrawDepositMapper {
	//查询提现条数
	WithdrawDeposit selectNum(@Param("query")String query,@Param("btu1")String btu1,@Param("btu2")String btu2,@Param("starttime")String starttime,@Param("endtime")String endtime);
	
	List<WithdrawDeposit> queryTime(String Starttime,String endTime);
    int deleteByPrimaryKey(Integer id);
    
 List<WithdrawDeposit>selectByPrimaryKey(WithdrawDeposit withdrawDeposit);
    
    List<WithdrawDeposit>selectByBalance(String name);
    //查询提现
    List<WithdrawDeposit> selectAll(@Param("query") String query,@Param("starttime") String starttime, @Param("endtime")String endtime,@Param("btu1") String btu1, @Param("btu2") String btu2);
    //查询提现分页
    List<WithdrawDeposit> selectByPage(@Param("query") String query,@Param("starttime") String starttime, @Param("endtime") String endtime, @Param("page") int page,@Param("pageSize") int pageSize,@Param("btu1") String btu1, @Param("btu2") String btu2);
	
    WithdrawDeposit selectByPrimaryKey(Integer id);
        List<WithdrawDeposit> selectPage();
    List<WithdrawDeposit> queryWithdraw(@Param("name") String name);
	List<WithdrawDeposit> queryWithdrawPaGe(@Param("page") int page,@Param("pageSize") int pageSize, @Param("name") String name);
	List<WithdrawDeposit> queryByTime6(@Param("starttime") String starttime,@Param("endtime") String endtime);
	List<WithdrawDeposit> queryByTime6Page(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("page") int page,@Param("pageSize") int pageSize);
	
	List<WithdrawDeposit> selectByTime6(@Param("starttime") String starttime,@Param("endtime") String endtime, @Param("name") String name);
	List<WithdrawDeposit> selectByTime6Page(@Param("starttime") String starttime,@Param("endtime") String endtime, @Param("name") String name,@Param("page") int page,@Param("pageSize") int pageSize);
	List<WithdrawDeposit> queryAllShouYi(@Param("desc") String desc,@Param("query") String query,@Param("starttime") String starttime, @Param("endtime") String endtime);
	List<WithdrawDeposit> selectByPageShouYi(@Param("desc") String desc,@Param("query") String query,@Param("starttime") String starttime, @Param("endtime") String endtime,@Param("page") int page,@Param("pageSize") int pageSize);
	List<WithdrawDeposit> queryWithdrawTimeMoHuchaxun(@Param("name") String name,@Param("desc") String desc);
	List<WithdrawDeposit> queryWithdrawPaGeTimeMoHuchaxun(@Param("name") String name,@Param("desc") String desc, @Param("page") int page,@Param("pageSize") int pageSize);
	List<WithdrawDeposit> queryByTime6ShouYi(@Param("starttime") String starttime,@Param("endtime") String endtime,
			@Param("desc") String desc);
	List<WithdrawDeposit> queryByTime6PageShouYi(@Param("starttime") String starttime,@Param("endtime") String endtime,
			@Param("desc") String desc,  @Param("page") int page,@Param("pageSize") int pageSize);

	//查询全部收益
	WithdrawDeposit queryEarningsAll();
	//收益
	List<WithdrawDeposit>selectIncome(@Param("name")String name,@Param("starttime")String starttime,@Param("endtime")String endtime);
	
		WithdrawDeposit queryusername(@Param("queryusername") String queryusername,@Param("starttime")String starttime,@Param("endtime")String endtime,@Param("btu1") String btu1,@Param("btu2") String btu2);
	//查询收益和工资到账分页
	List<WithdrawDeposit> selectByStatus(@Param("btu1") String btu1, @Param("btu2") String btu2);
	//查询收益和工资到账
	List<WithdrawDeposit> selectByPageStatus(@Param("page")int page,@Param("pageSize")int pageSize,@Param("btu1")String btu1,@Param("btu2")String btu2);

	List<WithdrawDeposit> selectWithdrawByYesterdayInfo(@Param("starttime") String yesterday,@Param("endtime")
			String now,@Param("chooseBtu") String chooseBtu,@Param("queryUserName") String queryUserName,  @Param("page") int page, @Param("pageSize") int pageSize);
	/*李奎写的代码*/
	List<WithdrawDeposit> selectWithdrawDepositByTime(@Param("starttime") String starttime,@Param("endtime") String endtime, @Param("chooseBtu") String chooseBtu,@Param("queryUserName") String queryUserName);

	List<WithdrawDeposit> queryAllSort(@Param("query") String query,@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("btu1") String btu1,@Param("btu2") String btu2);

	List<WithdrawDeposit> selectByPageInfo(@Param("query") String query,@Param("starttime") String starttime,@Param("endtime") String endtime, @Param("btu1") String btu1,@Param("btu2") String btu2,@Param("page")int page,@Param("pageSize") int pageSize);
}