import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from '../tools/shared/app-material/app-material.module';
import { ToolsRoutingModule } from './tools-routing.module';
import { ToolsComponent } from './tools/tools.component';
import { ToolsLendComponent } from './tools-lend/tools-lend.component';
import { ReactiveFormsModule } from '@angular/forms';




@NgModule({
  declarations: [
    ToolsComponent,
    ToolsLendComponent
  ],
  imports: [
    CommonModule,
    ToolsRoutingModule,
    AppMaterialModule,
    ReactiveFormsModule
  ]
})
export class ToolsModule { }
