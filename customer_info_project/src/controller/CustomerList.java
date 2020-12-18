package controller;

import model.Customer;

public class CustomerList {
	
	//保存客戶對象
	private Customer[] customers;
	//紀錄已保存客戶數量
	private int total;
	
	//初始化Customer[]陣列
	//totalCistomer - 指定陣列長度
	public CustomerList(int totalCistomer) {
		//長度不確定，先設定動態陣列
		customers=new Customer[totalCistomer];
	}
	
	//CRUD here
	
	//新增
	public boolean addCustomer(Customer customer) {
		if(total>customers.length) {
			return false;
		}
		customers[total]=customer;
		total++;
		return true;
	}
	
	//修改
	//index=要修改的客戶編號，所以不可能大於total
	public boolean replaceCustomer(int index,Customer cust) {
		if(index<0 || index>=total) {
			return false;
		}
		customers[index]=cust;
		return true;
	}
	
	//刪除
	//index=要修改的客戶編號，所以不可能大於total
	public boolean deleteCustomer(int index) {
		if(index<0 || index>=total) {
			return false;
		}
		//確保取消後，客戶編號能接續，故從要取消的編號開始回圈
		for (int i = index; i < total-1; i++) {
			customers[i]=customers[i+1];
		}
		//接續後，陣列最後一個資料清空
		customers[total-1]=null;
		total--;
		return true;
	}
	
	//讀取
	public Customer[] getAllCustomers() {
		//陣列長度有可能大於已保存客戶數量，為避免輸出null
		//新增一個陣列長度為已確認的客戶數量
		Customer[] custs=new Customer[total];
		for (int i = 0; i < custs.length; i++) {
			//複製給值
			custs[i]=customers[i];
		}
		return custs;
	}
	
	//獲取指定客戶資料
	public Customer getCustomer(int index) {
		if(index<0 || index>=total) {
			return null;
		}
		return customers[index];
		
	}
	public int getTotal() {
		return total;
		
	}
}
