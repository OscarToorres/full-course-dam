def ej01():
    cantidad = 1000
    iva = 0.21
    print("La cantidad con IVA es: "+ str(cantidad + cantidad*iva))

# ej01()

def ej02():
    numeros = [1,2,3,4,5]
    contador = 0
    for i in range(len(numeros)):
        contador += numeros[i]
    print("La media es:",str(contador/(len(numeros))))

# ej02()

def ej03():
    numero = int(input("Introduce un numero:"))
    diccionario = {}
    for i in range(numero+1):
        diccionario[i] = i*i
    print(str(diccionario.items()))
# ej03()

def ej04():
    diccionario = dict(Euro='€',Dollar='$',Yen='Y')
    divisa = input("Introduce una divisa:")
    if(divisa in diccionario):
        print(diccionario[divisa])
    else:
        print("La divisa no está en el diccionario")
# ej04()

def ej05():
    diccionario = dict(manzana=1,pera=1.5,banano=2)
    while(True):
        fruta = input("Introduce una fruta:")
        fruta = fruta.lower()
        try:
            cantidad = int((input("Introduce cantidad:")))
            if(fruta in diccionario):
                print("Precio final:",str(diccionario[fruta]*cantidad),"€")
            else:
                print("La fruta NO existe")
        except:
            print("Introduce solo numeros")
        consulta = input("Desea realizar otra consulta? (SI->[s] o NO->[n]):")
        if(consulta != "s"):
            break
# ej05()

def ej06():
    nombre = input("Nombre: ")
    try:
        edad = int(input("Edad: "))
        direccion = input("Dame tu direccion: ")
        tlf = input("Dame tu telefono: ")
        diccionario = dict(nombre=nombre,edad=edad,direccion=direccion,telefono = tlf)
        print(diccionario["nombre"],"tiene",diccionario["edad"],"años, vive en",diccionario["direccion"],"y su número de teléfono es",diccionario["telefono"])
    except:
        print("Introduce solo numeros en 'edad' y 'telefono'")
# ej06()

def ej07():
    diccionario = {}
    while(True):
        clave = input("Dato que se desea introducir: ")
        valor = input("Valor del dato: ")
        diccionario[clave] = valor 
        print(str(diccionario))
        seguir = input("Desea introducir más datos (SI->[s] o NO->[n]): ")
        if(seguir == "n"):
            break
# ej07()

def ej08():
    cadena = input("Introduce vocabulario con el formato [palabra:traduccion] separadas por comas ',':")
    list=[]
    diccionario = {}
    list = cadena.split(",")
    for i in range(len(list)):
        lista = list[i].split(":")
        diccionario[lista[0]] = lista[1]
    frase = input("Introduce frase a traducir:")
    listaFrase = frase.split(" ")
    fraseTraducida = ""
    for j in range(len(listaFrase)):
        if(listaFrase[j] in diccionario):
           fraseTraducida = fraseTraducida + " " + diccionario[listaFrase[j]]
        else:
            fraseTraducida = fraseTraducida + " " + listaFrase[j]
    print(fraseTraducida)
# ej08()

def engadirCliente(diccionario = {}):
    nif = input("Introduce tu DNI:")
    dicAuxiliar = {}
    nombre = input("Introduce el nombre:")
    dicAuxiliar["nombre"]= nombre
    direccion = input("Introduce la direccion:")
    dicAuxiliar["direccion"]= direccion
    tlf = input("Introduce el telefono:")
    dicAuxiliar["telefono"]= tlf
    correo = input("Introduce el correo:")
    dicAuxiliar["correo"]= correo
    pref = True
    preferente = input("Desea que sea preferente (SI->[s] o NO->[n]): ")
    if(preferente == "n"):
        pref = False
    dicAuxiliar["preferente"]= pref
    diccionario[nif] = dicAuxiliar

def ex9():
    opcion = True
    diccionario = {}
    while(opcion):
        print("(1) Añadir cliente")
        print("(2) Eliminar cliente")
        print("(3) Mostrar cliente")
        print("(4) Listar todos los clientes")
        print("(5) Listar clientes preferentes")
        print("(6) Terminar")
        op = int(input("Introduce opción: "))
        if(op == 1):
            engadirCliente(diccionario)
        elif(op == 2):
            nif = input("Dni que desea eliminar: ")
            if(nif in diccionario):
                del(diccionario[nif])
            else:
                print("NIF equivocado")
        elif(op == 3):
            nif = input("Dni que desea buscar: ")
            if(nif in diccionario):
                print(diccionario[nif])
            else:
                print("NIF equivocado")
        elif(op == 4):
            for clave,valor in diccionario.items():
                diccionarioAuxiliar = valor
                print("NIF:",str(clave)," Nombre:",str(diccionarioAuxiliar["nombre"]))
        elif(op == 5):
            for clave,valor in diccionario.items():
                diccionarioAuxiliar = valor
                if(valor["preferente"]==True):
                    print("NIF:",str(clave)," Nombre:",str(diccionarioAuxiliar["nombre"]))
        elif(op==6):
            opcion = False
        else:
            print("Opcion erronea")
# ex9()


def notas(diccionario):
    auxiliar = {}
    for clave,valor in diccionario.items():
        if(valor < 5):
            auxiliar[clave.upper()] = "SUSPENSO"
        elif((valor >= 5) and (valor < 6)):
            auxiliar[clave.upper()] = "APROBADO"
        elif((valor >= 6) and (valor < 7)):
            auxiliar[clave.upper()] = "BIEN"
        elif((valor >= 7) and (valor < 9)):
            auxiliar[clave.upper()] = "NOTABLE"
        elif((valor >= 9) and (valor <= 10)):
            auxiliar[clave.upper()] = "SOBRESALIENTE"
        else:
            print("NOTA NO VALIDA")
    return auxiliar

def ex10():
    diccionario = dict(ad=10,di=8,sxe=9,psp=8,eie=7,pmdm=8)
    diccionarioFinal = notas(diccionario)
    for clave,valor in diccionarioFinal.items():
            print("NIF:",str(clave)," Nombre:",str(valor))
#ex10()