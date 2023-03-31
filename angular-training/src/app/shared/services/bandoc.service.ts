import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BanDocService {
    readonly API = 'http://localhost:8080';

    constructor(private http: HttpClient) {
    }

    getBanDoc(): Observable<any> {
        return this.http.get(`${this.API}/ban-doc/all`);
    }

    getDetailBanDoc(id: number): Observable<any> {
        return this.http.get(`${this.API}/ban-doc/find/${id}`);
    }

    addBanDoc(data: any): Observable<any> {
        return this.http.post(`${this.API}/ban-doc/create`, data);
    }

    updateBanDoc(data: any): Observable<any> {
        return this.http.put(`${this.API}/ban-doc/update`, data);
    }

    deleteBanDoc(id: number): Observable<any> {
        return this.http.delete(`${this.API}/ban-doc/delete/${id}`);
    }
}
