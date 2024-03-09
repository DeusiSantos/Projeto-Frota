#include <stdio.h>

int buscaBinaria(int arr[], int l, int r, int x) {
    if (r >= l) {
        int mid = l + (r - l) / 2;
        if (arr[mid] == x)
            return mid;
        if (arr[mid] > x)
            return buscaBinaria(arr, l, mid - 1, x);

        return buscaBinaria(arr, mid + 1, r, x);
    }
    return -1;
}

int main(void) {
    int arr[] = {2, 3, 4, 10, 40};
    int n = sizeof(arr) / sizeof(arr[0]);
    int x = 60;
    int resultado = buscaBinaria(arr, 0, n - 1, x);
    if (resultado == -1)
        printf("Elemento não presente no array\n");
    else
        printf("Elemento encontrado no índice: %d\n", resultado);
    return 0;
}
