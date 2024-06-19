# def ej01():
#     edad = int(input("Dime tu edad: "))
#     if edad >= 18:
#         print("Mayor de edad")
#     else:
#         print("Menor de edad")
# ej01()

def ej02():
    psw = "abc123."
    pswUser = input("Introduce una contraseña: ")
    if (psw.lower() == pswUser.lower()):
        print("Coinciden")
    else:
        print("No coinciden")
# ej02()

def ej03():
    nombre = input("Nombre: ")
    sexo = input("Sexo ('h'-> hombre 'm'-> mujer): ")
    if (sexo == "m"):
        if (nombre < "m"):
            print("Grupo A")
        else:
            print("Grupo B")
    else:
        if(nombre > "n"):
            print("Grupo A")
        else:
            print("Grupo B")
# ej03()

def ej04():
    puntuacion = float(input("Puntuacion: "))
    if (puntuacion >= 0.0 and puntuacion < 0.4):
        print("Tienes un nivel inaceptable, tu plus es de 0")
    elif (puntuacion >= 0.4 and puntuacion < 0.6):
        print("Tienes un nivel aceptable, tu plus es de", 2400*0.4)
    elif(puntuacion >= 0.6):
        print("Tienes un nivel meritorio, tu plus es de", 2400*puntuacion)
    else:
        print("Puntuación no valida")
# ej04()

def ej05():
    pregunta = input("Que tipo de pizza quieres: vegetariana o no vegetariana:")

    if ("vegetariana" == pregunta):
        print("Ingredientes:")
        ingredientes = ["Pimiento", "Tofu"]
        for x in range(len(ingredientes)):
            print(str(x +1), ingredientes[x])
        opcion = int((input("Selecciona uno:")))
        print("Se escogio una pizza vegetariana con mozzarela, tomate,", ingredientes[opcion - 1])
    elif("no vegetariana" == pregunta):
        print("Ingredientes:")
        ingredientes = ["Peperoni", "Jamón", "Salmón"]
        for x in range(len(ingredientes)):
            print(str(x +1), ingredientes[x])
        opcion = int(input("Selecciona uno:"))
        print("Se escogio una pizza no vegetariana con mozzarela, tomate,", ingredientes[opcion - 1])
ej05()

def ej06():
    palabra = input("Introduce una palabra:")
    variable = 0
    for x in range (10):
        print(str(x + 1),palabra)
        variable += 1
# ej06()

def ej07():
    opcion = int(input("Dame un numero entero positivo: "))
    for x in range(opcion):
        if ((x % 2) != 0):
            print(x,end=', ')
# ej07()

def ej08():
    opcion = int(input("Dame un numero entero positivo: "))
    for x in range(opcion):
        for y in range(x, 0 , -2):
            if ((y % 2) != 0):
                print(y, end=" ")
        print("")
ej08()

def ej09():
    frase = str(input("Dime una frase: "))
    letra = str(input("Dime una letra: "))
    contador = 0

    for x in range(len(frase)):
        if (frase[x] == letra):
            print(frase[x], end=" ")
            contador += 1
    print("\nLa letra",letra,"aparece",contador,"veces")
# ej09()

def ej10():    
    while (True):
        frase = input("Intrudoce un texto: ")
        if ("stop" == frase):
            break
        print(frase)
# ej10()
