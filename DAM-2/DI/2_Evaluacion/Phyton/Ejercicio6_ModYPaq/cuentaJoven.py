from Ejercicio6_ModYPaq.cuenta import Cuenta

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