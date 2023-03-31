import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";


@Injectable ({
    providedIn: 'root'
})
export class SachService{
    readonly API_Url = "http://localhost:8080";

    constructor(private http: HttpClient) { }

    getSach() : Observable<any> {
        return this.http.get(`${this.API_Url}/sach/all`);
    }

    addSach(sach: any): Observable<any> {
        return this.http.post(`${this.API_Url}/sach/create`, sach);
    }

    updateSach(sach: any): Observable<any> {
        return this.http.put(`${this.API_Url}/sach/update`, sach);
    }

    deleteSach(id: any): Observable<any> {
        return this.http.delete(`${this.API_Url}/sach/delete/${id}`);
    }
}
