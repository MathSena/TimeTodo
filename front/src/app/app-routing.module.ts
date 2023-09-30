import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReadAllComponent } from './components/read-all/read-all.component';
import {FinishedComponent} from "./components/finished/finished.component";


const routes: Routes = [
  {
    path: '',
    component: ReadAllComponent
  },
  {
    path: 'finished',
    component: FinishedComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }