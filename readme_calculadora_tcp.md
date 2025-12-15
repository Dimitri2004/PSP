# Calculadora_PSP

Proyecto de cálculo distribuido usando **Java TCP sockets**.  
El servidor recibe operaciones matemáticas desde clientes vía TCP, las procesa y devuelve el resultado.  
Además, se gestionan errores y se mantiene un registro de conexiones y operaciones.

---

## 📂 Estructura del proyecto

```
Calculadora_PSP/
 └── src/
 └── TareaCalculadora/
    ├── ServidorTCP.java
    ├── ClienteTCP.java
    ├── Funciones.java
    └── ControladorClientes.java
```

---

## 🏗️ Clases principales

### 1. `Servidor`
- **Rol:** Punto de entrada del sistema.
- **Responsabilidades:**
    - Abre un `ServerSocket` en el puerto `9001`.
    - Espera conexiones de clientes vía TCP.
    - Cada cliente se maneja en un **hilo independiente**.
    - Procesa las operaciones usando la clase `Funciones`.
    - Maneja errores y condiciones especiales con la clase `Errores`.
    - Envía la respuesta al cliente de forma persistente.
    - Registra conexiones y operaciones en un fichero `log.txt`.
    - Cierra la conexión del cliente cuando este envía el comando `"salir"`.

Ejemplo de flujo:
```
ClienteTCP → "2+2"  ServidorTCP → procesa → "4.0"  ServidorTCP → responde al cliente → "4.0"
```

---

### 2. `Cliente`
- **Rol:** Aplicación que envía operaciones al servidor y recibe resultados.
- **Responsabilidades:**
    - Crea un `Socket` para conectarse al servidor TCP.
    - Envía cadenas de texto con operaciones matemáticas.
    - Recibe la respuesta del servidor y la muestra al usuario.
    - Permite enviar comandos especiales (ej. `"salir"`) para desconectarse del servidor.
    - Mantiene la conexión abierta para enviar varias operaciones en un mismo hilo.

---

### 3. `Funciones`
- **Rol:** Núcleo de la lógica matemática.  
- **Responsabilidades:**
  - Implementa las operaciones de la calculadora (suma, resta, multiplicación, división, etc.).
  - Mantiene el valor de la última operación (`ans`) para reutilizarlo en cálculos posteriores.
  - Devuelve resultados en formato `String` para ser enviados al cliente.

Ejemplo:
```java
Funciones f = new Funciones();
String resultado = f.Operaciones("3*5"); // → 15.0
```

---

### 4. `Controlador`
- **Rol:** Gestión de validaciones y control de flujo.  
- **Responsabilidades:**
  - Maneja el flujo de clientes

---

### 🔹 Notas sobre TCP
- La comunicación es **orientada a conexión**: cada cliente mantiene un canal abierto con el servidor hasta que envía `"salir"`.
- Cada cliente tiene su propio valor `ans` independiente.
- El servidor puede manejar **múltiples clientes simultáneamente**, usando hilos para cada conexión.
---

## 📌 Logs
- Todas las conexiones y operaciones se guardan en `log.txt` dentro del directorio del proyecto.
- Cada registro incluye fecha, hora, IP del cliente y operación realizada.

---

## 🎯 Resumen
- Servidor TCP multicliente, persistente y seguro.  
- Cada cliente mantiene su propio `ans`.  
- Manejo de errores robusto.  
- Comunicación clara y registro de operaciones.

