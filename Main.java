package com.example.jdbc;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.bean.User;
import com.example.daoimp.UserDaoImp;

public class Main {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("������ʹ�ô����ݿ��ѯ�����Ϣ����������ϣ����ѯ�����ݣ�");
		String sql1=in.nextLine();
		String sql2=in.nextLine();
		dsjc DSJC=new dsjc();
		DSJC.search(sql1,sql2);
		
	    int flag=1;
		UserDaoImp imp = new UserDaoImp();
		User user = new User(); 
		System.out.println("�������Ƿ�ϣ���������ۣ�(����1Ϊ��������)");
		int m=in.nextInt();
		if(m==1)
		{
		System.out.println("��ѡ�����Ĳ���:��¼������1��ע��������2");
		m=in.nextInt();
		if(m==1) {
		    System.out.println("��ѡ�����ĵ�¼��ʽ:�ʺ�����������1��������ʽ������2");
			m=in.nextInt();		    
			if(m==1)
		    {
			in.nextLine();
			user.setUserid(in.nextLine());
			user.setPassword(in.nextLine());
			Iterator<User> iter= imp.findAll().iterator();
			int length=imp.findAll().size();
			int i=0;
			while(iter.hasNext()){
				User te=iter.next();
				
				if((te.getUserid().trim()).equals(user.getUserid())&&(te.getPassword().trim()).equals(user.getPassword()))
				{
					System.out.println("������Ϣ�ǣ�"+te.getUserid()+" "+te.getPassword()+" "+te.getEmail()+" "+te.getWeChat());
					System.out.println("���Ե�¼��");
					break;
				}
				i++;
				if(i==length)
				{
					System.out.println("��¼ʧ�ܣ�");
					flag=0;
				}
			}
			System.out.println("�����������ڸõ�Ӱ�����ۣ�");
			//sql1=in.nextLine();
			sql2=in.nextLine();
			DSJC=new dsjc();
			DSJC.insert(sql2,user.getUserid());
			}
		else
		{
			in.nextLine();
			String tem=in.nextLine();	
			user.setWeChat(tem);
			user.setQQ(tem);
			user.setEmail(tem);
			user.setSina(tem);
			user.setPhonenumber(Integer.parseInt(tem));
			Iterator<User> iter= imp.findAll().iterator();
			int length=imp.findAll().size();
     		int i=0;
			while(iter.hasNext()){
				User te=iter.next();
				if((te.getWeChat().trim()).equals(user.getWeChat())||(te.getQQ().trim()).equals(user.getQQ())||(te.getEmail().trim()).equals(user.getEmail())||(te.getSina().trim()).equals(user.getSina())||te.getPhonenumber()==user.getPhonenumber())
				{
					
					System.out.println("���Ե�¼��");
					System.out.println("������Ϣ�ǣ�"+te.getUserid()+" "+te.getPassword()+" "+te.getEmail()+" "+te.getWeChat());
					break;
				}
				i++;
				if(i==length)
				{
					System.out.println("��¼ʧ�ܣ�");
					flag=0;
					
				}
			}
			System.out.println("�����������ڸõ�Ӱ�����ۣ�");
			//sql1=in.nextLine();
			sql2=in.nextLine();
			DSJC=new dsjc();
			DSJC.insert(sql2,user.getUserid());
	     }
		
		}
		else
		{
			System.out.println("���趨�����û�ID:");
			int flag1=1;
			User user1=new User();
			while(flag1==1)
			{
				user1.setUserid(in.nextLine());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					if((te.getUserid().trim()).equals(user1.getUserid()))
					{
						
						System.out.println("�������ô��û�����");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("����ʹ�ô��û�����");
						flag1=0;
					}
				}

			}
			System.out.println("���趨�������룺20λ����");
			user1.setPassword(in.nextLine());
			System.out.println("�����Ƿ��΢���ʺţ���������1������������2");
			int n=in.nextInt();
			if(n==1)
			{
				System.out.println("����������΢���ʺ�");
				user1.setWeChat(in.nextLine());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					if((te.getWeChat().trim()).equals(user1.getWeChat()))
					{
						
						System.out.println("�����԰󶨴�΢���ʺţ�");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("���԰󶨴�΢���ʺţ�");
						flag1=0;
					}
				}
			}
			
			System.out.println("�����Ƿ�������ʺţ���������1������������2");
			n=in.nextInt();
			if(n==1)
			{
				System.out.println("���������������ʺ�");
				user1.setSina(in.nextLine());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					if((te.getSina().trim()).equals(user1.getSina()))
					{
						
						System.out.println("�����԰󶨴������ʺţ�");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("���԰󶨴������ʺţ�");
						flag1=0;
					}
				}
			}
			
			System.out.println("�����Ƿ��QQ�ʺţ���������1������������2");
			n=in.nextInt();
			if(n==1)
			{
				System.out.println("����������QQ�ʺ�");
				user1.setQQ(in.nextLine());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					if((te.getQQ().trim()).equals(user1.getQQ()))
					{
						
						System.out.println("�����԰󶨴�QQ�ʺţ�");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("���԰󶨴�QQ�ʺţ�");
						flag1=0;
					}
				}
			}
			
			System.out.println("�����Ƿ��E-mail�ʺţ���������1������������2");
			n=in.nextInt();
			if(n==1)
			{
				System.out.println("����������E-mail�ʺ�");
				user1.setEmail(in.nextLine());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					if((te.getEmail().trim()).equals(user1.getEmail()))
					{
						
						System.out.println("�����԰󶨴�E-mail�ʺţ�");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("���԰󶨴�E-mail�ʺţ�");
						flag1=0;
					}
				}
			}
			
			System.out.println("�����Ƿ���ֻ��ţ���������1������������2");
			n=in.nextInt();
			if(n==1)
			{
				System.out.println("�����������ֻ���");
				user1.setPhonenumber(in.nextInt());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					String s=String.valueOf(user1.getPhonenumber());
					String s1=String.valueOf(te.getPhonenumber());
					if((s1.trim()).equals(s))
					{
						
						System.out.println("�����԰󶨴��ֻ��ţ�");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("���԰󶨴��ֻ��ţ�");
						flag1=0;
					}
				}
			}
			
			imp.add(user1);
			
		}
	  }
	else
	{
		exit(0);
	}
   }

	private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}
}
