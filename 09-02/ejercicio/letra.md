# Procesamiento de Ordenes

## Descripción

Eres el encargado de recibir las ordenes de platos de un restaurante italiano.
A medida que los pedidos crecen, los mismos se deberan registrar y procesar en un orden FIFO (First In First Out)

Se te ha encomendado identificar cual fue el plato mas pedido y el total de dinero entrante en el dia.

## Nota
En caso de haber empate de dos o mas platos con mayor numero de pedidos, se debera devolver el que tenga el menor ID.

## Entrada
Un entero `N` que representa la cantidad de pedidos a recibir \
Luego se reciben `N` lineas con los pedidos:
`<Id plato> <Costo>`

1 <= `<Id plato>` <= N 

## Salida
Se debe imprimir el plato mas pedido y el dinero entrante total: \
`<ID plato mas pedido>`
`<total dinero entrante>`



## Restricciones

El procesamiento debe ser en O(N) espacial y temporal.

## Ejemplo

### Input

10 \
6 596 \
6 921 \
10 356 \
6 920 \
10 255 \
7 613 \
1 556 \
5 223 \
3 837 \
4 217 


### Output

6 5494

### Explicación

6 es el plato que se pidio mas veces (3), a pesar de que el plato 10 tambien se ordeno la misma cantidad de veces, se devuelve 6 porque es el menor de ambos.

5494 es el total de dinero obtenido con la venta de los 10 pedidos.