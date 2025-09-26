import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

import { LendService } from '../services/lend.service';
import { MatSnackBar } from '@angular/material/snack-bar';


LendService

@Component({
  selector: 'app-tools-lend',
  templateUrl: './tools-lend.component.html',
  styleUrls: ['./tools-lend.component.css']
})
export class ToolsLendComponent {

  formGroup: FormGroup;
  toolsService: any;
  selectedTool: any;

  constructor(
    private formBuilder: FormBuilder,
    private lendService: LendService,
    private router: Router,
    private snackBar: MatSnackBar
  ){
    this.formGroup = this.formBuilder.group({
      nameEmployee: [null],
    });

    const navigation = this.router.getCurrentNavigation();
    if (navigation?.extras.state && navigation.extras.state['tool']) {
      this.selectedTool = navigation.extras.state['tool'];
    }
  }

  goBack(){
    window.history.back();
  }

  lendTool(){
    const lendPayload = {
      tool: { id: this.selectedTool.id },
      employee: { name: this.formGroup.value.nameEmployee },
    };

    // const lendPayload = {
    //   tool: this.selectedTool,
    //   employee: { id: this.formGroup.value.employeeId },
    //   dateLend: new Date().toISOString().split('T')[0]
    // };

    this.lendService.create(lendPayload).subscribe({
      next: (lend) => this.snackBar.open('Ferramenta emprestada com sucesso!', '', { duration: 3000 }),
      error: (error) => this.snackBar.open(error.error.message, '', { duration: 3000 })
    });
  }
}
