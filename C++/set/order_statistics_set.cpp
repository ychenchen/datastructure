#include <iostream>
#include <set>
#include <vector>

using namespace std;

int main()
{
	set<int> S = {3, 2, 1, 4, 5};
	// get the kst smaller element in set S
	int k;
	cin >> k;
	if (k < 1 || k > S.size())
		cout << "out of range!" << endl;
	else
	{
		// Method 1
		auto iter = S.begin();
		for ( int i = 0; i < k - 1; ++i)
			++iter;
		cout << *iter << endl;
		
		// Method2, slower than method1
		vector<int> V;
		// reserve k - 1 space
		V.reserve(k -1);
		// Remove k - 1 elements from S and reserve them to V
		for (int i = 0; i < k - 1; ++i)
		{
			V.push_back(*S.begin());
			S.erase(S.begin());
		}
		cout << *S.begin() << endl;
		
		// push back the k - 1 element to S
		//S.insert(V.begin(), V.end());
		//for (size_t i = 0; i < V.size(); ++i)
		//	S.insert(V[i]);
		// range based for loop
		for (const auto& x: V)
			S.insert(x);
		return 0;
	}
}
