import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class NhaXuatBanService{
    readonly API = 'http://localhost:8080';
    constructor(private http: HttpClient) {
    }
    getNhaXuatBan(): Observable<any> {
        return this.http.get(`${this.API}/nha-xuat-ban/all`);
    }
    getDetailNhaXuatBan(id: number): Observable<any> {
        return this.http.get(`${this.API}/nha-xuat-ban/find/${id}`);
    }
    addNhaXuatBan(data: any): Observable<any> {
        return this.http.post(`${this.API}/nha-xuat-ban/create`, data);
    }
    updateNhaXuatBan(data: any): Observable<any> {
        return this.http.put(`${this.API}/nha-xuat-ban/update`, data);
    }
    deleteNhaXuatBan(id: number): Observable<any> {
        return this.http.delete(`${this.API}/nha-xuat-ban/delete/${id}`);
    }

}
