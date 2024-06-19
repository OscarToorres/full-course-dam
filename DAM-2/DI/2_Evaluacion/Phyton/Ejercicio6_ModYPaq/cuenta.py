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
