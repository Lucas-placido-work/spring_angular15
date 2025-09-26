import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ToolsComponent } from './tools/tools.component';
import { ToolsLendComponent } from './tools-lend/tools-lend.component';

const routes: Routes = [
  {path: '', component: ToolsComponent},
  {path: 'lend', component: ToolsLendComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ToolsRoutingModule { }
