import { Component, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'engine-lifecycle-detail-breakdown',
  template: `
    <h1>Dialog Here.  foo: {{data.foo}}</h1>
  `
})
export class EngineLifecycleDetailBreakdownComponent {

  constructor(
    public dialogRef: MatDialogRef<EngineLifecycleDetailBreakdownComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
