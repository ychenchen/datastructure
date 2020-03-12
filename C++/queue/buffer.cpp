#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{
	vector<int> buffer;
	size_t C = 10;
	size_t N = C + 1;	//真实buffer长度为N.
	buffer.resize(N);

	// front和rear的初始值任选buffer中的有效位置，这里都取N/2.
	size_t front = N / 2;
	size_t rear = N / 2;

	int x = 0;

	// 当buffer不满, 持续放入0, 1, 2, ..., C-1
	while (rear + 1 < N ? front != rear + 1: front != 0)
	{
		buffer[rear] = x++;
		// 下面的操作比rear = (rear + 1) % N更快.
		if (rear < C)
			++rear;
		else
			rear = 0;
	}
	
	// 当buffer不空, 持续输出队首元素并出队.
	while (front != rear)
	{
		cout << buffer[front] << " ";
		// 下面的操作比front = (front + 1) % N更快.
		if (front < C)
			++front;
		else
			front = 0;
	}
	cout << endl;
	
	// 直接使用队列.
	queue<int> Q;
	for (x = 0; Q.size() != C; x++)
		Q.push(x);
	while (!Q.empty())
	{
		cout << Q.front() << " ";
		Q.pop();
	}
	cout << endl;

	return 0;
}
