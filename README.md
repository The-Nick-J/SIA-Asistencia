Proyecto de **Programación Avanzada**  
INF2236 · PUCV · Segundo semestre 2026

---

## La idea

El proyecto consiste en un sistema de gestión de asistencia para un colegio. 
Su objetivo es permitir que el personal encargado registre, consulte y administre
la asistencia de los alumnos de manera ordenada.

El sistema trabaja principalmente con tres tipos de datos:

- **Alumnos:** identificados por su RUT, nombre, apellido y curso.
- **Cursos:** identificados por un código, nombre, profesor jefe y una lista de alumnos.
- **Asistencias:** asociadas a un alumno y una fecha, indicando si estuvo presente,
  ausente, si tuvo una falta justificada o si se retiró antes de finalizar la jornada.

La relación principal del sistema es que un curso puede tener varios alumnos y que
cada alumno puede tener varios registros de asistencia en distintas fechas.

## Equipo

| Integrante |
|---|---|
| Nicolás Jaramillo   | 
| Lucas Ahumada       | 
| Alessandro Reginato | 

## Herramientas

Java 11 · Apache NetBeans 21 · Maven · GitHub

## INSTRUCCIONES DE INSTALACION Y USO

# Cómo abrir el proyecto

1. Descargar el proyecto en forma de ZIP desde github o el que subimos al aula virtual.
2. Extrae el ZIP completo en una carpeta de tu computador.
3. Abre NetBeans.
4. Selecciona `File > Open Project`.
5. Busca la carpeta extraída del proyecto.
6. Selecciona el proyecto y presiona `Open Project`.
7. Espera a que NetBeans cargue Maven y las dependencias.

## Cómo ejecutar el proyecto

1. Haz clic derecho sobre el proyecto.
2. Selecciona `Clean and Build`.
3. Cuando la compilacion termine, vuelve a hacer clic derecho sobre el proyecto.
4. Selecciona `Run`.
5. Si NetBeans solicita elegir una clase principal, selecciona:
```text
GestionAsistencia
