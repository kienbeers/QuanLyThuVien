import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NhaXuatBanComponent } from './nha-xuat-ban.component';

const routes: Routes = [{ path: '', component: NhaXuatBanComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NhaXuatBanRoutingModule { }
