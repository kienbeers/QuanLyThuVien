import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { BanDocService } from 'src/app/shared/services/bandoc.service';
import { MuonSachService } from 'src/app/shared/services/muonsach.service';
import { SachService } from 'src/app/shared/services/sach.service';

@Component({
  selector: 'app-muon-sach',
  templateUrl: './muon-sach.component.html',
  styleUrls: ['./muon-sach.component.scss']
})
export class MuonSachComponent implements OnInit {
    formGroup!: FormGroup;
    muonSach:any;
    banDoc:any;
    sachId:any;
    checkText!:boolean;
    checkButton!:boolean;
  constructor(private formBuilder : FormBuilder,
    private muonSachService: MuonSachService,
    private banDocService: BanDocService,
    private sachService: SachService,
    private toastrService: ToastrService
    ) { }

  ngOnInit(): void {
    this.getBanDoc();
    this.getSachall();
    this.getMuonSachAll();
    this.formGroup = this.formBuilder.group({
        id: [''],
        bd_id: ['',Validators.required],
        sach_id: ['',Validators.required],
        soLuong: ['',Validators.required],
        ngayMuon: ['',Validators.required],
        ngayTra: ['',Validators.required],
        trangThai: ['',Validators.required],
        ghichu: [''],
    });
  }
    getMuonSachAll(){
        this.muonSachService.getMuonSach().subscribe(data=>{
            console.log(data);
            this.muonSach = data;
        },error=>{
            console.log(error);
        });
    }
    clickAdd(){
        this.checkText = true;
        this.checkButton = true;
        this.formGroup.reset();
    }
    getSachall(){
        this.sachService.getSach().subscribe(data=>{
            this.sachId = data;
        },error=>{
            console.log(error);
        });
    }
    getBanDoc(){
        this.banDocService.getBanDoc().subscribe(data=>{
            this.banDoc = data;
        },error=>{
            console.log(error);
        });
    }

    getBanDocById(id:any){
        return this.banDoc.filter((x: { id: number; }) => x.id == id)[0];
    }

    getSachById(id:any){
        return this.sachId.filter((x: { id: number; }) => x.id == id)[0];
    }
    addMuonSach(){
        this.formGroup.value.bd_id = this.getBanDocById(this.formGroup.getRawValue().bd_id);
        this.formGroup.value.sach_id = this.getSachById(this.formGroup.getRawValue().sach_id);
        this.muonSachService.addMuonSach(this.formGroup.value).subscribe(data=>{
            console.log(data);
            this.toastrService.success('Add successful!');
            this.getMuonSachAll();
        },error=>{
            this.toastrService.error('Add failed!');
            console.log(error);
        });
    }
    editMuonSach(item:any){
        this.checkText = false;
        this.checkButton = false;
        this.formGroup.patchValue({
            id: item.id,
            bd_id: item.bd_id.id,
            sach_id: item.sach_id.id,
            soLuong: item.soLuong,
            ngayMuon: item.ngayMuon,
            ngayTra: item.ngayTra,
            trangThai: item.trangThai,
            ghichu: item.ghichu,

        });
    }
    updateMuonSach(){
        this.formGroup.value.bd_id = this.getBanDocById(this.formGroup.getRawValue().bd_id);
        this.formGroup.value.sach_id = this.getSachById(this.formGroup.getRawValue().sach_id);
        this.muonSachService.updateMuonSach(this.formGroup.value).subscribe(data=>{
            console.log(data);
            this.toastrService.success('Update successful!');
            this.getMuonSachAll();
        },error=>{
            this.toastrService.error('Update failed!');
            console.log(error);
        });
    }
    onSubmit(){
        if(this.formGroup.invalid){
            this.formGroup.markAllAsTouched();
            return;
        }
        if(this.formGroup.value.id){
            this.updateMuonSach();
        }else{
            this.addMuonSach();
        }
    }
    deleteMuonSach(id:any){
        this.muonSachService.deleteMuonSach(id).subscribe(data=>{
            console.log(data);
            this.toastrService.success('Delete successful!');
            this.getMuonSachAll();
        },error=>{
            this.toastrService.error('Delete failed!');
            console.log(error);
        });
    }
}
