import { Component, OnInit } from '@angular/core';
import { Todo } from "../../models/todo";
import { TodoService } from "../../services/todo.service";

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {
  closed = 1;
  list: Todo[] = [];
  listFinished : Todo[] = [];

  constructor(private service: TodoService) {}

  ngOnInit(): void {
    this.findAll();
    console.log("Finished tasks after initialization:", this.closed);


  }

  findAll(): void {
    this.service.findAll().subscribe(
      (todos) => {
        this.listFinished = todos.filter(todo => todo.finished);
        this.list = todos.filter(todo => !todo.finished);

        this.closed = this.listFinished.length;

        console.log("Returned tasks:", todos);
      },
      (error) => {
        // Handle the error appropriately
        console.error('Failed to fetch todos:', error);
      }
    );
  }

  delete(id:any): void {
    this.service.delete(id).subscribe((response) => {
      if(response === null){
        this.service.message('Task successfully deleted!');
        this.list = this.list.filter(todo => todo.id !== id);
      }
      }

    );
  }



}
