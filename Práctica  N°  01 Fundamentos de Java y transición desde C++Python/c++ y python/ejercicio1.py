def sumar_arreglo(arreglo):
    total = 0
    for elemento in arreglo:
        total += elemento
    return total

numeros = [1, 2, 3, 4, 5]
print(f"La suma es: {sumar_arreglo(numeros)}")
