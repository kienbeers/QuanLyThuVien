import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { NhaXuatBanService } from 'src/app/shared/services/nhaxuatban.service';
import { SachService } from 'src/app/shared/services/sach.service';
import { TacGiaService } from 'src/app/shared/services/tac-gia.service';

@Component({
    selector: 'app-sach',
    templateUrl: './sach.component.html',
    styleUrls: ['./sach.component.scss']
})
export class SachComponent implements OnInit {
    formGroup!: FormGroup;
    getSach: any;
    getNXB: any;
    getTacGia: any;
    checkText!: boolean;
    checkButton!: boolean;
    constructor(private formBuilder: FormBuilder,
        private sachService: SachService,
        private nxbService: NhaXuatBanService,
        private tgService: TacGiaService,
        private toastrService: ToastrService) { }

    ngOnInit(): void {
        this.getTacGiaAll();
        this.getSachAll();
        this.getNXBAll();
        this.formGroup = this.formBuilder.group({
            id: [''],
            ma: ['',Validators.required],
            ten: ['',Validators.required],
            chuDe: ['',Validators.required],
            moTa: [''],
            namXuatBan: ['',Validators.required],
            soLuongCon: ['',Validators.required],
            soLuongDaMuon: ['',Validators.required],
            tongSoLuong: ['',Validators.required],
            nxbId: ['',Validators.required],
            tgId: ['',Validators.required],

        });
    }
    clickAdd() {
        this.checkText = true;
        this.checkButton = true;
        this.formGroup.reset();
    }
    getSachAll() {
        this.sachService.getSach().subscribe(data => {
            this.getSach = data;
        }, error => {
            console.log(error);
        });
    }
    getNXBAll() {
        this.nxbService.getNhaXuatBan().subscribe(data => {
            this.getNXB = data;
        }, error => {
            console.log(error);
        });
    }
    getTacGiaAll() {
        this.tgService.getAllTacGia().subscribe(data => {
            this.getTacGia = data;
            console.log("asdugasda", data);
        }, error => {
            console.log(error);
        });
    }
    addSach() {
        this.formGroup.value.tgId = this.getTacGiaById(this.formGroup.getRawValue().tgId);
        this.formGroup.value.nxbId = this.getNXBbyid(this.formGroup.getRawValue().nxbId);
       console.log("data",this.formGroup.value);
        this.sachService.addSach(this.formGroup.value).subscribe(data => {
            console.log(data);
            this.toastrService.success('Add Successful!');
            this.getSachAll();
        }, error => {
            console.log(error);
        });
    }
    updateSach() {
        this.formGroup.value.tgId = this.getTacGiaById(this.formGroup.getRawValue().tgId);
        this.formGroup.value.nxbId = this.getNXBbyid(this.formGroup.getRawValue().nxbId);
        this.sachService.updateSach(this.formGroup.value).subscribe(data => {
            console.log(data);
            this.toastrService.success('Update Successful!');
            this.getSachAll();
        }, error => {
            console.log(error);
        });
    }
    onSubmit() {
        if(this.formGroup.invalid){
            this.formGroup.markAllAsTouched();
            return;
        }
        if (this.formGroup.get('id')?.value) {
            this.updateSach();
        } else {
            this.addSach();
        }
    }
    deleteSach(id: any) {
        this.sachService.deleteSach(id).subscribe(data => {
            console.log(data);
            this.toastrService.success('Delete Successful!');
            this.getSachAll();
        }, error => {
            console.log(error);
        });
    }
    editSach(item: any) {
        this.checkButton = false;
        this.checkText = false;
        this.formGroup.patchValue({
            id: item.id,
            ma: item.ma,
            ten: item.ten,
            chuDe: item.chuDe,
            moTa: item.moTa,
            namXuatBan: item.namXuatBan,
            soLuongCon: item.soLuongCon,
            soLuongDaMuon: item.soLuongDaMuon,
            tongSoLuong: item.tongSoLuong,
            nxbId: item.nxbId.id,
            tgId: item.tgId.id,

        });
    }
    nxbName(id: number) {
        this.nxbService.getDetailNhaXuatBan(id).subscribe(data => {
            console.log(data);
            return data.ten;
    });
}

    getTacGiaById(id: number) {
        return this.getTacGia.filter((x: { id: number; }) => x.id == id)[0]
    }
    getNXBbyid(id: number) {
        return this.getNXB.filter((x: { id: number; }) => x.id == id)[0]
    }
}
