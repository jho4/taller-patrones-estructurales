# Taller de Patrones de Diseño Estructurales

Este repositorio contiene la solución práctica en Java y las respuestas teóricas del taller sobre patrones de diseño estructurales (**Adapter**, **Proxy**, **Decorator** y **Facade**), desarrollado para la asignatura.

---

## 👥 Integrantes
* **Jhoan Esteban Avilés Sánchez**
* **Miguel Angel Bocanegra Villanueva**

---

## 🛠️ Tecnologías Utilizadas
* **Lenguaje de Programación:** Java (JDK 17 o superior)
* **Entorno de Desarrollo (IDE):** IntelliJ IDEA / VS Code / Eclipse
* **Control de Versiones:** Git & GitHub

---
## 📝 Respuestas de taller: Quiz de Patrones de Diseño Estructurales

A continuación se detallan las soluciones y justificaciones propuestas por Miguel para el cuestionario de patrones estructurales.

---

### 📋 Pregunta 1: Combinación de funcionalidades (Logging, Encryption, Compression)

#### **a. ¿Qué patrón de diseño utilizaría?**
* **Patrón Decorator.**

#### **b. ¿Por qué este patrón es más apropiado que crear una clase diferente para cada combinación?**
Con el Decorator, cada funcionalidad (*Logging, Encryption y Compression*) es una clase que envuelve al mensaje y le agrega su comportamiento. Así se pueden combinar en el orden que se necesite sin modificar `BasicMessage`.

Crear una clase por cada combinación sería poco práctico, porque habría muchas clases con código repetido y cada funcionalidad nueva aumentaría exponencialmente ese número.

---

### 📋 Pregunta 2: Coordinación de sistema de compras (Inventario, Pago, Envío, Notificación)

#### **a. ¿Qué patrón de diseño utilizaría?**
* **Patrón Facade.**

#### **b. Explique en 2 o 3 líneas por qué considera que este patrón es apropiado.**
El Facade ofrece una sola interfaz (el método `purchase`) que se encarga de coordinar el inventario, el pago, el envío y la notificación. De esta forma, el controlador solo hace una llamada y no necesita conocer cómo funciona cada componente por dentro.

---

### 📋 Pregunta 3: Control de acceso y verificación de permisos

#### **a. ¿Qué patrón de diseño estructural utilizaría?**
* **Patrón Proxy.**

#### **b. Explique brevemente por qué es adecuado para esta situación.**
El Proxy tiene la misma interfaz que el servicio real, por lo que el cliente lo usa de la misma forma. Antes de pasar la consulta al servicio, el proxy verifica los permisos del usuario. Así se protege la información sensible sin modificar el servicio original.

---

### 📋 Pregunta 4: Integración con biblioteca externa de pagos

#### **a. ¿Qué patrón de diseño utilizaría?**
* **Patrón Adapter.**

#### **b. Explique cuál es el problema que debe resolver el patrón.**
El problema es que la aplicación usa `processPayment(amount)`, pero la biblioteca externa ofrece `makeTransaction(value)`, y esa clase no se puede modificar.

El Adapter implementa la interfaz `PaymentProcessor` y por dentro llama a `makeTransaction`, permitiendo que ambas interfaces trabajen juntas sin alterar el código de la biblioteca de terceros.

```text
src/
├── adaptador/
│   ├── ProcesadorPago.java
│   ├── ServicioPagoExterno.java
│   └── AdaptadorPago.java
├── proxy/
│   ├── ServicioInventario.java
│   ├── ServicioInventarioReal.java
│   └── ProxyInventario.java
├── decorador/
│   ├── ServicioNotificacion.java
│   ├── ServicioNotificacionBasico.java
│   ├── DecoradorNotificacion.java
│   ├── DecoradorRegistro.java
│   └── DecoradorCompresion.java
├── fachada/
│   └── FachadaCompra.java
└── principal/
    └── Principal.java
```

---

*Nota: La clase `Principal.java` contiene el método `main` para poder ejecutar el programa.*

