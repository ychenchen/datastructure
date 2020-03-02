#include <iostream>
#include <vector>

using namespace std;

uint64_t iterative_Collatz(size_t n)
{
	if (n < 1)
		return 0;
	uint64_t l = 1;
	while (n != 1)
	{
		n = (n %2 == 0) ? n /2 : 3 * n + 1;
		++l;
	}
	return l;
}

// Memorized Method
uint64_t memoized_Collatz(vector<uint64_t>& V, size_t n)
{
	// if n is beyond V.size(), degrade it to some digital which is inside V.size()
	uint64_t d = 0;
	while ( n >= V.size())
	{
		n = (n %2 == 0) ? n /2 : 3 * n + 1;
		++d;
	}
	// compute V[n]
	if (V[n] == 0) // means V[n] has never been computed.
		V[n] = memoized_Collatz(V, (n % 2 == 0) ? n / 2 : 3 * n + 1) + 1;
	// return V[n] plus d
	return V[n] + d;
		
}

int main()
{
	const size_t m = 10000;
	vector<uint64_t> V(m, 0);
	V[1] = 1;
	size_t max = 100000;
	bool equal = true;
	for (size_t n = 1; n <= max; ++n)
		if (iterative_Collatz(n) != memoized_Collatz(V, n))
			equal = false;
	cout << (equal ? "相符" : "不符") << endl;

	return 0;
}
