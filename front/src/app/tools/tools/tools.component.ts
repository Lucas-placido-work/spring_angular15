import { Component } from '@angular/core';
import { Observable } from 'rxjs';

import { ToolsService } from '../services/tools.service';
import { Tools } from './../model/tools';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-tool',
  templateUrl: './tools.component.html',
  styleUrls: ['./tools.component.css']
})
export class ToolsComponent {
  tools: Observable<Tools[]>;
  displayedColumns = ['name', 'available', 'actions'];
  constructor(
    private toolsService: ToolsService,
    private router: Router,
    private route: ActivatedRoute
  ){
    this.tools = this.toolsService.list();
  };

  onAddLend(tool: Tools){
    this.router.navigate(['lend'], {relativeTo: this.route, state: { tool }});
  }
}
