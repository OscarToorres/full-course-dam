from Ejercicio6_ModYPaq.cuenta import Cuenta
from Ejercicio6_ModYPaq.cuentaJoven import CuentaJoven
from Ejercicio6_ModYPaq.persona import Persona

def main():
    p = Persona("Oscar", 23, "12345678A")
    c = Cuenta(p,1000)
    # c.__str__()
    cj = CuentaJoven(p,1000,10)
    print(cj)
    cj.retirarCantidad(100)
    print(cj)
main()