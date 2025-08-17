#include <iostream>
#include <numeric> 

int sumar_arreglo(int arr[], int tamano) {
    int total = 0;
    for (int i = 0; i < tamano; ++i) {
        total += arr[i];
    }
    return total;
}

template <typename T>
T sumar_arreglo_moderno(const T& arr) {
    T total = 0;
    for (auto const& elemento : arr) {
        total += elemento;
    }
    return total;
}

int main() {
    int numeros[] = {1, 2, 3, 4, 5};
    int tamano = sizeof(numeros) / sizeof(numeros[0]);
    std::cout << "La suma es: " << sumar_arreglo(numeros, tamano) << std::endl;
    return 0;
}
