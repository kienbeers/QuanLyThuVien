import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TacGiaComponent } from './tac-gia.component';

const routes: Routes = [{ path: '', component: TacGiaComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TacGiaRoutingModule { }
