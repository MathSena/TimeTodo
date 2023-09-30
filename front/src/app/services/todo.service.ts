import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Todo} from "../models/todo";
import {Observable} from "rxjs";
import { environment } from '../../environments/environment';
import {MatSnackBar} from "@angular/material/snack-bar";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  baseUrl: string;

  constructor(private http: HttpClient, private SnackBar: MatSnackBar) {
    this.baseUrl = environment.baseUrl;
  }

  findAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.baseUrl);
  }

  delete(id: any): Observable<void>{
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url);
  }

  message(message: string): void{
    this.SnackBar.open(`${message}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
  }
