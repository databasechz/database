package com.example.jdbc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.bean.User;
import com.example.daoimp.UserDaoImp;
import com.example.helper.JdbcDaoHelper;

public class Main {
	
	public static void main(String args[])
	{
			Window win=new Window();
			win.new SearchWindow();
	}
}
class Window
{
	String Myid=null,MyPWD,Mywc,Myqq,Mysina,Myemail,Mypn;
	int sign=0,sign1=0;
	User user=new User();
	UserDaoImp imp = new UserDaoImp();
	dsjc DSJC=new dsjc();
	CRACCOUNT cra=new CRACCOUNT("注册");
	class SearchWindow extends JFrame //implements ActionListener
   {
    JLabel tishi =new JLabel("查询或登录");
    JButton chaxun=new JButton("查询");
    JButton login = new JButton("登录");
    SearchWindow() {

        setTitle("豆瓣网");
        setLocation(200, 200);
        setSize(250, 250);
        validate();
        setVisible(true);
        GridLayout grid = new GridLayout(3, 1);
        JPanel p = new JPanel(grid);
        p.add(tishi);
        p.add(chaxun);
        p.add(login);
		chaxun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new chaxu("查询");
				setVisible(false);
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LogWindow();
				setVisible(false);
            }
        });
        add(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    }
    class LogWindow  extends JFrame //implements ActionListener
   {
    JButton three =new JButton("第三方登录");
    JButton register=new JButton("注册");
    JButton Login=new JButton("登录");
    JTextField account=new JTextField();
    JPasswordField password=new JPasswordField();
	String z,m;
	JButton fanhui=new JButton("返回");
	JLabel jieguo=new JLabel();
    LogWindow()
    {
        setTitle("登陆");
        setLocation(250, 250);
        setSize(450, 450);
        validate();
        setVisible(true);
        GridLayout grid = new GridLayout(5,2);
        JPanel p = new JPanel(grid);
        p.add(new JLabel("账号："));
        p.add(account);
        p.add(new JLabel("密码："));
        p.add(password);
        p.add(three);
        p.add(Login);
        p.add(new JLabel("还没有账号？"));
        p.add(register);
		p.add(fanhui);
		p.add(jieguo);
		add(p);
		Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             z=account.getText();
             char[] contentArray = password.getPassword();
             m=String.copyValueOf(contentArray);
			user.setUserid(z);
			user.setPassword(m);
			Iterator<User> iter= imp.findAll().iterator();
			int length=imp.findAll().size();
			int i=0;
			while(iter.hasNext()){
				User te=iter.next();	
				if((te.getUserid().trim()).equals(user.getUserid())&&(te.getPassword().trim()).equals(user.getPassword()))
			 {
					Myid=te.getUserid();
					MyPWD=te.getPassword();
					Mywc=te.getEmail();
					Myqq=te.getWeChat();
					Mysina=te.getSina();
					Myemail=te.getEmail();
					Mypn=String.valueOf(te.getPhonenumber());
					sign1=1;
			 new InWindow();
		     setVisible(false);
			 }
			 i++;
				if(i==length)
				{
					jieguo.setText("登录失败！");
					jieguo.setForeground(Color.red);
					
					
				}
            }
			}
        });
		
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreeWindow();
				setVisible(false);
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				//new CRACCOUNT("注册");
				cra.setVisible(true);
				setVisible(false);
            }
        });
		fanhui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchWindow();
				setVisible(false);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
    class ThreeWindow  extends JFrame
{

