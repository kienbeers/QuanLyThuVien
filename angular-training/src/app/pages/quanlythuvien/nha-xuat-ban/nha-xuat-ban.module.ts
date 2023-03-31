import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NhaXuatBanRoutingModule } from './nha-xuat-ban-routing.module';
import { NhaXuatBanComponent } from './nha-xuat-ban.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    NhaXuatBanComponent
  ],
  imports: [
    CommonModule,
    NhaXuatBanRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class NhaXuatBanModule { }
