# StreamingReproducirPelicula
últimos dos microservicios para proyecto de SOA: Streaming de películas

# Colas empleadas en el microservicio de reproducir película
queue.name.in = stream.repp.in [Recibe un JSON con datos de la renta (folio, tiempo, idpelicula, idusuario, total)]  
queue.name.out = stream.repp.out [Recibe un mensaje por cualquier error ocurrido en este microservicio]  
queue.name.next = stream.out [Recibe un JSON con la fecha de inicio de reproducción 
                  y el tiempo rentado]  

