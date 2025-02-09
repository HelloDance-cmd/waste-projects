#include <iostream>

void insertionSort(int *a, int len) {
    for(int i = 1; i < len; ++i) {
        int j = i - 1;
        int n = a[i];
        while(j >= 0 && a[j] < a[j + 1]) {
            a[j + 1] = a[j];
            j--;
        }

        a[j + 1] = a[j];
    }
}

int main(int argc, char const *argv[])
{
    int a[5];
    for(int i = 0; i < 5; ++i)
        std::cin >> a[i];
    
    insertionSort(a, 5);

    for(int i = 0; i < 5; ++i)
        std::cout << a[i];
    return 0;
}