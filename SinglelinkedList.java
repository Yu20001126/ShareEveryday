package node;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
public class SinglelinkedList {
public static void main(String []arg) {
	//����һ������
	//�ȴ����ڵ�
	HeroNode h1 = new HeroNode(132, "Theshy", "�����·�һ����");
	HeroNode h2 = new HeroNode(006, "Uzi","����������Ժ�" );
	HeroNode h3 = new HeroNode(126, "Ning", "���֮�ս��ʱ");
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
//����һ��SinglelinkedList���������ǵ�Ӣ�ۣ�
class SinglinkedList
{//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ����
	private HeroNode head = new HeroNode(0, "", "");
	//��ӽڵ㵽�����б�
	//˼·���������Ǳ�ŵ�˳��ʱ���ҵ�
	//��ǰ�б�����Ľڵ㣬
	//������������next��ָ���µĽڵ�
	public void add(HeroNode heroNode) {
		//head�ڵ㲻��������������Ҫһ����������temp
		HeroNode temp = head;
		//���������ҵ����
		while(true) {
			//nextyuΪ�գ��ҵ������
			if(temp.next == null) {
				break;
			}
			//���û���ҵ�����temp����
			temp = temp.next;
		}
		//�˳�whileʱ��tempָ������������
		temp.next = heroNode;
		}
		public void add2(HeroNode heroNode) {
			//��һ����ʱ�����������ҵ���ӵ�λ��
			//��Ϊ������Ҫ�ҵ�temp��λ�����λ��
			//��ǰһ����㣬������벻��
			HeroNode temp = head;
			boolean flag = false;//��ӵı��
			//�Ƿ���ڣ�Ĭ��false
			while(true) {
				if(temp.next == null) {
					break;
					}if (temp.next.no >heroNode.no) //λ���ҵ�������temp��
									  {break;
				    }else if(temp.next.no == heroNode.no) {
					flag = true;//��Ŵ���
					break;
					
				    }
			temp = temp.next;//���ƣ����ű���
			
					}
			if(flag){
				System.out.printf("׼�������Ӣ�۱��%d�Ѿ����ڣ����ܲ���",heroNode.no);
					}else {
				//���뵽������temp�ĺ���
				heroNode.next = temp.next;
				temp.next = heroNode;
					}
					}
	//��ʾ�����������ķ���
	public void list() {
		if(head.next == null) {
			System.out.print("����Ϊ��");
			return;
		}
		//ͷ�ڵ㲻���ø���������
		HeroNode temp = head.next;
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			//���ڵ���ƶ������룡������ѭ����
			temp = temp.next;
		}
		
			
	}
	}
//����һ��ͷ�ڵ�HeroNode��ÿ��HeroNode�������һ���ڵ�
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//ָ����һ���ڵ�
	public HeroNode(int hno,String hname,String hnickname){
		this.no=hno;
		this.name=hname;
		this.nickname = hnickname;
		}
//Ϊ����ʾ���㣬��дtoString
	@Override
	public String toString() {
		return "HeroNode [���" + no + ", "+ "������" + name + ", "+ "��־��" + nickname ;
	}
	//�ڵ㴴�����
	}