def ej01():
    asignaturas = ["AD","DI", "PMDM","SXE"]
    for x in range(len(asignaturas)):
        print(asignaturas[x])
# ej01()

def ej02():
    print("Asignaturas de DAM 2")
    asignaturas = ["AD","DI", "PMDM","SXE", "PSP", "EIE"]
    notas = []
    for x in range(len(asignaturas)):
        print("Nota en", asignaturas[x],end=":")
        nota = float(input())
        notas.append(nota)
    zipped = zip(asignaturas, notas)
    for x,y in zip(asignaturas, notas):
        print("En",x,"has sacado",y)
# ej02()

def ej03():
    combinacion = []
    for x in range(6):
        numero = int(input("Numeros de la loteria: "))
        combinacion.append(numero)
    combinacion.sort()
    for x in range(len(combinacion)):
        print(combinacion[x])
# ej03()

def ej04():
    numeros = []
    for x in range(10):
        numeros.append(x +1)
    numeros.sort(reverse=True)
    for x in range(len(numeros)):
        if numeros[x] == numeros[-1]:
            print(numeros[x])
            break
        print(numeros[x], end=", ")
# ej04()

def ej05():
    print("Asignaturas de DAM 2")
    asignaturas = ["AD","DI", "PMDM","SXE", "PSP", "EIE"]
    asignaturasSuspensas = []
    for x in range(len(asignaturas)):
        print("Nota en", asignaturas[x],end=":")
        nota = float(input())
        if nota < 5:
            asignaturasSuspensas.append(asignaturas[x])
    print("Tienes que repetir",end=": ")
    for x in range(len(asignaturasSuspensas)):
        print(asignaturasSuspensas[x],end=", ")
# ej05()

def ej06():
    abecedario = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"]
    for x in range(len(abecedario),0,-1):
        if (x % 3) == 0:
            abecedario.pop(x - 1)
            print("Eliminada la posicion ", x)

    for x in range(len(abecedario)):
            print(abecedario[x], end=" ")
# ej06()

def ej07():
    palabra = input("Introduce una palabra: ")
    letras = []
    for x in range(len(palabra)):
        if (letras.count(palabra[x]) == 0):
            letras.append(palabra[x])

    for x in range(len(letras)):
        contador = 0
        for y in range(len(palabra)):
            if (letras[x] == palabra[y]):
                contador += 1
        print("La letra",letras[x],"aparece",contador,"veces")
ej07()

def ej08():
    precios = [50,75,46,22,80,65,8]
    print("El mas bajo es: ", min(precios))
    print("El mas alto es: ", max(precios))
# ej08()

def ej09():
    v1 = [1,2,3]
    v2 = [-1,0,2]
    productoEscalar = 0
    for x in range(3):
        productoEscalar += v1[x] * v2[x]
    print(productoEscalar)
# ej09()

def ej10():
    valores = (1,2,3,4,5,6,7,8,9,10)
    indice = int(input("Introduce un indice [1-10]: "))
    for x in range(indice):
        print(valores[x], end=" ")
# ej10()