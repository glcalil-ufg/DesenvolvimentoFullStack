import { Hospedagem } from '../Model/hospedagem.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HospedagemService {

  urlBase: string = "http://localhost:8080/hospedagens";
  constructor(
    private http: HttpClient,
    private snackBar: MatSnackBar
  ) { }

  showMessage(msg: string, isError: boolean = false): void{
    this.snackBar.open(msg, 'Fechar',
    {
      verticalPosition: 'top',
      horizontalPosition: 'right',
      duration: 3000,
      panelClass: isError ? ['msg-error'] : ['msg-success']
    }
    )
  }

  // CREATE
  create(hospedagem: Hospedagem) : Observable<Hospedagem>{
    return this.http.post<Hospedagem>(this.urlBase, hospedagem);
  }

  // READ
    // findAll
    findAll() : Observable<Hospedagem[]> {
        return this.http.get<Hospedagem[]>(this.urlBase);
    }
    // findById
    findById(id: string ) : Observable<Hospedagem>{
      let url = `${this.urlBase}/${id}`;
      return this.http.get<Hospedagem>(url);
    }

  // UPDATE
  update(hospedagem: Hospedagem) : Observable<Hospedagem>{
    return this.http.put<Hospedagem>(this.urlBase, hospedagem);
  }


  // DELETE

  delete(hospedagem: Hospedagem): Observable<Hospedagem>{
    let url = `${this.urlBase}/${hospedagem.idHospedagem}`;
    console.log(url);
    return this.http.delete<Hospedagem>(url);
  }
}