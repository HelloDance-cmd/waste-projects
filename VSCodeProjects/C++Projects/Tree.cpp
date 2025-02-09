#include <iostream>

void QuicklySort(int8_t * arr, unsigned short size, int i, int j)
{
    int priv = i;
    int left = i, right = j;
    while(left <= right)
    {
        while(arr[right] < arr[priv]) right--;    
        std::swap(arr[right], arr[priv]);
        priv = right;
    
        while(arr[left] > arr[priv]) left++;
        std::swap(arr[left], arr[priv]);
        priv = left;
    }
}

int main()
{
    int8_t arr[5] = {1, 3, 6, 7, 0};
    QuicklySort(arr, 10, 0, 4);
    
    for(int8_t item : arr)
        std::cout << item << std::endl;
    
    return 0;
}