#include <iostream>
#include <set>
#include <vector>
#include <string>

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
	// difference set.
	set<int> A = {3, 2, 1, 4, 7, 9, 11};
	set<int> B = {6, 2, 9};
	
	vector<int> C;
	C.reserve(A.size());	
	for (auto iter = A.begin(); iter != A.end(); ++iter)
		if (B.find(*iter) == B.end())
			C.push_back(*iter);
	print_all(C);

	set<string> D = {"English", "Ability", "Algorithm", "Faith", "Data"};
	set<string> E;
	
	while (!D.empty())
	{
		if ((*D.begin()).size() % 2 == 0)
			E.insert(*D.begin());
		D.erase(D.begin());
	}
	print_all(E);
	
	cout << "*****" << endl;

	// dynamic change elements in set.
	set<int> F = {3, 5, 1, 7, 2, 8, 0};
	while (F.size() > 1)
	{
		int first = *F.begin();
		cout << first << endl;
		F.erase(F.begin());
		int second = *F.begin();
		cout << second << endl;
		F.erase(F.begin());
		F.insert(first + second);
		cout << *F.begin() << endl;
		cout << "-----" << endl;
	}
	if (F.size() > 0)
		cout << *F.begin() << endl;

	return 0;
} 
