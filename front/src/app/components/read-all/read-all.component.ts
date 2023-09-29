import {Component, OnInit} from '@angular/core';
import {Todo} from "../../models/todo";

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {

  list: Todo[] = [{
    title: "teste",
    timeToFinish: new Date,
    isFinished: false
  },
    {
      title: "teste 2",
      timeToFinish: new Date,
      isFinished: false
    },


  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}
