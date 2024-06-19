from Ejercicio5_ModYPaq.cuenta import Cuenta

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
