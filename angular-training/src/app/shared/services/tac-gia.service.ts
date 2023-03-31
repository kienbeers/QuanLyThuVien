import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable ({
    providedIn: "root"
})
export class TacGiaService{

    readonly API_URL = "http://localhost:8080";

    constructor(private http: HttpClient) {}

    getAllTacGia(): Observable<any> {
        return this.http.get(`${this.API_URL}/tac-gia/all`);
    }

    getDetailTacGia(id: number): Observable<any> {
        return this.http.get(`${this.API_URL}/tac-gia/find/${id}`);
    }

    addTacGia(data: any): Observable<any> {
        return this.http.post(`${this.API_URL}/tac-gia/create`, data);
    }

    updateTacGia(data: any): Observable<any> {
        return this.http.put(`${this.API_URL}/tac-gia/update`, data);
    }

    deleteTacGia(id: number): Observable<any> {
        return this.http.delete(`${this.API_URL}/tac-gia/delete/${id}`);
    }

}
