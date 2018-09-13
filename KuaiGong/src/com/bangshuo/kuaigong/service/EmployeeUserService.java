package com.bangshuo.kuaigong.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.bangshuo.kuaigong.mapper.EmployeeUserMapper;
import com.bangshuo.kuaigong.po.EmployeeUser;
import com.bangshuo.kuaigong.po.EmployerUser;

public class EmployeeUserService {
	
	@Autowired
	EmployeeUserMapper employeeUserMapper;
	
	//查询工人收益记录条数
	public EmployeeUser queryCountMoney(String id,String starttime,String endtime){
		
		EmployeeUser list=employeeUserMapper.queryCountMoney(id,starttime,endtime);
		
		return list;
	}
	//查询业务员下的工人个数
	public EmployeeUser salesemployeeuser(int id,String name,String username){
		
		EmployeeUser list=employeeUserMapper.salesemployeeuser(id, name, username);
		
		return list;
	}
	
	//查询工人个数
	public EmployeeUser selectNum(String name,String eeid,String phone,String btu){
		
		EmployeeUser list=employeeUserMapper.selectNum(name, eeid, phone, btu);
		
		return list;
	}
	//转移
	public int updateSalesmanId(EmployeeUser employeeUser){
		
		int list =employeeUserMapper.updateSalesmanId(employeeUser);
		
		return list;
	}
	//修改转移
	public int updateid(EmployeeUser employeeUser){
		
		int list =employeeUserMapper.updateid(employeeUser);
		
		return list;
	}
	
    //查询业务员管理的工人
	public List<EmployeeUser>selectBySalesman(int id,String name,String username){
		List<EmployeeUser>list = employeeUserMapper.selectBySalesman(id,name,username);
		return list;
	}
	//查询业务员管理的工人分页
	public List<EmployeeUser>selectBySalesmanPage(int page,int pageSize,int id,String name,String username){
		List<EmployeeUser>list = employeeUserMapper.selectBySalesmanPage(page,pageSize,id,name,username);
		return list;
	}
	
	//根据id查询分页
	
	public List<EmployeeUser>selectByPrimaryPage(int page,int pageSize,int id){
		 
		List<EmployeeUser> list = employeeUserMapper.selectByPrimaryPage(page, pageSize, id);
		  
		  return list;
	}
	//查询干活次数
	public List<EmployeeUser> selectByWork(int id){
		
		List<EmployeeUser> list=employeeUserMapper.selectByWork(id);
		
		return list;
	}
	//查询干活次数分页
	public List<EmployeeUser>selectByPageWork(int page,int pageSize,int id){
		 
		List<EmployeeUser> list = employeeUserMapper.selectByPageWork(page, pageSize, id);
		  
		  return list;
	}
	  //全查分页
	public List<EmployeeUser> selectAllByPage(int page,int pageSize,int id){
	
		List <EmployeeUser>list = employeeUserMapper.selectAllByPage(page, pageSize, id);
	
		return list;
	}
	//根据时间查询提现时间
//	public List<EmployeeUser> queryData(String starttime,String endtime){
//		
//		List<EmployeeUser> list=employeeUserMapper.queryData(starttime, endtime);
//		
//		return list;
//		}
	//������ʱ���ѯ��ҳ
	public List<EmployeeUser> queryDate(String starttime,String endtime){
	
		List<EmployeeUser> list=employeeUserMapper.queryDate(starttime, endtime);
	
		return list;
		}
// ������ʱ���ѯ��ҳ����
	public List<EmployeeUser> queryDate1(String starttime,String endtime, int id){
		List<EmployeeUser> list=employeeUserMapper.queryDate1(starttime, endtime,id);
		return list;
	}
	//����ʱ���ѯ
		public List<EmployeeUser> queryDatePaGe1(String starttime,String endtime,int page,int pageSize){
			List<EmployeeUser> list=employeeUserMapper.queryDatePaGe1(starttime, endtime,page,pageSize);
			return list;
		}
 //����ʱ���ѯ
	public List<EmployeeUser> queryDatePaGe(String starttime,String endtime,int page,int pageSize, int id){
		List<EmployeeUser> list=employeeUserMapper.queryDatePaGe(starttime, endtime,page,pageSize,id);
		return list;
	}
	//���˹�������
	public List<EmployeeUser> queryDato(String startime,String endtime, int id){
		
		List<EmployeeUser> list=employeeUserMapper.queryDato(startime, endtime,id);
		
		return list;
	}
	
	//���˹�����������
	public List<EmployeeUser> queryDatoo(String startime,String endtime){
		
		List<EmployeeUser> list=employeeUserMapper.queryDatoo(startime, endtime);
		
		return list;
	}
	
	//���˹�����������
	public List<EmployeeUser> queryDatooPage(String startime,String endtime,int page,int pageSize, int id){
		
		List<EmployeeUser> list=employeeUserMapper.queryDatooPage(startime, endtime,page,pageSize,id);
		
		return list;
	}
	
	
			public  List<EmployeeUser> selectByPage(int page,int pageSize){
			
				List<EmployeeUser> list = employeeUserMapper.selectByPage(page, pageSize);
			
				return list;

			}
			public  List<EmployeeUser> selectBYPageMoney(int page,int pageSize,int id, String btu){
				
				List<EmployeeUser> list = employeeUserMapper.selectBYPageMoney(page, pageSize,id,btu);
				
				return list;
				
			}
			public  List<EmployeeUser> selectByPaGeOnline(int page,int pageSize,int id){
				
				List<EmployeeUser> list = employeeUserMapper.selectByPaGeOnline(page, pageSize,id);
				return list;
				
			}
			
