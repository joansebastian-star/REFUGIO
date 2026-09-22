# Sistema de Gestión de un Refugio de Animales

**Autor:** *Joan Yambay*
**Curso:** Bloque Java · Tarea Integradora POO

## Descripción

Aplicación de consola en Java que permite a un refugio registrar perros y
gatos, consultarlos, buscarlos por ID y gestionar su adopción. El proyecto
integra los conceptos fundamentales de Programación Orientada a Objetos:
clases, objetos, encapsulamiento, herencia, `super()`, sobrescritura
(`@Override`), polimorfismo, colecciones con `ArrayList` y manejo básico de
errores con `try-catch`.

## Clases del proyecto

|Archivo|Responsabilidad|
|-|-|
|`Animal.java`|Clase padre con los atributos y comportamientos comunes.|
|`Perro.java`|Subclase de `Animal`; agrega el atributo `raza`.|
|`Gato.java`|Subclase de `Animal`; agrega el atributo `color`.|
|`Refugio.java`|Administra la colección (`ArrayList<Animal>`): registra, busca, muestra y gestiona adopciones.|
|`Main.java`|Contiene el `Scanner`, el menú de consola y la interacción con el usuario.|

## Funcionalidades

1. **Registrar animal**: elige entre Perro o Gato, valida ID (positivo y
único), nombre (no vacío) y edad (≥ 0) antes de almacenarlo.
2. **Mostrar animales**: recorre la colección, muestra los datos generales,
el atributo propio de cada tipo y ejecuta `realizarAccion()`
(polimorfismo).
3. **Buscar animal por ID**: búsqueda secuencial; informa si no existe.
4. **Adoptar animal**: cambia el estado de `DISPONIBLE` a `ADOPTADO`;
evita adoptar un animal inexistente o ya adoptado.
5. **Salir**: finaliza el programa de forma controlada.

## Validaciones implementadas

* Opción de menú fuera de rango (1-5).
* ID menor o igual a 0, o repetido.
* Nombre vacío.
* Edad negativa.
* Tipo de animal distinto de 1 o 2.
* Colección vacía al mostrar, buscar o adoptar.
* Entrada no numérica controlada con `try-catch` (`NumberFormatException`),
sin detener la ejecución del programa.

## Ejemplo de uso

```
=========== REFUGIO ===========
1. Registrar animal
2. Mostrar animales
3. Buscar animal por ID
4. Adoptar animal
5. Salir
Seleccione una opción: 1
Elija el tipo (1 = Perro, 2 = Gato): 1
Ingrese ID: 1
Ingrese nombre: Firulais
Ingrese edad: 3
Ingrese raza: Labrador
Animal registrado correctamente.
```

