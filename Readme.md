# Calculadora_PSP

Proyecto de cálculo distribuido usando **Java UDP sockets**.  
El servidor recibe operaciones matemáticas desde clientes, las procesa y devuelve el resultado.  
Además, se gestionan errores y se mantiene un registro de conexiones y operaciones.

---
## 📂 Estructura del proyecto
```
Calculadora_PSP/
 └── src/ 
 └── TareaCalculadora/
    ├── Servidor.java 
    ├── Cliente.java
    ├── Funciones.java
    └── Errores.java
```
---

## 🏗️ Clases principales

### 1. `Servidor`
- **Rol:** Punto de entrada del sistema.
- **Responsabilidades:**
    - Abre un `DatagramSocket` en el puerto `9001`.
    - Recibe mensajes de clientes vía UDP.
    - Procesa las operaciones usando la clase `Funciones`.
    - Maneja errores y condiciones especiales con la clase `Errores`.
    - Envía la respuesta al cliente.
    - Registra conexiones y operaciones en un fichero `log.txt`.

Ejemplo de flujo:
```
Cliente → "2+2"  Servidor → procesa → "4"  Servidor → responde al  cliente → "4"
```

---
### 2. `Cliente`
- **Rol:** Aplicación que envía operaciones al servidor y recibe resultados.
- **Responsabilidades:**
    - Crea un `DatagramSocket` para comunicarse con el servidor.
    - Envía cadenas de texto con operaciones matemáticas.
    - Recibe la respuesta del servidor y la muestra al usuario.
    - Permite enviar comandos especiales (ej. salir del servidor).




---

### 3. `Funciones`
- **Rol:** Núcleo de la lógica matemática.  
- **Responsabilidades:**
  - Implementa las operaciones de la calculadora (suma, resta, multiplicación, división, raíz cuadrada, etc.).
  - Mantiene el valor de la última operación (`ans`) para reutilizarlo en cálculos posteriores.
  - Devuelve resultados en formato `String` para ser enviados al cliente.

Ejemplo:
```java
Funciones f = new Funciones();
String resultado = f.calcular("3*5"); // → "15"
```

---

### 4. `Errores`
- **Rol:** Gestión de validaciones y control de flujo.  
- **Responsabilidades:**
  - Detecta entradas inválidas (valores nulos, cadenas vacías).
  - Reconoce comandos especiales (ej. salir del servidor).
  - Encapsula la lógica de comprobación antes de ejecutar una operación.
  - Devuelve mensajes de error claros al cliente.

---

