package maze_setting;

public class Stack {

	private static int top = -1;
	private static Position[] stk = new Position[Define.CAPACITY];
	
	public void push(Position pos){
		stk[++top] = pos;
	}
	
	public Position pop(){
		return stk[top--];
	}
	
	public boolean isEmpty(){
		if (top < 0)
			return true;
		else return false;
	}

	public int getTop(){
		return top;
	}
	
	public Position getStack(int index){
		return stk[index];
	}
}
