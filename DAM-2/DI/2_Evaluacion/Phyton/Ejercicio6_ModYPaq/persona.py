class Persona:

    def __init__(self,nombre,edad,dni):
        self.__nombre = nombre
        self.__edad = edad
        self.__dni = dni
    
    @property
    def nombre(self):
        return self.__nombre
    @nombre.setter
    def nombre(self,x):
        self.__nombre = x
    @property
    def edad(self):
        return self.__edad
    @edad.setter
    def edad(self,x):
        self.__edad = x  
    @property
    def dni(self):
        return self.__edad
    @dni.setter
    def dni(self,x):
        self.__dni = x  

    def __str__(self):
        return "Persona nombre: " + self.__nombre + " edad: " + str(self.__edad) + " dni: " + str(self.__dni)
    
    def esMayorDeEdad(self):
        if self.__edad >= 18:
            return True
        else:
            return False
