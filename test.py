while True:
  numero = int(input("Ingrese un numero: "))
  break
else:
  print("El numero ingresado no esta en el rango valido")
  print(f"Ha ingresado el numero: {numero}")

for i in range(1, numero + 1):
  if i%numero == 0:
    print(f"Saltando multiplo de {numero}: {i}")
    continue

  while True: numero_secuencial = int(input(f"Ingrese el numero secuencial {i}"))

  if numero_secuencial == i: break
  else: print(f"Error: deberia haber ingresado el numero {i}. Intentelo nuevamente")
  print("Ha ingresado correctamente los numeros secuenciales fin del juego")