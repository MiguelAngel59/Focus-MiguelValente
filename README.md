# Practica 01

## ¿Tuviste problemas con la aceleración de hardware o la creación de los AVD? Describe la solución.

Tuve problemas para usar los AVD, pues no tenía activada la opción de
virtualización en el cpu, la solución fue entrar al BIOS y activar dicha
opción.

------------------------------------------------------------------------

## ¿Por qué elegiste ArrayList sobre otras opciones?

Es la opción más simple que encontré, otra opción pudo ser una tabla
hash aprovechando el uso de IDs en mi clase Task, pero quería algo
simple.

------------------------------------------------------------------------

## Si las tareas se guardaran en un servidor remoto, ¿qué cambiaría en el manejo de excepciones de tu función?

Si las tareas se guardaran en un servidor remoto, tendría que manejar
más tipos de excepciones, como errores de conexión, timeouts o fallos
del servidor. Probablemente usaría bloques try-catch más específicos y
no solo retornaría false, sino que también registraría el error o lo
propagaría según el caso.
