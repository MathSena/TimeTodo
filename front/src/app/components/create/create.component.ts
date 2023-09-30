import {Component, OnInit} from '@angular/core';
import {Todo} from "../../models/todo";
import {TodoService} from "../../services/todo.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit{


  todo: Todo = {
    title: '',
    description: '',
    timeToFinish: new Date(),
    finished: false
  }

  constructor(private router: Router, private service: TodoService) { }

  ngOnInit(): void {

  }

  createTodo(): void {
    this.formatDate();
    this.service.createTodo(this.todo).subscribe((response) => {
      this.service.message('To-do criado com sucesso!');
      this.router.navigate(['']);
    }, err => {
      this.service.message('Falha ao criar To-do');
      this.router.navigate(['']);
    })
  }

  cancel() {
     this.router.navigate(['']).then(r => console.log('Cancelado'))

  }

  formatDate(): void {
    let data = new Date(this.todo.timeToFinish);
    this.todo.timeToFinish = `${data.getDate()}/${data.getMonth() + 1}/${data.getFullYear()}`;
  }


}
