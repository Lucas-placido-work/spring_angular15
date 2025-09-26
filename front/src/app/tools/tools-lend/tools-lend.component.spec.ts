import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToolsLendComponent } from './tools-lend.component';

describe('ToolsLendComponent', () => {
  let component: ToolsLendComponent;
  let fixture: ComponentFixture<ToolsLendComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ToolsLendComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ToolsLendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
