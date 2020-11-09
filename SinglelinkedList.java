package node;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
public class SinglelinkedList {
public static void main(String []arg) {
	//进行一个测试
	//先创建节点
	HeroNode h1 = new HeroNode(132, "Theshy", "天神下凡一锤四");
	HeroNode h2 = new HeroNode(006, "Uzi","不捡灯笼我自豪" );
	HeroNode h3 = new HeroNode(126, "Ning", "夺冠之日结婚时");
	HeroNode h4 = new HeroNode(001, "ClearLove", "4396");
	HeroNode h5 = new HeroNode(031, "xioahu", "2200");
	SinglinkedList singlelinkedList = new SinglinkedList();
	singlelinkedList.add2(h1);
	singlelinkedList.add2(h2);
	singlelinkedList.add2(h3);
	singlelinkedList.add2(h4);
	singlelinkedList.add2(h5);
	singlelinkedList.list();
	
}
}
//定义一个SinglelinkedList来管理我们的英雄！
class SinglinkedList
{//先初始化一个头节点，头节点不要动！
	private HeroNode head = new HeroNode(0, "", "");
	//添加节点到单向列表
	//思路：当不考虑编号的顺序时，找到
	//当前列表的最后的节点，
	//将最后这个结点的next域指向新的节点
	public void add(HeroNode heroNode) {
		//head节点不动，所以我们需要一个辅助变量temp
		HeroNode temp = head;
		//遍历链表，找到最后
		while(true) {
			//nextyu为空，找到了最后
			if(temp.next == null) {
				break;
			}
			//如果没有找到，将temp后移
			temp = temp.next;
		}
		//退出while时，temp指向了链表的最后
		temp.next = heroNode;
		}
		public void add2(HeroNode heroNode) {
			//整一个临时变量来帮助找到添加的位置
			//因为单链表，要找的temp是位于添加位置
			//的前一个结点，否则加入不了
			HeroNode temp = head;
			boolean flag = false;//添加的编号
			//是否存在，默认false
			while(true) {
				if(temp.next == null) {
					break;
					}if (temp.next.no >heroNode.no) //位置找到，插入temp后
									  {break;
				    }else if(temp.next.no == heroNode.no) {
					flag = true;//编号存在
					break;
					
				    }
			temp = temp.next;//后移，接着遍历
			
					}
			if(flag){
				System.out.printf("准备插入的英雄编号%d已经存在，不能插入",heroNode.no);
					}else {
				//插入到链表中temp的后面
				heroNode.next = temp.next;
				temp.next = heroNode;
					}
					}
	//显示链表（遍历）的方法
	public void list() {
		if(head.next == null) {
			System.out.print("链表为空");
			return;
		}
		//头节点不动用辅助变量来
		HeroNode temp = head.next;
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			//将节点后移动，必须！否则，死循环！
			temp = temp.next;
		}
		
			
	}
	}
//定义一个头节点HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//指向下一个节点
	public HeroNode(int hno,String hname,String hnickname){
		this.no=hno;
		this.name=hname;
		this.nickname = hnickname;
		}
//为了显示方便，重写toString
	@Override
	public String toString() {
		return "HeroNode [编号" + no + ", "+ "姓名：" + name + ", "+ "标志：" + nickname ;
	}
	//节点创建完毕
	}