import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MuonSachRoutingModule } from './muon-sach-routing.module';
import { MuonSachComponent } from './muon-sach.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    MuonSachComponent
  ],
  imports: [
    CommonModule,
    MuonSachRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class MuonSachModule { }
