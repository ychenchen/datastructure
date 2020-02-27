#include <iostream>
#include <vector>

using namespace std;

int main()
{
	const int n = 42;
	const int c =1;
	
	// define an array and a vector
	int A1[n];
	vector<int> V1(n);

	// array initialization
	for (size_t i = 0; i < n; ++i)
		A1[1] = c;
	
	// vector initialization
	vector<int> V2(n, c);

	// initialization with list
	vector<int> V3 = {1, 2, 3, 4, 5};
	for(size_t i = 0; i < V3.size(); ++i)
		cout << V3[i] << " ";
	cout << endl;

	// dynamic add or remove elements from vector
	V3.push_back(6);
	cout << V3.size() << endl;
	cout << V3.front() << " " << V3.back() << endl;
	V3.pop_back();
	cout << V3.size() << endl;
	cout << V3.front() << " " << V3.back() << endl;

	// Iterator
	for (auto iter = V3.begin(); iter != V3.end(); ++iter)
		cout << *iter << " ";
	cout << endl;

	return 0;		
}
