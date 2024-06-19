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
