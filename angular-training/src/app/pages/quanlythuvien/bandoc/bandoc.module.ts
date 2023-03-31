import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BandocRoutingModule } from './bandoc-routing.module';
import { BandocComponent } from './bandoc.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    BandocComponent
  ],
  imports: [
    CommonModule,
    BandocRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class BandocModule { }
