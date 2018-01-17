import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Part } from '../../shared-interfaces/service';

@Component({
  selector: 'part-form',
  templateUrl: './part-form.component.html',
  styleUrls: ['./part-form.component.scss']
})
export class PartFormComponent implements OnInit {
  part: Part;
  edit: boolean;

  constructor(
    public dialogRef: MatDialogRef<PartFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data
  ) { }

  ngOnInit() {
    const { part = <Part>{}, edit = false } = this.data;
    this.part = part;
    this.edit = edit;
  }

  onAdd() {
    this.dialogRef.close();
  }
}
