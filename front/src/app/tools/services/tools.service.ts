import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, tap } from 'rxjs';

import { Tools } from '../model/tools';

@Injectable({
  providedIn: 'root'
})
export class ToolsService {

  private readonly API = 'api/tools';

  constructor(private httpClient: HttpClient) {}

  list() {
    return this.httpClient.get<Tools[]>(this.API)
    .pipe(
      first(),
      tap(data => console.log(data))
    );
  }

  save(tool: Tools) {
    console.log(tool);
    // return this.httpClient.post<Tools>(this.API, tool).pipe(first());
  }

  delete(id: number) {
    // return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }

  update(tool: Tools) {
    // return this.httpClient.put<Tools>(`${this.API}/${tool._id}`, tool).pipe(first());
  }
}
