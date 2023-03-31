import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { TacGiaService } from 'src/app/shared/services/tac-gia.service';

@Component({
  selector: 'app-tac-gia',
  templateUrl: './tac-gia.component.html',
  styleUrls: ['./tac-gia.component.scss']
})
export class TacGiaComponent implements OnInit {
    checkText!: boolean;
    checkButton!: boolean;
    formGroup!: FormGroup;
    getTacGia: any;
  constructor(private formBuilder: FormBuilder,private tacGiaService: TacGiaService,private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.getAllTacGia();
    this.formGroup = this.formBuilder.group({
        id: [''],
        ma: ['',Validators.required],
        ten: ['',Validators.required],
        sdt: ['',Validators.required],
        diaChi: ['',Validators.required],
        moTa: ['']
        });
}
    getAllTacGia(){
        this.tacGiaService.getAllTacGia().subscribe(data => {
            this.getTacGia = data;
        },error => {
            console.log(error);
        });
}
    clickAdd(){
        this.checkText = true;
        this.checkButton = true;
        this.formGroup.reset();
    }
    addTacGia(){
        this.tacGiaService.addTacGia(this.formGroup.getRawValue()).subscribe(data => {
            console.log(data);
            this.toastrService.success(`Successful`);
            this.getAllTacGia();
        },error => {
            this.toastrService.error(`Failed`);
            console.log(error);
        });
    }
    updateTacGia(){

        this.tacGiaService.updateTacGia(this.formGroup.getRawValue()).subscribe(data => {
            console.log(data);
            this.toastrService.success(`Successful`);
            this.getAllTacGia();
        },error => {
            this.toastrService.error(`Failed`);
            console.log(error);
        });
    }
    deleteTacGia(id: any){
        this.tacGiaService.deleteTacGia(id).subscribe(data => {
            console.log(data);
            this.toastrService.success(`Successful`);
            this.getAllTacGia();
        },error => {
            this.toastrService.error(`Failed`);
            console.log(error);
        });
    }
    editTacGia(item: any){
        this.checkText = false;
        this.checkButton = false;
        this.formGroup.patchValue({
            id: item.id,
            ma: item.ma,
            ten: item.ten,
            sdt: item.sdt,
            diaChi: item.diaChi,
            moTa: item.moTa

        });
    }

    onSubmit(){
        if(this.formGroup.invalid){
            this.formGroup.markAllAsTouched();
            return;
        }
        if(this.formGroup.value.id === ''){
            this.addTacGia();
        }else{
            this.updateTacGia();
        }
    }
}
