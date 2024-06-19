# def ej1():
#     print("¡hola, estoy estudiando desarrollo de aplicaciones multiplataforma!")
# ej1()
# def ej2():
#     text = "¡Soy alumno de DAM2!"
#     print(text)
# ej2()
# def ej3():
#     nombre = input("Nombre: ")
#     print("¡Hola " + nombre + "!")
# ej3()
# def ej4():
#     nombre = input("Nombre: ")
#     numero = int(input("Numero entero: "))
#     for i in range(numero):
#         print(nombre)
# ej4()
# def ej5():
#     nombre = input("Nombre: ")
#     print(nombre.upper + " tiene",len(nombre),"letras")
# ej5()
# def ej6():
#     suma =  3+2
#     division = suma / 2.5
#     resultado = pow(division, 2)
#     print(resultado)
# ej6()
# def ej7():
#     horas = float(input("Numero de horas trabajadas: "))
#     costo = float(input("Costo por hora: "))
#     paga = horas * costo
#     print(paga, "€")
# ej7()
# def ej8():
#     peso = float(input("Peso en kg: "))
#     altura = float(input("Estatura en metros: "))
#     imc = peso / pow(altura,2)
#     print(round(imc,2))
# ej8()
# import math
# def ej9():
#     precio = float(input("Introduce un precio con dos decimales: "))
#     result = math.modf(precio)
#     entero = result[1]
#     decimal = result[0]
#     print(entero,"euros",round(decimal,2),"centimos")
# ej9()
def ej10():
    precioDescuento = 0.4 * 3.49
    barrasVendidas = int(input("Barras vendidas que no son del dia: "))
    print("El precio de una barra de pan fresca es de ",3.49)
    print("Se le aplica un descuento del 60% por no ser fresca")
    coste = precioDescuento * barrasVendidas
    print("Coste total: ", round(coste,2))
ej10()
    