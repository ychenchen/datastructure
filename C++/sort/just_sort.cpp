#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	const int n = 5;
	int A[n] = {2, 5, 3, 1, 4};
	
	// sort from smaller to bigger
	sort(A, A + n);	//left closed, right opened
	for (int i = 0; i < n; ++i)
		cout << A[i] << " ";
	cout << endl;

	// sort from bigger to smaller with functional object greater<int>()
	sort(A, A + n, greater<int>());
	for (int i = 0; i < n; ++i)
		cout << A[i] << " ";
	cout << endl;

	// sort string
	string B[n] = {"www", "algorithm", "racer", "text", "wait"};
	sort(B, B + n);
	for (int i = 0; i < n; ++i)
    		cout << B[i] << endl;
  	sort(B, B + n, greater<string>());
  	for (int i = 0; i < n; ++i)
    		cout << B[i] << endl;

	// sort vector
	vector<string> V = {"www", "algorithm", "racer", "text", "wait"};
	sort(V.begin(), V.end());
	sort(V.begin(), V.end(), greater<string>());

	// print all elements in vector with iterator
	for (auto iter = V.begin(); iter != V.end(); ++iter)
		cout << *iter << endl;	

	// sort from bigger to smaller with reverse iterator
	sort(V.rbegin(), V.rend());

	cout << "*****" << endl;
	// range based for loop
	for (const string &x : V)
		cout << x << endl;
	
	return 0;
}
