#include <iostream>
#include <set>

using namespace std;

int main()
{
	set<int> S = {3, 2, 1, 4, 5};

	// insert
	S.insert(1);
	S.insert(7);
	
	// find & delete
	auto iter = S.find(0);
	if (iter != S.end())
		S.erase(iter);
	iter = S.find(5);
		S.erase(iter);
	S.erase(5);

	// iter
	iter = S.begin();
	cout << *iter << endl;
	++iter;
	cout << *iter << endl;
	--iter;
	cout << *iter << endl;
	
	// traverse set
	for (auto iter = S.begin(); iter != S.end(); ++iter)
		cout << *iter << ' ';
	cout << endl;
	for (auto riter = S.rbegin(); riter != S.rend(); ++riter)
		cout << *riter << ' ';
	cout << endl;
	
	// enhanced for loop
	for (const auto& x : S)
		cout << x << ' ';
	cout << endl;
	
	return 0;			
}
