import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { BanDocService } from 'src/app/shared/services/bandoc.service';

@Component({
  selector: 'app-bandoc',
  templateUrl: './bandoc.component.html',
  styleUrls: ['./bandoc.component.scss']
})
export class BandocComponent implements OnInit {
    formGroup!: FormGroup;
    banDoc: any;
    checkText!: boolean;
    checkButton!:boolean;
  constructor(private formBuilder: FormBuilder,private banDocService: BanDocService,private toastrService: ToastrService) {

   }


  ngOnInit(): void {
    this.checkButton = true;
    this.checkText = true;
    this.getBanDoc();
    this.formGroup = this.formBuilder.group({
        id: [''],
        ma: ['',Validators.required],
        ten: ['',Validators.required],
        diaChi: ['',Validators.required],
        sdt: ['',Validators.required],
        ngaySinh: ['',Validators.required],
        ngayTao: ['',Validators.required],
        hang: ['',Validators.required]
        });
  }
  getBanDoc(){
    this.banDocService.getBanDoc().subscribe(data => {
      console.log(data);
        this.banDoc = data;
    });
  }
  clickAdd(){
    this.checkButton = true;
    this.checkText = true;
    this.formGroup.reset();
  }
  addBanDoc(){
    this.banDocService.addBanDoc(this.formGroup.getRawValue()).subscribe(data => {
      console.log(data);
      this.toastrService.success(`Successful`);
      this.getBanDoc();
    },
    error => {
        this.toastrService.error(`Failed`);
        console.log(error);
    });
  }
  onSubmit(){
    if(this.formGroup.invalid){
        this.formGroup.markAllAsTouched();
        return;
    }
    console.log(this.formGroup.getRawValue());
    if(this.formGroup.getRawValue().id){
      this.updateBanDoc();
    }else{
        this.addBanDoc();
    }
  }
  deleteBanDoc(id: any){
    this.banDocService.deleteBanDoc(id).subscribe(data => {
      console.log(data);
      this.toastrService.success(`Successful`);
      this.getBanDoc();
    },
    error => {
        this.toastrService.error(`Failed`);
        console.log(error);
    });
  }
  editBanDoc(item: any){
    this.checkButton = false;
    this.checkText = false;
     console.log(item);
    this.formGroup.patchValue({
        id: item.id,
        ma: item.ma,
        ten: item.ten,
        diaChi: item.diaChi,
        sdt: item.sdt,
        ngaySinh: item.ngaySinh,
        ngayTao: item.ngayTao,
        hang: item.hang

    });
  }
  updateBanDoc(){
    this.banDocService.updateBanDoc(this.formGroup.getRawValue()).subscribe(data => {
      console.log(data);
      this.toastrService.success(`Successful`);
      this.getBanDoc();
    },
    error => {
        this.toastrService.error(`Failed`);
        console.log(error);
    });
  }
}
