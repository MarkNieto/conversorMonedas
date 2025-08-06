# 💱 Conversor de Monedas - Desafío Alura LATAM

Este proyecto es parte del desafío de programación de **Alura LATAM**. El objetivo es construir una aplicación en **Java** que funcione como conversor de monedas, utilizando datos obtenidos en tiempo real desde una **API de tasas de cambio**.

## 🚀 ¿Qué hace esta aplicación?

- Realiza una solicitud HTTP a una API pública de tasas de cambio (`https://api.exchangerate-api.com/`)
- Analiza la respuesta en formato **JSON** utilizando la biblioteca **Gson**
- Filtra y muestra las tasas de cambio de tres monedas específicas:
  - `ARS` - Peso argentino
  - `BOB` - Boliviano
  - `BRL` - Real brasileño
- Permite al usuario ingresar una cantidad en USD y elegir a cuál de esas monedas desea convertirla
- Muestra el resultado de la conversión en consola

---

## 🛠 Tecnologías y herramientas utilizadas

- Java 8 o superior
- Biblioteca [Gson](https://github.com/google/gson) para el manejo de JSON
- IntelliJ IDEA como entorno de desarrollo (opcional)
- API de tasas de cambio: [ExchangeRate-API](https://www.exchangerate-api.com/)

---

## 📥 Instalación y uso

### 1. Clona el repositorio
```bash
git clone https://github.com/tu-usuario/conversor-monedas.git
cd conversor-monedas
```

## Si usas Maven agrega esto en tu pom.xml:
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
