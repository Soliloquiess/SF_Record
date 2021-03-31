package Queue_Stack;


import java.util.*;


class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val=x;
	}
}

//�� ������ bfs Ǫ�µ� ���� �⺻���� ����. Ʈ����� �⺻ ���� �ϰ� �� Ʈ������ ������� ¥�����ΰ�.
//bfs�� ť�� ������ dfs�� ������ ������ 
public class _03_BinaryTreeLevelOrder{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(solve(root));
	}
	public static List<List<Integer>> solve(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		//ť�� Ʈ����尡 ������.
		queue.offer(root);
		
		
		//���� ����ó�� �ܿ�� ��.
		while(!queue.isEmpty()) {	//�α��� ��.
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			//���⿡ �����ض�.
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				//Ʈ����� Ÿ�����η� ����(ť���� �ϳ��� ����)
				list.add(node.val);
				//val�� �� ���� ���µ� �װ� ����Ʈ�� ����.(3�� �� ���)
				//ť ��ũ�帮��Ʈ�� ��� �̾���. ���� ���ö� ����.
				if(node.left!=null) {
					queue.offer(node.left);
				}
				if(node.right!= null) {
					queue.offer(node.right);
				}
			}
//			6,7�� ���� ������ ������ �� for�� �ѹ��� ���� 3 �ѹ��� ����.
			
//			for�� �����ڸ��� �� ���� result�� ����.
//			�� while���� �� ������ result�� ����.
			result.add(list);
		}
		return result;
	}
}
