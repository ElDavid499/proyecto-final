import { Injectable } from '@angular/core';
import { map, Observable, of } from 'rxjs';
import { Deporte } from './deporte';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class DeportesService {

  private urlEndpoint:string="http://localhost:8080/api/deportes"

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'})

  constructor(private http: HttpClient) { }

  //buscar tareas de la base de datos
  getDeportes():Observable<Deporte[]>{
    
   //return of (TAREAS);
   return this.http.get(this.urlEndpoint).pipe(
    map((response)=> response as Deporte[])
   )
  }

  //Método de crear tarea
  create(deporte:Deporte):Observable<Deporte>{
      return this.http.post<Deporte>(this.urlEndpoint, deporte, {headers:this.httpHeaders})
  }

  //Método de editar tarea
  getDeporte(id: any):Observable<Deporte>{
    return this.http.get<Deporte>(`${this.urlEndpoint}/${id}`)
  }

  //Edición final
  update(deporte: Deporte):Observable<Deporte>{
    return this.http.put<Deporte>(`${this.urlEndpoint}/${deporte.id}`, deporte, {headers:this.httpHeaders})
  }

  //Eliminar
  delete(id:number):Observable<Deporte>{
    return this.http.delete<Deporte>(`${this.urlEndpoint}/${id}`, {headers:this.httpHeaders})
  }

}
