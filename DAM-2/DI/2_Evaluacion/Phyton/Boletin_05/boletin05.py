class Alumno:

    def __init__(self,nombre,nota):
        self.__nombre = nombre
        self.__nota = nota

    @property
    def nombre(self):
        return self.__nombre
    @nombre.setter
    def nombre(self,x):
        self.__nombre = x
    @property
    def nota(self):
        return self.__nota
    @nota.setter
    def nota(self,x):
        self.__nota = x
    
    def comprobarNota(self):
        if self.nota < 5:
            print(self.nombre + " tiene un " + str(self.nota) + " => SUSPENSO")
        else:
            print(self.nombre + " tiene un " + str(self.nota) + " => APROBADO")

def main():
    #Crear el objeto alumno
    a1 = Alumno("Luis",7)
    print("Nombre: ",a1.nombre)
    print("Nota: ", str(a1.nota))
    a1.comprobarNota()
    #Crear otro objeto Alumno, pasandole solo el nombre
    a2 = Alumno("Maria")
    print("Nombre: ",a2.nombre)
    print("Nota: ", str(a2.nota))
    #Introducir nota con set
    a2.nota = 4
    #Comprobar la nota
    a2.comprobarNota()
# main()

class Persona:
    def __init__(self,nombre="",edad=0,):
        self.__nombre=nombre
        self.__edad=edad
    
    @property
    def nombre(self):
        return self.__nombre
    @nombre.setter
    def nombre(self,x):
        self.__nombre = x
    @property
    def edad(self):
        return self.__edad
    @edad.setter
    def edad(self,x):
        self.__edad = x

    def comprobarEdad(self):
        if self.edad < 18:
            print(self.nombre + " es menor de edad")
        else:
            print(self.nombre + " es mayor de edad")

def main1():
    p1 = Persona("Luis",32)
    print("Nombre: " + p1.nombre)
    print("Edad: " + str(p1.edad))
    p1.comprobarEdad()
# main1()

class Triangulo:
    def __init__(self,lado1=0,lado2=0,lado3=0):
        self.__lado1 = lado1
        self.__lado2 = lado2
        self.__lado3 = lado3
    
    @property
    def lado1(self):
        return self.__lado1
    @lado1.setter
    def lado1(self,x):
        self.__lado1 = x
    @property
    def lado2(self):
        return self.__lado2
    @lado2.setter
    def lado2(self,x):
        self.__lado2 = x
    @property
    def lado3(self):
        return self.__lado3
    @lado3.setter
    def lado3(self,x):
        self.__lado3 = x

    def comprobarLados(self):
        if self.lado1 == self.lado2 == self.lado3:
            print("Triangulo equilatero")
        elif self.lado1 == self.lado2 or self.lado1 == self.lado3 or self.lado2 == self.lado3:
            print("Triangulo isosceles")
        else:
            print("Triangulo escaleno")    

def main2():
    t1 = Triangulo(2,2,2)
    print("Lado 1: " + str(t1.lado1))
    print("Lado 2: " + str(t1.lado2))
    print("Lado 3: " + str(t1.lado3))
    t1.comprobarLados()
# main2()

class Calculadora:

    def __init__(self):
        self.__n1 = int(input("Numero 1: "))
        self.__n2 = int(input("Numero 2: "))
    
    @property
    def n1(self):
        return self.__n1
    @n1.setter
    def n1(self,x):
        self.__n1 = x
    @property
    def n2(self):
        return self.__n2
    @n2.setter
    def n2(self,x):
        self.__n2 = x
    
    def sumar(self):
        suma = self.n1 + self.n2
        print("Valor de la suma: " + str(suma))
    
    def resta(self):
        resta = self.n1 - self.n2
        print("Valor de la resta: " + str(resta))
    
    def multiplicacion(self):
        multiplicacion = self.n1 * self.n2
        print("Resultado de la multiplicacion: " + str(multiplicacion))

    def division(self):
        try:
            division = self.n1 / self.n2 
            print("Resultado de la division: " + str(division))
        except:
            print("Algo salio mal")
    
def main3():
    c1 = Calculadora()
    c1.sumar()
    c1.resta()
    c1.multiplicacion()
    c1.division()
# main3()

