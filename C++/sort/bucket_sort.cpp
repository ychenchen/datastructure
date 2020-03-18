#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	vector<double> V = {0.8, 0.3, 0.6, 0.5, 0.4, 0.2, 0.1, 0.9, 0.0, 0.7};
	// e为每个桶中期望元素个数, 理论值取1, 但一般会稍微取大一点.
	const size_t e = 1;
	vector<vector<double>> B(V.size() / e);	// 桶
	for (auto& D : B)
		D.reserve(e);
	// 将V中的元素分配到不同的桶中.
	for (const auto& x : V)
		B[x * B.size()].push_back(x);
	// 对每个同种元素进行排序.
	for (auto& D : B)
		sort(D.begin(), D.end());
	// 将每个桶中的元素依次加入到结果向量中.
	size_t i = 0;
	for (const auto& D : B)
		for (const auto& x : D)
			V[i++] = x;
	// 输出.
	for (const auto& x : V)
		cout << x << endl;
	
	return 0;
}
