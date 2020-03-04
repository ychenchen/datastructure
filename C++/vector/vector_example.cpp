#include <iostream>
#include <vector>

using namespace std;

int main()
{
	// define a vector with a initialized length 10
	vector<int> A(10);
	// initialize A with the position of each element.
	// for convience, we use size_t, actually, it should be vector<int>::size_tpye
	// the subscript usage of a vector is the same as that of an array, but make sure that the number of elements should equal to size()
	for (size_t i = 0; i < A.size(); ++i)
		A[i] = static_cast<int>(i);
	// iter
	for (auto iter = A.begin(); iter != A.end(); ++iter)
		*iter = 1;
	
	// define a vector B with length 5, all elements are initialized with 5.
	vector<int> B(5, 3);
	
	// add 100 2 at the end of Vector B.
	B.resize(B.size() + 100, 2);
	B.push_back(4);

	// another usage of iter.
	auto iter = B.begin();
	for (size_t i = 0; i < B.size(); ++i)
		*(iter + i) *= 2;
	
	while (!B.empty())
	{
		cout << B.back() << endl;
		B.pop_back();
	}
	
	// receive elements from input, terminate with a negative number.
	vector<int> C;
	int data;
	// it is very fast based on push_back
	for (cin >> data; data >= 0; cin >> data)
		C.push_back(data);
	for (const auto& x : C)
		cout << x << endl;

	// initialization.
	vector<int> D = {4, 2, 1, 5, 3};
	
	return 0;
}
