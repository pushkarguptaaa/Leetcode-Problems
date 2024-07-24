package StacksandQueues;

public class QueueUsingArray {
    public static void main(String[] args) {
        
    }
}

class MyQueue {

    int front, rear, cnt;
	int arr[] = new int[100005];
	int n= arr.length;

    MyQueue()
	{
		front=-1;
		rear=-1;
		cnt=0;
	}
	
	void push(int x)
	{
	    if(rear==-1){
	        front= 0;
	        rear=0;
	    }
	    else rear= (rear+1)%n;
	    
	    arr[rear]= x;
	    cnt++;
	} 

	int pop()
	{
		if(front==-1) return -1;
		
		int x= arr[front];
		
		if(cnt==1){
		    front= -1;
		    rear= -1;
		}
		else front= (front+1)%n;
		
		cnt--;
		return x;
	} 
}
