import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { NhaXuatBanService } from 'src/app/shared/services/nhaxuatban.service';

@Component({
  selector: 'app-nha-xuat-ban',
  templateUrl: './nha-xuat-ban.component.html',
  styleUrls: ['./nha-xuat-ban.component.scss']
})
export class NhaXuatBanComponent implements OnInit {
    checkText!: boolean;
    checkButton!:boolean;
    nxb: any;
    formGroup!: FormGroup;
  constructor(private formBuilder:FormBuilder,private nhaXuatBanService: NhaXuatBanService,private toaStrService: ToastrService ) { }

  ngOnInit(): void {
    this.checkButton = true;
    this.checkText = true;
    this.getNhaxuatban();
    this.formGroup = this.formBuilder.group({
        id: ['',Validators.required],
        ma: ['',Validators.required],
        ten: ['',Validators.required],
        trangThai: [''],
        diaChi: ['',Validators.required],
        moTa: [''],
    });
  }
  getNhaxuatban(){
    this.nhaXuatBanService.getNhaXuatBan().subscribe(data => {
      console.log(data);
        this.nxb = data;
    },error => {
        console.log(error);
    });
  }

  addNhaXuatBan(){
    this.nhaXuatBanService.addNhaXuatBan(this.formGroup.getRawValue()).subscribe(data => {
      console.log(data);
      this.toaStrService.success(`Successful`);
      this.getNhaxuatban();
    },error => {
        console.log(error);
        this.toaStrService.error(`Failed`);
    });
  }
  updateNhaXuatBan(){
    this.nhaXuatBanService.updateNhaXuatBan(this.formGroup.getRawValue()).subscribe(data => {
      console.log(data);
      this.toaStrService.success(`Successful`);
      this.getNhaxuatban();
    },error => {
        console.log(error);
        this.toaStrService.error(`Failed`);
    });
  }
  editNhaxuatban(item: any){
    this.checkButton = false;
    this.checkText = false;
    this.formGroup.patchValue( {
        id: item.id,
        ma: item.ma,
        ten: item.ten,
        trangThai: item.trangThai,
        diaChi: item.diaChi,
        moTa: item.moTa
    });
  }
    deleteNhaXuatBan(id: any){
    this.nhaXuatBanService.deleteNhaXuatBan(id).subscribe(data => {
      console.log(data);
      this.toaStrService.success(`Successful`);
      this.getNhaxuatban();
    },error => {
        console.log(error);
        this.toaStrService.error(`Failed`);
    });
  }

  onSubmit(){
    if(this.formGroup.invalid){
        this.formGroup.markAllAsTouched();
        return;
    }
    if(this.formGroup.getRawValue().id){
      this.updateNhaXuatBan();
    }else{
      this.addNhaXuatBan();
    }
  }

  clickAdd(){
    this.checkButton = true;
    this.checkText = true;
    this.formGroup.reset();
  }
}