class Cuenta:
    def __init__(self,titular, cantidad):
        self.__titular = titular
        self.__cantidad = cantidad
    
    @property
    def titular(self):
        return self.__titular
    @titular.setter
    def titular(self,x):
        self.__titular = x
    @property
    def cantidad(self):
        return self.__cantidad
    @cantidad.setter
    def cantidad(self,x):
        self.__cantidad = x

    def __str__(self):
        return "Cuenta: titular: " + self.__titular + " cantidad: " + str(self.__cantidad)
    
class CajaAhorro(Cuenta):
    def __init__(self, titular, cantidad):
        super().__init__(titular, cantidad)

    def __str__(self):
        return "CajaAhorro: " + super().__str__()

class PlazoFijo(Cuenta):
    def __init__(self, titular, cantidad,plazo,interes):
        super().__init__(titular, cantidad)
        self.__plazo = plazo
        self.__interes = interes
    
    @property
    def plazo(self):
        return self.__plazo
    @plazo.setter
    def plazo(self,x):
        self.__plazo = x
    @property
    def interes(self):
        return self.__interes
    @interes.setter
    def interes(self,x):
        self.__interes = x

    def obtenerImporte(self):
        return (self.interes * self.cantidad) / 100

    def __str__(self):
        return "PlazoFijo:",(super().__str__()),"plazo:",str(self.__plazo),"interes:",str(self.__interes),"interes total:",str(self.obtenerImporte())

class main4():
    cuenta = Cuenta(titular="Luis", cantidad=1000)
    print(cuenta.__str__())
    ahorro = CajaAhorro(cuenta.titular,cuenta.cantidad)
    print(ahorro.__str__())
    plazo = PlazoFijo(cuenta.titular,cuenta.cantidad,plazo=12,interes=0.02)
    print(plazo.__str__())
main4()

class Persona:

    def __init__(self,nombre,edad,dni):
        self.__nombre = nombre
        self.__edad = edad
        self.__dni = dni
    
    @property
    def nombre(self):
        return self.__nombre
    @nombre.setter
    def nombre(self,x):
        self.__nombre = x
    @property
    def edad(self):
        return self.__edad
    @edad.setter
    def edad(self,x):
        self.__edad = x  
    @property
    def dni(self):
        return self.__edad
    @dni.setter
    def dni(self,x):
        self.__dni = x  

    def __str__(self):
        return "Persona nombre: " + self.__nombre + " edad: " + str(self.__edad) + " dni: " + str(self.__dni)
    
    def esMayorDeEdad(self):
        if self.__edad >= 18:
            return True
        else:
            return False

class Cuenta:

    def __init__(self,titular,cantidad):
        self.__titular = titular
        self.__cantidad = cantidad

    @property
    def titular(self):
        return self.__titular
    @titular.setter
    def titular(self,x):
        self.__titular = x  
    @property
    def cantidad(self):
        return self.__cantidad   
    @cantidad.setter
    def cantidad(self,x):
        self.__cantidad = x   
        
    def __str__(self):
        return "Cuenta titular: " + self.__titular.__str__() + " cantidad: " + str(self.__cantidad)
 
    def ingresarCantidad(self,cantidad):
        if (cantidad >= 0):
            self.__cantidad = cantidad
    
    def retirarCantidad(self,cantidadRetirar):
        self.__cantidad = self.__cantidad - cantidadRetirar

class CuentaJoven(Cuenta):

    def __init__(self, titular, cantidad, bonificacion):
        super().__init__(titular, cantidad)
        self.__bonificacion = bonificacion

    @property
    def bonificacion(self):
        return self.__bonificacion
    @bonificacion.setter
    def bonificacion(self,x):
        self.__bonificacion = x 
    
    def esTitularValido(self):
        if (self.titular.edad >= 18 and self.titular.edad < 25):
            return True
        else:
            return False
    
    def retirarCantidad(self, cantidadRetirar):
        if (self.esTitularValido() == True):
            self.cantidad = self.cantidad - cantidadRetirar
            print("Cantidad retirada")
        else:
            print("No puede retirar dinero")

    def mostrar(self):
        print("Cuenta Joven: " + self.__bonificacion)

# class main5():
#     p = Persona("Oscar",23,"123455678A")
#     c = Cuenta(p,1000)
#     # c.__str__()
#     cj = CuentaJoven(p,1000,10)
#     print(cj)
#     cj.retirarCantidad(100)
#     print(cj)
# main5()