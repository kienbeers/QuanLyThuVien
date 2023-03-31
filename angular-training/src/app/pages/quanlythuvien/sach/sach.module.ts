import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SachRoutingModule } from './sach-routing.module';
import { SachComponent } from './sach.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    SachComponent
  ],
  imports: [
    CommonModule,
    SachRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class SachModule { }
