package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.EmployerUserWalletMapper;
import com.bangshuo.kuaigong.po.EmployerUserWallet;

public class EmployerUserWalletService {
	@Autowired
	EmployerUserWalletMapper employerUserWalletMapper;

	public EmployerUserWallet selectNum(String name){
		
		EmployerUserWallet list = employerUserWalletMapper.selectNum(name);
		
		return list;
	}
	
	public int chongzhi11(int id,String balance){
		int list=employerUserWalletMapper.updateWallet(id, balance);
		return list;
	}
	
	public  List<EmployerUserWallet> selectByWallet(String name){
		List<EmployerUserWallet> list=employerUserWalletMapper.selectByWallet(name);
		return list;
	}

	public List<EmployerUserWallet> selectByWalletPage(int page, int pageSize,String name) {
		List<EmployerUserWallet> list=employerUserWalletMapper.selectByWalletPage(page,pageSize,name);
		return list;
	}

	public List<EmployerUserWallet> MoHuChaXun(String query) {
		List<EmployerUserWallet> list=employerUserWalletMapper.MoHuChaXun(query);
		return list;
	}

	public List<EmployerUserWallet> MoHuChaXunPaGe(int page, int pageSize, String query) {
		List<EmployerUserWallet> list=employerUserWalletMapper.MoHuChaXunPaGe(page,pageSize,query);
		return list;
	}

	public int updateWalletMoney(EmployerUserWallet employerUserWallet) {
		int list=employerUserWalletMapper.updateWalletMoney(employerUserWallet);
		return list;
	}


	public List<EmployerUserWallet> selectQueryWalletByid(int id) {
		List<EmployerUserWallet> list=employerUserWalletMapper.selectQueryWalletByid(id);
		return list;
	}

	public List<EmployerUserWallet> selectQueryWalletByidPage(int id,int page,int pageSize) {
		List<EmployerUserWallet> list=employerUserWalletMapper.selectQueryWalletByidPage(id,page,pageSize);
		return list;
	}

	public List<EmployerUserWallet> selectByWalletSort(String name) {
		List<EmployerUserWallet> list=employerUserWalletMapper.selectByWalletSort(name);
		return list;
	}

	public List<EmployerUserWallet> selectByWalletPageInfo(int page,int pageSize, String name) {
		List<EmployerUserWallet> list=employerUserWalletMapper.selectByWalletPageInfo(page,pageSize,name);
		return list;
	}

	public int NewupdateWalletMoney(int erid, String balance) {
		int list=employerUserWalletMapper.NewupdateWallet(erid,balance);
		return list;
	
	}
}
