import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  apiUrl = "http://localhost:8080/cliniconect/pessoa";

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<any[]>(`${this.apiUrl}`);
  }

  criar(pessoa: any){
    return this.http.post(this.apiUrl, pessoa);
  }

  editar(pessoa: any){
    return this.http.put(this.apiUrl+`/${pessoa.id}`, pessoa);
  }

  deletar(pessoa: any){
    return this.http.delete(this.apiUrl+`/${pessoa.id}`);
  }
}
