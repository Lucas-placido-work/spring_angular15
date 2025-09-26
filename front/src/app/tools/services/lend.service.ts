import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Lend } from '../model/lend';

@Injectable({
  providedIn: 'root'
})
export class LendService {

  private readonly API = 'api/lends';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Lend[]> {
    return this.http.get<Lend[]>(this.API);
  }

  create(lend: { tool: { id: number }, employee: { name: string } }): Observable<Lend> {
    return this.http.post<Lend>(this.API, lend);
  }


  returnTool(id: number): Observable<Lend> {
    return this.http.put<Lend>(`${this.API}/${id}/return`, {});
  }
}
