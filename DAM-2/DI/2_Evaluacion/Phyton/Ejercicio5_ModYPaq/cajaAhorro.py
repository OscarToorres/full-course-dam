from Ejercicio5_ModYPaq.cuenta import Cuenta

class CajaAhorro(Cuenta):
    def __init__(self, titular, cantidad):
        super().__init__(titular, cantidad)

    def __str__(self):
        return "CajaAhorro: " + super().__str__()
