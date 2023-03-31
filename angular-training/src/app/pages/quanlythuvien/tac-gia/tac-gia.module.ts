import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TacGiaRoutingModule } from './tac-gia-routing.module';
import { TacGiaComponent } from './tac-gia.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    TacGiaComponent
  ],
  imports: [
    CommonModule,
    TacGiaRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class TacGiaModule { }
