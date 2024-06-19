from Ejercicio5_ModYPaq.cuenta import Cuenta
from Ejercicio5_ModYPaq.cajaAhorro import CajaAhorro
from Ejercicio5_ModYPaq.plazoFijo import PlazoFijo


class main4():
    cuenta = Cuenta(titular="Luis", cantidad=1000)
    print(cuenta.__str__())
    ahorro = CajaAhorro(cuenta.titular,cuenta.cantidad)
    print(ahorro.__str__())
    plazo = PlazoFijo(cuenta.titular,cuenta.cantidad,plazo=12,interes=0.02)
    print(plazo.__str__())
main4()