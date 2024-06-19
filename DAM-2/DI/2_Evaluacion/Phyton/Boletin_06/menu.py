import sqlite3

def crear_bd():
    conexion = sqlite3.connect("menu.db")
    conexion.execute("PRAGMA foreign_keys = 1")
    cursor = conexion.cursor()
    try:
        cursor.execute("CREATE TABLE categoria(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre VARCHAR(30) UNIQUE NOT NULL)")
        cursor.execute("CREATE TABLE plato(" + 
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre VARCHAR(30) UNIQUE NOT NULL, " +
            "id_categoria INTEGER, " 
            "FOREIGN KEY (id_categoria) REFERENCES categoria(id))")
        conexion.commit()
    except:
        print("Alguna de las tablas ya existen")
    conexion.close()
# crear_bd()

def agregar_categoria():
    try:
        conexion = sqlite3.connect("menu.db")
        cursor = conexion.cursor()
        nombre = input("Introduce un nombre de categoria: ")
        cursor.execute("INSERT INTO categoria VALUES (null,'"+nombre+"')")
        conexion.commit()
    except:
        print("La categoria ya existe")
    cursor.execute("SELECT * FROM categoria")
    categorias = cursor.fetchall()
    print("Categorias: " + str(categorias))
    conexion.close()

def agrear_plato():
    conexion = sqlite3.connect("menu.db")
    cursor = conexion.cursor()
    cursor.execute("SELECT * FROM categoria")
    categorias = cursor.fetchall()
    i = 0
    for cat in categorias:
        print("CATEGORIA " + cat[1])
        print("ID:",cat[0])
        print("*************")
        i+=1 

    while(True):
        try:
            print("Cantidad de categorias",str(i))
            id = int(input("Escoge el id de la categoria a la que le queiras añadir un plato: "))
            print("ID introducido: ", str(id))
            cursor.execute("SELECT * FROM categoria WHERE id = " + str(id))
            if(cursor.fetchone() == None):
                print("No hay categorias con ese id")
            else:
                plato = input("Introduce el nombre del plato: ")
                cursor.execute("INSERT INTO plato VALUES(null,'" + plato + "','" + str(id) +"')")
                break
        except:
            print("Opcion no valida")

    conexion.commit()
    conexion.close()

def mostrar_menu():
    print("==== MENU TULASKING ====")
    conexion = sqlite3.connect("menu.db")
    cursor = conexion.cursor()
    cursor.execute("SELECT * FROM categoria")
    categorias = cursor.fetchall()
    for cat in categorias:
        print(f"{cat[1]}:")
        cursor.execute("SELECT * FROM plato WHERE id_categoria = " + str(cat[0]))
        platos = cursor.fetchall()
        for plt in platos:
            print(f"\t{plt[1]}")

def mostrar_platos():
    print("Entra a mostrar platos")
    conexion = sqlite3.connect("menu.db")
    cursor = conexion.cursor()
    cursor.execute("SELECT * FROM plato")
    platos = cursor.fetchall()
    for cat in platos:
        print(f"ID del plato: {cat[0]}")
        print(f"Nombre del plato: {cat[1]}")
        print(f"Referencia con la categoria: {cat[2]}")