    JTextField wechat = new JTextField("WeChat");
    JTextField qq = new JTextField("QQ");
    JTextField sina = new JTextField("Sina");
    JTextField phone = new JTextField("000000");
    JTextField email = new JTextField("Email");
    JButton ok=new JButton("登录");
	JButton fanhui=new JButton("返回");
    JLabel panduan=new JLabel();
    ThreeWindow()
    {
        setTitle("第三方账号登陆");
        setLocation(300, 300);
        setSize(450, 450);
        validate();
        setVisible(true);
        GridLayout grid = new GridLayout(5, 2);
        JPanel p = new JPanel(grid);
        p.add(new JLabel("微信号"));
        p.add(wechat);
        p.add(new Label("QQ"));
        p.add(qq);
        p.add(new JLabel("新浪"));
        p.add(sina);
        p.add(new Label("手机号"));
        p.add(phone);
        p.add(new Label("邮箱"));
        p.add(email);
        JPanel p1 =new JPanel(new GridLayout(4, 1));
        p1.add(p);
        p1.add(ok);
		p1.add(fanhui);
		p1.add(panduan);
		fanhui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LogWindow();
				setVisible(false);
            }
		});
		ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            user.setWeChat(wechat.getText());
			user.setQQ(qq.getText());
			user.setEmail(email.getText());
			user.setSina(sina.getText());
			user.setPhonenumber(Integer.parseInt(phone.getText()));
			Iterator<User> iter= imp.findAll().iterator();
			int length=imp.findAll().size();
     		int i=0;
			while(iter.hasNext()){
				User te=iter.next();
				if((te.getWeChat().trim()).equals(user.getWeChat())||(te.getQQ().trim()).equals(user.getQQ())||(te.getEmail().trim()).equals(user.getEmail())||(te.getSina().trim()).equals(user.getSina())||te.getPhonenumber()==user.getPhonenumber())
				{
					Myid=te.getUserid();
					MyPWD=te.getPassword();
					Mywc=te.getEmail();
					Myqq=te.getWeChat();
					Mysina=te.getSina();
					Myemail=te.getEmail();
					Mypn=String.valueOf(te.getPhonenumber());
					sign1=1;
				new InWindow();
				setVisible(false);
				}
				i++;
				if(i==length)
				{
					panduan.setText("登陆失败");
					
					
				}
				
            }
		}
		});
		add(p1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
    class InWindow extends JFrame
   {
    JButton xiugai=new JButton("修改信息");
	JButton chaxun=new JButton("查询");
    JLabel id=new JLabel(Myid);
    JLabel pwd=new JLabel(MyPWD);
    JLabel wc=new JLabel(Mywc);
    JLabel qq=new JLabel(Myqq);
    JLabel sina=new JLabel(Mysina);
    JLabel email=new JLabel(Myemail);
    JLabel pn=new JLabel(Mypn);
    
    InWindow()
    {
        setTitle("用户操作");
        setLocation(200, 200);
        setSize(250, 250);
        validate();
        setVisible(true);
        GridLayout grid = new GridLayout(8, 2);
        JPanel p = new JPanel(grid);
        p.add(new JLabel("您的id为"));
        p.add(id);
        p.add(new JLabel("您的密码为"));
        p.add(pwd);
        p.add(new JLabel("您的微信为"));
        p.add(wc);
        p.add(new JLabel("您的QQ为"));
        p.add(qq);
        p.add(new JLabel("您的微博为"));
        p.add(sina);
        p.add(new JLabel("您的邮箱为"));
        p.add(email);
        p.add(new JLabel("您的手机号为"));
        p.add(pn);
        p.add(xiugai);
		p.add(chaxun);
		chaxun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new chaxu1("查询");
				setVisible(false);
            }
		});
		xiugai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new CRACCOUNT("删除旧帐户并重新注册");//同时进行sql语句删除数据库中这个人的信息。
                cra.setTitle("删除旧帐户并重新注册");
                cra.setVisible(true);
            	DSJC.delete(Myid);
				setVisible(false);
            }
		});
        add(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    }
    class CRACCOUNT extends JFrame implements ActionListener{
        JLabel 	jl1=new JLabel("请输入您的ID号：");
		JLabel  jl2=new JLabel("请输入您的密码：");
		JLabel  jl3=new JLabel("* 请输入您的微信号：");
		JLabel  jl4=new JLabel("* 请输入您的QQ号：");
		JLabel  jl5=new JLabel("* 请输入您的新浪帐号：");
		JLabel  jl6=new JLabel("* 请输入您的手机号：");
		JLabel  jl7=new JLabel("* 请输入您的E-mail：");
		JLabel attention1=new JLabel("无");
		JLabel newjl2=new JLabel("");
		JTextField text1=new JTextField(20);
		JPasswordField ps1=new JPasswordField(20);
		JTextField text2=new JTextField(20);
		JTextField text3=new JTextField(20);
		JTextField text4=new JTextField(20);
		JTextField text5=new JTextField(20);
		JTextField text6=new JTextField(20);
		JButton jb1=new JButton("确定");
		JButton jb2=new JButton("取消");
		JButton newjb1=new JButton("是");
		JButton newjb2=new JButton("否");
		boolean  flag=true;
        CRACCOUNT(String s){
			setTitle(s);
			setLayout(new GridLayout(2,1));
			
			JPanel jp1=new JPanel();
			jp1.setLayout(new GridLayout(7,2));
			jp1.add(jl1);
			jp1.add(text1);
			jp1.add(jl2);
			jp1.add(ps1);
			jp1.add(jl3);
			jp1.add(text2);
			jp1.add(jl4);
			jp1.add(text3);
			jp1.add(jl5);
			jp1.add(text4);
			jp1.add(jl6);
			jp1.add(text5);
			jp1.add(jl7);
			jp1.add(text6);
			add(jp1);
			
			JPanel jpz=new JPanel(new GridLayout(2,1));
			
			JPanel jp2=new JPanel();
			jp2.add(jb1);
			jp2.add(jb2);
			jpz.add(jp2);
			
			JPanel jp3=new JPanel();
			jp3.add(attention1);
			jpz.add(jp3);
			
			add(jpz);
			
			text1.addActionListener(this);
			text2.addActionListener(this);
			text3.addActionListener(this);
			text4.addActionListener(this);
			
			jb1.addActionListener(this);
			jb2.addActionListener(this);
			
			validate();
			setBounds(120,150,300,300);
			setVisible(false);
			/*if(sign==1)
		    {
				setVisible(false);
				new LogWindow();
			}*/
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public void actionPerformed(ActionEvent e){
			Object source=e.getSource();
			if(source==jb1)
			{
				 Iterator<User> iter= imp.findAll().iterator();
			     int length=imp.findAll().size();
			     int i=0;
			     while(flag){
				 User te=iter.next();
				
				if((te.getUserid().trim()).equals(text1.getText()))
				{
					attention1.setText("您的账户与数据库中的已有账户重复，请重新输入！");
					text1.setText("");
					break;
				}
				else if((te.getWeChat().trim()).equals(text2.getText()))
				{
					attention1.setText("您的微信号与数据库中的已有微信号重复，请重新输入！");
					text2.setText("");
					break;
				}
				else if((te.getQQ().trim()).equals(text3.getText()))
				{
					attention1.setText("您的QQ号与数据库中的已有QQ号重复，请重新输入！");
					text3.setText("");
					break;
				}
				else if((te.getSina().trim()).equals(text4.getText()))
				{
					attention1.setText("您的新浪账号与数据库中的已有新浪账号重复，请重新输入！");
					text4.setText("");
					break;
				}
				else if((te.getPhonenumber()==Integer.parseInt(text5.getText())))
				{
					attention1.setText("您的手机号与数据库中的已有手机号重复，请重新输入！");
					text5.setText("");
					break;
				}
				else if((te.getEmail().trim()).equals(text1.getText()))
				{
					attention1.setText("您的E-mail与数据库中的已有E-mail重复，请重新输入！");
					text6.setText("");
					break;
				}
				i++;
				if(i==length)
				{
					attention1.setText("您已注册成功！");
					setVisible(false);
					new LogWindow();
				}
			
			}}
            else if(source==jb2)
			{
			    new InputWindow();
				
	       }
        }
    }
	class chaxu extends JFrame implements ActionListener
   {
	JButton jb,jb1,jb2;
	JLabel jl;
	JTextField jt;
	JPanel jp,jp1;
	GridLayout grid,grid1;
	String a;
	JTextField jtf = new JTextField("");
	JTextField jtf1 = new JTextField("");
	JTextArea jta = new JTextArea();
	chaxu(String s)
	{
		setTitle(s);
		setLocation(160,160);
		setSize(120,120);
		jb = new JButton("查询");
		jb1 = new JButton("登陆后评价");//或者是编辑影评
		jb2 =new JButton("评价");
		if(sign1==1)
		{
			jb1.setText("评价");
		}
		jb.addActionListener(this);
		jb1.addActionListener(this);
		jl = new JLabel("请输入您想要查询的电影的相关信息");
		jt = new JTextField("");
		grid = new GridLayout(2,1);
		grid1 = new GridLayout(1,2);
		setLayout(new BorderLayout());
		jp = new JPanel(grid1);
		jp1 = new JPanel(grid1);
		jp.add(jl);
		jp.add(jt);
		jp1.add(jb);
		jp1.add(jb1);
		add(jp,BorderLayout.CENTER);
		add(jp1,BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s,sql;
		if (e.getSource()==jb)
		{
			s = jt.getText();
			//System.out.println("\n"+s);测试函数
			a = DSJC.Search(s);
		}
		else if (e.getSource()==jb1)
		{
			new LogWindow();
			setVisible(false);
		}
		
	}
   }
	class chaxu1 extends JFrame implements ActionListener
	   {
		JButton jb,jb1,jb2;
		JLabel jl;
		JTextField jt;
		JPanel jp,jp1;
		GridLayout grid,grid1;
		String a;
		JTextField jtf = new JTextField("");
		JTextField jtf1 = new JTextField("");
		JTextArea jta = new JTextArea();
		chaxu1(String s)
		{
			setTitle(s);
			setLocation(160,160);
			setSize(120,120);
			jb = new JButton("查询");
			//jb1 = new JButton("登陆后评价");//或者是编辑影评
			jb1 =new JButton("评价");
			if(sign1==1)
			{
				jb1.setText("评价");
			}
			jb.addActionListener(this);
			jb1.addActionListener(this);
			jl = new JLabel("请输入您想要查询的电影的相关信息");
			jt = new JTextField("");
			grid = new GridLayout(2,1);
			grid1 = new GridLayout(1,2);
			setLayout(new BorderLayout());
			jp = new JPanel(grid1);
			jp1 = new JPanel(grid1);
			jp.add(jl);
			jp.add(jt);
			jp1.add(jb);
			jp1.add(jb1);
			add(jp,BorderLayout.CENTER);
			add(jp1,BorderLayout.SOUTH);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public void actionPerformed(ActionEvent e)
		{
			String s,sql;
			if (e.getSource()==jb)
			{
				s = jt.getText();
				//System.out.println("\n"+s);测试函数
				a = DSJC.Search(s);
				
			}
			else if (e.getSource()==jb1)//影评
			{
			    JFrame f = new JFrame("电影评价");
				f.setTitle("电影评价");
			    f.setLocation(160,160);
			    f.setSize(120,120);
				f.setLayout(new BorderLayout());
				JLabel jla = new JLabel("请输入您对该电影的评分,并留下您对这部电影的高见:");
				JLabel jlb = new JLabel("请输入您对该电影标签:");
				JButton ja = new JButton("上传电影评价");
				JPanel j,jp;
				j = new JPanel(new GridLayout(1,2));
				jp =new JPanel(new GridLayout(1,3));
				jp.add(jlb);
				jp.add(jtf1);
				jp.add(ja);
				j.add(jla);
				j.add(jtf);
				f.add(j,BorderLayout.NORTH);
				f.add(jta,BorderLayout.CENTER);
				f.add(jp,BorderLayout.SOUTH);
				ja.addActionListener(new ActionListener()
	                                   {
										  String b,i,d;
										  double c;
	                                      public void actionPerformed(ActionEvent g)
										  {
											c=Double.parseDouble(jtf.getText());//score
											//System.out.println("\n"+a);测试函数
											b=jta.getText();
											//System.out.println("\n"+b);测试函数
											d= jtf1.getText();
											DSJC.insert(Myid,a,c,b,d);
											setVisible(false);
										  }
									   }
									);
				f.setVisible(true);
			    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
	   }
	class InputWindow extends JFrame implements ActionListener
    {
		boolean flag=true;
		JButton newjb1=new JButton("是");
		JButton newjb2=new JButton("否");
		JLabel newjl2=new JLabel("");
		public InputWindow()
		{
		    setLayout(new GridLayout(3,1));
			JLabel newjl1=new JLabel("请确定是否取消本次注册?");
			JPanel newjp1=new JPanel();
			newjp1.add(newjl1);
			add(newjp1);
			JPanel newjp2=new JPanel();
			newjp2.add(newjb1);
			newjp2.add(newjb2);
			add(newjp2);
			JPanel newjp3=new JPanel();
			newjl2.setForeground(Color.blue);
			newjp3.add(newjl2);
			add(newjp3);
			
			newjb1.addActionListener(this);
			newjb2.addActionListener(this);
			
			validate();
			setBounds(400,250,300,300);
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
      public void actionPerformed(ActionEvent e)
		{
          Object source=e.getSource();
			if(source==newjb1)
		       {
               newjl2.setText("已成功执行操作，倒计时3s后窗口自动跳转！");
							   SwingUtilities.invokeLater(new Runnable()
				             {
					            public void run()
					            {
								try
					            {
					              Thread.sleep(3000);
				                }catch(InterruptedException ee)
			                       {
				  
			                       }
								setVisible(false);
								cra.setVisible(false);
								new LogWindow();
							 }
		                     }
							 );
				                     
			}			   
          else	
		       {
		       newjl2.setText("已成功撤销操作，倒计时3s后窗口自动跳转！");
						SwingUtilities.invokeLater(new Runnable()
				         {
					        public void run()
					         {
						        try
					            {
					              Thread.sleep(3000);
				                }catch(InterruptedException ee)
			                    {
				  
			                    }
                             setVisible(false);
					         }
				        });
			}
      }
}
    
	
}