			public List<EmployeeUser> selectCountOrderForm(int id){
		
				List<EmployeeUser> list=employeeUserMapper.selectCount(id);
				
				return list;
		
			}
			
			public List<EmployeeUser> selectByPrimaryKey(int id){
		
				List<EmployeeUser> list=employeeUserMapper.selectByPrimaryKey(id);
				
				return list;
				
			}
			
			public List<EmployeeUser> queryAll(){
				
				List<EmployeeUser> list=employeeUserMapper.selectAll();
				
				return list;
			
			}
		
			public List<EmployeeUser> selectAllMoney(int id, String btu){
				
				List<EmployeeUser> list=employeeUserMapper.selectAllMoney(id,btu);
				return list;
			}
			
			public List<EmployeeUser> selectAllOnline(int id){
				
				List<EmployeeUser> list=employeeUserMapper.selectAllOnline(id);
				
				return list;
			}
			
			public List<EmployeeUser> selectByName(String name){
			   	 
				List<EmployeeUser> list = employeeUserMapper.selectByName(name);
		    	 
		    	return list;	
			}
			
		
			
			public int insert(EmployeeUser employeeUser){
				
				int list = employeeUserMapper.insert(employeeUser);
				
				return list;	
			}
			
			public int updateByPrimaryKey(EmployeeUser employeeUser){
				
				int list =employeeUserMapper.updateByPrimaryKey(employeeUser);
				
				return list;
				
			}
public int updateByPrimaryKey1(EmployeeUser employeeUser){
				
				int list =employeeUserMapper.updateByPrimaryKey1(employeeUser);
				
				return list;
				
			}
			
			public int  deleteByPrimaryKey(int id){
				
				int list =employeeUserMapper.deleteByPrimaryKey(id);
				
				return list ;
				
			}
			
			public List<EmployeeUser> selectUserLocation(int id){
				
				List<EmployeeUser> list=employeeUserMapper.selectUserLocation(id);
			
				return list;
			}
			//��鿴��������
			
			public List<EmployeeUser> queryDatashouru(String startime, String endtime, int id, String btu) {
				List<EmployeeUser> list=employeeUserMapper.queryData(startime,endtime,id,btu);
				return list;
			}
			//�鿴������������
			public List<EmployeeUser> queryDatashouru1(String startime, String endtime) {
				List<EmployeeUser> list=employeeUserMapper.queryData1(startime,endtime);
				return list;
			}
			//�鿴���������ҳ
			public List<EmployeeUser> queryDatashouruPage(String startime, String endtime,int page,int pageSize, int id, String btu) {
				List<EmployeeUser> list=employeeUserMapper.queryDataPage(startime, endtime, page, pageSize,id,btu);
				return list;
			}
			
			public  List<EmployeeUser> selectByNamePage(int page,int pageSize,String name,String eeid, String phone, String btu){//,String salesmanName){
				
				List<EmployeeUser> list = employeeUserMapper.selectByNamePage(page, pageSize,name,eeid,phone,btu);//,salesmanName);
			
				return list;
			}
	
			public List<EmployeeUser> selectByName1(String name,String eeid, String phone, String btu){//,String salesmanName) {
				List<EmployeeUser> list=employeeUserMapper.selectByName1(name,eeid,phone,btu);//,salesmanName);
				return list;
			}
			public List<EmployeeUser> queryDatePaGe66(String starttime, String endtime,
					int page, int pageSize, String btu,int id) {
				List<EmployeeUser> list=employeeUserMapper.queryDatePaGe66(starttime, endtime,btu,page,pageSize,id);
				return list;
			}
			public List<EmployeeUser> selectAllMoney1(int id, String btu) {
				List<EmployeeUser> list=employeeUserMapper.selectAllMoney1(id,btu);
				return list;
			}
			public List<EmployeeUser> queryCount(int id, String btu) {
				List<EmployeeUser> list=employeeUserMapper.selectAllMoney1(id,btu);
				return list;
			}
			public List<EmployeeUser> queryshouyi(int id, String starttime, String endtime) {
				List<EmployeeUser> list=employeeUserMapper.queryshouyi(id,starttime,endtime);
				return list;
			}
			public List<EmployeeUser> queryshouyiInfo(int id, int page,
					int pageSize, String starttime, String endtime) {
				List<EmployeeUser> list=employeeUserMapper.queryshouyiInfo(id,page,pageSize,starttime,endtime);
				return list;
			}
			public List<EmployeeUser> selectByusernameOrname(int id) {
				List<EmployeeUser> list=employeeUserMapper.selectByusernameOrname(id);
				return list;
			}
			public List<EmployeeUser> selectEeuseregid(int id) {
				List<EmployeeUser> list=employeeUserMapper.selectEeuseregid(id);
				return list;
			}
			public int updateStatus(String newusername, String status) {
				int list=employeeUserMapper.updateStatus(newusername,status);
				return list;
			}
		
			
		
		
			
	}