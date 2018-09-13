package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.EmployerUserWallet;
public interface EmployerUserWalletMapper {
	
	EmployerUserWallet selectNum(@Param("name")String name);
	
	  int updateWallet(@Param("id") int id,@Param("balance") String balance);
	
	  List<EmployerUserWallet> selectByWallet(@Param("name") String name);

	List<EmployerUserWallet> selectByWalletPage(@Param("page") int page,@Param("pageSize") int pageSize,@Param("name") String name);

	List<EmployerUserWallet> MoHuChaXun(@Param("name") String name);

	List<EmployerUserWallet> MoHuChaXunPaGe(@Param("page") int page,@Param("pageSize") int pageSize, @Param("name") String name);

	int updateWalletMoney(EmployerUserWallet employerUserWallet);


	List<EmployerUserWallet> selectQueryWalletByid(@Param("erid") int erid);

	List<EmployerUserWallet> selectQueryWalletByidPage(@Param("erid") int erid,@Param("page") int page,@Param("pageSize") int pageSize);

	List<EmployerUserWallet> selectByWalletSort(@Param("name") String name);

	List<EmployerUserWallet> selectByWalletPageInfo(@Param("page") int page,@Param("pageSize") int pageSize,
			@Param("name") String name);

	int NewupdateWallet(@Param("id") int id,@Param("balance") String balance);
}
