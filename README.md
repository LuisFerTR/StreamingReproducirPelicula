# StreamingReproducirPelicula
últimos dos microservicios para proyecto de SOA: Streaming de películas

# Colas empleadas en el microservicio de reproducir película
queue.name.in = stream.repp.in [Recibe un JSON con datos de la renta (folio, tiempo, idpelicula, idusuario, total)]  
queue.name.out = stream.repp.out [Recibe un mensaje por cualquier error ocurrido en este microservicio]  
queue.name.next = stream.dp.in [Recibe un JSON con la fecha de inicio de reproducción 
                  y el tiempo rentado]  

# Colas empleadas en el microservicio de validar pelicula
queue.name.in = stream.dp.in [Recibe un JSON con id de usuario, nombre y titulo deseado]  
queue.name.out = stream.dp.out [Recibe un mensaje por cualquier error ocurrido en este microservicio]  
queue.name.next = stream.dp.final [Recibe un JSON con el mensaje 
                  "Se detuvo la reproducción de la película"]