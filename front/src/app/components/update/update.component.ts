import {Component, OnInit} from '@angular/core';
import {Todo} from "../../models/todo";
import {ActivatedRoute, Router} from "@angular/router";
import {TodoService} from "../../services/todo.service";

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  todo: Todo = {
    title: '',
    description: '',
    timeToFinish: new Date(),
    finished: false
  }

  constructor(private router: Router, private service: TodoService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.todo.id = this.route.snapshot.paramMap.get("id")!;
    this.findById();
  }

  findById(): void {
    this.service.findById(this.todo.id).subscribe((response) => {
      this.todo = response;
    })
  }

  update(): void {
    this.formatData();
    this.service.update(this.todo).subscribe((response) => {
      this.service.message('Informações atualizadas com sucesso!');
      this.router.navigate(['']);
    }, error => {
      this.service.message('Falha ao atualizar To-do!');
      this.router.navigate(['']);
    })
  }

  cancel(): void {
    this.router.navigate([''])
  }

  formatData(): void {
    let data = new Date(this.todo.timeToFinish)
    this.todo.timeToFinish = `${data.getDate()}/${data.getMonth() + 1}/${data.getFullYear()}`
  }

}
