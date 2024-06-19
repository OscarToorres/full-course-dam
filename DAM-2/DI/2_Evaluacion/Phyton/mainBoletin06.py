from Boletin_06.menu import agrear_plato,agregar_categoria,mostrar_menu

def main():
    while(True):
        print("\n-----Menu-----")
        print("1.- Crear una categoria")
        print("2.- Crear un plato")
        print("3.- Mostrar Menu")
        print("4.- Salir")
        try:
            opcion = int(input("Introduce una opcion: "))
            print("*************")
            if (opcion == 1):
                agregar_categoria()
            elif (opcion == 2):
                agrear_plato()
            elif(opcion == 3):
                mostrar_menu()
            elif(opcion == 4):
                break
            else:
                print("Opcion no valida")    
        except:
            print("Opcion no valida")
main()