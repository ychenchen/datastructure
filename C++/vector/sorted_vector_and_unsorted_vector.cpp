#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

template <typename T>
void print_all(const T& S)
{
	for (const auto& x: S)
		cout << x << ' ';
	cout << endl;
}

int main()
{
	int key;
	
	// sorted vector.
	vector<int> SV = {1, 3, 6, 6, 8, 9};

	// find element.
	cin >>key;
	auto iter = lower_bound(SV.begin(), SV.end(), key);
	cout << iter - SV.begin() << endl;
	iter = upper_bound(SV.begin(), SV.end(), key);
	cout << iter - SV.begin() << endl;
	
	// insert element.
	key = 0;
	SV.insert(upper_bound(SV.begin(), SV.end(), key), key);

	// delete element if exists.
	if (binary_search(SV.begin(), SV.end(), key))
	{
		iter = upper_bound(SV.begin(), SV.end(), key);
		SV.erase(--iter);
	}

	// find the range of duplicate key, [range.first, range.second)
	auto range = equal_range(SV.begin(), SV.end(), key);
	// print range.
	// remove elements in this range.
	SV.erase(range.first, range.second);
	// print
	print_all(SV); //1 3 6 6 8 9

	// unsorted vector.
	vector<int> USV = {9, 6, 1, 3, 8, 6};
	// insert element.
	key = 0;
	USV.push_back(key);
	// remove the last key in duplicate ones.
	key = 6;
	// use reverse iter instead of iter.
	auto riter = find(USV.rbegin(), USV.rend(), key);
	// delete if exists.
	if (riter != USV.rend())
	{
		*riter = USV.back();
		USV.pop_back();
	}	
	// print.
	print_all(USV);
	
	return 0;
}
