import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MuonSachComponent } from './muon-sach.component';

const routes: Routes = [{ path: '', component: MuonSachComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MuonSachRoutingModule { }
