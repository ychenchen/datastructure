#include <iostream>
#include <vector>

using namespace std;

// Method1, for convience, we didn't use vector<T>::const_iterator.
template <typename T>
bool binary_search_vector(const T& key, typename vector<T>::iterator data, size_t N)
{
	size_t low = 0;
	size_t high = N;
	while(low < high)
	{
		size_t mid = low + (high - low)/2;
		if (key < *(data + mid))
			high = mid;
		else if (*(data + mid) < key)
			low = mid + 1;
		else
			return true;
	}
	return false;
}

// Method2, use iterator, clearly described. What's more, it can be used for Array.
template <typename T, typename iterator>
bool binary_search_iterator(const T& key, iterator L, iterator R)
{
	while ( L < R)
	{
		iterator M = L + (R -L)/2;
		if (key < *M)
			R = M;
		else if ( *M < key)
			L = M + 1;
		else
			return true;
	}
	return false;
}

// Method3, const_iterator
template <typename T>
bool binary_search_const_iterator(const T& key, typename vector<T>::const_iterator data, size_t N)
{
	size_t low = 0;
        size_t high = N;
        while(low < high)
        {
                size_t mid = low + (high - low)/2;
                if (key < *(data + mid))
                        high = mid;
                else if (*(data + mid) < key)
                        low = mid + 1;
                else
                        return true;
        }
        return false;
}


int main()
{
	vector<int> v = {1, 2, 3, 4, 5};
	cout << binary_search_vector(2, v.begin(), 5) << endl;
	cout << binary_search_vector(0, v.begin(), 5) << endl;
	cout << binary_search_vector(2, v.begin() + 2, 5) << endl;
	cout << binary_search_vector(0, v.begin(), 0) << endl;
	cout << binary_search_iterator(2, v.begin(), v.end()) << endl;
	cout << binary_search_iterator(0, v.begin(), v.end()) << endl;
	cout << binary_search_iterator(2, v.begin() + 2, v.end()) << endl;
	cout << binary_search_iterator(0, v.begin(), v.end()) << endl;
	cout << binary_search_const_iterator(2, v.cbegin(), 5) << endl; //difference between cbegin() and begin() is data in cbegin() cann't be modified.
	cout << binary_search_const_iterator(0, v.cbegin(), 5) << endl;
	cout << binary_search_const_iterator(2, v.cbegin() + 2, 5) << endl;
	cout << binary_search_const_iterator(0, v.cbegin(), 0) << endl;
	return 0;
}
