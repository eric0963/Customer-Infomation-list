package view;

import controller.CustomerList;
import model.Customer;
import util.CustomerUtility;

public class CustomerView {

	private CustomerList customerList=new CustomerList(10);
	
	public CustomerView() {
		Customer customer=new Customer("Eric", 'M', 35, "0962", "aaa@hotmail.com");
		customerList.addCustomer(customer);
	}
	
	String detail="編號\t姓名\t性別\t年齡\t電話\t\t電子郵件\n";
	
	public void enterMainMenu() {
		boolean isflag=true;
		while(isflag) {
			System.out.print("		   --客戶資料-- \n");
			System.out.println();
			System.out.print("		1.   新增客戶資料\n");
			System.out.print("		2.   修改客戶資料\n");
			System.out.print("		3.   刪除客戶資料\n");
			System.out.print("		4.   查看客戶總表\n");
			System.out.print("		5.   退出\n");
			System.out.println();
			System.out.print("	           請選擇 1-5進入: \n");
		
			char menu=CustomerUtility.readMenuSelection();
			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.println("是否確認退出？(Y / N)");
				char c=CustomerUtility.readConfirmSelection();
				if(c=='Y') {
					isflag=false;
					System.out.println("下次見！！");
				}
			}
		}
		
	}
	private void addNewCustomer() {
		System.out.println("		   新增客戶資料 ");
		System.out.println("-------------------------------------------");
		System.out.println("姓名(20個字以內):");
		String name = CustomerUtility.readString(50);
		System.out.println("性別(輸入男/女):");
		char gender = CustomerUtility.readChar();
		System.out.println("年齡(2位數):");
		int age = CustomerUtility.readInt();
		System.out.println("電話(10個字以內):");
		String phone = CustomerUtility.readString(10);
		System.out.println("電子郵件(20個字以內):");
		String email = CustomerUtility.readString(20);
		boolean addCust = customerList.addCustomer(new Customer(name, gender, age, phone, email));
		if (addCust) {
			System.out.println("		   --新增會員成功--！");
		}else {
			System.out.println("		   --會員數量已滿--！");
			
		}
		System.out.println("-------------------------------------------");
	}
	private void modifyCustomer() {
		System.out.println("		   修改客戶資料 ");
		System.out.println("-------------------------------------------");
		Customer cust;
		int number;
		for(;;) {
			System.out.println("		請輸入要更改的客戶編號： ");
			System.out.println("		   或輸入0回上一頁： ");
			number = CustomerUtility.readInt();
			if(number==0) {
				return;
			}
			
			//客戶看到的數字從1開始，但陣列是從0開始，故-1
			cust = customerList.getCustomer(number-1);
			if (cust==null) {
				System.out.println("		   修改客戶資料 ");
				System.out.println("-------------------------------------------");
				System.out.println("\t      ***找不到該編號，請重新輸入***");
				System.out.println("-------------------------------------------");
			//為閱讀方便，else寫外面
			}else {
				break;
			}
		}
		System.out.println("姓名("+cust.getName()+"):");
		String name = CustomerUtility.readString(20, cust.getName());
		
		System.out.println("性別("+cust.getGender()+"):");
		char gender = CustomerUtility.readChar(cust.getGender());
		
		System.out.println("年齡("+cust.getAge()+"):");
		int age = CustomerUtility.readInt(cust.getAge());
		
		System.out.println("電話("+cust.getPhone()+"):");
		String phone = CustomerUtility.readString(20, cust.getPhone());
		
		System.out.println("電子郵件("+cust.getEmail()+"):");
		String email = CustomerUtility.readString(30, cust.getEmail());
		
		//客戶看到的數字從1開始，但陣列是從0開始，故-1
		boolean isReplaced = customerList.replaceCustomer(number-1, new Customer(name, gender, age, phone, email));
		if (isReplaced) {
			System.out.println("		--修改客戶資料成功-- ");
		}
		
		System.out.println("-------------------------------------------");
	}
	private void deleteCustomer() {
		System.out.println("		   刪除客戶資料 ");
		System.out.println("-------------------------------------------");
		int number;
		for(;;) {
			System.out.println("		請輸入要刪除的客戶編號： ");
			System.out.println("		   或輸入0回上一頁： ");
			number = CustomerUtility.readInt();
			if(number==0) {
				return;
			}
			//客戶看到的數字從1開始，但陣列是從0開始，故-1
			Customer cust = customerList.getCustomer(number-1);
			if(cust==null) {
				System.out.println("		   刪除客戶資料 ");
				System.out.println("-------------------------------------------");
				System.out.println("\t      ***找不到該編號，請重新輸入***");
				System.out.println("-------------------------------------------");
			//為閱讀方便，else寫外面
			}else {
				break;
			}
		}
		System.out.println("\t     確定要刪除"+number+"號客戶資料？(Y/N)");
		char isDeleted = CustomerUtility.readConfirmSelection();
		if(isDeleted=='Y') {
			boolean confirmDeleted = customerList.deleteCustomer(number-1);
			if(confirmDeleted) {
				System.out.println("		--刪除客戶資料成功-- ");
			}
		}
		System.out.println("-------------------------------------------");
		
	}
	private void listAllCustomers() {
		System.out.println("		   客戶總表 ");
		System.out.println("-------------------------------------------");
		if(customerList.getTotal()==0) {
			System.out.println("                 沒有客戶資料！！");
		}else {
			System.out.print(detail);
			Customer[] cust = customerList.getAllCustomers();
			for (int i = 0; i < cust.length; i++) {
				Customer cu = cust[i];
				System.out.println((i+1)+"\t"+cu.getName()+"\t"+cu.getGender()+"\t"+cu.getAge()+"\t"+
				cu.getPhone()+"\t\t"+cu.getEmail());
			}
		}

		System.out.println("-------------------------------------------");
	}
	public static void main(String[] args) {
		
		CustomerView view =new CustomerView();
		view.enterMainMenu();
//		Customer customer=new Customer("Eric", 'M', 35, "0962", "aaa@hotmail.com");
	}
}
