import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class MuonSachService{
    readonly API = 'http://localhost:8080';
    constructor(private http: HttpClient) {
    }
    getMuonSach(): Observable<any> {
        return this.http.get(`${this.API}/muon-sach/all`);
    }
    getDetailMuonSach(id: number): Observable<any> {
        return this.http.get(`${this.API}/muon-sach/find/${id}`);
    }
    addMuonSach(data: any): Observable<any> {
        return this.http.post(`${this.API}/muon-sach/create`, data);
    }
    updateMuonSach(data: any): Observable<any> {
        return this.http.put(`${this.API}/muon-sach/update`, data);
    }
    deleteMuonSach(id: number): Observable<any> {
        return this.http.delete(`${this.API}/muon-sach/delete/${id}`);
    }

}
